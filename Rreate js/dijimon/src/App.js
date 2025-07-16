import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './pages/Home';
import Components from './pages/Components';
import Examples from './pages/Examples';
import DigimonTestPage from './pages/DigimonTestPage'; // ✅ 추가
import DigimonList from "./pages/DigimonList";
import './App.css';

function App() {
  return (
    <BrowserRouter>
      <nav className="navbar">
        <Link to="/">Home</Link>
        <Link to="/components">Components</Link>
        <Link to="/examples">Examples</Link>
        <Link to="/digimon">Digimon</Link> {/* ✅ 링크 추가 */}
      </nav>
      <Routes>
        
        <Route path="/" element={<Home />} />   

        <Route path="/components" element={<Components />} />      
        
        <Route path="/examples" element={<Examples />} />      
        
        <Route path="/digimon" element={<DigimonTestPage />} /> {/* ✅ 라우팅 추가 */}
      </Routes>
    </BrowserRouter>
  );
}
<Route path="/digimons" element={<DigimonList />} />
export default App;