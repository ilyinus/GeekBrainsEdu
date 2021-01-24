package homework07;

public class Main {

    @BeforeSuite
    public static void beforeSuite() {
        System.out.println("BeforeSuite");
    }

    @AfterSuite
    public static void afterSuite() {
        System.out.println("AfterSuite");
    }

    @Test(order = 3)
    public static void tes3() {
        System.out.println("Test3");
    }

    @Test(order = 1)
    public static void test1() {
        System.out.println("Test1");
    }

    @Test(order = 1)
    public static void test1_1() {
        System.out.println("Test1_1");
    }

    @Test(order = 2)
    public static void test2() {
        System.out.println("Test2");
    }

    public static void main(String[] args) {
        UnitTest.start(Main.class);
    }

}
