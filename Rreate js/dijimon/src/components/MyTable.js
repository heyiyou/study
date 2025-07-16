import React from 'react';

export default function MyTable({ rows }) {
  return (
    <table border="1" cellPadding="10">
      <thead>
        <tr>
          <th>이름</th>
          <th>나이</th>
          <th>등급</th>
        </tr>
      </thead>
      <tbody>
        {rows.map((row, idx) => (
          <tr key={idx}>
            <td>{row.name}</td>
            <td>{row.age}</td>
            <td>{row.grade}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}
