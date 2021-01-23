-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-01-2021 a las 12:57:26
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
(1, 'Overgrow'),
(2, 'Overgrow'),
(3, 'Overgrow'),
(4, 'Blaze'),
(5, 'Blaze'),
(6, 'Blaze'),
(7, 'Torrent'),
(8, 'Torrent'),
(9, 'Torrent'),
(10, 'Shield Dust'),
(11, 'Shield Dust'),
(12, 'Shield Dust'),
(13, 'Shield Dust'),
(14, 'Shield Dust'),
(15, 'Swarm'),
(16, 'Shed Skin'),
(17, 'Compound Eyes'),
(18, 'Shed skin'),
(19, 'Keen Eye'),
(20, 'Tangled Feet'),
(21, 'Keen Eye'),
(22, 'Tangled Feet'),
(23, 'Keen Eye'),
(24, 'Tangled Feet'),
(25, 'Run away'),
(26, 'Guts'),
(27, 'Run Away'),
(28, 'Guts'),
(29, 'Keen Eye'),
(30, 'Keen Eye'),
(31, 'Shed Skin'),
(32, 'Intimidate'),
(33, 'Shed Skin'),
(34, 'Intimidate'),
(35, 'Static'),
(36, 'Static');

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
(1, 'Ivysaur', 16),
(2, 'Venusaur', 32),
(3, 'Charmeleon', 16),
(4, 'Charizard', 32),
(5, 'Wartortle', 16),
(6, 'Blastoise', 32),
(7, 'Metapod', 16),
(8, 'Butterfree', 32),
(9, 'Kakuna', 16),
(10, 'Beedril', 32),
(11, 'Pidgeotto', 16),
(12, 'Pidgeot', 32),
(13, 'Raticate', 16),
(14, 'Fearow', 16),
(15, 'Arbok', 16),
(16, 'Raichu', 16);

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
(1, 1, 1),
(2, 2, 1),
(3, 3, 4),
(4, 4, 4),
(5, 5, 7),
(6, 6, 7),
(10, 10, 15),
(11, 7, 16),
(12, 8, 17),
(13, 9, 16),
(14, 11, 19),
(15, 11, 20),
(16, 12, 19),
(17, 12, 20),
(18, 13, 25),
(19, 13, 26),
(20, 14, 19),
(21, 15, 16),
(22, 15, 32),
(23, 16, 35);

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
(1, 1, 1),
(2, 2, 1),
(3, 3, 2),
(4, 4, 2),
(5, 5, 3),
(6, 6, 3),
(7, 7, 4),
(8, 8, 4),
(9, 9, 5),
(10, 10, 5),
(11, 11, 6),
(12, 12, 6),
(13, 13, 7),
(14, 14, 8),
(15, 15, 9),
(16, 16, 10);

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
(1, 1, 7),
(2, 1, 3),
(3, 2, 3),
(4, 2, 7),
(5, 3, 4),
(8, 4, 4),
(9, 4, 6),
(10, 5, 5),
(11, 6, 5),
(12, 7, 8),
(13, 8, 8),
(14, 9, 8),
(15, 9, 7),
(16, 10, 7),
(17, 10, 8),
(18, 8, 6),
(19, 11, 6),
(20, 11, 1),
(21, 12, 1),
(22, 12, 6),
(23, 13, 1),
(24, 14, 1),
(25, 14, 6),
(26, 15, 7),
(27, 16, 2);

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
(1, 'Bulbasaur'),
(2, 'Charmander'),
(3, 'Squirtle'),
(4, 'Caterpie'),
(5, 'Weedle'),
(6, 'Pidgey'),
(7, 'Rattata'),
(8, 'Spearow'),
(9, 'Ekans'),
(10, 'Pikachu');

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
(1, 1, 1),
(2, 2, 4),
(3, 3, 7),
(4, 4, 10),
(5, 5, 10),
(6, 6, 19),
(7, 6, 20),
(8, 7, 25),
(9, 7, 26),
(10, 8, 19),
(11, 9, 16),
(12, 9, 32),
(13, 10, 35);

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
(1, 1, 3),
(2, 1, 7),
(3, 2, 4),
(4, 3, 5),
(5, 4, 8),
(6, 5, 8),
(7, 5, 7),
(8, 6, 1),
(9, 6, 6),
(10, 7, 1),
(11, 8, 1),
(12, 8, 6),
(13, 9, 7),
(14, 10, 2);

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
(1, 1, 1, 5),
(2, 1, 2, 4),
(3, 1, 3, 2),
(4, 1, 4, 6),
(5, 1, 5, 5),
(6, 2, 6, 2),
(7, 2, 7, 3),
(8, 2, 8, 3),
(9, 2, 9, 4),
(10, 2, 10, 2);

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
(1, 'user1', 'user1'),
(2, 'user2', 'user2');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT de la tabla `evolution`
--
ALTER TABLE `evolution`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `evolution_abilities`
--
ALTER TABLE `evolution_abilities`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `evolution_pkm`
--
ALTER TABLE `evolution_pkm`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `evolution_type`
--
ALTER TABLE `evolution_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `pokemon`
--
ALTER TABLE `pokemon`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `pokemon_abilities`
--
ALTER TABLE `pokemon_abilities`
  MODIFY `pokemon_abilities` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

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
