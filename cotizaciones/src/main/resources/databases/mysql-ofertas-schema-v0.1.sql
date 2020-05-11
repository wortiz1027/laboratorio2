CREATE SCHEMA IF NOT EXISTS `cotizacionesdb` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `cotizacionesdb` ;
  
CREATE TABLE IF NOT EXISTS `cotizacionesdb`.`catalogo` (
  `id_catalogo` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NOT NULL,
  `nombre_catalogo` VARCHAR(50) NOT NULL,
  `tipo_catalogo` VARCHAR(20) NOT NULL,
  `descripcion_catalogo` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`id_catalogo`));
  
commit;

CREATE TABLE IF NOT EXISTS `cotizacionesdb`.`producto` (
  `id_producto` INT NOT NULL AUTO_INCREMENT,
  `id_catalogo` INT NOT NULL,
  `nombre_producto` VARCHAR(50) NOT NULL,
  `descripcion_producto` VARCHAR(50) NOT NULL,
  `tipo_producto` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id_producto`));
  
commit;

CREATE TABLE IF NOT EXISTS `cotizacionesdb`.`cotizacion` (
  `id_cotizacion` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NOT NULL,
  `fecha_cotizacion` DATE NOT NULL,
  `fecha_respuesta` DATE NOT NULL,
  PRIMARY KEY (`id_cotizacion`));
  
commit;

CREATE TABLE IF NOT EXISTS `cotizacionesdb`.`precio_proveedor` (
  `id_precio_proveedor` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NOT NULL,
  `id_producto` INT NOT NULL,
  `precio` DECIMAL NOT NULL,
  PRIMARY KEY (`id_precio_proveedor`));
  
commit;

CREATE TABLE IF NOT EXISTS `cotizacionesdb`.`productos_cotizados` (
  `id_productos_cotizados` INT NOT NULL AUTO_INCREMENT,
  `id_producto` INT NOT NULL,
  `id_cotizacion` DECIMAL NOT NULL,
  PRIMARY KEY (`id_productos_cotizados`));
  
commit;