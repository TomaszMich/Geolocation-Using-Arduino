# Organizacja i infrastruktura projektu

## Opis projektu i produktu

### Nazwa projektu

System geolokalizacji z wykorzystaniem modułu Arduino.
### Adresowany problem

Brak możliwości rejestrowania miejsca przebywania bliskich osób, które mogą nie być w stanie same o siebie zadbać oraz przedmiotów nieożywionych, które chcemy mieć pod stałą kontrolą.

### Obszar zastosowania
Zastosowanie prywatne w codziennym życiu.
Zastosowanie komercyjne przez firmy i korporacje.
### Rynek
Na rynku istnieje np. geolokalizacja przy użyciu aplikacji Find My iPhone na urządzenia Apple, które jednak zwykle są znacznie droższe od innych smartfonów. W internecie można również znaleźć szereg modułów GPS przeznaczonych dla pojazdów ciężarowych i osobowych, oraz dla kontenerów transportowych.
### Interesariusze

Osoby prywatne zainteresowane produktem

Promotor pracy inżynierskiej

### Użytkownicy i ich potrzeby

Osoby dorosłe w różnym wieku – intuicyjny i czytelny interfejs na urządzeniach mobilnych wymagający jedynie podstawowych umiejętności obsługi smartfonów.
Firmy transportowe i wynajmujące pojazdy - szybki i responsywny interfejs użytkownika, działanie modułu w trudnych warunkach pogodowych oraz w miejscach bez zasięgu GSM

### Cel i zakres projektu

Umożliwienie lokalizacji w czasie rzeczywistym osób i obiektów.

### Ograniczenia

Ze względu na wielkość modułu Arduino może być niekiedy niemożliwe, aby mieć go przy sobie.
Urządzenie będzie miało problem z lokalizacją w budynkach, czy na parkingu podziemnym, ze względu na ograniczony zasięg anteny.
### Inne współpracujące systemy

Arduino z modułem geolokalizacji

System map na licencji Open Source

### Termin

Grudzień 2020

### Główne etapy projektu

1.  Identyfikacja i zebranie potrzebnych informacji z literatury źródłowej.
2.  Skonstruowanie modułu geolokalizacji przy pomocy modułu Arduino.
3.  Implementacja potrzebnego oprogramowania na urządzenia mobilne.
4.  Sporządzenie pracy pisemnej na podstawie zebranych informacji.
## Interesariusze i użytkownicy, persony

### Persona A

Dorota ma 42 lata i jest samotną matką syna Roberta, który ma 12 lat. Rodzina mieszka daleko od dużego miasta, do którego muszą dojeżdżać autobusem do szkoły i pracy. Robert samemu jeździ autobusem, często wracając do domu już po zmroku. Zaniepokojona matka chce mieć pod kontrolą to czy syn bezpiecznie zmierza do domu. Szuka, więc produktu, który pozwoli jej mieć pod kontrolą aktualne położenie nieletniego syna.

### Persona B

Paweł lat 27 jest miłośnikiem klasyków motoryzacji. Niestety, starsze samochody mają bardzo słabe systemy antykradzieżowe i istnieje duże ryzyko przywłaszczenia ich sobie przez złodzieja. Paweł chce zainstalować moduł geolokalizacji do swojego samochodu, aby w razie kradzieży móc łatwo namierzyć pojazd i odzyskać go z rąk złodzieja.

## Zespół

### Tomasz Michalski
Nr tel.: 537 596 556
Umiejętności: praca w zespole, programowanie, analityczne myślenie, organizacja pracy, doświadczenie w pracy z metodyką zwinną Scrum, zarządzenie

### Jakub Włostowski

Nr tel.: 726 164 770

Umiejętności: praca w zespole, programowanie na dobrym poziomie, analityczne myślenie, efektywna współpraca.

Projekt będziemy realizować w rozproszeniu przy użyciu narzędzi typu Git.

## Komunikacja w zespole i z interesariuszami

W zespole na co dzień komunikować będziemy się przy użyciu komunikatora tekstowego Messenger. Spotykać będziemy się w piątki, co 2 tygodnie na wydziale ETI o godzinie 13, w celu przedyskutowania dotychczasowych postępów prac. Oprócz tego, w każdy weekend będziemy przeprowadzać przynajmniej dwugodzinne sesje na platformie Skype lub Discord.

Z promotorem komunikować będziemy się osobiście i  przy użyciu poczty elektronicznej.

## Współdzielenie dokumentów i kodu
Dokumenty będziemy rozwijać kooperacyjnie używając serwisu [https://stackedit.io/](https://stackedit.io/), który umożliwia zespołowe tworzenie plików markdown z automatyczną synchronizacją na połączonym repozytorium w serwisie GitHub. Dokumenty będą się znajdować w podfolderze *docs/* głównego folderu projektu. Zastosujemy automatyczny sposób wersjonowania narzędzia *Git*.
Osoba odpowiedzialna za porządek w dokumentacji: *Jakub Włostowski*

Do współdzielenia kodu wykorzystamy narzędzie *Git* oraz serwis *GitHub*. 
Link do repozytorium projektu: [Geolocation-Using-Arduino](https://github.com/TomaszMich/Geolocation-Using-Arduino)
Osoba odpowiedzialna za konfigurację i utrzymanie repozytorium: *Tomasz Michalski*

## Narzędzia
##### Komunikacja w zespole
Messenger, Discord, Skype
##### Organizacja projektu i zarządzanie nim
Google Jamboard
##### Tworzenie dokumentów
StackEdit, GitHub
##### Wytwarzanie
Git, GitHub, JetBrains CLion IDE, C++
##### Testowanie
JetBrains CLion IDE, C++, GoogleTest
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTEwMzU2MTk1MzMsNzA0NjQzNDg5LDE4MT
kzODcwNTUsMTc5MTkwODQ1NSw5MDMxMDEyNjksMTMxNDk3Mjgx
NSwtNTQyMDQzODIsMTA3MDE5ODQwMiwtOTQ2NjExNTkyLC03Nz
UyNzg5NTQsLTE2NDEzOTk1ODcsNTU0NDEyNDg5LDEyODE4NTY4
NDksLTE0NjIzNzEwMjEsLTE1NjAyMzIxNiwtMTg2MjAxNzAwNl
19
-->