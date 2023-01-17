USE car_dealership;

ALTER TABLE employee
ADD christmas_bonus DECIMAL(10,2);

ALTER TABLE employee
RENAME COLUMN christmas_bonus to holiday_bonus;

ALTER TABLE employee
MODIFY COLUMN holiday_bonus INT;

ALTER TABLE employee
DROP COLUMN holiday_bonus;