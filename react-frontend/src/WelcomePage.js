import {Image, Button, Row} from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import './css/App.css';
import {Link} from "react-router-dom";
import {useEffect} from "react";
import axios from "axios";
import history from './history';


const WelcomePage = () => {
  const fetchWelcomePage = () => {
    axios.get("http://localhost:8080/welcome").then(res => {
      console.log(res)
    })
  }

  useEffect(() => {
    fetchWelcomePage();
  }, [])
  return (
    <div className="text-center">
      <div className="decor" >
      <Image src="/image/Group6.png" alt='decor'/>
      </div>
      <div className="container">
      <Row>
        <div className='mt-5 mb-3'>
          <Image src='/image/logo_Fulbright.svg' alt='logo'/>
        </div>
        <div className="Nameapp mb-5">
            Fulbright Forum
        </div>
      </Row>
      <Row >
        <div >
          <Button className="mb-3 logSignButton"
             href="/login">
            Login</Button>
        </div>
      </Row>
      <Row >
        <div >
          <Button className="mt-4 logSignButton"
             href="/signup">
            Sign up</Button>
        </div>
      </Row>
      </div>
    </div>
  )
}

export default WelcomePage;