\c stateproject


CREATE TABLE stateproject.public.roles
(
    id integer NOT NULL,
    name character varying(128) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_roles PRIMARY KEY (id),
    CONSTRAINT uk_roles_mane UNIQUE (name)
);
ALTER TABLE stateproject.public.roles OWNER to stateproject;


CREATE TABLE stateproject.public.users
(
    id integer NOT NULL,
    name character varying(128) COLLATE pg_catalog."default" NOT NULL,
    email character varying(256) COLLATE pg_catalog."default" NOT NULL,
    phone_number character varying(20) NOT NULL,
    password character varying(256) NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id),
    CONSTRAINT uk_users_email UNIQUE (email)
);
ALTER TABLE stateproject.public.users OWNER to stateproject;


CREATE TABLE stateproject.public.authorizations
(
    role_id integer NOT NULL,
    user_id integer NOT NULL,
    CONSTRAINT pk_authorizations PRIMARY KEY (role_id, user_id)
);
ALTER TABLE stateproject.public.authorizations OWNER to stateproject;


CREATE TABLE stateproject.public.categories
(
    id integer NOT NULL,
    name character varying(128) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_categories PRIMARY KEY (id),
    CONSTRAINT uk_categories_name UNIQUE (name)
);
ALTER TABLE stateproject.public.categories OWNER to stateproject;


CREATE TABLE stateproject.public.products
(
    id integer NOT NULL,
    name character varying(128) COLLATE pg_catalog."default" NOT NULL,
    details character varying(256) COLLATE pg_catalog."default" NOT NULL,
    available boolean NOT NULL,
    category_id integer NOT NULL,
    CONSTRAINT pk_products PRIMARY KEY (id),
    CONSTRAINT uk_products_name UNIQUE (name),
    CONSTRAINT fk_products_category FOREIGN KEY (category_id) REFERENCES stateproject.public.categories (id)
);
ALTER TABLE stateproject.public.products OWNER to stateproject;


CREATE TABLE stateproject.public.market_types
(
    id integer NOT NULL,
    name character varying(128) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_market_types PRIMARY KEY (id),
    CONSTRAINT uk_market_types_name UNIQUE (name)
);
ALTER TABLE stateproject.public.market_types OWNER to stateproject;


CREATE TABLE stateproject.public.markets
(
    id integer NOT NULL,
    name character varying(128) COLLATE pg_catalog."default" NOT NULL,
	quantity numeric,
	price numeric NOT NULL,
    market_type_id integer NOT NULL,
    open_from date NOT NULL,
    open_till date,
    product_id integer NOT NULL,
    user_id integer NOT NULL,
    CONSTRAINT pk_markets PRIMARY KEY (id),
    CONSTRAINT uk_markets_name UNIQUE (name),
    CONSTRAINT fk_markets_market_type FOREIGN KEY (market_type_id) REFERENCES stateproject.public.market_types (id),
    CONSTRAINT fk_markets_product FOREIGN KEY (product_id) REFERENCES stateproject.public.products (id),
    CONSTRAINT fk_markets_user FOREIGN KEY (user_id) REFERENCES stateproject.public.users (id)
);
ALTER TABLE stateproject.public.markets OWNER to stateproject;


CREATE TABLE stateproject.public.bid_statuses
(
    id integer NOT NULL,
    name character varying(128) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_bid_statuses PRIMARY KEY (id),
    CONSTRAINT uk_bid_statuses_name UNIQUE (name)
);
ALTER TABLE stateproject.public.bid_statuses OWNER to stateproject;


CREATE TABLE stateproject.public.bids
(
    id integer NOT NULL,
    bid_status_id integer NOT NULL,
    market_id integer NOT NULL,
    made_on date NOT NULL,
    valid_till date,
    price integer NOT NULL,
    seller integer NOT NULL,
    buyer integer NOT NULL,
    CONSTRAINT pk_bids PRIMARY KEY (id),
    CONSTRAINT fk_bids_status FOREIGN KEY (bid_status_id) REFERENCES stateproject.public.bid_statuses (id),
    CONSTRAINT fk_bids_market FOREIGN KEY (market_id) REFERENCES stateproject.public.markets (id),
    CONSTRAINT fk_bids_seller FOREIGN KEY (seller) REFERENCES stateproject.public.users (id),
    CONSTRAINT fk_bids_buyer FOREIGN KEY (buyer) REFERENCES stateproject.public.users (id)
);
ALTER TABLE stateproject.public.bids OWNER to stateproject;

