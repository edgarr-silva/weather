CREATE TABLE `climate` (
	`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`station_name` VARCHAR(200),
	`province` CHAR(2),
	`date` DATE,
	`mean_temp` DOUBLE,
	`highest_monthly_maxi_temp` DOUBLE,
	`lowest_monthly_min_temp` DOUBLE,
);
