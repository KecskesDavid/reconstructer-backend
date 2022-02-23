\c stateproject

CREATE OR REPLACE VIEW stateproject.public.v_authorizations AS
  select r.id as role_id, r.name as role_name,
         u.id as user_id, u.name as user_name
    from stateproject.public.roles as r,
         stateproject.public.users as u,
         stateproject.public.authorizations as a
   where a.role_id = r.id
     and a.user_id = u.id
;
ALTER VIEW stateproject.public.v_authorizations OWNER to stateproject;


CREATE OR REPLACE VIEW stateproject.public.v_products AS
  select c.id as category_id, c.name as category_name,
         p.id as product_id, p.name as product_name
    from stateproject.public.categories as c,
         stateproject.public.products as p
   where p.category_id = c.id
;
ALTER VIEW stateproject.public.v_products OWNER to stateproject;


CREATE OR REPLACE VIEW stateproject.public.v_markets AS
  select mt.id as market_type_id, mt.name as market_type_name,
         m.id as market_id, m.name as market_name, m.open_from, m.open_till,
         p.id as product_id, p.name as product_name
    from stateproject.public.market_types as mt,
         stateproject.public.markets as m,
         stateproject.public.products as p
   where m.market_type_id = mt.id
     and m.product_id = p.id
;
ALTER VIEW stateproject.public.v_markets OWNER to stateproject;


CREATE OR REPLACE VIEW stateproject.public.v_bids AS
  select b.id as bid_id,
         bs.id as bid_status_id, bs.name as bid_status_name,
         m.id as market_id, m.name as market_name, 
         mt.id as market_type_id, mt.name as market_type_name, 
         p.id as product_id, p.name as product_name,
         b.made_on, b.valid_till, b.price
    from stateproject.public.bids as b,
         stateproject.public.bid_statuses as bs,
         stateproject.public.markets as m,
         stateproject.public.market_types as mt,
         stateproject.public.products as p
   where b.bid_status_id = bs.id
     and b.market_id = m.id
     and m.market_type_id = mt.id
     and m.product_id = p.id
;
ALTER VIEW stateproject.public.v_bids OWNER to stateproject;


