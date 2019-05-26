CREATE TABLE IF NOT EXISTS pantry_items (
  id_pantry_item serial,
  expirationDate date,
  weight int,
  share int,
  PRIMARY KEY( id_pantry_item )
);
