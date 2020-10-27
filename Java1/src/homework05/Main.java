package homework05;

public class Main {

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Иванов Иван Иванович", "Уборщик", "admin@mail.ru", "89112223332", 10000, 25);
        employees[1] = new Employee("Петров Юрий Иванович", "Директор", "admin@mail.ru", "89112223332", 100000, 26);
        employees[2] = new Employee("Сидоров Евгений Иванович", "Строитель", "admin@mail.ru", "89112223332", 30000, 50);
        employees[3] = new Employee("Семенов Петр Иванович", "Официант", "admin@mail.ru", "89112223332", 20000, 38);
        employees[4] = new Employee("Васильев Сергей Иванович", "Уборщик", "admin@mail.ru", "89112223332", 10000, 47);

        for (Employee employee : employees) {
            if (employee.getAge() > 40)
                System.out.println(employee);
        }

    }

}
