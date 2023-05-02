CREATE SCHEMA `security` ;
CREATE TABLE `security`.`user` (
                                   `id` INT NOT NULL AUTO_INCREMENT,
                                   `username` VARCHAR(45) NULL,
                                   `password` VARCHAR(100) NULL,
                                   PRIMARY KEY (`id`));
INSERT INTO `security`.`user` (`username`, `password`) VALUES ('sonpt', '$2a$10$x.6ED.1m8a.KpR9O/ZfvP.RoegdZ0Ab19qSmMkDQo.yMK.d0bHl9S');
