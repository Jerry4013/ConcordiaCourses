drop table if exists chat_messages;
drop table if exists user_chat;
drop table if exists chats;
drop table if exists session_token;

drop table if exists t_participates;
drop table if exists t_user_group;
drop table if exists t_group_requests;
drop table if exists t_comment;
drop table if exists t_post;
drop table if exists t_group;
drop table if exists event_details;
drop table if exists t_event;
drop table if exists t_user;
drop table if exists t_permission;
drop table if exists t_email;

CREATE TABLE t_permission (
	role VARCHAR(256),
	`action` VARCHAR(256),
	PRIMARY KEY (role, action)
)ENGINE=InnoDB;

CREATE TABLE t_user (
	email VARCHAR(256) PRIMARY KEY,
	`password` VARCHAR(50) NOT NULL,
	role VARCHAR(256),
	birth_date DATE,
	`name` VARCHAR(256) NOT NULL,
	address VARCHAR(256),
	phone VARCHAR(256),
	organization VARCHAR(256),
	FOREIGN KEY (role) REFERENCES t_permission(role)
)ENGINE=InnoDB;

CREATE TABLE session_token (
	user VARCHAR(256) PRIMARY KEY,
	token text,
	FOREIGN KEY (user) REFERENCES t_user(email)
)ENGINE=InnoDB;

CREATE TABLE t_event(
	id INT PRIMARY KEY auto_increment,
	title VARCHAR(256) NOT NULL,
	event_manager VARCHAR(256) NOT NULL,
	`status` VARCHAR(256),
	description VARCHAR(256) Not null,
	FOREIGN KEY (event_manager) REFERENCES t_user(email)
)ENGINE=InnoDB;

CREATE TABLE t_participates (
	eventID INT,
	participant VARCHAR(256),
	FOREIGN KEY (participant) REFERENCES t_user(email) ON DELETE CASCADE,
	FOREIGN KEY (eventID) REFERENCES t_event(id) ON DELETE CASCADE,
	PRIMARY KEY(participant, eventID)
)ENGINE=InnoDB;

CREATE TABLE event_details(
	dID INT PRIMARY KEY auto_increment,
	start_date DATE,
	end_date DATE,
	organization_type VARCHAR(256),
	event_address VARCHAR(256),
	account_no VARCHAR(50),
	bank_name VARCHAR(256),
	storage_used VARCHAR(256),
	bandwidth_used VARCHAR(256),
	eventID INT,
	FOREIGN KEY (eventID) references t_event(id) on delete cascade
)ENGINE=InnoDB;

-- Tables concerning groups and posts

create table t_group (
	groupID int primary key auto_increment, 
    eventID int, 
    owner_email varchar(256), 
    title varchar(255) Not null,
    foreign key (eventID) references t_event(ID) on delete CASCADE,
    foreign key (owner_email) references t_user(email)
)ENGINE=InnoDB;



create table t_post(
	ID int primary key auto_increment, 
    url varchar(255), 
    content text,
    p_date date,
    isCommentable boolean, 
    isPublic boolean,
    groupID int,
    author_email varchar(256), 
    foreign key (author_email) references t_user(email),
    foreign key (groupID) references t_group(groupID) on delete cascade
)ENGINE=InnoDB;



create table t_comment(
	ID int primary key auto_increment,
    content text,
    p_date date,
	author_email varchar(256), 
	postID int,
	foreign key (postID) references t_post(id) on delete cascade,
    foreign key (author_email) references t_user(email)
)ENGINE=InnoDB;


create table t_user_group(
	groupID int, 
    author_email varchar(256),
    foreign key (author_email) references t_user(email),
    foreign key (groupID) references t_group(groupID) on delete cascade
)ENGINE=InnoDB;


create table t_group_requests(
	groupID int, 
    user_email varchar(256),
    foreign key (user_email) references t_user(email),
    foreign key (groupID) references t_group(groupID) on delete cascade
)ENGINE=InnoDB;

CREATE TABLE t_email (
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(200),
	sender VARCHAR(200) NOT NULL,
	recipient VARCHAR(200) NOT NULL,
	content MEDIUMTEXT,
	sent_time TIMESTAMP NOT NULL DEFAULT NOW()
);


-- CHAT TABLES
create table chats(
	cID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
	lastMessageID int
)ENGINE=InnoDB;

create table chat_messages(
	mID int PRIMARY KEY AUTO_INCREMENT,
	chatID int,
	sender varchar(256),
	receipient varchar(256),
	content text,
	sentTime varchar(256),
	foreign key(chatID) references chats(cID),
	foreign key (sender) references t_user(email),
	foreign key (receipient) references t_user(email)
)ENGINE=InnoDB;

create table user_chat(
	user varchar(256),
	cID int,
	foreign key (user) references t_user(email),
	foreign key (cID) references chats(cID),
	PRIMARY KEY (user, cID)
)ENGINE=InnoDB;
-- END CHAT TABLES

-- Triggers
CREATE TRIGGER `event_status`
BEFORE INSERT ON `t_event`
FOR EACH ROW
SET NEW.status = 'active';

create trigger `event_details_trigger`
before insert on `event_details`
for each ROW
set new.bandwidth_used = 0, new.storage_used =0;


-- some mock data
insert into t_email (title, sender, recipient, content)
values ('email1', 'jim@gmail.com', 'bob@gmail.com', 'test email1');

insert into t_email (title, sender, recipient, content)
values ('email2', 'bob@gmail.com', 'jim@gmail.com', 'test email2');

insert into t_email (title, sender, recipient, content)
values ('email3', 'jim@gmail.com', 'bob@gmail.com', 'test email3');

insert into t_email (title, sender, recipient, content)
values ('email3', 'tom@gmail.com', 'jim@gmail.com', 'test email3');

insert into t_email (title, sender, recipient, content)
values ('email4', 'alice@gmail.com', 'jim@gmail.com', 'test email4');

insert into t_email (title, sender, recipient, content)
values ('email5', 'john@gmail.com', 'jim@gmail.com', 'test email5');

insert into t_permission 
values ('Admin', 'all');

insert into t_permission
values ('Controller', 'set rate');

insert into t_permission
values ('Controller', 'set discount');

insert into t_permission
values ('Controller', 'set extra fee');

insert into t_permission
values ('Event_Manager', 'manage event');

insert into t_permission
values ('Event_Manager', 'update event');

insert into t_permission
values ('Event_Manager', 'add participant');

insert into t_permission
values ('Event_Manager', 'update participant');

insert into t_permission
values ('Event_Manager', 'delete participant');

insert into t_permission
values ('Event_Manager', 'add group');

insert into t_permission
values ('Event_Manager', 'delete group');

insert into t_permission
values ('Event_Manager', 'update group');

insert into t_permission
values ('Event_Manager', 'upload file');

insert into t_permission
values ('Group_Owner', 'invite');

insert into t_permission
values ('Group_Owner', 'permit');

insert into t_permission
values ('Group_Owner', 'add member');

insert into t_permission
values ('Group_Owner', 'delete member');

insert into t_permission
values ('user', 'create group');

insert into t_permission
values ('user', 'join group');

insert into t_permission
values ('user', 'post');

insert into t_permission
values ('user', 'comment');


insert into t_user
values ('jim@gmail.com', 'pas123', 'Admin', '1990-10-10', 'Jim', '1234 street', '123-123-1232', 'ABCCompany'); 

insert into t_user
values ('bob@gmail.com', 'pas123', 'Controller', '1990-10-10', 'Bob', '1234 street', '123-123-1232', 'ABCCompany');

insert into t_user
values ('mike@gmail.com', 'pas123', 'Event_Manager', '1990-10-10', 'Mike', '1234 street', '123-123-1232', 'ABCCompany');

insert into t_user
values ('tom@gmail.com', 'pas123', 'Group_Owner', '1990-10-10', 'Tom', '1234 street', '123-123-1232', 'ABCCompany');

insert into t_user
values ('alice@gmail.com', 'pas123', 'user', '1990-10-10', 'Alice', '1234 street', '123-123-1232', 'ABCCompany');

insert into t_user
values ('jerry@gmail.com', 'pas123', 'user', '1990-10-10', 'Jerry', '1234 street', '123-123-1232', 'ABCCompany');

insert into t_user
values ('john@gmail.com', 'pas123', 'user', '1990-10-10', 'John', '1234 street', '123-123-1232', 'ABCCompany');

insert into chats
Values(null,3);

insert into chat_messages(chatID,sender,receipient,content,sentTime)
Values(1, 'jim@gmail.com', 'bob@gmail.com', "jim said Hi!", "Mon Dec 02 2019 18:27:46 GMT-0500 (Eastern Standard Time)");

insert into chat_messages(chatID,sender,receipient,content,sentTime)
Values(1, 'jim@gmail.com', 'bob@gmail.com', "jim said Hi again!","Mon Dec 02 2019 18:27:46 GMT-0500 (Eastern Standard Time)");

insert into chat_messages(chatID,sender,receipient,content,sentTime)
Values(1, 'bob@gmail.com', 'jim@gmail.com', "bob said Hi!", "Mon Dec 02 2019 18:27:46 GMT-0500 (Eastern Standard Time)");

insert into user_chat (user, cID) 
Values('jim@gmail.com', 1);

insert into user_chat (user, cID) 
Values('bob@gmail.com', 1);

insert into t_event(event_manager, title, description)
values ('jim@gmail.com', 'A private event', '1st event for site');

insert into t_event(event_manager, title, description)
values ('bob@gmail.com', 'My family event', 'Regular gathering for all family members');

insert into event_details(start_date, end_date, organization_type,account_no,bank_name,event_address, eventID)
value('2019-1-1', null, 'Private', '112121212', 'BMO', '1234 Guy Street',1);

insert into event_details(start_date, end_date, organization_type,account_no,bank_name,event_address, eventID)
value('2019-2-1', null, 'Family', '01010101', 'RBC', '1234 Saint-Catherine Street',2);

insert into t_event(event_manager, title, description)
values ('bob@gmail.com', 'Company event', 'Regular gathering for all staff members');

insert into t_participates (participant, eventID)
values ('jim@gmail.com', 1);

insert into t_participates (participant, eventID)
values ('jim@gmail.com', 2);

insert into t_participates (participant, eventID)
values ('bob@gmail.com', 2);

insert into t_participates (participant, eventID)
values ('bob@gmail.com', 3);

insert  into t_group (eventID, owner_email, title)
values (2, 'bob@gmail.com', 'my group');

insert  into t_group (eventID, owner_email, title)
values (2, 'jerry@gmail.com', 'my group 2');

insert  into t_group (eventID, owner_email, title)
values (1, 'tom@gmail.com', 'my group 3');

insert  into t_group (eventID, owner_email, title)
values (3, 'alice@gmail.com', 'my group 4');