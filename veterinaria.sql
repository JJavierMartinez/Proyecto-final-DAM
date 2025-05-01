-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         11.5.2-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para veterinaria
CREATE DATABASE IF NOT EXISTS `veterinaria` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci */;
USE `veterinaria`;

-- Volcando estructura para tabla veterinaria.citas
CREATE TABLE IF NOT EXISTS `citas` (
  `id_cita` uuid NOT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `motivo` varchar(255) DEFAULT NULL,
  `id_paciente` uuid DEFAULT NULL,
  `id_pago` uuid DEFAULT NULL,
  `id_veterinario` uuid DEFAULT NULL,
  PRIMARY KEY (`id_cita`),
  KEY `FKa6jbqxi4v5ij2jdlgrmwnt94o` (`id_paciente`),
  KEY `FK9v7f3yogq3ik63qp9adb552g4` (`id_pago`),
  KEY `FKg5i7jfrign48aep0uxtml2h2u` (`id_veterinario`),
  CONSTRAINT `FK9v7f3yogq3ik63qp9adb552g4` FOREIGN KEY (`id_pago`) REFERENCES `pagos` (`id_pago`),
  CONSTRAINT `FKa6jbqxi4v5ij2jdlgrmwnt94o` FOREIGN KEY (`id_paciente`) REFERENCES `pacientes` (`id_paciente`),
  CONSTRAINT `FKg5i7jfrign48aep0uxtml2h2u` FOREIGN KEY (`id_veterinario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla veterinaria.enfermedades
CREATE TABLE IF NOT EXISTS `enfermedades` (
  `id_enfermedad` uuid NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_enfermedad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla veterinaria.historiales
CREATE TABLE IF NOT EXISTS `historiales` (
  `id_historial` uuid NOT NULL,
  `fecha_evento` datetime(6) DEFAULT NULL,
  `notas` varchar(255) DEFAULT NULL,
  `tipo_evento` varchar(255) DEFAULT NULL,
  `id_paciente` uuid DEFAULT NULL,
  PRIMARY KEY (`id_historial`),
  KEY `FK8hnhwlkyhkyyaxkdn56axstpj` (`id_paciente`),
  CONSTRAINT `FK8hnhwlkyhkyyaxkdn56axstpj` FOREIGN KEY (`id_paciente`) REFERENCES `pacientes` (`id_paciente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla veterinaria.historial_enfermedad
CREATE TABLE IF NOT EXISTS `historial_enfermedad` (
  `estado` varchar(255) DEFAULT NULL,
  `fecha_diagnostico` datetime(6) DEFAULT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  `tratamiento` varchar(255) DEFAULT NULL,
  `id_historial` uuid NOT NULL,
  `id_enfermedad` uuid NOT NULL,
  PRIMARY KEY (`id_enfermedad`,`id_historial`),
  KEY `FKapi73duqotmy2awkt8n9cwrg4` (`id_historial`),
  CONSTRAINT `FKapi73duqotmy2awkt8n9cwrg4` FOREIGN KEY (`id_historial`) REFERENCES `historiales` (`id_historial`),
  CONSTRAINT `FKlpv5k3uqivftc84aatc9priyp` FOREIGN KEY (`id_enfermedad`) REFERENCES `enfermedades` (`id_enfermedad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla veterinaria.pacientes
CREATE TABLE IF NOT EXISTS `pacientes` (
  `id_paciente` uuid NOT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `dni_mascota` varchar(255) DEFAULT NULL,
  `especie` varchar(255) DEFAULT NULL,
  `fecha_nac` datetime(6) DEFAULT NULL,
  `fecha_registro` datetime(6) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `raza` varchar(255) DEFAULT NULL,
  `seguro` bit(1) DEFAULT NULL,
  `id_dueno` uuid DEFAULT NULL,
  PRIMARY KEY (`id_paciente`),
  KEY `FKlawxt4o6spky0f0ymeiu48lni` (`id_dueno`),
  CONSTRAINT `FKlawxt4o6spky0f0ymeiu48lni` FOREIGN KEY (`id_dueno`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla veterinaria.pagos
CREATE TABLE IF NOT EXISTS `pagos` (
  `id_pago` uuid NOT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `metodo_pago` varchar(255) DEFAULT NULL,
  `monto` float DEFAULT NULL,
  PRIMARY KEY (`id_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla veterinaria.rol
CREATE TABLE IF NOT EXISTS `rol` (
  `id_rol` uuid NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla veterinaria.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id_usuario` uuid NOT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `contrasena` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `fecha_alta` datetime(6) DEFAULT NULL,
  `fecha_nac` datetime(6) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  `id_rol` uuid DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `FK5ubh1vhgk6g42j7twprjlvmpu` (`id_rol`),
  CONSTRAINT `FK5ubh1vhgk6g42j7twprjlvmpu` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- La exportación de datos fue deseleccionada.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
