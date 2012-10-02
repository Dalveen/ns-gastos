USE gastos_v2;
CREATE TABLE `estructura_campo_entidad` (
	`id` int(8) NOT NULL AUTO_INCREMENT,
	`identificador` varchar(100) NOT NULL,
	`claseTipo` varchar(255) NOT NULL,
	`requerido` tinyint(1) NOT NULL,
	`fechaDeCreacion` datetime NOT NULL,
	PRIMARY KEY (`id`),
	KEY `identificador` (`identificador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;