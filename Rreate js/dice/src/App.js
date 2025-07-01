import React, { useState } from "react";

const BOARD_SIZE = 20;
const INIT_CASH = 100000;

const EVENT_TILES = {
  3: { type: "penalty", amount: 10000, message: "벌금! 1만원 차감" },
  7: { type: "bonus", amount: 20000, message: "보너스! 2만원 획득" },
  15: { type: "bonus", amount: 50000, message: "대박! 5만원 획득" },
};

export default function App() {
  const [position, setPosition] = useState(0);
  const [dice, setDice] = useState(null);
  const [cash, setCash] = useState(INIT_CASH);
  const [log, setLog] = useState([]);
  const [turn, setTurn] = useState(1);
  const [history, setHistory] = useState([]);

  const rollDice = () => {
    const roll = Math.floor(Math.random() * 6) + 1;
    const nextPos = (position + roll) % BOARD_SIZE;
    const event = EVENT_TILES[nextPos];

    setDice(roll);
    setPosition(nextPos);
    setTurn((prev) => prev + 1);
    setHistory((prev) => [...prev, { turn, roll, to: nextPos }]);

    if (event) {
      const cashChange = event.type === "bonus" ? event.amount : -event.amount;
      setCash((prev) => Math.max(0, prev + cashChange));
      setLog((prev) => [`[턴 ${turn}] ${event.message} (위치 ${nextPos})`, ...prev]);
    } else {
      setLog((prev) => [`[턴 ${turn}] ${nextPos}칸 - 아무 일도 없었다...`, ...prev]);
    }
  };

  return (
    <div style={{ padding: 20 }}>
      <h1>🎲 모두의 마블 - 주사위 게임</h1>
      <p>턴: {turn}</p>
      <p>위치: {position}칸</p>
      <p>주사위: {dice ?? "-"}</p>
      <p>소지금: {cash.toLocaleString()}원</p>
      <button onClick={rollDice}>주사위 굴리기</button>

      <h3 style={{ marginTop: 30 }}>말판</h3>
      <div style={{ display: "flex", flexWrap: "wrap", width: 240 }}>
        {Array.from({ length: BOARD_SIZE }).map((_, i) => {
          const event = EVENT_TILES[i];
          const isCurrent = i === position;
          return (
            <div
              key={i}
              style={{
                width: 40,
                height: 40,
                border: "1px solid #ccc",
                backgroundColor: isCurrent ? "yellow" : event ? (event.type === "bonus" ? "lightgreen" : "lightcoral") : "white",
                textAlign: "center",
                lineHeight: "40px",
                fontSize: 12,
              }}
            >
              {i}
            </div>
          );
        })}
      </div>

      <h3 style={{ marginTop: 30 }}>이동 기록</h3>
      <ul>
        {history.map((h, idx) => (
          <li key={idx}>
            턴 {h.turn} - {h.roll} 눈 → {h.to}칸
          </li>
        ))}
      </ul>

      <h3 style={{ marginTop: 30 }}>로그</h3>
      <ul>
        {log.map((line, idx) => (
          <li key={idx}>{line}</li>
        ))}
      </ul>
    </div>
  );
}
