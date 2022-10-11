create database notizbuch;
use notizbuch;

CREATE USER root /*IDENTIFIED BY ''*/;

grant usage on *.* to root@localhost /*identified by ''*/;
grant all privileges on notizbuch.* to root@localhost;

CREATE TABLE notizen (
        id INT NOT NULL AUTO_INCREMENT,
        notiz VARCHAR(400) NOT NULL,
        PRIMARY KEY (ID)
);

INSERT INTO notizen values (default, 'Test Notiz' );
