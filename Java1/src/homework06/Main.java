package homework06;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[4];
        animals[0] = new Cat();
        animals[1] = new Cat("кот Васька",20, 40);
        animals[2] = new Dog();
        animals[3] = new Dog("пес Бобик",100, 30, 100);

        for (Animal animal : animals) {
            animal.run(30);
            animal.jump(20);
            animal.swim(80);
            System.out.println();
        }

    }
}
