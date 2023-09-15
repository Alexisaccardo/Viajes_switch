-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 15-09-2023 a las 15:42:32
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `viajes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `documento` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `celular` varchar(30) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  PRIMARY KEY (`documento`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`documento`, `nombre`, `correo`, `celular`, `direccion`) VALUES
('123456789', 'Alexis', 'medinaalexis2@gmail.com', '3224536798', 'cra 3 #6-20 lote 15'),
('987654321', 'Adriana', 'adrianamedina@gmail.com', '3202487658', 'calle 12b #6-30'),
('214365879', 'Luis', 'luisdiaz@gmail.com', '3167779898', 'cra 3 # 5-32');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

DROP TABLE IF EXISTS `departamento`;
CREATE TABLE IF NOT EXISTS `departamento` (
  `codigo` varchar(30) NOT NULL,
  `departamento` varchar(30) NOT NULL,
  `cliente` varchar(30) NOT NULL,
  `reservas` varchar(30) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`codigo`, `departamento`, `cliente`, `reservas`) VALUES
('12345', 'Antioquia', 'Johan', 'En espera'),
('54321', 'Valle', '', ''),
('21435', 'Cundinamarca', '', ''),
('45231', 'Quindio', '', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informacion`
--

DROP TABLE IF EXISTS `informacion`;
CREATE TABLE IF NOT EXISTS `informacion` (
  `codigo` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `documento` varchar(30) NOT NULL,
  `estado` varchar(30) NOT NULL,
  `puntos` varchar(30) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `informacion`
--

INSERT INTO `informacion` (`codigo`, `nombre`, `documento`, `estado`, `puntos`) VALUES
('12345', 'johan', '7698689789', 'en espera', '53000');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
