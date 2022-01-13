import React from 'react';
import { getUser, removeUserSession } from './Utils/Common';
import {Router } from 'react-router-dom';
import history from './history';
 
function Dashboard(props) {
  const user = getUser();
 
  // handle click event of logout button
  const handleLogout = () => {
    removeUserSession();
    history.push('/');
    window.location.reload(false);
    //Router.push("/login");
  }
 
  return (
    <div>
      Welcome {user}!<br /><br />
      <input type="button" onClick={handleLogout} value="Logout" />
    </div>
  );
}
 
export default Dashboard;