import React, { useState } from 'react';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';

export default function MyTab({
  tabs = [
    { label: '탭 1', content: '탭 1의 내용입니다' },
    { label: '탭 2', content: '탭 2의 내용입니다' },
    { label: '탭 3', content: '탭 3의 내용입니다' },
  ],
}) {
  const [value, setValue] = useState(0);
  const handleChange = (event, newValue) => setValue(newValue);

  return (
    <Box sx={{ width: '100%', typography: 'body1' }}>
      <Tabs value={value} onChange={handleChange} centered>
        {tabs.map((tab, idx) => (
          <Tab key={idx} label={tab.label} />
        ))}
      </Tabs>
      <Box sx={{ p: 2 }}>
        <Typography>{tabs[value]?.content}</Typography>
      </Box>
    </Box>
  );
}
