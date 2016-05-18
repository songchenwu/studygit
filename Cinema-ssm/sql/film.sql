drop table filmInfo;
drop table filmtype;

-- Create table
create table FILMINFO --电影信息
(
  FILMID      NUMBER(8) primary key,
  FILMNAME    VARCHAR2(50 CHAR) not null,
  TYPEID      VARCHAR2(8 CHAR) not null,
  ACTOR       VARCHAR2(255 CHAR),
  DIRECTOR    VARCHAR2(50 CHAR),
  TICKETPRICE NUMBER(19) not null
);

-- Create table
create table FILMTYPE --电影类型
(
  TYPEID   NUMBER(8) primary key,
  TYPENAME VARCHAR2(20)
);

drop sequence seq_filmType;
create sequence seq_filmType start with 10000;
insert into filmType values(seq_filmType.nextval, '爱情片');
insert into filmType values(seq_filmType.nextval, '动作片');
insert into filmType values(seq_filmType.nextval, '喜剧片');
insert into filmType values(seq_filmType.nextval, '战争片');
insert into filmType values(seq_filmType.nextval, '科幻片');
insert into filmType values(seq_filmType.nextval, '恐怖片');
insert into filmType values(seq_filmType.nextval, '动画片');
insert into filmType values(seq_filmType.nextval, '其它片');

drop sequence seq_filmInfo;
create sequence seq_filmInfo start with 100000;
insert into filmInfo values(seq_filmInfo.nextval, '阿凡达', 10005, '萨姆·沃辛顿,佐伊·索尔达娜,西格妮·韦弗,乔·摩尔,拉兹·阿隆索,乔瓦尼·瑞比西', '詹姆斯·卡梅隆', 150);
insert into filmInfo values(seq_filmInfo.nextval, '猫和老鼠', 10007, '汤姆,杰瑞', 'William Hanna,Joseph Barbera', 60);
insert into filmInfo values(seq_filmInfo.nextval, '大兵小将', 10002, '成龙,王力宏,刘承俊,林鹏,徐冬梅,杜玉明', '丁晟', 50);
insert into filmInfo values(seq_filmInfo.nextval, '大侦探福尔摩斯', 10002, '小罗伯特·唐尼,裘德·洛', '盖·里奇', 100);
insert into filmInfo values(seq_filmInfo.nextval, '全城热恋', 10001, '谢霆锋,张学友 ,刘若英,徐若瑄,徐熙媛', '夏永康,陈国辉', 80);
insert into filmInfo values(seq_filmInfo.nextval, '第九区', 10005, '沙尔托·科普雷,詹森·库伯,威廉·艾伦·扬', '尼尔·布洛姆坎普', 100);
insert into filmInfo values(seq_filmInfo.nextval, '敢死队3', 10002, '西尔维斯特·史泰龙，杰森·斯坦森，梅尔·吉布森，李连杰，阿诺·施瓦辛格，杜夫·龙格尔', '派特里克·休斯', 250);
select * from filmType;
select * from filmInfo;
select * from filminfo fi join filmtype ft on fi.typeid=ft.typeid;
select * from filminfo fi join filmtype ft on fi.typeid=ft.typeid;
commit;