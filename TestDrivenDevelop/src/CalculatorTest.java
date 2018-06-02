import org.hamcrest.core.AnyOf;
import org.hamcrest.core.Is;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class CalculatorTest {
    Calculator calculator;

    @BeforeClass
    public static void setUpBeforeClass(){
        System.out.println("Run before all tests");
    }

    @Before
    public void setUp(){
        calculator = new Calculator();
        System.out.println("Run before each test method");
    }

    @After
    public void tearDown(){
        System.out.println("Run after each test");
    }

    @AfterClass
    public static void tearDownAfterTests(){
        System.out.println("Run after all tests");
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Parameterized.Parameters
    public static Collection<Integer[]> parameters(){
        return Arrays.asList(new Integer[][]{
            {1, 1, 2},
            {2, 4, 6},
            {4, 1, 5},
            {1, 6, 7}
        });
    }

    @Parameterized.Parameter(0)
    public int argument1;

    @Parameterized.Parameter(1)
    public int argument2;

    @Parameterized.Parameter(2)
    public int expectedResult;

    @Test
    public void testAdd(){
        //GIVEN
        //Calculator calculator = new Calculator();
        //WHEN
        int result = calculator.add(1, 2);
        //THEN
        assert result == 3;

        Assert.assertEquals("I expect 3",3, result);
        Assert.assertThat(3, Is.is(result));

        int a = 1, b = 1, c = 2;
        Assert.assertThat(2, AnyOf.anyOf(Is.is(a), Is.is(b), Is.is(c)));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideBy0(){
        //Calculator calculator = new Calculator();
        int anyNumber = new Random().nextInt();
        double result = calculator.divide(anyNumber,0);
        //should throw exception
    }

    @Test
    public void testDivideBy0WithRule(){
        //Calculator calculator = new Calculator();
        int anyNumber = new Random().nextInt();
        expectedException.expect(ArithmeticException.class);
        expectedException.expectMessage("/ by zero");
        calculator.divide(anyNumber, 0);
    }

    @Test
    public void testAddWithParameters(){
        //given
        System.out.println("Aici am parametri");
        //when
        int result = calculator.add(argument1, argument2);

        //then
        Assert.assertEquals(expectedResult, result);
    }

}
