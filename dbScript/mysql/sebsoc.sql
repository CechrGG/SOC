CREATE TABLE IF NOT EXISTS websoc.t_users (
	userName varchar(64) NOT NULL,
	passwordMD5 varchar(64) NOT NULL,
	email varchar(64),
	mobilePhone varchar(20),
	PRIMARY KEY (userName),
	UNIQUE KEY (userName)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;