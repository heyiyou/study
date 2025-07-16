import React, { useState } from "react";
import axios from "axios";

function DigimonSearch() {
  const [name, setName] = useState("");
  const [digimons, setDigimons] = useState([]);

  const handleSearch = async () => {
    try {
      const res = await axios.get(`http://localhost:8080/api/digimons/search?name=${name}`);
      setDigimons(res.data);
    } catch (error) {
      console.error("검색 실패:", error);
    }
  };

  return (
    <div style={{ padding: "20px", backgroundColor: "#222", color: "#fff" }}>
      <h2>🔍 디지몬 이름 검색</h2>
      <input
        value={name}
        onChange={(e) => setName(e.target.value)}
        placeholder="예: Agumon"
        style={{ padding: "8px", marginRight: "10px" }}
      />
      <button onClick={handleSearch}>검색</button>

      <div style={{ marginTop: "20px" }}>
        {digimons.map((d) => (
          <div key={d.name} style={{ marginBottom: "10px" }}>
            <img src={d.img} alt={d.name} width="100" />
            <p>{d.name} ({d.level})</p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default DigimonSearch;