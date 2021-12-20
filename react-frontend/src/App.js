import './App.css';
import React from 'react';
import { Navigate, BrowserRouter, Routes, Route } from 'react-router-dom'
import WelcomePage from './WelcomePage';
import Restricted from "./Restricted";


function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/welcome' element={<WelcomePage />}/>
        <Route path="/" element={<Navigate replace to="/welcome" />} />
        <Route path='/restricted' element={<Restricted />}/>
      </Routes>
    </BrowserRouter>
    
  );
}

export default App;
