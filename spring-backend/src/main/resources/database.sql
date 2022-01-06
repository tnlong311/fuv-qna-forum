USE QnAForum;
CREATE TABLE user (
                      Uid		Int		NOT NULL auto_increment,
                      Email		Char(100)	NOT NULL,
                      Username	Char(100)	NOT NULL,
                      Password	Char(100)	NOT NULL,
                      CONSTRAINT	USERS_PK	PRIMARY KEY(Uid)
);

CREATE TABLE post (
                      Pid		Int		NOT NULL auto_increment,
                      Uid		Int		NOT NULL,
                      DateCreated	DateTime	NOT NULL,
                      Title 		VarChar(100)	NOT NULL,
                      Content		VarChar(2000)	NOT NULL,
    -- ThreadNum	Int		Default 0,
                      CreatedBy Char(100)		NOT NULL,
                      CONSTRAINT	POST_PK		PRIMARY KEY(Pid),
                      CONSTRAINT	POST_FK 	FOREIGN KEY(Uid) REFERENCES user(Uid)
);