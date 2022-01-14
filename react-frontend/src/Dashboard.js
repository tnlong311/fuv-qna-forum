import React from 'react';
import {Router } from 'react-router-dom';
import history from './history';
import {Image, Button, Row} from "react-bootstrap";
import axios from 'axios';
import { getToken, removeUserSession, getUser, setUserSession } from './Utils/Common';

function Dashboard(props) {
  const user = getUser();
 
  // handle click event of logout button
  // const handleLogout = () => {
  //   removeUserSession();
  //   history.push('/');
  //   window.location.reload(false);
  //   //Router.push("/login");
  // }
  function start(){
  
  }
  
 function getContent() {
  var config = {
    headers: {'Authorization': `Bearer ${getToken()}`},
  };

  console.log(localStorage.getItem('token'))
  axios.get('http://localhost:8080/api/posts/all', config)
  .then((response) => {
   console.log(response.data)
  })

 }

  start();

  return (
    <div>
      <div className="decor" >
      <Image src="/image/Group6.png" alt='decor'/>
      </div>
      Welcome {user}!<br /><br />
      <input type="button" onClick={getContent} value="Logout" />
    </div>
  );
}
 
export default Dashboard;