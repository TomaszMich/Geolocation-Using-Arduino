# 1. RUP: Ogólny plan projektu

## O projekcie

System geolokalizacji z wykorzystaniem modułu Arduino, przeznaczony do celów prywatnych jak i komercyjnych. System ma na celu uwidocznienie aktualnej pozycji człowieka lub przedmiotu na mapie.

## Założenia planu

#### Ograniczenia projektu: 
- termin ustalony na grudzień 2020 roku
- ograniczony czas uczestników na pracę nad projektem
- zasoby ludzkie (dwuosobowy zespół)
#### Produkty projektu
- urządzenie oparte na module Arduino
- aplikacja użytkownika do obsługi system
- system koordynujący działanie urządzeń i aplikacji użytkownika

## Organizacja zespołu - role

Obsada poszczególnych ról w zespole:

Tomasz Michalski:
- kierownik projektu
- programista
- projektant
- specyfikujący wymagania
- inżynier procesu
- kontroler jakości

Jakub Włostowski:
- architekt oprogramowania
- programista
- projektant
- specyfikujący wymagania
- inżynier procesu
- specjalista ds. narzędzi 

## Przebieg projektu
### Fazy i iteracje
#### Faza rozpoczęcia (Inception phase)
W nawiasie podana osoba odpowiedzialna za produkt.

- iteracja początkowa
-- wizja (Tomasz Michalski, Jakub Włostowski)
-- lista zagrożeń (Jakub Włostowski)
 -- kontekst biznesowy (Tomasz Michalski)
 -- plan wytwarzania oprogramowania (Tomasz Michalski)
 -- model przypadków użycia (Jakub Włostowski)
- druga iteracja początkowa
-- repozytorium projektu (Tomasz Michalski)
 -- narzędzia (Jakub Włostowski)
-- Prototyp/model interfejsu użytkownika (Jakub Włostowski)
-- Struktura informacji UI (Tomasz Michalski)
#### Faza opracowania (Elaboration phase)
- opracowanie nr 1
 -- plan iteracji (Jakub Włostowski)
  -- model analityczny, projektowy, danych (Tomasz Michalski)
 -- definicja architektury oprogramowania (Tomasz Michalski)
  -- model implementacyjny  (Jakub Włostowski)
  -- definicja architektury oprogramowania (Tomasz Michalski)
    -- przypadki i skrypty testowe (Jakub Włostowski)
 -- aktualizacja i rozwój artefaktów z fazy Inception (Tomasz Michalski, Jakub Włostowski)

- opracowanie nr 2
 -- aktualizacja i rozwój artefaktów z iteracji pierwszej (Tomasz Michalski, Jakub Włostowski)


#### Faza konstrukcji (Construction phase)
- konstrukcja nr 1
 -- plan iteracji (Tomasz Michalski)
  -- model analityczny, projektowy, danych
 (Jakub Włostowski)
 -- komponenty (Tomasz Michalski)
 -- produkt (Tomasz Michalski)
 -- plan wdrożenia (Jakub Włostowski)
-- aktualizacja i rozwój artefaktów z fazy Inception i Elaboration (Tomasz Michalski, Jakub Włostowski)
- konstrukcja nr 2
 -- aktualizacja i rozwój artefaktów z iteracji pierwszej (Tomasz Michalski, Jakub Włostowski)
- konstrukcja nr 3
-- aktualizacja i rozwój artefaktów z iteracji drugiej (Tomasz Michalski, Jakub Włostowski)

#### Faza przekazania systemu (Transition phase)
- przekazanie nr 1
 -- plan iteracji
 (Tomasz Michalski)
 -- plan wdrożenia (Tomasz Michalski)
 -- zestaw wdrożeniowy (Jakub Włostowski)
 -- pakiet produktu (Jakub Włostowski)
 -- materiały wspomagające użytkowników (Tomasz Michalski)
 -- aktualizacja i rozwój artefaktów z fazy Inception, Elaboration i Construction
- przekazanie nr 2
 -- aktualizacja i rozwój artefaktów z iteracji pierwszej
- przekazanie nr 3
 -- aktualizacja i rozwój artefaktów z iteracji pierwszej
### Wydania
 Co tydzień nowy Release Candidate, a co trzy tygodnie nowe  wydanie 
 - wydanie produkcyjne 1 - 01.08.2020
- wydanie produkcyjne 2 - 22.08.2020
- ...
- Finalny produkt 1.0 - 06.12.2020

Po premierze produktu dla klientów, comiesięczne patche z usprawnieniami i naprawami błędów.
 
### Harmonogram
Rozpoczęcie prac - 01.07.2020
#### Inception phase 
- Iteracja 1 -- 01-15.07.2020
- Iteracja 2 -- 16-30.07.2020
#### Elaboration phase
- Iteracja 1 -- 01-15.08.2020
- Iteracja 2 -- 16-30.08.2020
#### Construction phase
- Iteracja 1 -- 1-15.09.2020
- Iteracja 2 -- 16-30.09.2020
- Iteracja 3 -- 1-15.10.2020
#### Transition phase
- Iteracja 1 -- 16-30.10.2020
- Iteracja 2 -- 1-15.11.2020
- Iteracja 3 -- 16-30.11.2020

Zakoń0.2020
 czenie prac - 01.12.2020
Późżniej utrzymanie i naprawa błęedów.
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTEyNjM5NDg4MjIsLTE3NTE2MjM3NTMsMT
AyNTM3Njg1NSwtNjQ1MzE1MTc2LDE4MTYxNzgyMDUsLTE4MDA4
OTEyMDAsMTMzMzI4NTM1MSwxNDEwNTg3NzI0LDE5NzIwMjA3MD
YsMTI2NDg2OTg0LC0xMDQwNjczODk3LC0yMDM2NzUwNTY2LC0y
MzAwNDA2MDQsLTE5MDEyODM1MjEsNDA4NzM1ODU0LC0xMjAxOT
AyNjYxLC0xMDQ1NTQ0MTY3LC01Mzc3MTQ4OTAsLTI1MTU0MDg5
MSwtMzI4MTUxNDM3XX0=
-->