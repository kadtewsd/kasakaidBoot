CREATE TABLE IF NOT EXISTS festival_artist (
  artist_id bigint(20) NOT NULL,
  festival_id bigint(20) NOT NULL,
  play_order int NOT NULL,
  start TIMESTAMP NOT NULL,
  PRIMARY KEY (artist_id, festival_id, play_order)
);

