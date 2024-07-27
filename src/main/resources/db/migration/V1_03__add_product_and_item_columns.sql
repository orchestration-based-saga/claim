alter table claim add column if not exists item_id integer;
alter table claim alter column item_id set not null;
alter table claim add column if not exists merchant_inventory_id integer;
alter table claim alter column merchant_inventory_id set not null;
alter table claim alter column refund_amount drop not null;