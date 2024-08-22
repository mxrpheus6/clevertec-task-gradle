package ru.clevertec;

public class Utils {

    private Utils() {

    }

    public static boolean isAllPositiveNumbers(String... strings) {
        boolean flag = true;
        for (String str: strings) {
            if (!StringUtils.isPositiveNumber(str)) {
                flag = false;
                System.out.println(str + " - false");
            } else {
                System.out.println(str + " - true");
            }
        }
        return flag;
    }
}
