package ru.clevertec;

public class StringUtils {

    private StringUtils() {

    }

    public static boolean isPositiveNumber(String str) {
        try {
            return Double.parseDouble(str) > 0.0;
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
    }
}
