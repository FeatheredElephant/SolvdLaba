USE car_dealership;
SELECT COUNT(person_id) FROM person
WHERE person.name = "Emma";

SELECT AVG(price) FROM vehicle
WHERE vehicle.year < 2020;

SELECT SUM(amount) FROM payment;

SELECT AVG(price), year FROM vehicle
GROUP BY year
HAVING year < 2020;