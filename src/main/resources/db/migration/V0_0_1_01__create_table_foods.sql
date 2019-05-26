CREATE TABLE IF NOT EXISTS foods (
	id_food serial,
	label VARCHAR (25),
  protein FLOAT,
  fat FLOAT,
  carbohydrate FLOAT,
  calorie FLOAT,
  food_type VARCHAR (25),
	PRIMARY KEY( id_food )
);
