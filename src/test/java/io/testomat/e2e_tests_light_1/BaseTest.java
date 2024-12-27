package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.Configuration;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.Objects;

public class BaseTest {
    static Dotenv env = Dotenv.load();

    static {
        Configuration.baseUrl = Objects.requireNonNull(env.get("BASE_URL"));
    }
}
