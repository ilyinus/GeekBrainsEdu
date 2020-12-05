package homework03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final String[] ARRAY = {"Арбуз" , "Алмаз", "Арбуз" ,
                                           "Дорога", "Башня", "Машина",
                                           "Башня" , "Дом"  , "Апельсин",
                                           "Банан" , "Орех" , "Банан"};

    private static void processArray() {
        Map<String, Integer> map = new HashMap<>();

        for (String string : ARRAY) {
            map.putIfAbsent(string, 0);
            map.put(string, map.get(string) + 1);
        }

        System.out.println(map);

    }

    private static class PhoneBook {
        private static final Map<String, Set<String>> DATA = new HashMap<>();

        public static void add(String lastName, String phone) {
            Set<String> value = DATA.get(lastName);

            if (value == null)
                value = new HashSet<>();

            value.add(phone);
            DATA.put(lastName, value);
        }

        public static void get(String lastName) {
            System.out.println("Results for query \"" + lastName + "\":\n\t" + DATA.get(lastName));
        }

    }

    public static void main(String[] args) {
        // Задача №1
        processArray();

        // Задача №2
        PhoneBook.add("Иванов", "+7-911-123-22-33");
        PhoneBook.add("Иванов", "+7-909-321-11-44");
        PhoneBook.add("Петров", "+7-906-123-11-33");
        PhoneBook.get("Иванов");
    }

}
