create table tag(
	tid number primary key,
	tname varchar2(100) not null,
	tcount number check(tcount>0)
)
create table favorite(
	fid number primary key,
	flabel varchar2(1000) not null,
	furl varchar2(300) not null,
	ftage varchar2(1000),
	fdesc varchar2(2000)
)

insert into TAG
select 1,'java',2 from dual union
select 2,'struts',1 from dual union
select 3,'oracle',1 from dual ;

insert into FAVORITE
select 1,'Apache Struts','http://struts.apache.org','java,struts','struts的官方网站' from dual union
select 2,'Oracle','http://www.oracle.com','','Oracle的官方网站' from dual ;

select * from FAVORITE;
select * from TAG;