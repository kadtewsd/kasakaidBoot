CREATE TABLE IF NOT EXISTS accompany (
  festival_id bigint(20) NOT NULL,
  accompany_id bigint(20) NOT NULL,
  name varchar(255) NOT NULL,
  PRIMARY KEY (festival_id, accompany_id)
);

