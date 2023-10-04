CREATE TABLE IF NOT EXISTS users
(
    id           serial primary key,
    firstName    varchar(50),
    lastName     varchar(50),
    username     varchar(50),
    password     varchar(50),
    email        varchar(50),
    mobileNumber varchar(50)
);

CREATE TABLE IF NOT EXISTS shoppingCart
(
    id        serial,
    productName varchar(50),
    price       int


);