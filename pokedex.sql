-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-01-2021 a las 23:26:37
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pokedex`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `abilities`
--

CREATE TABLE `abilities` (
  `id` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `abilities`
--

INSERT INTO `abilities` (`id`, `name`) VALUES
(1, 'Static'),
(2, 'Torrent');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evolution`
--

CREATE TABLE `evolution` (
  `id` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `lvlEvolve` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `evolution`
--

INSERT INTO `evolution` (`id`, `name`, `lvlEvolve`) VALUES
(1, 'Raychu', 32),
(2, 'Ivysaur', 16),
(3, 'Venusaur', 32),
(4, 'Pichu', 16),
(5, 'Wartortle', 16),
(6, 'Blastoise', 32),
(7, 'Charmeleon', 16),
(8, 'Charizard', 32),
(9, 'Metapod', 16),
(10, 'Butterfree', 32),
(11, 'Kakuna', 16),
(12, 'Beedril', 32),
(13, 'Pidgeotto', 16),
(14, 'Pidgeot', 32),
(15, 'Raticate', 16),
(16, 'Fearow', 16),
(17, 'Arbok', 16);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evolution_abilities`
--

CREATE TABLE `evolution_abilities` (
  `id` int(11) NOT NULL,
  `idEvo` int(11) NOT NULL,
  `idAbilitie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `evolution_abilities`
--

INSERT INTO `evolution_abilities` (`id`, `idEvo`, `idAbilitie`) VALUES
(1, 6, 2),
(2, 4, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evolution_pkm`
--

CREATE TABLE `evolution_pkm` (
  `id` int(11) NOT NULL,
  `idEvo` int(11) NOT NULL,
  `idPkm` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `evolution_pkm`
--

INSERT INTO `evolution_pkm` (`id`, `idEvo`, `idPkm`) VALUES
(1, 2, 3),
(2, 3, 3),
(3, 1, 1),
(4, 4, 1),
(5, 5, 2),
(6, 6, 2),
(7, 2, 3),
(8, 3, 3),
(9, 7, 4),
(10, 8, 4),
(11, 9, 5),
(12, 10, 5),
(13, 11, 6),
(14, 12, 6),
(15, 13, 7),
(16, 14, 7),
(17, 15, 8),
(18, 16, 9),
(19, 17, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evolution_type`
--

CREATE TABLE `evolution_type` (
  `id` int(11) NOT NULL,
  `idEvo` int(11) NOT NULL,
  `idType` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `evolution_type`
--

INSERT INTO `evolution_type` (`id`, `idEvo`, `idType`) VALUES
(1, 1, 2),
(2, 3, 3),
(3, 2, 3),
(4, 2, 7),
(5, 3, 7),
(6, 4, 2),
(7, 5, 5),
(8, 6, 5),
(9, 7, 4),
(10, 8, 4),
(11, 8, 6),
(12, 9, 8),
(13, 10, 8),
(14, 10, 6),
(15, 11, 8),
(16, 11, 7),
(17, 12, 8),
(18, 12, 7),
(19, 13, 1),
(20, 13, 6),
(21, 14, 1),
(22, 14, 6),
(23, 16, 1),
(24, 16, 6),
(25, 15, 1),
(26, 17, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pokemon`
--

CREATE TABLE `pokemon` (
  `id` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pokemon`
--

INSERT INTO `pokemon` (`id`, `name`) VALUES
(1, 'Pikachu'),
(2, 'Squirtle'),
(3, 'Bulbasaur'),
(4, 'Charmander'),
(5, 'Caterpie'),
(6, 'Weedle'),
(7, 'Pidgey'),
(8, 'Rattata'),
(9, 'Spearow'),
(10, 'Ekans'),
(11, 'Test'),
(12, 'Puchamon');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pokemon_abilities`
--

CREATE TABLE `pokemon_abilities` (
  `pokemon_abilities` int(11) NOT NULL,
  `idPkm` int(11) NOT NULL,
  `idAbilitie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pokemon_abilities`
--

INSERT INTO `pokemon_abilities` (`pokemon_abilities`, `idPkm`, `idAbilitie`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pokemon_type`
--

CREATE TABLE `pokemon_type` (
  `id` int(11) NOT NULL,
  `idPkm` int(11) NOT NULL,
  `idType` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pokemon_type`
--

INSERT INTO `pokemon_type` (`id`, `idPkm`, `idType`) VALUES
(1, 4, 4),
(2, 3, 3),
(3, 1, 2),
(4, 2, 5),
(5, 3, 7),
(6, 5, 8),
(7, 6, 8),
(8, 6, 7),
(9, 7, 6),
(10, 7, 1),
(11, 8, 1),
(12, 9, 1),
(13, 9, 6),
(14, 10, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `type`
--

CREATE TABLE `type` (
  `id` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `type`
--

INSERT INTO `type` (`id`, `name`) VALUES
(1, 'normal'),
(2, 'electric'),
(3, 'plant'),
(4, 'fire'),
(5, 'water'),
(6, 'fliying'),
(7, 'poison'),
(8, 'bug');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_pokemons`
--

CREATE TABLE `user_pokemons` (
  `id` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idPokemon` int(11) NOT NULL,
  `lvlFound` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `user_pokemons`
--

INSERT INTO `user_pokemons` (`id`, `idCliente`, `idPokemon`, `lvlFound`) VALUES
(1, 1, 1, 6),
(2, 1, 2, 4),
(3, 2, 3, 7),
(4, 2, 4, 5),
(5, 1, 4, 0),
(6, 1, 7, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `user` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `user`, `password`) VALUES
(1, 'test', 'test'),
(2, 'carlos', 'profe');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `abilities`
--
ALTER TABLE `abilities`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `evolution`
--
ALTER TABLE `evolution`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `evolution_abilities`
--
ALTER TABLE `evolution_abilities`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idEvo` (`idEvo`),
  ADD KEY `idAbilitie` (`idAbilitie`);

--
-- Indices de la tabla `evolution_pkm`
--
ALTER TABLE `evolution_pkm`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idEvo` (`idEvo`),
  ADD KEY `idPkm` (`idPkm`);

--
-- Indices de la tabla `evolution_type`
--
ALTER TABLE `evolution_type`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idEvo` (`idEvo`),
  ADD KEY `idType` (`idType`);

--
-- Indices de la tabla `pokemon`
--
ALTER TABLE `pokemon`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pokemon_abilities`
--
ALTER TABLE `pokemon_abilities`
  ADD PRIMARY KEY (`pokemon_abilities`),
  ADD KEY `idPkm` (`idPkm`),
  ADD KEY `idAbilitie` (`idAbilitie`);

--
-- Indices de la tabla `pokemon_type`
--
ALTER TABLE `pokemon_type`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idPkm` (`idPkm`),
  ADD KEY `idType` (`idType`);

--
-- Indices de la tabla `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user_pokemons`
--
ALTER TABLE `user_pokemons`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idCliente` (`idCliente`),
  ADD KEY `idPokemon` (`idPokemon`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `abilities`
--
ALTER TABLE `abilities`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `evolution`
--
ALTER TABLE `evolution`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `evolution_abilities`
--
ALTER TABLE `evolution_abilities`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `evolution_pkm`
--
ALTER TABLE `evolution_pkm`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `evolution_type`
--
ALTER TABLE `evolution_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `pokemon`
--
ALTER TABLE `pokemon`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `pokemon_abilities`
--
ALTER TABLE `pokemon_abilities`
  MODIFY `pokemon_abilities` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `pokemon_type`
--
ALTER TABLE `pokemon_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `type`
--
ALTER TABLE `type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `user_pokemons`
--
ALTER TABLE `user_pokemons`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `evolution_abilities`
--
ALTER TABLE `evolution_abilities`
  ADD CONSTRAINT `evolution_abilities_ibfk_1` FOREIGN KEY (`idAbilitie`) REFERENCES `abilities` (`id`),
  ADD CONSTRAINT `evolution_abilities_ibfk_2` FOREIGN KEY (`idEvo`) REFERENCES `evolution` (`id`);

--
-- Filtros para la tabla `evolution_pkm`
--
ALTER TABLE `evolution_pkm`
  ADD CONSTRAINT `evolution_pkm_ibfk_1` FOREIGN KEY (`idEvo`) REFERENCES `evolution` (`id`),
  ADD CONSTRAINT `evolution_pkm_ibfk_2` FOREIGN KEY (`idPkm`) REFERENCES `pokemon` (`id`);

--
-- Filtros para la tabla `evolution_type`
--
ALTER TABLE `evolution_type`
  ADD CONSTRAINT `evolution_type_ibfk_1` FOREIGN KEY (`idType`) REFERENCES `type` (`id`),
  ADD CONSTRAINT `evolution_type_ibfk_2` FOREIGN KEY (`idEvo`) REFERENCES `evolution` (`id`);

--
-- Filtros para la tabla `pokemon_abilities`
--
ALTER TABLE `pokemon_abilities`
  ADD CONSTRAINT `pokemon_abilities_ibfk_1` FOREIGN KEY (`idPkm`) REFERENCES `pokemon` (`id`),
  ADD CONSTRAINT `pokemon_abilities_ibfk_2` FOREIGN KEY (`idAbilitie`) REFERENCES `abilities` (`id`);

--
-- Filtros para la tabla `pokemon_type`
--
ALTER TABLE `pokemon_type`
  ADD CONSTRAINT `pokemon_type_ibfk_2` FOREIGN KEY (`idType`) REFERENCES `type` (`id`),
  ADD CONSTRAINT `pokemon_type_ibfk_3` FOREIGN KEY (`idPkm`) REFERENCES `pokemon` (`id`);

--
-- Filtros para la tabla `user_pokemons`
--
ALTER TABLE `user_pokemons`
  ADD CONSTRAINT `user_pokemons_ibfk_1` FOREIGN KEY (`idPokemon`) REFERENCES `pokemon` (`id`),
  ADD CONSTRAINT `user_pokemons_ibfk_2` FOREIGN KEY (`idCliente`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
