CREATE TABLE t_email (
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(200),
	sender VARCHAR(200) NOT NULL,
	recipient VARCHAR(200) NOT NULL,
	content MEDIUMTEXT,
	sent_time TIMESTAMP NOT NULL DEFAULT NOW()
);