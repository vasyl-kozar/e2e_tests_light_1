package io.testomat.e2e_tests_light_1;

import io.testomat.e2e_tests_light_1.web.ProjectPage;
import io.testomat.e2e_tests_light_1.web.ProjectsPage;
import io.testomat.e2e_tests_light_1.web.SignInPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ProjectPageTests extends BaseTest {

    private static final String userEmail = env.get("USEREMAIL");
    private static final String userPassword = env.get("USERPASSWORD");

    private static final ProjectsPage projectsPage = new ProjectsPage();
    private static final SignInPage signInPage = new SignInPage();
    private static final ProjectPage projectPage = new ProjectPage();
    private final String targetProjectName = "Manufacture light";

    @BeforeAll
    static void openTestomatAndLogin() {
        signInPage.open();
        signInPage.loginUser(userEmail, userPassword);
        projectsPage.isSignInSuccess();
    }

    private static Stream<Arguments> customSearchProvider() {
        return Stream.of(
                Arguments.of("Manufacture", 2),
                Arguments.of("Outdoors", 9),
                Arguments.of("Popopo", 3),
                Arguments.of("Custom", 0)
        );
    }

    @BeforeEach
    void OpenProjectsPage() {
        projectsPage.open();
        projectsPage.isLoaded();
    }

    @Test
    public void userCanFindProjectWithTests() {
        projectsPage.searchForProject(targetProjectName);

        projectsPage.selectProject(targetProjectName);

        projectPage.isLoaded(targetProjectName);
    }

    @Test
    public void checkProjectTestCasesNumberTest() {
        projectsPage.searchForProject(targetProjectName);

        var targetProject = projectsPage.countOfProjectsShouldBeEqualsTo(1).first();

        projectsPage.countTestCasesShouldBeEqualsTo(targetProject, 0);
    }

    @ParameterizedTest
    @MethodSource("customSearchProvider")
    @DisplayName("Verify the number of visible projects when using the proper key in the search field.")
    public void verifyProjectSearchFunctionalityTest(String searchedValue, int numberOfVisibleProject) {
        projectsPage.searchForProject(searchedValue);

        var visibleCount = projectsPage.countVisibleProjectsOnPage();

        Assertions.assertEquals(numberOfVisibleProject, visibleCount);
    }
}
