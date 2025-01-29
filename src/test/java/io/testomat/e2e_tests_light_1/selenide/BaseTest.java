package io.testomat.e2e_tests_light_1.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.TextReportExtension;
import io.github.cdimascio.dotenv.Dotenv;
import io.testomat.e2e_tests_light_1.selenide.common.Application;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Objects;

@ExtendWith(TextReportExtension.class)
public class BaseTest {
    static Dotenv env = Dotenv.load();
    protected static final String userEmail = env.get("USEREMAIL");
    protected static final String userPassword = env.get("USERPASSWORD");
    protected final String targetProjectName = "Manufacture light";

    protected static Application app = new Application();

    static {
        Configuration.baseUrl = Objects.requireNonNull(env.get("BASE_URL"));
        Configuration.headless = false;
        Configuration.fastSetValue = true;
        Configuration.timeout = 10000;
    }

    @BeforeAll
    static void openTestomatAndLogin() {
        app.signInPage.open();
        app.signInPage.loginUser(userEmail, userPassword);
        app.projectsPage.isSignInSuccess();
    }
}
