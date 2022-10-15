create database notizbuch;
use notizbuch;

CREATE USER sqluser IDENTIFIED BY 'sqluserpw';

grant usage on *.* to sqluser@localhost identified by 'sqluserpw';
grant all privileges on notizbuch.* to sqluser@localhost;

CREATE TABLE notizen (
        id INT NOT NULL AUTO_INCREMENT,
        notiz VARCHAR(400) NOT NULL,
        PRIMARY KEY (ID)
);
    
INSERT INTO notizen values (default, 'notiz eins' );
INSERT INTO notizen values (default, 'notiz zwei' );