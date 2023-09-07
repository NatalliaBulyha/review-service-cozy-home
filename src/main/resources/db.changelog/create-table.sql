CREATE TABLE IF NOT EXISTS reviews (
    id                uuid         NOT NULL PRIMARY KEY,
    rating            char         NOT NULL,
    comment           varchar(900) NOT NULL,
    created_at        timestamp    NOT NULL,
    modified_at       timestamp    NOT NULL,
    userName          varchar(40)  NOT NULL,
    product_sku_code  varchar(6)   NOT NULL
    )