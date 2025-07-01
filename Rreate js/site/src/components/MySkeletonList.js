import React from 'react';
import Skeleton from '@mui/material/Skeleton';
import Stack from '@mui/material/Stack';

export default function MySkeletonList({ loading = true, count = 3 }) {
  if (!loading) return null;
  return (
    <Stack spacing={2}>
      {Array.from({ length: count }).map((_, idx) => (
        <Skeleton key={idx} variant="rectangular" height={40} />
      ))}
    </Stack>
  );
}