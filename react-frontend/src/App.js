import './App.css';
import React , { useState, useEffect }from 'react';
import { Navigate, BrowserRouter, Routes,Route, Switch, Router, NavLink } from 'react-router-dom'
import WelcomePage from './WelcomePage';
import axios from 'axios';
import Login from './Login';
import Signup from './Signup';
import Dashboard from './Dashboard';
import OnePost from './OnePost';
import Home from './Home';
import PrivateRoute from './Utils/PrivateRoute';
import PublicRoute from './Utils/PublicRoute';
import { getToken, removeUserSession, setUserSession } from './Utils/Common';

function App() {
  const [authLoading, setAuthLoading] = useState(true);
  window.onload=()=>{
    
  }
  var config = {
    headers: {
      "Content-Type": 'application/json',
    },
  };
  useEffect(() => {
    const token = getToken();
    if (!token) {
      return;
    }
    axios.get('http://localhost:8080/api/test',{token},config).then(response => {
      setUserSession(response.data.token, response.data.user);
      setAuthLoading(false);
    }).catch(error => {
      removeUserSession();
      setAuthLoading(false);
    });
  }, []);

  if (authLoading && getToken()) {
    return <div className="content">Checking Authentication...</div>
  }
  return (
    <div className="App">
      <BrowserRouter>
      <Routes>
        <Route exact path="/" element={<WelcomePage />}/>
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
      </Routes>
      </BrowserRouter>
      
    </div>    
  );
}
{/* <div className="App">
      <BrowserRouter>
        <div>
          <div className="header">
            <NavLink exact activeClassName="active" to="/">Home</NavLink>
            <NavLink activeClassName="active" to="/login">Login</NavLink><small>(Access without token only)</small>
            <NavLink activeClassName="active" to="/dashboard">Dashboard</NavLink><small>(Access with token only)</small>
          </div>
          <div className="content">
            <Routes>
              <Route exact path="/" component={Home} />
              <Route path="/login" component={Login} />
              <Route path="/dashboard" component={Dashboard} />
            </Routes>
          </div>
        </div>
      </BrowserRouter>
    </div>
  );
} */}

export default App;
