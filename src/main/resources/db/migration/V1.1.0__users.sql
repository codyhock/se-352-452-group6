CREATE TABLE users (
        userid     identity not null primary key,
        usertypeid  INT not null,
        firstname   VARCHAR(50) not null,
        lastname    VARCHAR(50) not null,
        email       VARCHAR(50) not null,
        dateofbirth DATE not null,
        phonenumber VARCHAR(50) not null,

    FOREIGN KEY(usertypeid) REFERENCES user_types(id)
   );
INSERT INTO users(usertypeid, firstname, lastname, email, dateofbirth, phonenumber)
                  VALUES (1, 'Admin', 'Admin', 'admin@gmail.com', '1990-05-05', '123-456-7890');
