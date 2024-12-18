package io.testomat.e2e_tests_light_1.utils;

import org.jetbrains.annotations.NotNull;

public class StringParsesrs {

    @NotNull
    public static Integer getNumberFromText(String text) {
        String digitText = text.replaceAll("\\D+", "");
        return Integer.parseInt(digitText);
    }
}
