import './App.css';
import { BrowserRouter as Router, Routes,Route, Link } from 'react-router-dom';
import ProductList from './components/ProductList/ProductList';
import ProductDetail from './components/ProductDetail/ProductDetail';
import ProductForm from './components/ProductForm/ProductForm';
import ProductDelete from './components/ProductDelete/ProductDelete';
import ProductRegister from './product/ProductRegister';
import BoardEdit from './components/Board/BoardEdit';
import BoardDetail from './components/Board/BoardDetail';
import BoardList from './components/Board/BoardList';
import BoardForm from './components/Board/BoardForm';  //
import ProductEdit from './components/ProductEdit'; 
import Register from './pages/Register'; 
import Login from './pages/Login';
function App() {
  return (
      <Router>
        <div className="App">
          <h1> 상품 받아라 </h1>

     
        <div className="header-buttons">
          <Link to="/login">
            <button>로그인</button>
          </Link>
          <Link to="/register">
            <button>회원가입</button>
          </Link>
        

          <Routes>
           <Route path="/" element={<ProductList />} />
           <Route path="/:id" element={<ProductDetail />} />
           <Route path="/products/new" element={<ProductForm />} />

           <Route path="/board/list" element={<BoardList />} />
           <Route path="/board/detail/:id" element={<BoardDetail />} />
           <Route path="/board/form" element={<BoardForm />} />
           <Route path="/board/form/:id" element={<BoardForm />} />
           <Route path="/board/edit/:id" element={<BoardEdit />} />  

           <Route path="/register" element={<Register />} />
           <Route path="/login" element={<Login />} />  
          </Routes>
       </div>
      <div className="componentTachi">
        <ProductRegister />
        <ProductDelete />
        <BoardList />
        <ProductEdit productId={1} />
      </div>
    </div>
        </Router>
  );
}
export default App;