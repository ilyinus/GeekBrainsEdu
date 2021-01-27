package homework07;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class UnitTest {

    public static void start(Class<?> clazz) {
        doTests(clazz);
    }

    public static void start(String className) {
        try {
            doTests(Class.forName(className));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void doTests(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        Map<String, List<Method>> map = prepareMethodsForInvoke(methods);

        try {
            for (Method method : map.get("BeforeSuite")) {
                method.invoke(null);
            }
            for (Method method : map.get("Test")) {
                method.invoke(null);
            }
            for (Method method : map.get("AfterSuite")) {
                method.invoke(null);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    private static Map<String, List<Method>> prepareMethodsForInvoke(Method[] methods) {
        int countBeforeSuite = 0;
        int countAfterSuite = 0;
        Map<String, List<Method>> map = new HashMap<>();
        List<Method> beforeSuiteList = new ArrayList<>();
        List<Method> testList = new ArrayList<>();
        List<Method> afterSuiteList = new ArrayList<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (++countBeforeSuite > 1)
                    throw new RuntimeException("Count BeforeSuite annotations grater 1");
                beforeSuiteList.add(method);
            } else if (method.isAnnotationPresent(Test.class)) {
                if (method.getAnnotation(Test.class).order() < 1 || method.getAnnotation(Test.class).order() > 10)
                    throw new RuntimeException("Incorrect order value");
                testList.add(method);
            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                if (++countAfterSuite > 1)
                    throw new RuntimeException("Count AfterSuite annotations grater 1");
                afterSuiteList.add(method);
            }
        }

        testList.sort(Comparator.comparingInt(o -> o.getAnnotation(Test.class).order()));

        map.put("BeforeSuite", beforeSuiteList);
        map.put("Test", testList);
        map.put("AfterSuite", afterSuiteList);

        return map;

    }

}
