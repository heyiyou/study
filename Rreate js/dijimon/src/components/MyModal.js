import React from 'react';
import { Modal, Box, Typography, Button } from '@mui/material';

const style = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 400,
  bgcolor: 'background.paper',
  boxShadow: 24,
  p: 4,
};

export default function MyModal({ title, content }) {
  const [open, setOpen] = React.useState(true);

  const handleClose = () => {setOpen(false);};

  return (
    <Modal open={open} onClose={handleClose}>
      <Box sx={style}>
        <Typography variant="h6" component="h2">
          {title}
        </Typography>
        <Typography sx={{ mt: 2 }}>{content}</Typography>
        <Button onClick={handleClose} sx={{ mt: 2 }}>
          닫기
        </Button>
      </Box>
    </Modal>
  );
}
