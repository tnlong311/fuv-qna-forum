import logo from './logo.svg';
import './App.css';
import axios from "axios";
import React, {useEffect} from "react";
import {Switch, Route} from 'react-router-dom';
import Restricted from './';
import Unrestricted from './';


const UserProfiles = () => {
  const fetchUserProfiles = () => {
    axios.get("http://localhost:8080/").then(res => {
      console.log(res.data);
    })
  }

  useEffect(() => {
    fetchUserProfiles();
  }, [])

  return <h2>Hello world!!</h2>
}

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <a
          className="App-link"
          href="/restricted"
        >
          Log in with Google
        </a>

        <a
            className="App-link"
            href="/unrestricted"
        >
          Access Restricted
        </a>

        <UserProfiles/>

      </header>
      <Switch>
        <Route path='/restricted'>
          <Restricted />
        </Route>
        <Route path='/unrestricted'>
          <Unrestricted />
        </Route>
      </Switch>
    </div>
  );
}

export default App;
