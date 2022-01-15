import React, { useState, useRef, useEffect } from 'react';
import './Dashboard.css'
import {Router } from 'react-router-dom';
import history from './history';
import {Image, Button, Row, Card, Panel, ListGroup, Col, Modal} from "react-bootstrap";
import axios from 'axios';
import { getToken, removeUserSession, getUser, setUserSession,  } from './Utils/Common';
import OnePost from './OnePost'
/*import JoditEditor from "jodit-react";*/

function Dashboard(props) {
  const user = getUser();
  const [title,setTitle] = useState('');
  const [lgShow, setLgShow] = useState(false);

  const [isOpen, setIsOpen] = useState(false);
  const [post, setPost] = useState('');
  const [comments, setComments] = useState('');

  const [postList, setPostList] = useState([])
  const handleTitleChange = (title) => {
    setTitle(title.target.value)
  }
  // handle click event of logout button
  const handleLogout = () => {
    removeUserSession();
    history.push('/');
    window.location.reload(false);
    //Router.push("/login");
  }
  
  const handleNewpost = () => {
    axios.post('http://localhost:8080/api/auth/signin',{title:title, content:content}, configapi)
  }
  const editor = useRef(null)
	const [content, setContent] = useState('')

	const config = {
		readonly: false // all options from https://xdsoft.net/jodit/doc/
	}
  var configapi = {
    headers: {'Authorization': `Bearer ${getToken()}`},
  }; 
  
 function getContent(callback) {
  
   console.log(localStorage.getItem('token'))
   axios.get('http://localhost:8080/api/posts/all', configapi)
   .then((response) => {
      setPostList(response.data)
    console.log(response.data)
     return response;
   })
   .then(callback);
 }

 function start(){
  getContent(function(posts){
    console.log(posts)
    })
  }
  
  start();

  const getPost = (pid) => {
    let config = {
      headers: {'Authorization': `Bearer ${getToken()}`},
    };

    axios.get(`http://localhost:8080/api/comment/all/${pid}`, config)
        .then((response) => {
          console.log("Get comment successfully");
          setComments(response.data);
        })

    axios.get(`http://localhost:8080/api/posts/${pid}`, config)
        .then((response) => {
          console.log("Get post successfully");
          setPost(response.data)

          setIsOpen(!isOpen)
        })
        .catch((err) => {
          alert("Post does not exist")
        })

  }

  return (
    <>
    <div className="decor" >
      <Image src="/image/Group6.png" alt='decor'/>
      </div>
      
      <Row className="mb-2">
        <Col xl={2} className='pt-4 pl-3'>
        <Image src='/image/logo_Fulbright.svg' alt='logo' style={{width:"60%", height:"auto"}}/>
        </Col>
        <Col xl={7}>
          <div className="Nameapp pt-5 text-start">
            Fulbright Forum
          </div>
        </Col>
        <Col xl={3}>
        <Button className="mt-4 logSignButton"
             onClick={handleLogout}>
            Log out</Button>
        <Button className="mt-4 NewpostButton" id="get-started_main-menu_get-started-modal" variant="primary" size={"md"} onClick={() => setLgShow(true)}> 
            New post</Button>
        </Col>
      </Row>

      <Button onClick={() => getPost(8)}>Toggle one post</Button>

      {isOpen ? <OnePost postProp={post} commentsProp={comments}/> : null}

      <Row className="gx-4 gy-5 mt-3 mx-auto" style={{width:'50%'}}>
        {postList.map(post => 
          <Card className="Postcard text-start" border="0" style={{}}>
              <Card.Title>
                <div className = "username mb-1"> 
                  {post.uid}
                </div>
                <div className="datecre mb-2">
                  {new Date(post.createdDate).toDateString()}
                </div>
              </Card.Title>
              <Card.Text>
                <div className="posttitle mb-1">
                  {post.title}
                </div>
                <div className="postcontent">
                  {post.content}
                </div>
              </Card.Text>      
    
          </Card>
          )}
      </Row>


      <Modal
        size="lg"
       
        show={lgShow}
        onHide={() => setLgShow(false)}
        aria-labelledby="model-sizes-title-lg"
        className="Postmodal "
        centered
        style={{marginLeft: 'auto', marginRight: 'auto'}}
      >
      <Modal.Body style={{}}> 
                <div className="md-form mb-5">
                  <input type="text" className="form-control validate mb-3" placeholder='Add title'value={title} onChange={handleTitleChange}/>
                  <textarea name="textValue" rows="4" wrap="hard" className="form-control validate text-nowrap" placeholder='Add content'/>
                  {/* <JoditEditor
                            ref={editor}
                            placeholder='aloalo'
                              value={content}
                              config={config}
                              tabIndex={1} // tabIndex of textarea
                              onBlur={newContent => setContent(newContent)} // preferred to use only this option to update the content for performance reasons
                              onChange={() => {handleNewContent}}
                          /> */}
                  
                </div>
                <Row>
                  <Col xl={10} style={{padding:"0px"}}>
                    <Button className="modalButton float-end" onClick={() => setLgShow(false)}>Cancel</Button>
                  </Col>
                  <Col xl={2} style={{paddingLeft:"0px"}}>
                    <Button className="modalButton float-end" onClick={(handleNewpost) => setLgShow(false)}>Post</Button>
                  </Col>
                  
                </Row>
                  
      </Modal.Body>
      </Modal>

      
    </> 
  );
}
 
export default Dashboard;