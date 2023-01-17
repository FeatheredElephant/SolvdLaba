USE car_dealership;

SELECT person.person_id, person.name, employee.title, employee.wage, model.name, service_provider.service_provider_id FROM person
LEFT JOIN employee ON employee.person_id = person.person_id
LEFT JOIN customer ON customer.person_id = person.person_id
LEFT JOIN vehicle_sale ON customer.customer_id = vehicle_sale.customer_id
LEFT JOIN vehicle ON vehicle.vehicle_id = vehicle_sale.vehicle_id
LEFT JOIN model ON vehicle.model_id = model.model_id
LEFT JOIN service_provider ON person.person_id = service_provider.person_id
LEFT JOIN vendor ON vendor.person_id = person.person_id;

SELECT * FROM person
INNER JOIN employee ON person.person_id = employee.person_id;

SELECT vehicle.id, vehicle.year, vehicle.price, model.name FROM vehicle
RIGHT JOIN model ON model.model_id = vehicle.vehicle_id;

SELECT vehicle.id, vehicle.year, vehicle.price, model.name FROM vehicle
RIGHT JOIN model ON model.model_id = vehicle.vehicle_id;