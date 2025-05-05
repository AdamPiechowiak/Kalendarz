Program sprawdza czy w ciągu najbliższych pięciu dni następuje dzień wymieniony w pliku date.csv i wyświetla date oraz opis tego dnia.

plik date.csv powinien zostać stworzony w folderze głównym projektu i zawierać daty oraz opisy w formatach:

 - O,yyyy-MM-dd,opis  
gdy chcemy aby komunikat wyświetlił się tylko raz

 - Y,MM-dd,opis  
gdy chcemy aby komunikat wyświetlał się co roku

 - M,dd,opis  
gdy chcemy aby komunikat wyświetlił się co miesiąc

do pliku można wpisać wiele dat

przykład:

```
O,2024-02-02,drugi luty 2024
Y,06-12,12 czerwca
Y,03-07,siódmy marca
M,01,pierwszy dzień miesiąca
```
