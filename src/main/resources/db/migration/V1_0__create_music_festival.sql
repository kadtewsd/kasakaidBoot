CREATE TABLE IF NOT EXISTS music_festival (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  artist_id bigint(20) NOT NULL,
  place varchar(255) NOT NULL,
  event_date DATE NOT NULL,
  PRIMARY KEY (id)
);

