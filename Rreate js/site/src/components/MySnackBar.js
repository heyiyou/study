import React, { useState } from 'react';
import Button from '@mui/material/Button';
import Snackbar from '@mui/material/Snackbar';
import Alert from '@mui/material/Alert';

export default function MySnackBar({ message = "알림", severity = "success" }) {
  const [open, setOpen] = useState(false);

  const handleClick = () => setOpen(true);
  const handleClose = (event, reason) => {
    if (reason === 'clickaway') return;
    setOpen(false);
  };

  return (
    <>
      <Button variant="outlined" onClick={handleClick}>
        알림 보기
      </Button>
      <Snackbar
        open={open}
        autoHideDuration={3000}
        onClose={handleClose}
        anchorOrigin={{ vertical: 'bottom', horizontal: 'center' }}
      >
        <Alert onClose={handleClose} severity={severity} sx={{ width: '100%' }}>
          {message}
        </Alert>
      </Snackbar>
    </>
  );
}
