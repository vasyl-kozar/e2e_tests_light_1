package io.testomat.e2e_tests_light_1.selenide;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ProjectPageTests extends BaseTest {

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
        app.projectsPage.open();
        app.projectsPage.isLoaded();
    }

    @Test
    public void userCanFindProjectWithTests() {
        app.projectsPage.searchForProject(targetProjectName);

        app.projectsPage.selectProject(targetProjectName);

        app.projectPage.isLoaded(targetProjectName);
    }

    @Test
    public void checkProjectTestCasesNumberTest() {
        app.projectsPage.searchForProject(targetProjectName);

        var targetProject = app.projectsPage.countOfProjectsShouldBeEqualsTo(1).first();

        app.projectsPage.countTestCasesShouldBeEqualsTo(targetProject, 0);
    }

    @ParameterizedTest
    @MethodSource("customSearchProvider")
    @DisplayName("Verify the number of visible projects when using the proper key in the search field.")
    public void verifyProjectSearchFunctionalityTest(String searchedValue, int numberOfVisibleProject) {
        app.projectsPage.searchForProject(searchedValue);

        var visibleCount = app.projectsPage.countVisibleProjectsOnPage();

        Assertions.assertEquals(numberOfVisibleProject, visibleCount);
    }
}
