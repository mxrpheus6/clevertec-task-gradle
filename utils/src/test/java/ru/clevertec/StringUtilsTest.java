package ru.clevertec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

    @Test
    void isPositiveNumber_PositiveInteger_True() {
        Assertions.assertTrue(StringUtils.isPositiveNumber("52"));
    }

    @Test
    void isPositiveNumber_NegativeInteger_False() {
        Assertions.assertFalse(StringUtils.isPositiveNumber("-52"));
    }

    @Test
    void isPositiveNumber_PositiveDouble_True() {
        Assertions.assertTrue(StringUtils.isPositiveNumber("52.25"));
    }

    @Test
    void isPositiveNumber_NegativeDouble_False() {
        Assertions.assertFalse(StringUtils.isPositiveNumber("-52.25"));
    }

    @Test
    void isPositiveNumber_InvalidArgument_False() {
        Assertions.assertFalse(StringUtils.isPositiveNumber("abc"));
    }

    @Test
    void isPositiveNumber_NullPointer_False() {
        Assertions.assertFalse(StringUtils.isPositiveNumber(null));
    }
}
