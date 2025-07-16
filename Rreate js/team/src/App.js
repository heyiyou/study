import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ProductList from './components/ProductList/ProductList';
import ProductDetail from './components/ProductDetail/ProductDetail';
import ProductForm from './components/ProductForm/ProductForm';
import ProductDelete from './components/ProductDelete/ProductDelete';
import ProductRegister from './prodcut/ProductRegister';
import BoardEdit from './components/Board/BoardEdit';
import BoardRegister from './components/Board/BoardRegister';
import BoardDetail from './components/Board/BoardDetail';
import ProductEdit from './components/ProductEdit';
function App() {
  return (
    <>
      <Router>
        <div className="App">
          <h1> 상품 받아라 </h1>
          <Routes>
            <Route path="/" element={<ProductList />} />
            <Route path="/products/new" element={<ProductForm />} />
            <Route path="/board/edit/:id" element={<BoardEdit />} />
            <Route path="/:id" element={<ProductDetail />} /> 
            <Route path="/board/register" element={<BoardRegister />} />
            <Route path="/board/detail/:id" element={<BoardDetail />} />
          </Routes>
        </div>
      </Router>
      <div className="componentTachi">
        <ProductRegister />
        <ProductDelete />
        <ProductEdit productId={1} />
      </div>
    </>
  );
}
export default App;