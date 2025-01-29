package io.testomat.e2e_tests_light_1.selenium;

import io.testomat.e2e_tests_light_1.selenium.common.LoginTestomatExtension;
import io.testomat.e2e_tests_light_1.selenium.common.WebDriverLifeCycleExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.testomat.e2e_tests_light_1.selenium.web.common.Elements.find;
import static io.testomat.e2e_tests_light_1.selenium.web.common.Elements.findByText;

@ExtendWith({WebDriverLifeCycleExtension.class, LoginTestomatExtension.class})
public class ProjectsTests {

    private final String targetProjectName = "Manufacture light";

    @BeforeEach
    public void searchTargetProject() {
        find("#container .common-flash-success").waitFor().visibility();

        find("[id='search']").sendKeys(targetProjectName);
    }

    @Test
    @DisplayName("Find possible projects by name")
    void findProjectByNameTest() {
        findByText(targetProjectName).click();

        find("h2").waitFor().containsText(targetProjectName);
    }

    @Test
    @DisplayName("Check number of test cases for target project")
    public void checkProjectTestCasesNumberTest() {
        find("ul li:last-of-type p").waitFor().containsText("0 tests");
    }
}
