drop table tbl_board;
create table tbl_board(
                          bno int auto_increment primary key ,
                          title varchar(500) not null ,
                          content varchar(2000) not null ,
                          writer varchar(100) not null ,
                          regDate timestamp default now(),
                          updateDate timestamp default now()
);