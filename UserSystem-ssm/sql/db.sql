create sequence seq_profile;


create table profile(
     id number primary key,
     name varchar2(20 char) not null, 
     birthday varchar2(20 char)not null, 
     gender varchar2(4 char), 
     career varchar2(20 char), 
     address varchar2(50 char), 
     mobile varchar2(20 char)
)



insert into profile values(seq_profile.nextval,'����','1982-07-07','��','����Ա','����','1234566');
insert into profile values(seq_profile.nextval,'����','1982-07-07','��','����Ա','����','1234566');
insert into profile values(seq_profile.nextval,'����','1982-07-07','��','����Ա','����','1234566');
insert into profile values(seq_profile.nextval,'����','1982-07-07','��','����Ա','����','1234566');

commit;

select * from profile;
