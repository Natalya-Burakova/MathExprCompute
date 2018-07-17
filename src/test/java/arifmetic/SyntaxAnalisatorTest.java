package arifmetic;


import org.junit.*;

import static org.junit.Assert.assertEquals;

public class SyntaxAnalisatorTest {
    private SyntaxAnalisator syntaxAnalisator;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before CalculatorTest.class");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("After CalculatorTest.class");
    }

    @Before
    public void initTest() {
        syntaxAnalisator = new SyntaxAnalisator();
    }

    @After
    public void afterTest() {
        syntaxAnalisator = null;
    }


    @Test
    public void testGetSum() throws Exception {
        assertEquals("7.0", syntaxAnalisator.analyse("2+5"));
    }

    @Test
    public void testGetDivide() throws Exception {
        assertEquals("9.0", syntaxAnalisator.analyse("(25-7)-(12-5)-2"));
    }

    @Test
    public void testGetMultiple() throws Exception {
        assertEquals("58.0", syntaxAnalisator.analyse("(2+5)*8+(9-3)-12/3"));
    }

    @Test
    public void testUnbalanced() {
        assertEquals( "Unbalanced Parentheses", syntaxAnalisator.analyse("(2+4"));
    }

    @Test
    public void testDivizionZero() {
        assertEquals( "Division by zero", syntaxAnalisator.analyse("2/0"));
    }


    @Test
    public void testSyntaxExsp() {
        assertEquals( "Syntax error", syntaxAnalisator.analyse("(2+5)*3+5/"));
    }

    @Test
    public void testNullExpr() {
        assertEquals( "No Expression Present", syntaxAnalisator.analyse(""));
    }

}