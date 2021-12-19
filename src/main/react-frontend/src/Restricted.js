import {Image, Button, Row} from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import './App.css';

const WelcomePage = () => {
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
        This is the restricted area
      </Row>
      </div>

    </div>
  )
}

export default WelcomePage;