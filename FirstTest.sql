create database TestJava6
use TestJava6

create table brand
(
	id bigint identity(1,1) primary key,
	brand_name varchar(100)
)

create table category
(
	id bigint identity(1,1) primary key,
	cate_code varchar(20),
	cate_name varchar(50)
)

create table [status]
(
	id bigint identity(1,1) primary key,
	status_name varchar(100)
)

create table sub_category
(
	id bigint identity(1,1) primary key,
	sub_cate_code varchar(20),
	sub_cate_Name varchar(50),
	cate_id bigint references category(id)
)

create table product
(
	id bigint identity(1,1) primary key,
	subcate_id bigint references sub_category(id),
	produce_name varchar(100),
	color varchar(50),
	quantity bigint,
	sell_price float,
	origin_price float,
	[description] varchar(1000),
	status_id bigint references [status](id)

)

create table product_brand
(
	id bigint identity(1,1) primary key,
	product_id bigint references product(id),
	brand_id bigint references brand(id)
)

--alter table product
--add product_name varchar(100)

select p.product_name, b.brand_name, origin_price, s.status_name, sc.sub_cate_Name
from product p join product_brand pb on p.id = pb.product_id
				join brand b on pb.brand_id = b.id
				join sub_category sc on p.subcate_id = sc.id
				join [status] s on p.status_id = s.id
insert into brand(brand_name) values('Brand A')

insert into category(cate_code,cate_name) values('Cate Code A', 'Cate Name A')
insert into category(cate_code,cate_name) values('Cate Code B', 'Cate Name B')

insert into [status](status_name) values('status 1')

insert into sub_category(sub_cate_code,sub_cate_Name, cate_id) values ('sub cate code a', 'sub cate name a', 1)
insert into product(subcate_id, product_name, color, quantity, sell_price, origin_price, [description], status_id)
	values(1, 'product A','color A', 200, 150000, 120000, 'none', 1)
insert into product_brand(product_id, brand_id) values(1,1)