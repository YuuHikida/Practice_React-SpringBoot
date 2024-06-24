drop table if exists my_table;

create table my_table(
    id integer,
    name varchar(30);
    primary key(id)
);

insert into my_table (id,name) values(1,'HIKIDA');
insert into my_table (id,name) values(2,'TANAKA');