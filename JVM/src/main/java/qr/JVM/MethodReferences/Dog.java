package qr.JVM.MethodReferences;

public class Dog extends Animal implements Hunt{

    @Override
    public void eat() {
        System.out.println("Dog want a bones...");
    }

    @Override
    public void hunt() {
        System.out.println("It's none of its business");
    }
}
