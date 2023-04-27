CREATE SCHEMA `api_document` ;

CREATE TABLE `api_document`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `age` INT NULL,
  `salary` INT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `api_document`.`user` (`name`, `age`, `salary`) VALUES ('sơn', '19', '192832');
INSERT INTO `api_document`.`user` (`name`, `age`, `salary`) VALUES ('tuấn ', '29', '1299999');
INSERT INTO `api_document`.`user` (`name`, `age`, `salary`) VALUES ('nam', '28', '2999999');
INSERT INTO `api_document`.`user` (`name`, `age`, `salary`) VALUES ('giang', '18', '1999999');
