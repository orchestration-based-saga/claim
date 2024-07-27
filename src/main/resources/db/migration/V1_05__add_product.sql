create table if not exists merchant_product
(
    id              integer not null primary key,
    name            text    not null,
    description     text    not null,
    serviceable     boolean not null default false,
    on_site_service boolean not null
);

alter table claim
    add constraint fk_merchant_product foreign key (merchant_inventory_id)
        references merchant_product;