package io.testomat.e2e_tests_light_1.common;

import io.testomat.e2e_tests_light_1.web.ProjectPage;
import io.testomat.e2e_tests_light_1.web.ProjectsPage;
import io.testomat.e2e_tests_light_1.web.SignInPage;

public class Application {
    public final ProjectsPage projectsPage = new ProjectsPage();
    public final SignInPage signInPage = new SignInPage();
    public final ProjectPage projectPage = new ProjectPage();
}
