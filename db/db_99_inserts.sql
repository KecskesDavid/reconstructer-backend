\c stateproject


insert into stateproject.public.roles (id, name) values (nextval('stateproject.public.seq_roles'), 'user');
insert into stateproject.public.roles (id, name) values (nextval('stateproject.public.seq_roles'), 'data_owner');
insert into stateproject.public.roles (id, name) values (nextval('stateproject.public.seq_roles'), 'administrator');
select * from stateproject.public.roles;


insert into stateproject.public.users (id, name, email, phone_number, password) values (nextval('stateproject.public.seq_users'), 'Kecskes Dávid', 'kecskesdavid@yahoo.com', '', '');
insert into stateproject.public.users (id, name, email, phone_number, password) values (nextval('stateproject.public.seq_users'), 'Graf László', 'graf.laszlo@gmail.com', '', '');
insert into stateproject.public.users (id, name, email, phone_number, password) values (nextval('stateproject.public.seq_users'), 'John Doe', 'john.doe@abc.xyz', '', '');
select * from stateproject.public.users;


insert into stateproject.public.authorizations (role_id, user_id) values (
    (select id from stateproject.public.roles where name = 'administrator'),
    (select id from stateproject.public.users where name = 'Kecskes Dávid' and email = 'kecskesdavid@yahoo.com')
);
insert into stateproject.public.authorizations (role_id, user_id) values (
    (select id from stateproject.public.roles where name = 'administrator'),
    (select id from stateproject.public.users where name = 'Graf László' and email = 'graf.laszlo@gmail.com')
);
select * from stateproject.public.v_authorizations;


insert into stateproject.public.categories (id, name) values (nextval('stateproject.public.seq_categories'), 'Tile');
insert into stateproject.public.categories (id, name) values (nextval('stateproject.public.seq_categories'), 'Paint');
select * from stateproject.public.categories;


insert into stateproject.public.market_types (id, name) values (nextval('stateproject.public.seq_market_types'), 'Offer');
insert into stateproject.public.market_types (id, name) values (nextval('stateproject.public.seq_market_types'), 'Request');
select * from stateproject.public.market_types;


insert into stateproject.public.products (id, name, details, available, category_id) values (
    nextval('stateproject.public.seq_categories'), 
    'White tile',
	'Beautiful white tile for sale.',
	True,
    (select id from stateproject.public.categories where name = 'Tile')
);
select * from stateproject.public.v_products;


insert into stateproject.public.bid_statuses (id, name) values (nextval('stateproject.public.seq_bid_statuses'), 'Offer made');
insert into stateproject.public.bid_statuses (id, name) values (nextval('stateproject.public.seq_bid_statuses'), 'Accepted');
insert into stateproject.public.bid_statuses (id, name) values (nextval('stateproject.public.seq_bid_statuses'), 'Dismissed');
select * from stateproject.public.bid_statuses;


select * from stateproject.public.v_markets;
select * from stateproject.public.v_bids;
