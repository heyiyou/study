import React, { useEffect, useState } from 'react';
import axios from 'axios';
import styles from './ProductList.module.css'; 
import { useNavigate } from 'react-router-dom'; 

export default function ProductList() {
  const [products, setProducts] = useState([]);                // 상품 목록 (배열 형태)
  const [total, setTotal] = useState(0);                       // 전체 상품 개수
  const [keyword, setKeyword] = useState('');                  // 검색바
  const [category, setCategory] = useState('');                // 카테고리
  const categories = ["전체", "도시락", "음료수", "과자", "아이스크림"];
  const [sort, setSort] = useState('new');
  const navigate = useNavigate();

  useEffect(() => {
    
    axios.get('http://localhost:8080/cal/product/list', {
      params: {
        keyword: keyword,     // 검색어
        category:  category === "전체" ? "" : category, // "전체"는 빈 값으로 전달
        page: 1,         // 페이지 번호 (1부터 시작)
        size: 8,          // 한 페이지에 불러올 상품 수
        sort: sort,

      }
    })
    .then((res) => {
      setProducts(res.data.products);             // res.data JSON 객체이며, products는 상품 목록 배열
      setTotal(res.data.total);                   // 전체 상품 수 저장 
    })

    .catch((err) => {
      console.error("상품 조회 실패:", err);      
    });
  }, [keyword,category,sort,navigate]);     // 검색어가 바뀔 때마다 자동 요청하게 괄호안에 있는것들을 넣음


  return (
     <div className={styles.container}>


       {/* 카테고리 탭 */}
      <div className={styles.tabs}>
        {categories.map((cat) => (
          <button
            key={cat}
            className={`${styles.tabButton} ${category === cat ? styles.active : ''}`}
            onClick={() => setCategory(cat)}
          >
            {cat}
          </button>
        ))}
      </div>

       {/* 검색창 */}
     
      <div className={styles.search}>
        <input
          value={keyword}
          onChange={(e) => setKeyword(e.target.value)}
          placeholder="상품명을 입력"
        />
      </div>
       {/* 정렬순 버튼 */}
      <div className={styles.sortContainer}>
  <button
    className={`${styles.sortButton} ${sort === 'new' ? styles.active : ''}`}
    onClick={() => setSort('new')}>
    최근껄로 드가자</button>
  <button
    className={`${styles.sortButton} ${sort === 'old' ? styles.active : ''}`}
    onClick={() => setSort('old')}>
    오래된순</button>
  <button
    className={`${styles.sortButton} ${sort === 'recommend' ? styles.active : ''}`}
    onClick={() => setSort('recommend')}>
    추천순</button>
</div>
 <h2>상품 목록 ({total}개)</h2>

      <ul className={styles.grid}>
        {products.map((p) => (
          <li
            key={p.id}
            className={styles.item}
            onClick={() => navigate(`/${p.id}`)}
          >
            {p.imageUrl ? (
            <img
              src={p.imageUrl}
              alt={p.name}
              className={styles.itemImage}
            />
            ): null}
            <div className={styles.itemContent}>
              <div className={styles.itemName}>{p.name}</div>
              <div className={styles.itemPrice}>{p.price}원</div>
              <div className={styles.itemCategory}>{p.category}</div>
            </div>
            <button
              className={styles.button}
              onClick={(e) => {
                e.stopPropagation();
                navigate(`/board/edit/${p.id}`);}}> 게시판 수정하기
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}