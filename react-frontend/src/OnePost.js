import React from 'react';
import "./OnePost.css"

function OnePost() {
  const postUserName = "Longcool_292"
  const postDateCreated = "02/09/2021"
  const postTitle = "Hôm nay học gì?"
  const postContent = `Lorem ipsum dolor sit amet, consectetur adipiscing elit. Magna pulvinar faucibus tellus blandit nibh at 
  sagittis molestie. Amet arcu enim euismod quis vel. Sed ut at...Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
  Magna pulvinar faucibus tellus blandit nibh at sagittis molestie. Amet arcu enim euismod quis vel. 
  Sed ut at...Lorem ipsum dolor sit amet, consectetur adipiscing elit. Magna pulvinar faucibus tellus blandit nibh at sagittis molestie. 
  Amet arcu enim euismod quis vel. Sed ut at.Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
  Magna pulvinar faucibus tellus blandit nibh at sagittis molestie. Amet arcu enim euismod quis vel. Sed ut at...
  Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
  Magna pulvinar faucibus tellus blandit nibh at sagittis molestie. Amet arcu enim euismod quis vel. 
  Sed ut at.Lorem ipsum dolor sit amet, consectetur adipiscing elit.
  Lorem ipsum dolor sit amet, consectetur adipiscing elit. Magna pulvinar faucibus tellus blandit nibh at sagittis molestie. 
  Amet arcu enim euismod quis vel. Sed ut at...`

  const cmtUserName = "Longcool_292"
  const cmtDateCreated = "02/09/2021"
  const cmtContent = `Lorem ipsum dolor sit amet, consectetur adipiscing elit. Magna pulvinar faucibus tellus blandit nibh at 
  sagittis molestie. Amet arcu enim euismod quis vel. Sed ut at...Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
  Magna pulvinar faucibus tellus blandit nibh at sagittis molestie. Amet arcu enim euismod quis vel.`

  return (
    <div className="one-post-wrap d-flex flex-column justify-content-start col-8">
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
      
      <div className="cmt-wrap d-flex flex-column align-items-start">
        <div className="cmt-top">
          <div className="cmt-name">{cmtUserName}</div>
          <div className="cmt-date">{cmtDateCreated}</div>
        </div>
        <div className="cmt-middle">
          <p className="cmt-content">{cmtContent}</p>
        </div>
      </div>

      <div className="cmt-wrap d-flex flex-column align-items-start">
        <div className="cmt-top">
          <div className="cmt-name">{cmtUserName}</div>
          <div className="cmt-date">{cmtDateCreated}</div>
        </div>
        <div className="cmt-middle">
          <p className="cmt-content">{cmtContent}</p>
        </div>
      </div>

      <div className="cmt-wrap d-flex flex-column align-items-start">
        <div className="cmt-top">
          <div className="cmt-name">{cmtUserName}</div>
          <div className="cmt-date">{cmtDateCreated}</div>
        </div>
        <div className="cmt-middle">
          <p className="cmt-content">{cmtContent}</p>
        </div>
      </div>
      
    </div>
  );
}
 
export default OnePost;