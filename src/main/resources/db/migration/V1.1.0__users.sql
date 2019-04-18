CREATE TABLE users (
        userid     identity not null primary key,
        usertypeid INT not null,
        firstname  VARCHAR(50) not null,
        lastname   VARCHAR(50) not null,
        email      VARCHAR(50) not null,
        username   VARCHAR(50) not null,
        password   VARCHAR(50) not null,

    FOREIGN KEY(usertypeid) REFERENCES user_types(id)
   );
INSERT INTO users(usertypeid, firstname, lastname, email, username, password)
                  VALUES (1, 'Admin', 'Admin', 'admin@gmail.com', 'AAdmin', 'AAdmin123');
