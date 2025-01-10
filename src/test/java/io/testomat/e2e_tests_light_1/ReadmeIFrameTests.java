package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.junit5.TextReportExtension;
import io.testomat.e2e_tests_light_1.web.ProjectPage;
import io.testomat.e2e_tests_light_1.web.ProjectsPage;
import io.testomat.e2e_tests_light_1.web.ReadmePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TextReportExtension.class)
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
