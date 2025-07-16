import React, { useState } from "react";
import axios from "axios";

function DigimonTestPage() {
  const [digimons, setDigimons] = useState([]);
  const [name, setName] = useState("");
  const [level, setLevel] = useState("");

  const fetchAll = async () => {
    try {
      const res = await axios.get("http://localhost:8080/api/digimons");
      setDigimons(res.data);
    } catch (err) {
      console.error("전체 조회 실패", err);
    }
  };

  const searchByName = async () => {
    try {
      const res = await axios.get(`http://localhost:8080/api/digimons/search?name=${name}`);
      setDigimons(res.data);
    } catch (err) {
      console.error("이름 검색 실패", err);
    }
  };

  const searchByLevel = async () => {
    try {
      const res = await axios.get(`http://localhost:8080/api/digimons/level?level=${level}`);
      setDigimons(res.data);
    } catch (err) {
      console.error("레벨 검색 실패", err);
    }
  };

  return (
    <div style={{ padding: "2rem", fontFamily: "Arial" }}>
      <h1>🐉 Digimon API 테스트</h1>

      <button onClick={fetchAll}>전체 디지몬 가져오기</button>

      <div style={{ marginTop: "1rem" }}>
        <input
          type="text"
          value={name}
          onChange={(e) => setName(e.target.value)}
          placeholder="이름으로 검색 (예: Agumon)"
        />
        <button onClick={searchByName}>이름 검색</button>
      </div>

      <div style={{ marginTop: "1rem" }}>
        <select value={level} onChange={(e) => setLevel(e.target.value)}>
          <option value="">레벨 선택</option>
          <option value="In Training">In Training</option>
          <option value="Rookie">Rookie</option>
          <option value="Champion">Champion</option>
          <option value="Ultimate">Ultimate</option>
          <option value="Mega">Mega</option>
        </select>
        <button onClick={searchByLevel}>레벨 검색</button>
      </div>

      <hr />

      <div>
        {digimons.map((d, idx) => (
          <div
            key={idx}
            style={{
              border: "1px solid #ccc",
              padding: "1rem",
              marginBottom: "1rem",
              borderRadius: "8px",
              background: "#f9f9f9",
            }}
          >
            <h3>{d.name}</h3>
            <p>레벨: {d.level}</p>
            {d.img && <img src={d.img} alt={d.name} style={{ height: "100px" }} />}
          </div>
        ))}
      </div>
    </div>
  );
}

export default DigimonTestPage;
