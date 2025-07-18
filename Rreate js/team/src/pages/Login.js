import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

export default function Login() {
  const [form, setForm] = useState({
    id: '',
    pw: ''
  });

  const [loggedIn, setLoggedIn] = useState(false);
  const [userId, setUserId] = useState('');

  const navigate = useNavigate();

  // localStorage + getItem 복원, setItem 저장, removeItem 삭제
  useEffect(() => {
    const savedUser = localStorage.getItem('loggedInUser');
    if (savedUser) {
      setLoggedIn(true);
      setUserId(savedUser);
    }
  }, []);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm({ ...form, [name]: value });
  };

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8080/cal/member/login', {
        username: form.id,
        password: form.pw
      });
      alert('로그인 성공');
      setLoggedIn(true);
      setUserId(form.id);
      localStorage.setItem('loggedInUser', form.id);
      navigate('/');
    } catch (error) {
      console.error('❌ 로그인 실패:', error);
      alert('로그인 실패');
    }
  };

  const handleLogout = () => {
    // 로그아웃 시 상태 초기화
    setLoggedIn(false);
    setUserId('');
    localStorage.removeItem('loggedInUser');
  };

  return (
    <div style={{ maxWidth: 400, margin: '0 auto', padding: 20 }}>
      <h2>로그인</h2>

      {loggedIn ? (
        <>
          {/* 로그인 상태 표시 */}
          <p>현재 로그인 사용자: {userId}</p>
          <button onClick={handleLogout}>로그아웃</button>
        </>
      ) : (
        <form onSubmit={handleLogin}>
          <div>
            <label>아이디:</label>
            <input
              type="text"
              name="id"
              value={form.id}
              onChange={handleChange}
              required
            />
          </div>
          <div>
            <label>비밀번호:</label>
            <input
              type="password"
              name="pw"
              value={form.pw}
              onChange={handleChange}
              required
            />
          </div>
          <button type="submit">로그인</button>
        </form>
      )}
    </div>
  );
}
