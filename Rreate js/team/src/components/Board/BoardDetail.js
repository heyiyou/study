import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

export default function BoardDetail() {
  const { id } = useParams();
  const [board, setBoard] = useState(null);

  useEffect(() => {
    axios.get(`http://localhost:8080/cal/board/detail/${id}`)
      .then(res => setBoard(res.data))
      .catch(err => console.error('게시글 상세 불러오기 실패:', err));
  }, [id]);

  if (!board) return <div>로딩 중...</div>;

  return (
    <div>
      <h2>{board.title}</h2>
      <p>작성자: {board.writer}</p>
      <p>{board.content}</p>
    </div>
  );
}
