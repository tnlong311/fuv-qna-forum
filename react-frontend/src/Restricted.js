import {Image, Button, Row} from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import './App.css';
import {useEffect} from "react";
import axios from "axios";

const Restricted = () => {
  const fetchRestricted = () => {
    axios.get("http://localhost:8080/restricted").then(res => {
      console.log(res)
    })
  }

  useEffect(() => {
    fetchRestricted();
  }, [])

  return (
    <div className="App">
      <div className="decor" >
      <Image src="/image/Group6.png" alt='decor'/>
      </div>
      <div className="container">
      <Row>
        <div className='mt-5 mb-5'>
        <Image src='/image/logo_Fulbright.svg' alt='logo'/>
        </div>
      </Row>
      <Row >
        This is the restricted area
      </Row>
      </div>

    </div>
  )
}

export default Restricted;