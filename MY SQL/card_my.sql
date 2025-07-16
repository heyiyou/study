use my_cat;

show tables;


create table card_my(
	no int primary key auto_increment,
    job char(20) not null default '전사',
    grade char(20) not null default 'N',
    id char(20) not null default 'cat'
    ,deployment int not null default 0
);

select * from card_my;

drop table card_my;

insert into card_my value();




create table card_my_party(
	no int primary key auto_increment,
    job char(20) not null default '전사',
    grade char(20) not null default 'N',
    id char(20) not null default 'cat'
);

select * from card_my_party;
drop table card_my_party;
insert into card_my_party value();

delete from card_my_party;

truncate card_my_party;


##내 재산

create table my_wealth(
    gold int UNSIGNED not null default 0,
    dice int UNSIGNED not null default 0,
    id char(20) not null default 'cat'
);

insert into my_wealth value();
update my_wealth set gold = -1 where id = 'cat';
update my_wealth set gold = 1 where id = 'cat';
update my_wealth set dice = -1 where id = 'cat';
update my_wealth set dice = 1 where id = 'cat';
update my_wealth set dice = 12 where id = 'cat';
truncate my_wealth;

select * from my_wealth;

drop table my_wealth;    

