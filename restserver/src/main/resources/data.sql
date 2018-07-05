--H2 populate db on start up
INSERT INTO Product(name, description, price) VALUES('Whiskey', 'Scottish drink', 300);
INSERT INTO Product(name, description, price) VALUES('Bourbon', 'American drink', 200);

INSERT INTO Role(roleType) VALUES('USER');