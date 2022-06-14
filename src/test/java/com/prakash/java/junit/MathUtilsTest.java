package com.prakash.java.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("MathUtils Test Class")
class MathUtilsTest {

    static MathUtils mu = null;

    @BeforeAll
    public static void beforeClassInstance() {
        System.out.println("Before Class Instatiation it will be executed");
        mu = new MathUtils();
    }

    @AfterAll
    public static void AfterClassExecuteCompletes() {
        System.out.println("After Class execution completes");
        mu = null;
    }

    @BeforeEach
    public void init() {
        System.out.println("Before Each method Call..");

    }

    @AfterEach
    public void cleanUp() {
        System.out.println("After Each method Call..");
    }

    @Test
    @DisplayName("Test for Adding 2 numbers")
    void testAdd() {
        System.out.println("Inside Add");
        MathUtils mu = new MathUtils();
        int expected = 2;
        int actual = mu.add(1, 1);
        assertEquals(expected, actual, () -> "should return "+actual+" which is expected "+expected);
    }

    @Test
    void testDivide() {
        boolean isServerUp = false;
        assumeTrue(isServerUp); // This is a conditional stmt . If isServerUp will return true , then only execute this method or else not .
        System.out.println("Inside Divide");
        MathUtils mu = new MathUtils();
        assertThrows(ArithmeticException.class, () -> mu.divide(1, 0), "Divided by zero should throw Exception");
    }

    @Test
    void testComputeCircleArea() {
        System.out.println("Inside Circle Area");
        assertEquals(314.1592653589793, mu.computeCircleArea(10), "Test for computing Circle Area");

    }

    @Test
    @Disabled
    @DisplayName("Disabling as it depends on other Module")
    void testDisbaled() {
        fail("This should be fail");
    }


    @Test
    @DisplayName("Multiplication of 2 numbers")
    void testMultiply() {
        System.out.println("Executing testMultiply");
        //assertEquals(4, mu.multiply(2,2),"This should multiply 2 numbers");
        assertAll(
                () -> assertEquals(4, mu.multiply(2, 2)),
                () -> assertEquals(0, mu.multiply(2, 0)),
                () -> assertEquals(-1, mu.multiply(1, -1))
        );
    }

    @Nested
    @DisplayName("Substract Test")
    class SubstractTest {

        @Test
        @DisplayName("Substract Positive Number")
        void testSubstractPositive() {
            System.out.println("Executing testSubstractPositive");
            assertEquals(1, mu.substract(2, 1), "Should return +ve number");
        }

        @Test
        @DisplayName("Substract Negative Number")
        void testSubstractNegative() {
            System.out.println("Executing testSubstractNegative");
            assertEquals(-9, mu.substract(-5, 4), "Should return -ve number");
        }
    }

    @RepeatedTest(value = 3)
    public void testAddThree(RepetitionInfo repInfo){
        if (repInfo.getCurrentRepetition() == 1)
            assertEquals(5, mu.addThree(1,2,2), () -> "Add Three +ve Numbers and it should return +ve number");
        else if(repInfo.getCurrentRepetition() == 2)
            assertEquals(-6, mu.addThree(-2,-2,-2),"Add Three -ve Numbers");
        else
            assertEquals(1, mu.addThree(-3,2,2),"Add Three combination +ve and -ve Numbers");
    }
}