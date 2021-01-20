DROP TABLE IF EXISTS board_table;
 
CREATE TABLE board_table (
id INT NOT NULL AUTO_INCREMENT,
title VARCHAR(45) NOT NULL,
writer VARCHAR(45) NOT NULL,
content text NULL,
reg_time datetime NULL,
PRIMARY KEY (id));

INSERT INTO board_table ( title , writer , content , reg_time ) VALUES ( 'first data1','first data1','first data1', now());
INSERT INTO board_table ( title , writer , content , reg_time) VALUES ( 'first data2','first data2','first data2', now());
INSERT INTO board_table ( title , writer , content , reg_time) VALUES ( 'first data3','first data3','first data3', now());
INSERT INTO board_table ( title , writer , content , reg_time) VALUES ( 'first data4','first data4','first data4', now());
INSERT INTO board_table ( title , writer , content , reg_time) VALUES ( 'first data5','first data5','first data5', now());
INSERT INTO board_table ( title , writer , content , reg_time) VALUES ( 'first data6','first data6','first data6', now());
INSERT INTO board_table ( title , writer , content , reg_time) VALUES ( 'first data7','first data7','first data7', now());
INSERT INTO board_table ( title , writer , content , reg_time) VALUES ( 'first data8','first data8','first data8', now());
INSERT INTO board_table ( title , writer , content , reg_time) VALUES ( 'first data9','first dat9','first data9', now());
INSERT INTO board_table ( title , writer , content , reg_time) VALUES ( 'first data10','first data10','first data10', now());
INSERT INTO board_table ( title , writer , content , reg_time) VALUES ( 'first data11','first data11','first data11', now());
INSERT INTO board_table ( title , writer , content , reg_time) VALUES ( 'first data12','first data12','first data12', now());
INSERT INTO board_table ( title , writer , content , reg_time) VALUES ( 'first data13','first data13','first data13', now());
