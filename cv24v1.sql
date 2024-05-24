SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `cv24v1`
--

-- --------------------------------------------------------

--
-- Structure de la table `autre`
--

CREATE TABLE `autre` (
  `id` bigint NOT NULL,
  `autre_comment` varchar(255) DEFAULT NULL,
  `autre_titre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `autre`
--

INSERT INTO `autre` (`id`, `autre_comment`, `autre_titre`) VALUES
(1, 'B', 'Permis');

-- --------------------------------------------------------

--
-- Structure de la table `autre_seq`
--

CREATE TABLE `autre_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `autre_seq`
--

INSERT INTO `autre_seq` (`next_val`) VALUES
(51);

-- --------------------------------------------------------

--
-- Structure de la table `certif`
--

CREATE TABLE `certif` (
  `fk_id_competences` bigint DEFAULT NULL,
  `id` bigint NOT NULL,
  `certif_titre` varchar(255) DEFAULT NULL,
  `datedeb` varchar(255) DEFAULT NULL,
  `datefin` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `certif`
--

INSERT INTO `certif` (`fk_id_competences`, `id`, `certif_titre`, `datedeb`, `datefin`) VALUES
(1, 1, 'Cloud Fundation', '2023-04-15', NULL),
(1, 2, 'Cloud Fundation 2', '2023-04-16', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `certif_seq`
--

CREATE TABLE `certif_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `certif_seq`
--

INSERT INTO `certif_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Structure de la table `competences`
--

CREATE TABLE `competences` (
  `id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `competences`
--

INSERT INTO `competences` (`id`) VALUES
(1),
(2);

-- --------------------------------------------------------

--
-- Structure de la table `competences_seq`
--

CREATE TABLE `competences_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `competences_seq`
--

INSERT INTO `competences_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Structure de la table `cv24`
--

CREATE TABLE `cv24` (
  `competences_id` bigint DEFAULT NULL,
  `divers_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL,
  `identite_id` bigint DEFAULT NULL,
  `objectif_id` bigint DEFAULT NULL,
  `prof_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `cv24`
--

INSERT INTO `cv24` (`competences_id`, `divers_id`, `id`, `identite_id`, `objectif_id`, `prof_id`) VALUES
(1, 1, 1, 1, 1, 1),
(2, NULL, 2, 2, 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `cv24_seq`
--

CREATE TABLE `cv24_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `cv24_seq`
--

INSERT INTO `cv24_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Structure de la table `detail`
--

CREATE TABLE `detail` (
  `fk_id_prof` bigint DEFAULT NULL,
  `id` bigint NOT NULL,
  `prof_id` bigint DEFAULT NULL,
  `datedeb` varchar(255) DEFAULT NULL,
  `datefin` varchar(255) DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `detail`
--

INSERT INTO `detail` (`fk_id_prof`, `id`, `prof_id`, `datedeb`, `datefin`, `titre`) VALUES
(1, 1, NULL, '2024-01-01', NULL, 'Developpeur Full Stack'),
(1, 2, NULL, '2023-08-01', '2024-09-01', 'Developpeur Full Stack'),
(1, 3, NULL, '2022-05-01', '2022-07-31', 'benevole jeux mediterraneens '),
(1, 4, NULL, '2021-11-01', '2022-02-01', 'Formateur institut francais'),
(2, 5, NULL, '2023-08-31', '2023-05-25', 'Stage Web');

-- --------------------------------------------------------

--
-- Structure de la table `detail_seq`
--

CREATE TABLE `detail_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `detail_seq`
--

INSERT INTO `detail_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Structure de la table `diplome`
--

CREATE TABLE `diplome` (
  `fk_id_competences` bigint DEFAULT NULL,
  `id` bigint NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `diplome_niveau` varchar(255) DEFAULT NULL,
  `institut_diplome` varchar(255) DEFAULT NULL,
  `titre_diplome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `diplome`
--

INSERT INTO `diplome` (`fk_id_competences`, `id`, `date`, `diplome_niveau`, `institut_diplome`, `titre_diplome`) VALUES
(1, 1, '2023-06-01', '4', 'Universite des sciences d\'oran', 'Master 1 systemes d\'information et de données '),
(1, 2, '2022-06-01', '3', 'Universite des sciences d\'oran', 'Licence en informatique systemes informatiques '),
(1, 3, '2025-06-01', '5', 'Universite de Rouen Normandie', 'Master genie de l\'informatique et logicielle '),
(2, 4, '2023-09-01', '4', 'Universite de Rouen Normandie', 'Master 1 Génie d\'informatique logicielle ');

-- --------------------------------------------------------

--
-- Structure de la table `diplome_seq`
--

CREATE TABLE `diplome_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `diplome_seq`
--

INSERT INTO `diplome_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Structure de la table `divers`
--

CREATE TABLE `divers` (
  `autre_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `divers`
--

INSERT INTO `divers` (`autre_id`, `id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `divers_seq`
--

CREATE TABLE `divers_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `divers_seq`
--

INSERT INTO `divers_seq` (`next_val`) VALUES
(51);

-- --------------------------------------------------------

--
-- Structure de la table `identite`
--

CREATE TABLE `identite` (
  `id` bigint NOT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `mel` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `identite`
--

INSERT INTO `identite` (`id`, `genre`, `mel`, `nom`, `prenom`, `tel`) VALUES
(1, 'Mr', 'toubalzineddine77@gmail.com', 'TOUBAL', 'Zine Eddine', '+33 1 23 45 67 89'),
(2, 'Mr', 'yacinebrutal76@gmail.com', 'BEN AHMED', 'Yacine', '+33 1 23 45 67 89');

-- --------------------------------------------------------

--
-- Structure de la table `identite_seq`
--

CREATE TABLE `identite_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `identite_seq`
--

INSERT INTO `identite_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Structure de la table `lv`
--

CREATE TABLE `lv` (
  `fk_id_divers` bigint DEFAULT NULL,
  `id` bigint NOT NULL,
  `cert` varchar(255) DEFAULT NULL,
  `lang` varchar(255) DEFAULT NULL,
  `nivi` varchar(255) DEFAULT NULL,
  `nivs` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `lv`
--

INSERT INTO `lv` (`fk_id_divers`, `id`, `cert`, `lang`, `nivi`, `nivs`) VALUES
(1, 1, 'MAT', 'fr', '580', 'C1'),
(1, 2, 'TOEIC', 'en', NULL, 'A2');

-- --------------------------------------------------------

--
-- Structure de la table `lv_seq`
--

CREATE TABLE `lv_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `lv_seq`
--

INSERT INTO `lv_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Structure de la table `objectif`
--

CREATE TABLE `objectif` (
  `id` bigint NOT NULL,
  `objectif_value` varchar(255) DEFAULT NULL,
  `statut_objectif` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `objectif`
--

INSERT INTO `objectif` (`id`, `objectif_value`, `statut_objectif`) VALUES
(1, 'Developpeur full stack', 'stage'),
(2, 'Developpeur web', 'stage');

-- --------------------------------------------------------

--
-- Structure de la table `objectif_seq`
--

CREATE TABLE `objectif_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `objectif_seq`
--

INSERT INTO `objectif_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Structure de la table `prof`
--

CREATE TABLE `prof` (
  `id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `prof`
--

INSERT INTO `prof` (`id`) VALUES
(1),
(2);

-- --------------------------------------------------------

--
-- Structure de la table `prof_seq`
--

CREATE TABLE `prof_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `prof_seq`
--

INSERT INTO `prof_seq` (`next_val`) VALUES
(101);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `autre`
--
ALTER TABLE `autre`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `certif`
--
ALTER TABLE `certif`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK83hh4u2c94d9sesp65yhemjp7` (`fk_id_competences`);

--
-- Index pour la table `competences`
--
ALTER TABLE `competences`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `cv24`
--
ALTER TABLE `cv24`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_5xmxc63l1pnggyy9hkosh696m` (`competences_id`),
  ADD UNIQUE KEY `UK_j4rl0wpl7mkck4p4jijdsrmim` (`divers_id`),
  ADD UNIQUE KEY `UK_b8k6r0hiuhvd7yxrbnmll2kqf` (`identite_id`),
  ADD UNIQUE KEY `UK_1uuehemqqjq8ud40qnxfr81uc` (`objectif_id`),
  ADD UNIQUE KEY `UK_np5o5bdcjylap03i4a4gxyct` (`prof_id`);

--
-- Index pour la table `detail`
--
ALTER TABLE `detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqrfpr9tfrddvv2le9xa2yqe8j` (`prof_id`),
  ADD KEY `FKeit4yggnmif9wijgafdslt16n` (`fk_id_prof`);

--
-- Index pour la table `diplome`
--
ALTER TABLE `diplome`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK516xd5pa5jgudxwpsx9upcnl8` (`fk_id_competences`);

--
-- Index pour la table `divers`
--
ALTER TABLE `divers`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_inqwiql66yl1tu6estv2yai0` (`autre_id`);

--
-- Index pour la table `identite`
--
ALTER TABLE `identite`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `lv`
--
ALTER TABLE `lv`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgnq3ea9vdxlbsocvyjcff80ty` (`fk_id_divers`);

--
-- Index pour la table `objectif`
--
ALTER TABLE `objectif`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `prof`
--
ALTER TABLE `prof`
  ADD PRIMARY KEY (`id`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `certif`
--
ALTER TABLE `certif`
  ADD CONSTRAINT `FK83hh4u2c94d9sesp65yhemjp7` FOREIGN KEY (`fk_id_competences`) REFERENCES `competences` (`id`);

--
-- Contraintes pour la table `cv24`
--
ALTER TABLE `cv24`
  ADD CONSTRAINT `FK6gm2gvf4icrxuc4iymtmbdqcr` FOREIGN KEY (`prof_id`) REFERENCES `prof` (`id`),
  ADD CONSTRAINT `FK6nfuo5osigfpc4d1ufcwimnvt` FOREIGN KEY (`identite_id`) REFERENCES `identite` (`id`),
  ADD CONSTRAINT `FK7cgxvx452qethrf9mt0dx40fy` FOREIGN KEY (`objectif_id`) REFERENCES `objectif` (`id`),
  ADD CONSTRAINT `FK9wt6o5250qi37rfnmrt15savb` FOREIGN KEY (`divers_id`) REFERENCES `divers` (`id`),
  ADD CONSTRAINT `FKs1jtu98vu1ut4x66o6c75ple5` FOREIGN KEY (`competences_id`) REFERENCES `competences` (`id`);

--
-- Contraintes pour la table `detail`
--
ALTER TABLE `detail`
  ADD CONSTRAINT `FKeit4yggnmif9wijgafdslt16n` FOREIGN KEY (`fk_id_prof`) REFERENCES `prof` (`id`),
  ADD CONSTRAINT `FKqrfpr9tfrddvv2le9xa2yqe8j` FOREIGN KEY (`prof_id`) REFERENCES `prof` (`id`);

--
-- Contraintes pour la table `diplome`
--
ALTER TABLE `diplome`
  ADD CONSTRAINT `FK516xd5pa5jgudxwpsx9upcnl8` FOREIGN KEY (`fk_id_competences`) REFERENCES `competences` (`id`);

--
-- Contraintes pour la table `divers`
--
ALTER TABLE `divers`
  ADD CONSTRAINT `FK1edsoriv3ihlgc0h6ib2u80ra` FOREIGN KEY (`autre_id`) REFERENCES `autre` (`id`);

--
-- Contraintes pour la table `lv`
--
ALTER TABLE `lv`
  ADD CONSTRAINT `FKgnq3ea9vdxlbsocvyjcff80ty` FOREIGN KEY (`fk_id_divers`) REFERENCES `divers` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
