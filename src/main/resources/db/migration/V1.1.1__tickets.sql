CREATE TABLE tickets (
             ticketid   identity not null primary key,
             seatid     INT not null,
             userid     INT not null,

        FOREIGN KEY(seatid) REFERENCES seats(id),
        FOREIGN KEY(userid) REFERENCES users(userid)
      );
