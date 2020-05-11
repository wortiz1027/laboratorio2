-- MySQL Script generated by MySQL Workbench
-- Mon Jun 26 16:45:41 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema cotizacionesdb
--
-- Base de datos que permite controlar la seguridad para mis servicios rest
-- -----------------------------------------------------
USE `cotizacionesdb` ;

-- -----------------------------------------------------
-- Table `cotizacionesdb`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cotizacionesdb`.`users` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `cotizacionesdb`.`users` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `cedula` BIGINT(255) NOT NULL,
  `nombres` VARCHAR(100) NOT NULL,
  `apellidos` VARCHAR(100) NOT NULL,
  `direccion` VARCHAR(255) NOT NULL,
  `fecha_nacimiento` DATETIME NOT NULL,
  `telefono` BIGINT(255) NOT NULL,
  `email` VARCHAR(512) NOT NULL,
  `username` VARCHAR(100) NOT NULL,
  `password` VARCHAR(512) NOT NULL,
  `enable` VARCHAR(45) NULL,
  `account_non_expired` VARCHAR(45) NULL,
  `credential_non_expired` VARCHAR(45) NULL,
  `account_non_locket` VARCHAR(45) NULL,
  PRIMARY KEY (`id_user`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `cedula_UNIQUE` ON `cotizacionesdb`.`users` (`cedula` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `cotizacionesdb`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cotizacionesdb`.`roles` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `cotizacionesdb`.`roles` (
  `id_role` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) NULL,
  PRIMARY KEY (`id_role`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `cotizacionesdb`.`users_roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cotizacionesdb`.`users_roles` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `cotizacionesdb`.`users_roles` (
  `user_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`),
  CONSTRAINT `fk_roles`
    FOREIGN KEY (`role_id`)
    REFERENCES `cotizacionesdb`.`roles` (`id_role`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `cotizacionesdb`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `cotizacionesdb`.`oauth_client_details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cotizacionesdb`.`oauth_client_details` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `cotizacionesdb`.`oauth_client_details` (
  `client_id` VARCHAR(255) NOT NULL,
  `resource_id` VARCHAR(255) NOT NULL,
  `client_secret` VARCHAR(255) NOT NULL,
  `scope` VARCHAR(255) NULL,
  `authorized_grant_types` VARCHAR(255) NULL,
  `web_server_redirect_uri` VARCHAR(255) NULL,
  `authorities` VARCHAR(255) NULL,
  `access_token_validity` BIGINT(10) NULL,
  `refresh_token_validity` BIGINT(10) NULL,
  `additional_information` VARCHAR(4096) NULL,
  `autoapprove` VARCHAR(255) NULL,
  PRIMARY KEY (`client_id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `cotizacionesdb`.`oauth_client_token`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cotizacionesdb`.`oauth_client_token` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `cotizacionesdb`.`oauth_client_token` (
  `token_id` VARCHAR(255) NOT NULL,
  `token` BLOB NULL,
  `authentication_id` VARCHAR(255) NULL,
  `user_name` VARCHAR(255) NULL,
  `client_id` VARCHAR(255) NULL,
  PRIMARY KEY (`token_id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `cotizacionesdb`.`oauth_access_token`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cotizacionesdb`.`oauth_access_token` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `cotizacionesdb`.`oauth_access_token` (
  `token_id` VARCHAR(255) NULL,
  `token` BLOB NULL,
  `authentication_id` VARCHAR(255) NULL,
  `user_name` VARCHAR(255) NULL,
  `client_id` VARCHAR(255) NULL,
  `oauth_access_tokencol` VARCHAR(255) NULL,
  `authentication` BLOB NULL,
  `refresh_token` VARCHAR(255) NULL)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `cotizacionesdb`.`oauth_refresh_token`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cotizacionesdb`.`oauth_refresh_token` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `cotizacionesdb`.`oauth_refresh_token` (
  `token_id` VARCHAR(255) NULL,
  `token` BLOB NULL,
  `authentication` BLOB NULL)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `cotizacionesdb`.`oauth_code`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cotizacionesdb`.`oauth_code` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `cotizacionesdb`.`oauth_code` (
  `code` VARCHAR(255) NULL,
  `authentication` BLOB NULL)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `cotizacionesdb`.`oauth_approval`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cotizacionesdb`.`oauth_approval` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `cotizacionesdb`.`oauth_approval` (
  `user_id` VARCHAR(255) NULL,
  `client_id` VARCHAR(255) NULL,
  `scope` VARCHAR(255) NULL,
  `status` VARCHAR(10) NULL,
  `expired_at` DATE NULL,
  `last_modified_at` DATE NULL)
ENGINE = InnoDB;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `cotizacionesdb`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `cotizacionesdb`;

-- username: admin
-- password: seguridad
INSERT INTO `cotizacionesdb`.`users` (`id_user`, `cedula`, `nombres`, `apellidos`, `direccion`, `fecha_nacimiento`, `telefono`, `email`, `username`, `password`, `enable`, `account_non_expired`, `credential_non_expired`, `account_non_locket`) VALUES (DEFAULT, 9645167, 'Administrator', 'Administrator', 'Calle 123', '1984-10-27', 301638457, 'administrator@localhost.co', 'admin', '$2a$10$.eFm7QuqWUg38t83B8RWseEwmb8bG9HuYltL/ogJqWmoX42q3fGXm', 'true', 'true', 'true', 'true');

-- username: acalle
-- password: Colombia2020
INSERT INTO `cotizacionesdb`.`users` (`id_user`, `cedula`, `nombres`, `apellidos`, `direccion`, `fecha_nacimiento`, `telefono`, `email`, `username`, `password`, `enable`, `account_non_expired`, `credential_non_expired`, `account_non_locket`) VALUES (DEFAULT, 900342297, 'acalle', 'Arturo Calle', 'Calle 456', '1984-10-27', 301638457, 'admin@acalle.co', 'acalle', '$2a$10$rKMjm.U07KEh6GrR7mPRbe8avK8Geu9.3VFbts1kWbhXGVazgOS0a', 'true', 'true', 'true', 'true');

-- username: avo5
-- password: Colombia2020
INSERT INTO `cotizacionesdb`.`users` (`id_user`, `cedula`, `nombres`, `apellidos`, `direccion`, `fecha_nacimiento`, `telefono`, `email`, `username`, `password`, `enable`, `account_non_expired`, `credential_non_expired`, `account_non_locket`) VALUES (DEFAULT, 891401345, 'avo5', 'Alberto Vo5', 'Calle 789', '1984-10-27', 301638457, 'avo5@avo5.com.co', 'avo5', '$2a$10$rKMjm.U07KEh6GrR7mPRbe8avK8Geu9.3VFbts1kWbhXGVazgOS0a', 'true', 'true', 'true', 'true');

COMMIT;


-- -----------------------------------------------------
-- Data for table `cotizacionesdb`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `cotizacionesdb`;
INSERT INTO `cotizacionesdb`.`roles` (`id_role`, `role`) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `cotizacionesdb`.`roles` (`id_role`, `role`) VALUES (2, 'ROLE_USER');
INSERT INTO `cotizacionesdb`.`roles` (`id_role`, `role`) VALUES (3, 'ROLE_PROVEEDOR');

COMMIT;


-- -----------------------------------------------------
-- Data for table `cotizacionesdb`.`users_roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `cotizacionesdb`;
INSERT INTO `cotizacionesdb`.`users_roles` (`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `cotizacionesdb`.`users_roles` (`user_id`, `role_id`) VALUES (1, 2);
INSERT INTO `cotizacionesdb`.`users_roles` (`user_id`, `role_id`) VALUES (1, 3);

INSERT INTO `cotizacionesdb`.`users_roles` (`user_id`, `role_id`) VALUES (2, 3);
INSERT INTO `cotizacionesdb`.`users_roles` (`user_id`, `role_id`) VALUES (3, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `cotizacionesdb`.`oauth_client_details`
-- -----------------------------------------------------
START TRANSACTION;
USE `cotizacionesdb`;
-- client_secret = 957254c06ba79806dfa64591f6942613 = spring cryto = $2a$10$4.sRz.udT2CbEfs3cQsRaOaPNWuaXFPcnEj7mERhNIh46dySUNNKO
INSERT INTO `cotizacionesdb`.`oauth_client_details` (`client_id`, `resource_id`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `authorities`, `access_token_validity`, `refresh_token_validity`, `additional_information`, `autoapprove`) VALUES ('cotizaciones_app', 'cotizaciones_service', '$2a$10$4.sRz.udT2CbEfs3cQsRaOaPNWuaXFPcnEj7mERhNIh46dySUNNKO', 'read,write', 'password,refresh_token,client_credentials,authorization_code', 'http://localhost:8082/cotizaciones/login/oauth2/code/', 'USER,PROVEEDOR', 300, 600, '', 'true');
-- client_secret = 8de6d4c46d616eb4c358ba6f63bb54dc = spring cryto = $2a$10$dKXov8JU3D9tAdJ16y6iTOqWWdXM0CJnwDca6BTbc1yNJeGRed9ua
INSERT INTO `cotizacionesdb`.`oauth_client_details` (`client_id`, `resource_id`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `authorities`, `access_token_validity`, `refresh_token_validity`, `additional_information`, `autoapprove`) VALUES ('proveedores_app', 'proveedores_service', '$2a$10$dKXov8JU3D9tAdJ16y6iTOqWWdXM0CJnwDca6BTbc1yNJeGRed9ua', 'read,write', 'password,refresh_token,client_credentials,authorization_code', 'http://localhost:8083/proveedores/login/oauth2/code/', 'USER,PROVEEDOR', 300, 600, '', 'true');

COMMIT;