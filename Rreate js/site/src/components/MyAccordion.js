import React from 'react';
import Accordion from '@mui/material/Accordion';
import AccordionSummary from '@mui/material/AccordionSummary';
import AccordionDetails from '@mui/material/AccordionDetails';
import Typography from '@mui/material/Typography';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';

export default function MyAccordion({
  items = [
    { title: '디지몬의 일상', content: '디지몬은 디지털 월드에서 모험과 훈련을 반복합니다.' },
    { title: '디지몬의 특성', content: '파트너와의 유대감을 통해 진화하며 속성마다 능력이 다릅니다.' }
  ],
}) {
  return (
    <div>
      {items.map((item, idx) => (
        <Accordion key={idx}>
          <AccordionSummary expandIcon={<ExpandMoreIcon />}>
            <Typography>{item.title}</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Typography>{item.content}</Typography>
          </AccordionDetails>
        </Accordion>
      ))}
    </div>
  );
}
