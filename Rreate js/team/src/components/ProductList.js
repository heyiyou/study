import React, { useEffect, useState } from 'react';
import axios from 'axios';

function ProductList() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/products")
      .then(res => setProducts(res.data))
      .catch(err => console.error("상품 불러오기 실패:", err));
  }, []);

  return (
    <div>
      <h2>상품 목록</h2>
      <ul>
        {products.map(product => (
          <li key={product.id}>
            <strong>{product.name}</strong> - {product.price}원 - {product.category}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ProductList;
