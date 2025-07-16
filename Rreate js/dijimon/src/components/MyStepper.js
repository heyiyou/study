import React from 'react';
import { Stepper, Step, StepLabel } from '@mui/material';

export default function MyStepper({ steps = [] }) {
  const [activeStep, setActiveStep] = React.useState(0);

  return (
    <Stepper activeStep={activeStep}>
      {steps.map((label, index) => (
        <Step key={index}>
          <StepLabel>{label}</StepLabel>
        </Step>
      ))}
    </Stepper>
  );
}
