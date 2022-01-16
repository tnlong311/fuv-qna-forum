import React, { useState, useRef, useEffect } from 'react';
import './css/Dashboard.css'
import {Router } from 'react-router-dom';
import history from './history';
import {Image, Button, Row, Card, Panel, ListGroup, Col, Modal, Dropdown} from "react-bootstrap";
import axios from 'axios';
import { getToken, removeUserSession, getUser, setUserSession,  } from './Utils/Common';
import OnePost from './OnePost'
/*import JoditEditor from "jodit-react";*/

const Dashboard = (props) => {
  const user = getUser()

  // new post toggle
  const [lgShow, setLgShow] = useState(false)

  // For single post view
  const [isOpen, setIsOpen] = useState(false)
  const [pid, setPid] = useState(0)

  // all posts
  const [postList, setPostList] = useState([])

  // watch for new post created
  const [postStatus, setPostStatus] = useState(0)
  // watch for post deleted
  const [deleteStatus, setDeleteStatus] = useState(0)

  // handle click event of logout button
  const handleLogout = () => {
    removeUserSession();
    history.push('/');
    window.location.reload(false);
    //Router.push("/login");
  }

  const configapi = {
    headers: {'Authorization': `Bearer ${getToken()}`},
  };

  useEffect(() => {
    axios.get('http://localhost:8080/api/posts/all', configapi)
        .then((response) => {
          setPostList(response.data)
        })
  }, [postStatus, deleteStatus])

  const getOnePost = (pid) => {
    setPid(pid)
    setIsOpen(!isOpen)
  }

  const deletePost = (pid) => {
    axios.delete(`http://localhost:8080/api/posts/${pid}`, configapi)
        .then(() => {
          setDeleteStatus(deleteStatus+1)
          console.log("delete post successfully")
        })
        .catch(error => alert("You are only able to delete your own posts"))
  }

  const NewPost = () => {
    const [postTitle, setPostTitle] = useState('');
    const [postContent, setPostContent] = useState('');

    const handleTitleChange = (postTitle) => {
      setPostTitle(postTitle.target.value)
    }

    const handleContentChange = (postContent) => {
      setPostContent(postContent.target.value)
    }

    const handleNewPostSuccess = () => {
      console.log("New post created!")
      setPostStatus(postStatus+1)
    }

    const handleNewPost = () => {
      if(postTitle != '' && postContent != ''){
        setLgShow(false)

        axios.post('http://localhost:8080/api/posts',{title: postTitle, content: postContent}, configapi)
            .then(() => handleNewPostSuccess())
            .catch(error => alert("Something went wrong!"))
      } else {
        alert("Please fill in all fields!")
      }
    }

     
    return (
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
              <input type="text" className="form-control validate mb-3" placeholder='Add title' value={postTitle}
                     onChange={handleTitleChange}/>
              <textarea name="textValue" rows="4" wrap="hard" className="form-control validate text-nowrap"
                        placeholder='Add content' value={postContent} onChange={handleContentChange}/>
            </div>

            <Row>
              <Col xl={10} style={{padding:"0px"}}>
                <Button className="modalButton float-end" onClick={() => setLgShow(false)}>Cancel</Button>
              </Col>
              <Col xl={2} style={{paddingLeft:"0px"}}>
                <Button className="modalButton float-end" onClick={() => handleNewPost()}>Post</Button>
              </Col>
            </Row>

          </Modal.Body>
        </Modal>
    )
  }


  return (
    <>
      <div className="decor" >
        <Image src="/image/Group6.png" alt='decor'/>
      </div>
      <Row className="mb-2">
        <Col xl={2} className='pt-4 pl-3'>
          <Image className="ml-3" src='/image/logo_Fulbright.svg' alt='logo' style={{width:"60%", height:"auto", marginLeft: "20%"}}/>
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
        <Button className="mt-4 NewpostButton" id="get-started_main-menu_get-started-modal" variant="primary"
                size={"md"} onClick={() => setLgShow(true)}>
            New post</Button>
        </Col>
      </Row>

      {isOpen ?
      <div className="d-flex flex-column align-items-center">
        <div className="post-mask" onClick={() => setIsOpen(false)}></div>
        <OnePost pid={pid}/>
      </div>
      : null
      }


      <Row className="gx-4 gy-5 my-3 mx-auto w-50">
        {postList.map(post => 
          <Card className="Postcard text-start" border="0" >
              <Card.Title>
              <Dropdown className='float-end'>
                <Dropdown.Toggle className="dropdowndash" variant="success" id="dropdown-basic">
                </Dropdown.Toggle>
                <Dropdown.Menu className=''>
                  <Dropdown.Item className="delete" onClick={() => deletePost(`${post.pid}`)}>Delete</Dropdown.Item>
                </Dropdown.Menu>
              </Dropdown>
                <div className = "username mb-1"> 
                  {post.userName}
                </div>
                <div className="datecre mb-2">
                  {new Date(post.createdDate).toDateString()}
                </div>
              </Card.Title>
              <Card.Text onClick={() => getOnePost(`${post.pid}`)}>
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

      <NewPost />
      
    </> 
  );
}
 
export default Dashboard;