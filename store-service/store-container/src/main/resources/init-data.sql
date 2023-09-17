INSERT INTO brands(id, brand_name)
	VALUES  ('1', 'ZARA'),
            ('2', 'PULL&BEAR'),
            ('3', 'MASSIMO DUTTI'),
            ('4', 'BERSHKA'),
            ('5', 'STRADIVARIUS'),
            ('6', 'OYSHO'),
            ('7', 'ZARA HOME'),
            ('8', 'UTERQüE');

INSERT INTO prices_list_description(id, price_list_name)
	VALUES ('1', 'Winter sales'),
	       ('2', 'Summer sales');

INSERT INTO products(id, product_name)
	VALUES ('35455', 'T-Shirt'),
	       ('35456', 'Shirt');

INSERT INTO prices(id, brand_id, start_date, end_date, price_list, product_id, priority, price)
	VALUES (1, 1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455 ,0, 35.50),
	       (2, 1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455 ,1, 25.45),
	       (3, 1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455 ,1, 30.50),
	       (4, 1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455 ,1, 38.95);