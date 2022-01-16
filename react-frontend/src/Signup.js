import React, { useState } from 'react';
import axios from 'axios';
import { setUserSession } from './Utils/Common';
import {Image, Button, Row, Form, FormGroup, ControlLabel, FormControl, HelpBlock, InputGroup} from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import './css/App.css';
import {useEffect} from "react";
import Cookies from 'js-cookie';
import history from './history';
import {Link, Navigate, Route, Router, useHref } from 'react-router-dom';

function Login(props) {
  const [loading, setLoading] = useState(false);
  const [email, setEmail] = useState("");
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState(null);
  var config = {
      headers: {
        "Content-Type": 'application/json',
      },
  }; 
  // handle button click of login for
  const handleLogin = async () => {
    setError(null);
    setLoading(true);
    axios.post('http://localhost:8080/api/auth/signup',{username:username, email:email, password:password}, config).then(response => {
      setLoading(false);
      console.log(response.data);
      alert('Sign up successfully. You can login now');
    }).catch(error => {
      setLoading(false);
      if (error.response) {
        alert('There is something wrong. Please try again');
      } else if (error.request) {
        // client never received a response, or request never left
      } else {
        // anything else
      }
    });
  }
 
  const handleEmailChange = (emails) => {
    setEmail(emails.target.value);
  }
  const handleUsernameChange = (username) => {
    setUsername(username.target.value);
  }
  const handlePasswordChange = (password) => {
    setPassword(password.target.value);
  }
  return (
    <div className="text-center">
      <div className="decor" >
        <Image src="/image/Group6.png" alt='decor'/>
      </div>
      <div className='mt-3 mb-2'>
          <Image src='/image/logo_Fulbright.svg' alt='logo'/>
        </div>
      <div className="Nameapp mb-3">
            Fulbright Forum
      </div>
      <Form>
        <Form.Group className="mb-3 posttitle" >
            <Form.Label>Username</Form.Label>
            <Form.Control className="mx-auto" type="text" placeholder="Enter username" style={{maxWidth:"200px", alignItems:"center"}} value={username} onChange={handleUsernameChange}/>
            </Form.Group>
        <Form.Group className="mb-3 posttitle" >
          <Form.Label>Email address</Form.Label>
          <Form.Control className="mx-auto" type="email" placeholder="Enter email" style={{maxWidth:"200px", alignItems:"center"}} value={email} onChange={handleEmailChange}/>
        </Form.Group>

        <Form.Group className="mb-3 posttitle" controlId="formBasicPassword">
          <Form.Label>Password</Form.Label>
          <Form.Control className="mx-auto"  type="password" placeholder="Enter password" style={{maxWidth:"200px"}} value={password} onChange={handlePasswordChange}/>
        </Form.Group>
        <Button href="#0" variant="primary" type="submit" className='signlogbut' onClick={handleLogin}>
          Signup
        </Button>
      </Form>
     </div>
  );
}

 
export default Login;