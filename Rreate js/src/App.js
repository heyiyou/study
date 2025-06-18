import React, { useState, useEffect } from 'react';

function RamenTimer({ onComplete }) {
//   const [timeLeft, setTimeLeft] = useState(180); // 3분 타이머 (180초)
  const [timeLeft, setTimeLeft] = useState(10); // 3분 타이머 (180초)

  useEffect(() => {
    if (timeLeft > 0) {
      const timerId = setTimeout(() => {
        setTimeLeft(timeLeft - 1);
        console.log("타이머 살았는지 체크용:"+ timeLeft);
      }, 1000);
      
      return () => clearTimeout(timerId);
    } else {
      onComplete(); // 타이머 종료 시 부모 컴포넌트에 알림
    }
  }, [timeLeft, onComplete]);

  return (
    <div style={{ textAlign: 'center', padding: '20px', fontSize: '1.5em' }}>
      남은 시간: {timeLeft}초
    </div>
  );
}

function App() {
  const [isTimerRunning, setIsTimerRunning] = useState(false); // 타이머 표시 여부
  const [resultMessage, setResultMessage] = useState(''); // 결과 메시지

  const handleStartTimer = () => {
    setIsTimerRunning(true);
    setResultMessage(''); // 타이머 시작 시 결과 메시지 초기화
  };

  const handleTimerComplete = () => {
    setIsTimerRunning(false);
    setResultMessage('너구리 라면이 완성되었습니다!');
  };

  return (
    <div style={{ textAlign: 'center', padding: '20px' }}>
      <button onClick={handleStartTimer} style={{ fontSize: '1.2em', padding: '10px' }}>
        너구리
      </button>

      {isTimerRunning && (
        <div>
          <RamenTimer onComplete={handleTimerComplete} />
        </div>
      )}

      <div style={{ marginTop: '20px', fontSize: '1.5em' }}>
        {resultMessage}
      </div>
    </div>
  );
}

export default App;
