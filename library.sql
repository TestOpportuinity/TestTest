-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 23 Maj 2017, 22:25
-- Wersja serwera: 10.1.21-MariaDB
-- Wersja PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `library`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `author`
--

CREATE TABLE `author` (
  `ID` int(11) NOT NULL,
  `firstName` varchar(40) COLLATE utf8_polish_ci NOT NULL,
  `lastName` varchar(40) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `author`
--

INSERT INTO `author` (`ID`, `firstName`, `lastName`) VALUES
(1, 'Vishal', 'Layka'),
(2, 'Radosław', 'Sokół'),
(3, 'Michael', 'Morrison'),
(4, 'Steven', 'Olson'),
(5, 'Thomas H', 'Cormen'),
(6, 'Piotr', 'Wróblewski'),
(7, 'Harlan', 'Carvey'),
(8, 'Paul', 'Wolfe'),
(9, 'Andrew', 'Ford'),
(10, 'Vivek', 'Ramachandran'),
(11, 'Justin', 'Seitz'),
(12, 'Łukasz', 'Pasternak'),
(13, 'Kevin', 'Mitnick'),
(14, 'Michael James', 'Williams'),
(15, 'Patrick', 'Engebretson'),
(16, 'Jon', 'Erickson'),
(17, 'Jason', 'Tyler'),
(18, 'Zachary', 'Kessom'),
(19, 'Luke', 'Stevens'),
(20, 'Alan', 'Monnox'),
(21, 'Krzysztof', 'Rychlicki-Kicior'),
(22, 'Joshua', 'Bloch'),
(23, 'Anil', 'Hemrajani'),
(24, 'Noel', 'Kalicharan');
(25, 'Bruce', 'Dang');
(30, 'Dawid', 'Farbaniec');
-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `book`
--

CREATE TABLE `book` (
  `ISBN` varchar(26) COLLATE utf8_polish_ci NOT NULL,
  `CATEGORY_ID` int(11) NOT NULL,
  `BOOK_TITLE` varchar(60) COLLATE utf8_polish_ci NOT NULL,
  `AUTHOR_ID` int(11) NOT NULL,
  `PUBLISHER` varchar(60) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `book`
--

INSERT INTO `book` (`ISBN`, `CATEGORY_ID`, `BOOK_TITLE`, `AUTHOR_ID`, `PUBLISHER`) VALUES
('83-246-1393-5', 5, 'Ajax. Niezbędnik projektanta dynamicznych aplikacji', 3, 'Helion'),
('83-246-2306-X', 6, 'Algorytmy, struktury danych i techniki programowania. Wydani', 6, 'Helion'),
('83-7361-587-3', 7, 'Anti-Spam Tool Kit. Edycja polska', 8, 'Helion'),
('978-83-246-1110-2', 5, 'Ajax on Java', 4, 'Helion'),
('978-83-246-2179-8', 10, 'Apache 2. Leksykon kieszonkowy ', 9, 'Helion'),
('978-83-246-6652-2', 7, 'Analiza śledcza i powłamaniowa. Zaawansowane techniki prowad', 7, 'Helion'),
('978-83-246-6682-9', 7, 'BackTrack 5. Testy penetracyjne sieci WiFi', 10, 'Helion'),
('978-83-246-7482-4', 6, 'Algorytmy bez tajemnic', 5, 'Helion'),
('978-83-246-9806-6', 3, 'Java. Projektowanie aplikacji WWW', 1, 'Helion'),
('978-83-283-0253-2', 4, 'ABC Linux. Wydanie II', 2, 'Helion'),
('978-83-283-1250-0', 1, 'Black Hat Python. Język Python dla hakerów i pentesterów', 11, 'Helion');
('978-83-283-0678-3', 7, 'Inżynieria odwrotna w praktyce. Narzędzia i techniki', 25, 'Helion');
 ('978-83-283-0678-3', 7, 'Inżynieria odwrotna w praktyce. Narzędzia i techniki 2', 25, 'Helion');
 ('978-83-246-8862-3', 7, 'Techniki Twórców złośliwego oprogamowania. Elementarz programisty', 30, 'Helion');
 ('978-83-246-8862-3', 7, 'Techniki Twórców złośliwego oprogamowania. Elementarz programisty 2', 30, 'Helion');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `category`
--

CREATE TABLE `category` (
  `ID` int(11) NOT NULL,
  `CATEGORY_NAME` varchar(20) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `category`
--

INSERT INTO `category` (`ID`, `CATEGORY_NAME`) VALUES
(1, 'Python'),
(2, 'C'),
(3, 'Java'),
(4, 'System Operacyjne'),
(5, 'Ajax'),
(6, 'Algorytmy'),
(7, 'Hacking i bezpieczeń'),
(8, 'CSS'),
(9, 'HTML'),
(10, 'Serwery Usług');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `libraryuser`
--

CREATE TABLE `libraryuser` (
  `ID` int(11) NOT NULL,
  `firstName` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `lastName` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `phone` varchar(12) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`ISBN`),
  ADD KEY `FK_BOOK_1` (`CATEGORY_ID`),
  ADD KEY `FK_BOOK_2` (`AUTHOR_ID`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `libraryuser`
--
ALTER TABLE `libraryuser`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `author`
--
ALTER TABLE `author`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT dla tabeli `category`
--
ALTER TABLE `category`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT dla tabeli `libraryuser`
--
ALTER TABLE `libraryuser`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `FK_BOOK_1` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `category` (`ID`),
  ADD CONSTRAINT `FK_BOOK_2` FOREIGN KEY (`AUTHOR_ID`) REFERENCES `author` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
