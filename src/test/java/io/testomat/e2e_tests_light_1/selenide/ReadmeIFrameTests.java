package io.testomat.e2e_tests_light_1.selenide;

import io.testomat.e2e_tests_light_1.selenide.web.ProjectPage;
import io.testomat.e2e_tests_light_1.selenide.web.ProjectsPage;
import io.testomat.e2e_tests_light_1.selenide.web.ReadmePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReadmeIFrameTests extends BaseTest {

    @Test
    @DisplayName("Update readme text in iframe")
    void updateReadmeTextInIframe() {
        var targetText = "TESTED TEXT";

        new ProjectsPage().isLoaded()
                .searchForProject(targetProjectName)
                .selectProject(targetProjectName);

        new ProjectPage().openReadme().clickOnEdit();

        new ReadmePage().isLoaded()
                .clickOnEditReadme()
                .editFirstLineInEditor("Welcome to Testomat.io " + targetText)
                .clickOnUpdate()
                .isFirstLineEdited(targetText);
    }

    @Test
    @DisplayName("")
    void readmeTest() {

    }
}
