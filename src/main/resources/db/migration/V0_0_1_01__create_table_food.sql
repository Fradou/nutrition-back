CREATE TABLE IF NOT EXISTS food (
	id_food serial,
	label VARCHAR (25),
  protein FLOAT,
  fat FLOAT,
  carbohydrate FLOAT,
  calorie FLOAT,
	PRIMARY KEY( id_food )
);
