create table if not exists claim
(
    id          serial         not null primary key,
    status      text           not null,
    shipment_id integer        not null,
    order_id    text           not null,
    amount      numeric(15, 2) not null
)