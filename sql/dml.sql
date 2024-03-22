insert into tbl_board (title, content, writer)
values ('테스트글1','no content','tester'),
       ('테스트글2','no content','tester'),
       ('테스트글3','no content','tester'),
       ('테스트글4','no content','tester'),
       ('테스트글5','no content','tester');

-- 인덱스는 DB의 특정 열에 대한 검색을 빠르게 할 수있는 데이터구조
-- bno(pk)가 인덱싱되어 0보다 큰 인덱스를 빠르게 찾음(쿼리 성능향상)
select * from tbl_board where bno > 0;
select count(*) from tbl_board;

update tbl_board
set title='테스트글old', content='no content..', updateDate=now()
where bno = 3;

select * from tbl_board order by bno desc limit 1, 20;

select count(bno) from tbl_board;
