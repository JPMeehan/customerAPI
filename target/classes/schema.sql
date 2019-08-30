create table customer(
        id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
        username varchar(255),
        email varchar(255),
        password varchar(255),
        primary key(id)
 );