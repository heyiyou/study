import React from 'react';

function DigimonCard(props) {
  const { digimon, onClick } = props;

  return (
    <div
      className="bg-white rounded-xl shadow-md transform transition duration-300 hover:scale-105 hover:shadow-2xl border-4 border-blue-300 text-black text-center p-4 cursor-pointer"
      onClick={onClick}
    >
      <img
        src={digimon.img}
        alt={digimon.name}
        className="w-full h-48 object-contain rounded-t-xl"
      />
      <h3 className="text-lg font-bold mt-2">{digimon.name}</h3>
      <p className="text-gray-700">{digimon.level}</p>
    </div>
  );
}

export default DigimonCard;
