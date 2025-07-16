import React from 'react';
import { Skeleton } from '@mui/material';

export default function MySkeletonList({ loading, count }) {
  return (
    <div>
      {loading &&
        Array.from({ length: count }).map((_, i) => (
          <Skeleton
            key={i}
            variant="rectangular"
            width={300}
            height={50}
            style={{ margin: '10px 0' }}
          />
        ))}
    </div>
  );
}
