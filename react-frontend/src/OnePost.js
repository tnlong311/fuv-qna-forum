import React from 'react';
import "./OnePost.css"

function OnePost({post, comments}) {
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
    )
  }


  return (
    <div className="one-post-wrap d-flex flex-column justify-content-start col-8">
      <PostView />
      <CommentView />
    </div>
  );
}
 
export default OnePost;