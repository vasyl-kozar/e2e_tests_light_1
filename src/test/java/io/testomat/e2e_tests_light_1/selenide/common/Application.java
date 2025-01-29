package io.testomat.e2e_tests_light_1.selenide.common;

import io.testomat.e2e_tests_light_1.selenide.web.ProjectPage;
import io.testomat.e2e_tests_light_1.selenide.web.ProjectsPage;
import io.testomat.e2e_tests_light_1.selenide.web.SignInPage;

public class Application {
    public final ProjectsPage projectsPage = new ProjectsPage();
    public final SignInPage signInPage = new SignInPage();
    public final ProjectPage projectPage = new ProjectPage();
}
