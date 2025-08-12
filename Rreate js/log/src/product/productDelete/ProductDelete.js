import React, {useEffect, useState } from 'react';
import axios from 'axios';
import './ProductDelete.css';
import { useLocation } from 'react-router-dom'; // 추가

function ProductDelete() {
    const [id, setId] = useState("");
       const location = useLocation(); // URL 정보 가져오기

      // URL 쿼리에서 id 값 추출해서 setId로 넣음
    useEffect(() => {
        const params = new URLSearchParams(location.search);
        const queryId = params.get('id');
        if (queryId) {
            setId(queryId);
        }
    }, [location]);

    const handleDelete = () => {
        if (!id) {
            alert("삭제할 ID를 입력해주세요.");
            return;
        }

        axios.delete(`http://localhost:8080/cal/product/delete/${id}`)
            .then(response => {
                alert(`상품 ID ${id} 삭제 성공!`);
                console.log("삭제 성공:", response);
            })
            .catch(error => {
                alert(`삭제 실패: ${error}`);
                console.error("삭제 실패:", error);
            });
    };

    return (
        <div className="delete-container">
            <h2>상품 삭제</h2>
            <input
                type="number"
                placeholder="삭제할 상품 ID"
                value={id}
                onChange={(e) => setId(e.target.value)}
            />
            <button onClick={handleDelete}>삭제하기</button>
        </div>
    );
}

export default ProductDelete;