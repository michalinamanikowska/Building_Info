# Building Info

## Opis projektu:
Projekt stworzony dla administratorów budynków, którzy pragną optymalizować koszty zarządzania budynkami. Nasza aplikacja Building Info umożliwia pozyskanie informacji o parametrach budynku na poziomie pomieszczeń, kondygnacji oraz całych budynków. Aplikacja jest dostępna poprzez GUI, a także jako zdalne API, dzięki czemu można ją zintegrować z istniejącymi narzędziami.

## Struktura danych:
- **Lokacja** to budynek, poziom lub pomieszczenie
- **Budynek** może składać się z poziomów, a te z pomieszczeń
- Każda **lokalizacja** jest charakteryzowana przez:
  - *id* – unikalny identyfikator
  - *name* – opcjonalna nazwa lokalizacji
- **Pomieszczenie** dodatkowo jest charakteryzowane przez:
  - *area* - powierzchnia w m^2
  - *cube* - kubatura pomieszczenia w m^3
  - *heating* - poziom zużycia energii ogrzewania (float)
  - *light* – łączna moc oświetlenia


## Przydatne linki:

link do wymagań projektowych(*DoD*): [Zasady punktowania sprintów (DoD)](https://docs.google.com/spreadsheets/d/e/2PACX-1vQndYCJCWd-LgB0E3TjUa2sMFUaV2M-3plaVgLB61xtYDLnorXlL9trQWuSvEYVByVTUqGMZVzwPiEJ/pubhtml)

link do tymczaoswego Product i Sprint Backlogu: [Google sheet](https://docs.google.com/spreadsheets/d/1De3WZcZFA9AvrjkqRHxhseTIAHGi7kNGydApnNlUyTc/edit?usp=sharing)
