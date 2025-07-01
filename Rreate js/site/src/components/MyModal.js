import React, { useState } from 'react';
import Button from '@mui/material/Button';
import Modal from '@mui/material/Modal';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';

const style = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 300,
  bgcolor: 'background.paper',
  border: '2px solid #888',
  boxShadow: 24,
  p: 4,
  borderRadius: 2,
};

export default function MyModal({ title = '알림', content = '이것은 모달입니다.' }) {
  const [open, setOpen] = useState(false);

  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  return (
    <div>
      <Button onClick={handleOpen} variant="contained">모달 열기</Button>

      <Modal open={open} onClose={handleClose}>
        <Box sx={style}>
          <Typography variant="h6" component="h2">
            {title}
          </Typography>
          <Typography sx={{ mt: 2 }}>
            {content}
          </Typography>
          <Button sx={{ mt: 2 }} variant="outlined" onClick={handleClose}>닫기</Button>
        </Box>
      </Modal>
    </div>
  );
}
