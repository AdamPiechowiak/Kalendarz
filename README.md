Program sprawdza czy w ciągu najbliższych pięciu dni następuje dzień wymieniony w pliku dane.csv i wyświetla date oraz opis tego dnia.

plik dane.csv powinien zawierać date oraz opis w formatach:

 - dd:MM:yyyy;opis  
gdy chcemy aby komunikat wyświetlił się tylko raz

 - dd:MM;opis  
gdy chcemy aby komunikat wyświetlał się co roku

 - dd;opis  
gdy chcemy aby komunikat wyświetlił się co miesiąc

do pliku można wpisać wiele dat

przykład:

```
01:02:2024;drugi luty 2024
12:6;12 czerwca
7:3;siódmy marca
01;pierwszy dzień miesiąca
```