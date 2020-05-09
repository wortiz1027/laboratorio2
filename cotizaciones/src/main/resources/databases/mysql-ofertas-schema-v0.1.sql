CREATE SCHEMA IF NOT EXISTS `cotizacionesdb` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `cotizacionesdb` ;
CREATE TABLE IF NOT EXISTS `cotizacionesdb`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nombre_usuario` VARCHAR(20) NOT NULL,
  `password` VARCHAR(1000) NOT NULL,
  `tipo_usuario` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_usuario`));
  
commit;
  
CREATE TABLE IF NOT EXISTS `cotizacionesdb`.`cliente` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `id_usuario` INT,
  `nombres` VARCHAR(20) NOT NULL,
  `apellidos` VARCHAR(20) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `telefono` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_cliente`));
  
commit;

CREATE TABLE IF NOT EXISTS `cotizacionesdb`.`proveedor` (
  `id_proveedor` INT NOT NULL AUTO_INCREMENT,
  `id_usuario` INT,
  `nombre_proveedor` VARCHAR(50) NOT NULL,
  `identificacion_proveedor` VARCHAR(20) NOT NULL,
  `telefono_proveedor` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_proveedor`));
  
commit;
  
CREATE TABLE IF NOT EXISTS `cotizacionesdb`.`catalogo` (
  `id_catalogo` INT NOT NULL AUTO_INCREMENT,
  `id_proveedor` INT NOT NULL,
  `nombre_catalogo` VARCHAR(50) NOT NULL,
  `tipo_catalogo` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_catalogo`));
  
commit;
  
CREATE TABLE IF NOT EXISTS `cotizacionesdb`.`cotizacion_cliente` (
  `id_cotizacion_cliente` INT NOT NULL AUTO_INCREMENT,
  `id_cliente` INT NOT NULL,
  `id_cotizacion_proveedor` INT NOT NULL,
  `fecha_cotizacion` DATETIME NOT NULL,
  PRIMARY KEY (`id_cotizacion_cliente`));
  
commit;
  
CREATE TABLE IF NOT EXISTS `cotizacionesdb`.`cotizacion_proveedor` (
  `id_cotizacion_proveedor` INT NOT NULL AUTO_INCREMENT,
  `id_cotizacion_cliente` INT NOT NULL,
  `fecha_cotizacion` DATETIME NOT NULL,
  PRIMARY KEY (`id_cotizacion_proveedor`));
  
commit;
  
CREATE TABLE IF NOT EXISTS `cotizacionesdb`.`producto` (
  `id_producto` INT NOT NULL AUTO_INCREMENT,
  `id_catalogo` INT NOT NULL,
  `nombre_producto` VARCHAR(50) NOT NULL,
  `precio` FLOAT NOT NULL,
  `tipo_producto` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id_producto`));
  
commit;
  
CREATE TABLE IF NOT EXISTS `cotizacionesdb`.`producto_cotizacion_proveedor` (
  `id_producto_cotizacion_proveedor` INT NOT NULL AUTO_INCREMENT,
  `id_catalogo` INT NOT NULL,
  `id_producto` INT NOT NULL,
  PRIMARY KEY (`id_producto_cotizacion_proveedor`));
  
commit;