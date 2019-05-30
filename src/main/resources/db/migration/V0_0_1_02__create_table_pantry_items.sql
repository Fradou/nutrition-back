CREATE TABLE IF NOT EXISTS pantry_items (
  id_pantry_item serial,
  expiration_date date,
  weight int,
  share int,
  PRIMARY KEY( id_pantry_item )
);
