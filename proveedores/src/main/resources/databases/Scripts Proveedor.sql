SHOW WARNINGS;
USE `ofertasdb` ;
CREATE TABLE IF NOT EXISTS `ofertasdb`.`catalogo` (
  `id_catalogo` INT NOT NULL AUTO_INCREMENT,
  `descripcion_catalogo` VARCHAR(1000) NOT NULL,
  `nombre_catalogo` VARCHAR(50) NOT NULL,
  `tipo_catalogo` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_catalogo`));

commit;

CREATE TABLE IF NOT EXISTS `ofertasdb`.`producto` (
  `id_producto` INT NOT NULL AUTO_INCREMENT,
  `id_catalogo` INT NOT NULL,
  `descripcion_producto` VARCHAR(1000) NOT NULL,
  `precio` FLOAT NOT NULL,
  `descuento` FLOAT NOT NULL,
  `stock` INT NOT NULL,
  PRIMARY KEY (`id_producto`));

commit;