package com.sadzbr.utils;

import com.sadzbr.controller.ErrorController;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Klasa walidująca dane.
 */
public class Validator {
    /**
     * Metoda walidująca poprawność dat przyjazdu oraz odjazu
     * @param arrival data przyjazdu
     * @param departure data odjazdu
     * @return Zwraca true jeżeli dane są poprawne
     */
    static public boolean reservationDates(LocalDate arrival, LocalDate departure) {
        boolean valid = true;
        ErrorController errorController = ErrorController.getInstance();
        if(arrival == null) {
            valid = false;
            errorController.addMessage("Data przyjazdu nie może być pusta");
        }
        if(departure == null) {
            valid = false;
            errorController.addMessage("Data odjazdu nie może być pusta");
        }
        if(valid && arrival.compareTo(departure) > 0) {
            valid = false;
            errorController.addMessage("Data odjazdu nie może być wcześniejsza niż data przyjazdu");
        }
        return valid;
    }

    /**
     * Metoda walidująca poprawność liczby osób rezerwujących pokój
     * @param number Liczba osób
     * @return Zwraca true jeżeli dane są poprawne
     */
    static public boolean numberOfPersons(int number) {
        boolean valid = true;
        ErrorController errorController = ErrorController.getInstance();
        if(number <= 0) {
            valid = false;
            errorController.addMessage("Liczba osób nie może być mniejsza bądź równa 0");
        }
        return valid;
    }

    /**
     * Służy do walidacji adres e-mail
     * @param email Adres e-mail
     * @return Zwraca true jeżeli dane są poprawne
     */
    static public boolean email(String email) {
        boolean valid = true;
        ErrorController errorController = ErrorController.getInstance();
        String pattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);
        if(!m.matches()) {
            valid = false;
            errorController.addMessage("Podany adres e-mail jest nieprawidłowy");
        }
        return valid;
    }

    /**
     * Sprawdza czy podany ciąg znaków posiada tylko i wyłącznie litery oraz spacje i inne znaki używane w słowach
     * @param text Tekst
     * @return Zwraca true jeżeli dane są poprawne
     */
    static public boolean charsOnly(String text) {
        boolean valid = true;
        ErrorController errorController = ErrorController.getInstance();
        String pattern = "^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        if(!m.matches()) {
            valid = false;
            errorController.addMessage("Podane pole może zawierać tylko litery i nie może być puste");
        }
        return valid;
    }

    /**
     * Sprawdza czy podany kod pocztowy jest poprawny
     * @param postCode kod pocztowy
     * @return Zwraca true jeżeli dane są poprawne
     */
    static public boolean postCode(String postCode) {
        boolean valid = true;
        ErrorController errorController = ErrorController.getInstance();
        String pattern = "^[0-9]{2}[-]+[0-9]{3}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(postCode);
        if(!m.matches()) {
            valid = false;
            errorController.addMessage("Podany kod pocztowy jest niepoprawny");
        }
        return valid;
    }

    /**
     * Sprawdza czy podana liczba jest dodatnia
     * @param number liczba
     * @return Zwraca true jeżeli dane są poprawne
     */
    static public boolean positiveNumber(int number) {
        boolean valid = true;
        ErrorController errorController = ErrorController.getInstance();
        if(number <= 0) {
            valid = false;
            errorController.addMessage("Podane pole musi zawierać liczbę większą od 0");
        }

        return valid;
    }

    static public boolean isNotEmpty(String text) {
        boolean valid = true;
        ErrorController errorController = ErrorController.getInstance();
        if(text.isEmpty()) {
            valid = false;
            errorController.addMessage("Podane pole nie może być puste");
        }
        return valid;
    }
}
