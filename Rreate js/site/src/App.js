import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './pages/Home';
import Components from './pages/Components';
import Examples from './pages/Examples';

import './App.css'; // 이미 상단에 있어야 함

function App() {
  return (
    <BrowserRouter>
      <nav className="navbar">
        <Link to="/">Home</Link>
        <Link to="/components">Components</Link>
        <Link to="/examples">Examples</Link>
      </nav>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/components" element={<Components />} />
        <Route path="/examples" element={<Examples />} />
      </Routes>
    </BrowserRouter>
  );
}
export default App;