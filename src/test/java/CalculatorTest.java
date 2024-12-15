import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import javafx.stage.Stage;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class CalculatorTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        // Виклик вашого додатка "Калькулятор"
        new CalculatorApp().start(stage);
    }

    @Test
    public void shouldDisplayCorrectResult() {
        // Натискання кнопок
        clickOn("#button2");
        clickOn("#buttonPlus");
        clickOn("#button3");
        clickOn("#buttonEquals");

        // Перевірка результату
        verifyThat("#resultDisplay", hasText("5"));
    }

    @Test
    public void takeScreenshot() {
        // Приклад скриншоту
        takeScreenshot("screenshot.png");
    }

    private void takeScreenshot(String filename) {
        // Метод збереження скриншота
        try {
            java.awt.Robot robot = new java.awt.Robot();
            java.awt.Rectangle screenRect = new java.awt.Rectangle(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
            java.awt.image.BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
            javax.imageio.ImageIO.write(screenFullImage, "png", new java.io.File(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
