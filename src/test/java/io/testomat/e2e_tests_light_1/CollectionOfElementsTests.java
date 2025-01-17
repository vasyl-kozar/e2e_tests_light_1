package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$$;

public class CollectionOfElementsTests extends BaseTest {
    @Test
    @DisplayName("Find all product experiments")
    void FindAllProductExperiments() {
        var labelCountOfTests = $$("ul li p")
                .shouldHave(CollectionCondition.sizeGreaterThan(0));

        for (SelenideElement labelCountOfTest : labelCountOfTests) {
            labelCountOfTest.shouldHave(Condition.text("13 tests").or(Condition.text("0 tests")));
        }
    }

    @Test
    @DisplayName("clipboard")
    void clipboard() {
        Selenide.clipboard().setText("tests");
        Selenide.clipboard().shouldHave(ClipboardConditions.content("tests"));

        Selenide.localStorage().shouldHave(LocalStorageConditions.itemWithValue("name", "target name"));
    }
}
