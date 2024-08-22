package ru.clevertec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UtilsTest {

    @Test
    void isAllPositiveNumbers_PositiveNumbers_True() {
        Assertions.assertTrue(Utils.isAllPositiveNumbers("52", "25", "19"));
    }

    @Test
    void isAllPositiveNumbers_PositiveNumbersAndOneNegative_False() {
        Assertions.assertFalse(Utils.isAllPositiveNumbers("-52", "25", "19"));
    }

    @Test
    void isAllPositiveNumbers_InvalidArguments_False() {
        Assertions.assertFalse(Utils.isAllPositiveNumbers("a", "b", "c"));
    }
}
