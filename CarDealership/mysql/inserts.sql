INSERT INTO car_dealership.person
VALUES 
	(0, "Emma"),
    (1, "Jake"),
    (2, "Jake"),
    (3, "Cliff"),
    (4, "Maria"),
    (5, "Ricky"),
    (6, "Diana"),
    (7, "Michael");


INSERT INTO car_dealership.employee
VALUES
	(0, 30.00, "Manager", 0),
    (1, 20.00, "Salesman", 1);

INSERT INTO car_dealership.customer
VALUES
	(0, 2),
    (1, 3);

INSERT INTO car_dealership.service_provider
VALUES
	(0, 4),
    (1, 5),
    (2, 6);

INSERT INTO car_dealership.vendor
VALUES
	(0, 6),
    (1, 7);

INSERT INTO car_dealership.brand
VALUES
	(0, "Ford"),
    (1, "Tesla"),
    (2, "Subaru");

INSERT INTO car_dealership.vehicle_type
VALUES
	(0, "Sedan"),
    (1, "SUV"),
    (2, "Truck");

INSERT INTO car_dealership.model
VALUES
	(0, "Fiesta", 0, 0),
    (1, "Explorer", 0, 1),
	(2, "Ranger", 0, 2),
    (3, "Model S", 1, 0),
    (4, "Model X", 1, 1),
    (6, "Impreza", 2, 0),
    (7, "Outback", 2, 1);

INSERT INTO car_dealership.color
VALUES
	(0, "black"),
    (1, "red"),
    (2, "blue"),
    (3, "green");

INSERT INTO car_dealership.vehicle
VALUES
	(0, 2018, 0, 3, 15000.00),
    (1, 2020, 3, 1, 140000.00),
    (2, 2016, 6, 3, 20000.00),
    (3, 2020, 3, 0, 100000.00);

INSERT INTO car_dealership.vehicle_purchase
VALUES
	(0, 2, 0, 15000.00),
    (1, 0, 1, 14000.00),
    (2, 1, 1, 130000.00),
    (3, 3, 1, 90000.00);

INSERT INTO car_dealership.vehicle_service
VALUES
	(0, 0, 2, 1500.00, "auto body repair + repainted"),
    (1, 0, 0, 200.00, "Tire alignment");

INSERT INTO car_dealership.vehicle_sale
VALUES
	(0, 0, 2, 200.00, 19800.00),
    (1, 1, 3, 500.00, 99500.00);

INSERT INTO car_dealership.part_type
VALUES
	(0, "Battery", 60.00),
    (1, "Tire", 100.00),
    (2, "Bumper", 150.00);

INSERT INTO car_dealership.vehicle_part
VALUES
	(0, 0),
    (1, 2),
    (2, 1);

INSERT INTO car_dealership.vehicle_part_purchase
VALUES
	(0, 0, 0),
    (1, 0, 0),
    (2, 0, 2),
    (3, 0, 1);

INSERT INTO car_dealership.payment
VALUES
	(0, 19000.00, 2),
    (1, -370.00, 6);