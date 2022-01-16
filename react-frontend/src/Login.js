import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { getToken, setUserSession } from './Utils/Common';
import {Image, Button, Row, Form, FormGroup, ControlLabel, FormControl, HelpBlock, InputGroup} from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import './css/App.css';
import Cookies from 'js-cookie';
import history from './history';
import {Link, Navigate, Route, Router, useHref } from 'react-router-dom';

function Login(props) {
  const [loading, setLoading] = useState(false);
  const [usernameOrEmail, setUsernameOrEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState(null);

  var config = {
      headers: {
        "Content-Type": 'application/json',
      },
  }; 
  // handle button click of login form
  const handleLogin = async () => {
    setError(null);
    setLoading(true);
    axios.post('http://localhost:8080/api/auth/signin',{usernameOrEmail:usernameOrEmail, password:password}, config).then(response => {
      setLoading(false);
      console.log(response.data);
      console.log(response.data.accessToken)
      window.localStorage.setItem('token', response.data.accessToken);
      window.localStorage.setItem('user', JSON.stringify(usernameOrEmail));
      history.push('/dashboard');
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
    setUsernameOrEmail(emails.target.value);
  }
  const handlePasswordChange = (password) => {
    setPassword(password.target.value);
  }


  return (
    <div className="text-center">
      <div className="decor" >
        <Image src="/image/Group6.png" alt='decor'/>
      </div>
      <div className='mt-3 mb-3'>
          <Image src='/image/logo_Fulbright.svg' alt='logo'/>
        </div>
      <div className="Nameapp mb-3">
            Fulbright Forum
      </div>      
      <Form>
        <Form.Group className="mb-3 posttitle" >
          <Form.Label>Username</Form.Label>
          <Form.Control className="mx-auto" type="text" placeholder="Enter username" style={{maxWidth:"200px", alignItems:"center"}} value={usernameOrEmail} onChange={handleEmailChange}/>
        </Form.Group>

        <Form.Group className="mb-3 posttitle" controlId="formBasicPassword">
          <Form.Label>Password</Form.Label>
          <Form.Control className="mx-auto"  type="password" placeholder="Password" style={{maxWidth:"200px"}} value={password} onChange={handlePasswordChange}/>
        </Form.Group>
        <Button href="#0"  className='signlogbut' variant="primary" type="submit" onClick={handleLogin}>
          Login
        </Button>
      </Form>

   </div>
  );
}









      {/* <div style={{ marginTop: 10 }}>
        Password<br />
        <input type="password" {...password} autoComplete="new-password" />
      </div>
      {error && <><small style={{ color: 'red' }}>{error}</small><br /></>}<br />
      <input type="button" value={loading ? 'Loading...' : 'Login'} onClick={handleLogin} disabled={loading} /><br />
    </div>
  );
}
 
const useFormInput = initialValue => {
  const [value, setValue] = useState(initialValue);
 
  const handleChange = e => {
    setValue(e.target.value);
  }
  return {
    value,
    onChange: handleChange
  }
} */}
 
export default Login;