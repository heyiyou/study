import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';

export default function BoardEdit() {
  const { id } = useParams();
  const navigate = useNavigate();

  const [title, setTitle] = useState('');
  const [content, setContent] = useState('');
  const [writer, setWriter] = useState('');
  const [loading, setLoading] = useState(false);
  const [message, setMessage] = useState('');

  // 디버깅 로그
  useEffect(() => {
    console.log("BoardEdit 렌더링됨, id:", id);
  }, [id]);

  // 기존 게시글 정보 가져오기
  useEffect(() => {
    axios.get(`http://localhost:8080/cal/board/detail/${id}`)
      .then(res => {
        const data = res.data;
        setTitle(data.title);
        setContent(data.content);
        setWriter(data.writer);
      })
      .catch(err => {
        console.error(err);
        setMessage('❌ 게시글 로드 실패');
      });
  }, [id]);

  // 수정 요청
  const handleUpdate = () => {
    if (!title.trim() || !content.trim()) {
      alert('제목과 내용을 모두 입력하세요!');
      return;
    }

    const updatedBoard = { title, content, writer };
    setLoading(true);

    axios.put(`http://localhost:8080/cal/board/update/${id}`, updatedBoard)
      .then(res => {
        alert(res.data);
        navigate(`/board/detail/${id}`, { replace: true });// 수정 완료 후 상세보기 페이지로 이동 (원하는 경로로 바꿔도 OK)
      })
      .catch(err => {
        console.error(err);
        setMessage('❌ 수정 실패');
      })
      .finally(() => setLoading(false));
  };

  return (
    <div>
      <h2>게시글 수정</h2>
      {loading && <p>수정 중...</p>}
      {message && <p>{message}</p>}

      <label>제목:
        <input value={title} onChange={(e) => setTitle(e.target.value)} />
      </label>
      <br />

      <label>내용:
        <textarea value={content} onChange={(e) => setContent(e.target.value)} />
      </label>
      <br />

      <label>작성자:
        <input value={writer} onChange={(e) => setWriter(e.target.value)}
                             //readOnly 고정
         />
      </label>
      <br />

      <button onClick={handleUpdate}>수정하기</button>
    </div>
  );
}
