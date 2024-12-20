package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;

public class ProjectPageTests extends BaseTest {

    String targetProjectName = "Manufacture light";

    @BeforeAll
    static void openTestomatAndLogin() {
        open(baseURL);

        loginUser(userEmail, userPassword);
    }

    @BeforeEach
    void OpenHomePage() {
        open(baseURL);
    }

    @Test
    public void userCanFindProjectWithTests() {
        searchForProject(targetProjectName);

        selectProject(targetProjectName);

        waitForProjectPageIsLoaded(targetProjectName);
    }

    @Test
    public void checkProjectTestCasesNumberTest() {
        searchForProject(targetProjectName);

        SelenideElement targetProject = countOfProjectsShouldBeEqualsTo(1).first();

        countTestCasesShouldBeEqualsTo(targetProject, 0);
    }

    private static Stream<Arguments> customSearchProvider() {
        return Stream.of(
                Arguments.of("Manufacture", 2),
                Arguments.of("Outdoors", 9),
                Arguments.of("Popopo", 3),
                Arguments.of("Custom", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("customSearchProvider")
    @DisplayName("Verify the number of visible projects when using the proper key in the search field.")
    public void verifyProjectSearchFunctionalityTest(String searchedValue, int numberOfVisibleProject) {
        searchForProject(searchedValue);

        int visibleCount = countVisibleProjectsOnPage();

        Assertions.assertEquals(numberOfVisibleProject, visibleCount);
    }


}
