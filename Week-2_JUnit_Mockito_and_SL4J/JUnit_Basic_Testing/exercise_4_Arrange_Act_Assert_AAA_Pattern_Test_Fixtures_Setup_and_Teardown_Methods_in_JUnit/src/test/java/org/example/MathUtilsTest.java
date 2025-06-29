package org.example;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MathUtilsTest {
    private MathUtils math;

    @Before
    public void setUp() {
        math = new MathUtils();
        System.out.println("Setup done");
    }
    @After
    public void tearDown() {
        math.close();
        System.out.println("Teardown done");
    }


    @Test
    public void testAdd() {
        // Arrange
        int a = 4;
        int b = 5;

        // Act
        int result = math.add(a, b);

        // Assert
        assertEquals(9, result);
    }
}
