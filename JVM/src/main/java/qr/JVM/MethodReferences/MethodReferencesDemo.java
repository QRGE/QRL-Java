package qr.JVM.MethodReferences;

public class MethodReferencesDemo {

    public static void main(String[] args) {
        AnimalDemo animalDemo = new AnimalDemo();
        Dog dog = new Dog();
        Cat cat = new Cat();
        animalDemo.showAnimal(dog);
        animalDemo.showAnimal(cat);
    }
}
