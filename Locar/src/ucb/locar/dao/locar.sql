CREATE DATABASE IF NOT EXISTS `locar`;

CREATE TABLE IF NOT EXISTS `user` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(45) NOT NULL,
	`password` VARCHAR(45) NOT NULL,
	`cpf` VARCHAR(45),
	`address` VARCHAR(45),
	`birthday` DATE,
	`permission` ENUM("ADMIN", "USER") NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE (`username`, `cpf`)
);

CREATE TABLE IF NOT EXISTS `vehicle` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`people` INT NOT NULL,
	`velocity` FLOAT NOT NULL,
	`power` INT NOT NULL,
	`plate` VARCHAR(45) NOT NULL,
	`model` VARCHAR(45) NOT NULL,
	`producer` VARCHAR(45) NOT NULL,
	`year` YEAR NOT NULL,
	`value_day` DOUBLE UNSIGNED NOT NULL,
	`available` TINYINT NOT NULL,
	PRIMARY KEY (`id`),
  	UNIQUE (`plate`)
);

CREATE TABLE IF NOT EXISTS `rent` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`pickup` DATE NOT NULL,
	`dropoff` DATE NOT NULL,
	`total` DOUBLE UNSIGNED NOT NULL,
	`user_id` INT NOT NULL,
	`vehicle_id` INT NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`user_id`) REFERENCES user(`id`),
	FOREIGN KEY (`vehicle_id`) REFERENCES vehicle(`id`)
);

CREATE TABLE IF NOT EXISTS `maintenance` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`type` ENUM("PREVENTIVA", "CORRETIVA") NULL,
	`km` INT NULL,
	`date` DATE NULL,
	`description` VARCHAR(100) NULL,
	`vehicle_id` INT NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`vehicle_id`) REFERENCES vehicle(`id`)
);

INSERT INTO `user` (`username`, `password`, `permission`)
VALUES ("admin", "0000", "ADMIN");

INSERT INTO `user` (`username`, `password`, `permission`)
VALUES ("user", "0000", "USER");

INSERT INTO `vehicle` (`people`, `velocity`, `power`, `plate`, `model`, `producer`, `year`, `value_day`, `available`)
VALUES (2, 250, 374, "JKC-1410", "I8", "BMW", 2020, 60.00, 1);

INSERT INTO `vehicle` (`people`, `velocity`, `power`, `plate`, `model`, `producer`, `year`, `value_day`, `available`)
VALUES (2, 330, 610, "JQQ-5809", "R8", "Audi", 2021, 90.00, 1);

INSERT INTO `vehicle` (`people`, `velocity`, `power`, `plate`, `model`, `producer`, `year`, `value_day`, `available`)
VALUES (5, 190, 170, "JCK-8823", "ASX", "Mitsubishi ", 2021, 50.00, 1);

INSERT INTO `vehicle` (`people`, `velocity`, `power`, `plate`, `model`, `producer`, `year`, `value_day`, `available`)
VALUES (5, 190, 170, "JJV-4733", "IX35", "Hyundai ", 2021, 70.00, 1);

INSERT INTO `vehicle` (`people`, `velocity`, `power`, `plate`, `model`, `producer`, `year`, `value_day`, `available`)
VALUES (5, 175, 170, "CPP-4425", "Toro", "Fiat ", 2020, 60.00, 1);

INSERT INTO `vehicle` (`people`, `velocity`, `power`, `plate`, `model`, `producer`, `year`, `value_day`, `available`)
VALUES (5, 250, 466, "CGG-4973", "Mustang", "Ford ", 2020, 80.00, 1);

INSERT INTO `rent` (`totalValue`, `pickupDate`, `dropoffDate`, ` user `, ` vehicle`)
VALUES (250, 18-03-2020, 25-03-2020, "Camila de Lima", " BMW);

INSERT INTO `rent` (`totalValue`, `pickupDate`, `dropoffDate`, ` user `, ` vehicle`)
VALUES (500, 18-03-2020, 25-03-2020, "Fernando Silva", " Jetta");

INSERT INTO `rent` (`totalValue`, `pickupDate`, `dropoffDate`, ` user `, ` vehicle`)
VALUES (300, 16-03-2020, 21-03-2020, "Paulo Roberto", " Mustang");

INSERT INTO `rent` (`totalValue`, `pickupDate`, `dropoffDate`, ` user `, ` vehicle`)
VALUES (600, 07-04-2020, 14-04-2020, "Fernando Silva", " Toro");

INSERT INTO `rent` (`totalValue`, `pickupDate`, `dropoffDate`, ` user `, ` vehicle`)
VALUES (100, 14-05-2020, 16-05-2020, "Roberto Bezerra", " IX35");

INSERT INTO `rent` (`totalValue`, `pickupDate`, `dropoffDate`, ` user `, ` vehicle`)
VALUES (270, 15-05-2020, 20-05-2020, "Pamela Fernandes", " ASX");

INSERT INTO `rent` (`totalValue`, `pickupDate`, `dropoffDate`, ` user `, ` vehicle`)
VALUES (250, 03-06-2020, 07-06-2020, "Geraldo Alberto", " R8");
