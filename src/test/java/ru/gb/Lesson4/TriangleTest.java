package ru.gb.Lesson4;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ru.gb.Lesson4.Square.Area;

public class TriangleTest {


    @Test
    void isSquareTest() throws Exception {
        Assertions.assertEquals(2, Area(1, 2, 4));

    }
    @Test
    void NegativeTest(){
        Assertions.assertThrows(Exception.class, () -> Area(-1, 2, 4));

    }


}
