ALTER TABLE pantry_items
  ADD COLUMN id_food int;

ALTER TABLE pantry_items
  ADD FOREIGN KEY (id_food)
    REFERENCES foods(id_food)
