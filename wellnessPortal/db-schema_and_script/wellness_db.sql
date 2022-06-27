DROP DATABASE IF EXISTS `wellness_portal`;
CREATE DATABASE IF NOT EXISTS `wellness_portal`;
USE `wellness_portal`;

--
-- Table structure for Pharmacy
--

DROP TABLE IF EXISTS `pharmacy`;

CREATE TABLE `pharmacy`(
`id` int NOT NULL AUTO_INCREMENT,
`pharmacy_name` varchar(45) DEFAULT NULL,
`pharmacy_address` varchar(155) DEFAULT NULL,
PRIMARY KEY(`id`)
);

--
-- Data for pharmacy table
--

INSERT INTO `pharmacy` VALUES
(1, 'Walmart', '500 N HWY 220 PHX AZ'),
(2, 'Walgreens', '501 N HWY 220 PHX AZ'),
(3, 'CVS', '502 N HWY 220 PHX AZ');


--
-- Table structure for Prescriptions
--

DROP TABLE IF EXISTS `prescriptions`;

CREATE TABLE `prescriptions`(
`id` int NOT NULL AUTO_INCREMENT,
`prescription_name` varchar(45) DEFAULT NULL,
`refill_cycle` int DEFAULT NULL,
PRIMARY KEY(`id`)
);

--
-- Data for Prescriptions
--

INSERT INTO `prescriptions` VALUES
(1, 'Ibuprofen', 30),
(2, 'Tylenol', 30),
(3, 'Zyrtec', 60),
(4, 'Lisinopril', 120),
(5, 'Atorvastatin', 90);


--
-- Table structure for insurance
--

DROP TABLE IF EXISTS `insurance_plans`;

CREATE TABLE `insurance`(
`id` int NOT NULL AUTO_INCREMENT,
`plan_name` varchar(45) DEFAULT NULL,
`monthly_cost` DOUBLE DEFAULT NULL,
`deductible` DOUBLE DEFAULT NULL,
PRIMARY KEY(`id`)
);


--
-- Data for insurance
--

INSERT INTO `insurance` VALUES
(1, 'Gold', 500, 2000),
(2, 'Silver', 400, 3000),
(3, 'Bronze', 300, 4000);

--
-- Table structure for role
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`(
`id` int NOT NULL AUTO_INCREMENT,
`name` varchar(45) DEFAULT NULL,
PRIMARY KEY(`id`)
);


--
-- Data for role
--
INSERT INTO `role` VALUES
(1, 'user');


-- 
-- Table structure for customer
--

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
`id` int NOT NULL auto_increment,
`first_name` varchar(45) DEFAULT NULL,
`last_name` varchar(45) DEFAULT NULL,
`email` varchar(45) DEFAULT NULL,
`password` varchar(150) NOT NULL,
`pharmacy_id` int(45) DEFAULT NULL,
`insurance_id` int(45) DEFAULT NULL,
PRIMARY KEY(`id`),
FOREIGN KEY(`pharmacy_id`) REFERENCES `pharmacy`(`id`),
FOREIGN KEY(`insurance_id`) REFERENCES `insurance`(`id`)
);

--
-- Data for customer table
--

INSERT INTO `customer` VALUES
(1, 'Elmer', 'Fudd', 'theFuddo@yahoo.com', '$2a$10$pCnOIgRKSLJ3CVWjMfPmVu7v5ZSKgw/IUHCqOfSprN4wTyT4Qjb2O', 3, 3);



-- 
-- Table structure for customer_prescriptions
--

DROP TABLE IF EXISTS `customer_prescriptions`;

CREATE TABLE `customer_prescriptions`(
`customer_id` int NOT NULL,
`prescription_id` int NOT NULL,
FOREIGN KEY(`customer_id`) REFERENCES `customer`(`id`),
FOREIGN KEY(`prescription_id`) REFERENCES `prescriptions`(`id`)
);

--
-- Data for customer_prescriptions table
--

INSERT INTO `customer_prescriptions` VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5);

--
-- Table structure for customers_roles
--

DROP TABLE IF EXISTS `customers_roles`;

CREATE TABLE `customers_roles`(
`customer_id` int NOT NULL,
`role_id` int NOT NULL,
FOREIGN KEY(`customer_id`) REFERENCES `customer`(`id`),
FOREIGN KEY(`role_id`) REFERENCES `role`(`id`)
);

--
-- Data for customers_roles
--

INSERT INTO `customers_roles` VALUES
(1, 1);