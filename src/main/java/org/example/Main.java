package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //zapiszPlik("test.txt");
        String odczytanyTekst = odczytajPlik("test.txt");
        System.out.println("Odczytany tekst:\n" + odczytanyTekst);
    }

    public static void zapiszPlik(String nazwaPliku) {

        // spróbuj...
        try {
            // Tworzenie obiektu typu PrintWriter, jako argument
            // zostaje podana nazwa pliku
            PrintWriter out = new PrintWriter(nazwaPliku);
            // po kolei zapisywane są kolejne linijki tekstu
            out.println("Raz");
            out.println("Dwa");
            out.println("Trzy");
            // po zapisaniu danych plik należy zamknąć
            out.close();
            // jeśli się nie udało utworzyć pliku..
        } catch (FileNotFoundException ex) {
            System.out.println("Niestety, nie mogę utworzyć pliku!");
        }
    }

    public static String odczytajPlik(String nazwaPliku) {
        // Deklarowanie i tworzenie obiektu typu File
        File plikDane = new File(nazwaPliku);
        // Utworzenie obiektu typu String, który będzie
        // przechowywał odczytany tekst
        String odczyt = "";
        try {
            // Utworzenie obiektu typu String
            Scanner skaner = new Scanner(plikDane);
            // Odczytywanie kolejnych linii pliku dopóki są kolejne linie
            while (skaner.hasNextLine()) {
                // Do łańcucha znaków dodawana jest zawartość kolejnej linii
                // oraz znak \n oznaczający następną linię
                odczyt = odczyt + skaner.nextLine() + "\n";
            }
            // Jeśli nie udało się odczytać pliku
        } catch (FileNotFoundException e) {
            System.out.println("Brak Pliku do odczytania!");
        }
        return odczyt;
    }
}

