import logo from './logo.svg';
import './App.css';
import React, {Component} from 'react';
import {Image, Button, Row} from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
function App() {
  return (
    <div className="App">
      <div className="decor" >
      <Image src="/image/Group6.png" alt='decor'/>
      </div>
      <div class="container">
      <Row>
        <div className='mt-5 mb-5'>
        <Image src='/image/logo_Fulbright.svg' alt='logo'/>
        </div>
      </Row>
      <Row >
        <div >
          <Button className="mb-3 logSignButton">Login</Button>{' '}
        </div>
      </Row>
      <Row >
        <div >
        <Button className="logSignButton">Sign up</Button>{' '}
        </div>
      </Row>
      </div>

    </div>
    
  );
}

export default App;
