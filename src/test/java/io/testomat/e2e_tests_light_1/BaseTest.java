package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.Configuration;
import io.github.cdimascio.dotenv.Dotenv;
import io.testomat.e2e_tests_light_1.common.Application;
import org.junit.jupiter.api.BeforeAll;

import java.util.Objects;

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
    }

    @BeforeAll
    static void openTestomatAndLogin() {
        app.signInPage.open();
        app.signInPage.loginUser(userEmail, userPassword);
        app.projectsPage.isSignInSuccess();
    }
}
