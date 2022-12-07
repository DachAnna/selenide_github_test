package com.anna.dach;

import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {

    @Test
    void swapElements() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(300, 0).release().perform();
        $("#column-a").dragAndDropTo($("#column-b"));
    }
}
