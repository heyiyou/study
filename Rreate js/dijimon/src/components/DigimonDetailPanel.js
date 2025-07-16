import React from 'react';
import digimonExtraData from '../data/digimonExtraData';

function DigimonDetailPanel(props) {
  const { digimon, onClose } = props;
  if (!digimon) return null;

  const extra = digimonExtraData[digimon.name] || {};

  return (
    <div className="fixed right-0 top-0 h-full w-full sm:w-96 bg-gray-900 text-white p-6 z-50 overflow-y-auto shadow-2xl border-l-4 border-yellow-400">
      <button
        onClick={onClose}
        className="text-yellow-400 font-bold text-lg mb-4 hover:text-yellow-200"
      >
        ✕ 닫기
      </button>
      <img src={digimon.img} alt={digimon.name} className="w-full h-60 object-contain mb-4" />
      <h2 className="text-3xl font-bold text-yellow-300 mb-2">{digimon.name}</h2>
      <p className="text-lg mb-1"><strong>레벨:</strong> {digimon.level}</p>
      {extra.attribute && <p className="text-lg mb-1"><strong>속성:</strong> {extra.attribute}</p>}
      {extra.description && <p className="text-sm text-gray-300 mt-2">{extra.description}</p>}
    </div>
  );
}

export default DigimonDetailPanel;
