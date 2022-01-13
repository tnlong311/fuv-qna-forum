import React, { Component, useState } from 'react';
import axios from 'axios';
import { setUserSession } from './Utils/Common';
import { render } from 'react-dom';
 
class App extends Component {
  constructor(props){
      super(props);
      this.state = {
          user:[]
      };
  };
 componentWillMount() {
     axios('https://api.randomuser.me/?nat=US&results=5')
     .then(response => this.setState({
         users:response
     }))
 }
 
render(){
    return <div className="App"></div>
}
}