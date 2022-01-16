import React, { useState, useEffect } from 'react'
import ReactDOM from "react-dom";
import "./OnePost.css"
import {Image, Button, Row, Form, FormGroup, ControlLabel, FormControl, HelpBlock, InputGroup} from "react-bootstrap"
import axios from 'axios'
import { getToken, getUser } from './Utils/Common'

function OnePost({pid}){
  const [post, setPost] = useState([])
  const [comments, setComments] = useState([])

  const configapi = {
    headers: {'Authorization': `Bearer ${getToken()}`},
  };

  useEffect(() => {
    axios.get(`http://localhost:8080/api/comment/all/${pid}`, configapi)
        .then((response) => {
          console.log("Get comment successfully");
          setComments(response.data);
        })

    axios.get(`http://localhost:8080/api/posts/${pid}`, configapi)
        .then((response) => {
          console.log("Get post successfully");
          setPost(response.data)
        })
  }, [])

  const PostView = () => {
    const postUserName = post.userName
    const postDateCreated = post.createdDate
    const postTitle = post.title
    const postContent =  post.content

    return (
        <div className="post-wrap d-flex flex-column align-items-start">
          <div className="post-top">
            <div className="post-name qna-heading-3">{postUserName}</div>
            <div className="post-date">{postDateCreated}</div>
          </div>
          <div className="post-middle">
            <div className="post-title qna-heading-2">{postTitle}</div>
            <div className='post-content'>{postContent}</div>
          </div>
        </div>
    )
  }

  const CommentView = () => {
    return (
        <div className="cmts-wrap">
          {(comments.length != 0) ?
            comments.map((comment) => (
              <div className="cmt-wrap d-flex flex-column align-items-start">
                <div className="cmt-top">
                  <div className="cmt-name">{comment.userName}</div>
                  <div className="cmt-date">{comment.createdDate}</div>
                </div>
                <div className="cmt-middle">
                  <p className="cmt-content">{comment.content}</p>
                </div>
              </div>
            ))
            :
            <div className="cmt-wrap d-flex flex-column align-items-center justify-content-center">
              <div className="not-found qna-heading-3">No comments yet...</div>
            </div>
          }
        </div>
    )
  }

  const NewComment = () => {
    const [cmtContent, setCmtContent] = useState("")
    const [newCmtStatus, setNewCmtStatus] = useState([0])

    // watch for new comment created events
    useEffect(() => {
      if(newCmtStatus != 0){
        axios.get(`http://localhost:8080/api/comment/all/${pid}`, configapi)
            .then((response) => {
              console.log("Get comment successfully");
              setComments(response.data);
            })
      }
    }, [newCmtStatus])

    const handleCommentChange = (cmtContent) => {
      setCmtContent(cmtContent.target.value)
    }

    const handleNewCommentSuccess = () => {
      setNewCmtStatus(newCmtStatus+1)
      console.log("New comment posted")
    }

    const handleNewComment = async () => {
      if(cmtContent != ''){
        let config = {
          headers: {'Authorization': `Bearer ${getToken()}`},
        }

        axios.post('http://localhost:8080/api/comment',{content: cmtContent, pid: post.pid}, config)
            .then(() => handleNewCommentSuccess())
            .catch(error => {
              if (error.response) {
                alert('There is something wrong. Please try again');
              } else if (error.request) {
                // client never received a response, or request never left
              } else {
                // anything else
              }
            })
      }

    }

    return (
        <Form className="new-cmt-wrap d-flex flex-row">
          <Form.Group className="new-cmt-input">
            <Form.Control className="mx-auto new-cmt-text" type="text" placeholder="Add a comment..."
                          value={cmtContent} onChange={handleCommentChange}/>
          </Form.Group>

          <Button className="submit-button" href="#" variant="primary" type="submit" onClick={handleNewComment}>
            Add
          </Button>
        </Form>
    )
  }

  return (
    <div className="one-post-wrap d-flex flex-column justify-content-start col-8">
      <PostView />
      <NewComment />
      <CommentView />
    </div>
  );
}
 
export default OnePost;