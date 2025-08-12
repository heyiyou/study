import { useState } from 'react';
import axios from 'axios';
import styles from './Find.module.css';
import { useNavigate } from 'react-router-dom';

export default function FindPassword() {
  const [form, setForm] = useState({ id: '', email: '' });
  const [notice, setNotice] = useState('');
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  const onChange = (e) => {
    const { name, value } = e.target;
    setForm({ ...form, [name]: value });
  };

  const onSubmit = async (e) => {
    e.preventDefault();
    if (!form.id.trim() || !form.email.trim()) return;

    try {
      setLoading(true);
      // 🔧 백엔드 준비되면 실제 엔드포인트로 수정 (예: POST /cal/member/reset-password-request)
      await axios.post('http://localhost:8080/cal/member/reset-password-request', {
        id: form.id.trim(),
        email: form.email.trim().toLowerCase(),
      });
      setNotice('등록된 이메일로 비밀번호 재설정 안내를 보냈습니다.');
    } catch (err) {
      setNotice('일치하는 계정이 없거나, 메일 전송에 실패했습니다.');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className={styles.wrap}>
      <div className={styles.card}>
        <h2 className={styles.title}>비밀번호 찾기</h2>
        <form onSubmit={onSubmit} className={styles.form}>
          <div className={styles.formRow}>
            <label className={styles.label}>아이디</label>
            <input className={styles.input} name="id" value={form.id} onChange={onChange} required />
          </div>
          <div className={styles.formRow}>
            <label className={styles.label}>이메일</label>
            <input className={styles.input} type="email" name="email" value={form.email} onChange={onChange} required />
          </div>
          <button className={styles.button} type="submit" disabled={loading}>
            {loading ? '요청 중…' : '재설정 메일 보내기'}
          </button>
        </form>

        {notice && <p className={styles.result}>{notice}</p>}

        <div className={styles.subActions}>
          <button className={styles.linkBtn} onClick={() => navigate('/login')}>로그인으로 돌아가기</button>
        </div>
      </div>
    </div>
  );
}