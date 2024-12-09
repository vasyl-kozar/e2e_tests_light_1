package io.testomat.e2e_tests_light_1;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectPageTests {
    @Test
    public void userCanFindProjectWithTests() {
        open("https://app.testomat.io/");

        //login user
        $("#content-desktop #user_email").setValue("kozar.vasyl@gmail.com");
        $("#content-desktop #user_password").setValue("eit9E$Ta'N@IFJ{");
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [type=\"submit\"]").click();
        $(".common-flash-success").shouldBe(visible);

        //search
        $("#search").setValue("manufacture light");
        $(byText("Manufacture light")).click();

        // wait for project loaded
        $("h2").shouldHave(text(("Manufacture light")));
    }
}
