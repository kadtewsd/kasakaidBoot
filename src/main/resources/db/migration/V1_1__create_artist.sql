CREATE TABLE IF NOT EXISTS artist (
  id bigint(20) NOT NULL,
  name varchar(255),
  genre varchar(50),
  members int,
  PRIMARY KEY (id)
);

