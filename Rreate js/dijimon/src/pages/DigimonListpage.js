// src/pages/DigimonListPage.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import DigimonCard from '../components/DigimonCard';
import DigimonDetailPanel from '../components/DigimonDetailPanel';

export default function DigimonListPage() {
  const [digimons, setDigimons] = useState([]);
  const [selected, setSelected] = useState(null);

  useEffect(() => {
    axios.get('http://localhost:8080/api/digimons')
      .then(res => setDigimons(res.data))
      .catch(err => console.error('불러오기 실패', err));
  }, []);

  return (
    <div className="p-8 grid gap-4 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4">
      {digimons.map((d, i) => (
        <DigimonCard key={i} digimon={d} onClick={() => setSelected(d)} />
      ))}
      {selected && <DigimonDetailPanel digimon={selected} onClose={() => setSelected(null)} />}
    </div>
  );
}
