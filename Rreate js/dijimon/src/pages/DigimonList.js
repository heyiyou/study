import React, { useEffect, useState } from "react";
import axios from "axios";

function DigimonList() {
  const [digimons, setDigimons] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/spring/api/digimons")
      .then((res) => setDigimons(res.data))
      .catch((err) => console.error("불러오기 실패", err));
  }, []);

  return (
    <div style={{ display: "flex", flexWrap: "wrap", gap: "20px", padding: "20px" }}>
      {digimons.map((d, idx) => (
        <div
          key={idx}
          style={{
            width: "180px",
            backgroundColor: "#fff",
            borderRadius: "12px",
            boxShadow: "0 2px 8px rgba(0,0,0,0.2)",
            padding: "1rem",
            textAlign: "center",
          }}
        >
          <img src={d.img} alt={d.name} style={{ width: "100%", height: "120px", objectFit: "contain" }} />
          <h3>{d.name}</h3>
          <p>{d.level}</p>
        </div>
      ))}
    </div>
  );
}

export default DigimonList;
