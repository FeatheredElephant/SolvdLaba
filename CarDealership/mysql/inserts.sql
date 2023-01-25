INSERT INTO car_dealership.person(name)
VALUES 
	("Emma"),
    ("Jake"),
    ("Jake"),
    ("Cliff"),
    ("Maria"),
    ("Ricky"),
    ("Diana"),
    ("Michael");

INSERT INTO car_dealership.employee(wage, title, person_id)
VALUES
	(30.00, "Manager", 1),
    (20.00, "Salesman", 2);

INSERT INTO car_dealership.customer(person_id)
VALUES
	(3),
    (4);

INSERT INTO car_dealership.service_provider (person_id)
VALUES
	(5),
    (6),
    (7);

INSERT INTO car_dealership.vendor (person_id)
VALUES
	(7),
    (8);

INSERT INTO car_dealership.brand (name)
VALUES
	("Ford"),
    ("Tesla"),
    ("Subaru");

INSERT INTO car_dealership.vehicle_type (name)
VALUES
	("Sedan"),
    ("SUV"),
    ("Truck");

INSERT INTO car_dealership.model (name, brand_id, vehicle_type)
VALUES
	("Fiesta", 1, 1),
    ("Explorer", 1, 2),
	("Ranger", 1, 3),
    ("Model S", 2, 1),
    ("Model X", 2, 2),
    ("Impreza", 3, 1),
    ("Outback", 3, 2);

INSERT INTO car_dealership.color (name)
VALUES
	("black"),
    ("red"),
    ("blue"),
    ("green");

INSERT INTO car_dealership.vehicle (year, model_id, color_id, price)
VALUES
	(2018, 1, 4, 15000.00),
    (2020, 4, 2, 140000.00),
    (2016, 7, 4, 20000.00),
    (2020, 4, 1, 100000.00);

INSERT INTO car_dealership.vehicle_purchase (vehicle_id, vendor_id, cost)
VALUES
	(3, 1, 15000.00),
    (1, 2, 14000.00),
    (2, 2, 130000.00),
    (4, 2, 90000.00);

INSERT INTO car_dealership.vehicle_service (service_provider_id, vehicle_id, service_cost, description)
VALUES
	(1, 3, 1500.00, "auto body repair + repainted"),
    (1, 1, 200.00, "Tire alignment");

INSERT INTO car_dealership.vehicle_sale (customer_id, vehicle_id, discount, total)
VALUES
	(1, 3, 200.00, 19800.00),
    (2, 4, 500.00, 99500.00);

INSERT INTO car_dealership.part_type (name, price)
VALUES
	("Battery", 60.00),
    ("Tire", 100.00),
    ("Bumper", 150.00);

INSERT INTO car_dealership.vehicle_part (part_type_id)
VALUES
	(1),
    (3),
    (2);

INSERT INTO car_dealership.vehicle_part_purchase (vendor_id, part_id)
VALUES
	(1, 1),
    (1, 1),
    (1, 3),
    (1, 2);

INSERT INTO car_dealership.payment (amount, person_id)
VALUES
	(19000.00, 3),
    (-370.00, 7);