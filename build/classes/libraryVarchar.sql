DROP TABLE webbook CASCADE;
DROP TABLE material_catalog CASCADE;
DROP TABLE kashidaichou CASCADE;
DROP TABLE yoyakudaichou CASCADE;

-----------------------------------------------------------------------
                          -- webbook
-----------------------------------------------------------------------

CREATE TABLE webbook (
  user_id             VARCHAR       PRIMARY KEY,
  user_family_name    VARCHAR(10)   NOT NULL,   
  user_name           VARCHAR(10)   NOT NULL,   
  user_postal         CHAR(7)       NOT NULL,   
  user_address        VARCHAR(100)  NOT NULL,   
  user_tel            VARCHAR       NOT NULL,   
  user_email          VARCHAR       NOT NULL,   
  user_birthday_date  DATE,                     
  user_join_date      DATE,                     
  user_taikai_date    DATE                      
);

TRUNCATE webbook;
INSERT INTO webbook(user_id, user_family_name, user_name, user_postal, user_address, user_tel, user_email, user_birthday_date, user_join_date, user_taikai_date)
VALUES(00, '只野','テスマン','1111147','和歌山県和歌山市','073-123-0000','tadano@testcase','2001/07/01','2001/07/13','2019/12/13');

INSERT INTO webbook(user_id, user_family_name, user_name, user_postal, user_address, user_tel, user_email, user_birthday_date, user_join_date, user_taikai_date)
VALUES(01,'イワシ','テスマン','1111147','東京都仮想市','073-123-0000','tadano@testcase','2001/07/01','2001/07/13','2019/12/13');

INSERT INTO webbook(user_id, user_family_name, user_name, user_postal, user_address, user_tel, user_email, user_birthday_date, user_join_date, user_taikai_date)
VALUES(02, '岩田','テストマン','1111147','和歌山県和歌山市','073-1442-0000','tadahu@testcase','1999/07/01','2001/02/13','2019/12/13');


-----------------------------------------------------------------------
                          -- material_catalog
-----------------------------------------------------------------------

CREATE TABLE material_catalog (           
  material_ISBN VARCHAR NOT NULL,         
  material_name VARCHAR(30) NOT NULL,     
  material_class_code VARCHAR NOT NULL,   
  material_aurthor VARCHAR(10) NOT NULL,  
  material_publishing VARCHAR NOT NULL,   
  material_publish_date DATE NOT NULL,    
  material_id VARCHAR PRIMARY KEY,        
  material_store_date DATE NOT NULL,      
  material_dispose_date DATE,             
  material_column VARCHAR(100)            
);

TRUNCATE material_catalog;
INSERT INTO material_catalog(material_ISBN, material_name, material_class_code, material_aurthor,
 material_publishing, material_publish_date, material_id, material_store_date, material_dispose_date, material_column)
VALUES(11425, '煙突町のプッポッパ', 2,'西野太郎','白紙社','2019/07/12',192847532,'2019/07/12','2020/07/01','テストです。');

INSERT INTO material_catalog(material_ISBN, material_name, material_class_code, material_aurthor,
 material_publishing, material_publish_date, material_id, material_store_date, material_dispose_date, material_column)
VALUES(11434, 'リーダブル・ドキュメント', 7,'ヒター・ドッグル','オイラー社','2019/02/11',1924537532,'2019/06/12','2020/07/01','早くだして。');

INSERT INTO material_catalog(material_ISBN, material_name, material_class_code, material_aurthor,
 material_publishing, material_publish_date, material_id, material_store_date, material_dispose_date, material_column)
VALUES(11432, '夜の散歩', 7,'秘密太郎','囚人社','2019/03/11',244537532,'2019/06/12','2020/07/01','大人気作。');
-----------------------------------------------------------------------
                          -- kashidaichou
-----------------------------------------------------------------------
CREATE TABLE kashidaichou (
material_user_id VARCHAR NOT NULL                 --
, material_id VARCHAR  PRIMARY KEY       --
, material_lending_date DATE  NOT NULL   --
, material_return_period DATE  NOT NULL  --
, material_return_date DATE              --
, material_column VARCHAR(100)           --
);

INSERT INTO kashidaichou(material_user_id, material_id, material_lending_date, material_return_period,
 material_return_date, material_column)
VALUES(001,234 ,'2019/03/11','2019/06/12','2020/07/01','大人気作。');

INSERT INTO kashidaichou(material_user_id, material_id, material_lending_date, material_return_period,
 material_return_date, material_column)
VALUES(002,235 ,'2019/03/12','2019/06/13','2020/07/04','大人気作。');

INSERT INTO kashidaichou(material_user_id, material_id, material_lending_date, material_return_period,
 material_return_date, material_column)
VALUES(003,236 ,'2019/03/13','2019/06/14','2020/07/05','大人気作。');
-----------------------------------------------------------------------
                          --  yoyakudaichou
-----------------------------------------------------------------------

CREATE TABLE yoyakudaichou (
    material_user_id         INTEGER    PRIMARY KEY  
  , material_booking_date    DATE    NOT NULL 
  , material_ISBN            BIGINT NOT NULL  
  , material_ensured_id      INTEGER NOT NULL 
  , material_is_booked       BIT              
  , material_columm          CHAR(100)        
);
 
INSERT INTO yoyakudaichou(material_user_id, material_booking_date, material_ISBN,
 material_ensured_id, material_is_booked, material_columm)
VALUES(112,'2019/03/13', 394288, 234, b'0','大人気作。');

INSERT INTO yoyakudaichou(material_user_id, material_booking_date, material_ISBN,
 material_ensured_id, material_is_booked, material_columm)
VALUES(113,'2019/04/23', 333288, 235, b'0','貸出人はお怒り。');

INSERT INTO yoyakudaichou(material_user_id, material_booking_date, material_ISBN,
 material_ensured_id, material_is_booked, material_columm)
VALUES(114,'2019/05/22', 311288, 236, b'1','大人気作。');

--  , user_password     VARCHAR(12) NOT NULL     --
