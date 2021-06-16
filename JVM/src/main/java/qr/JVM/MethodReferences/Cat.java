package qr.JVM.MethodReferences;

public class Cat extends Animal implements Hunt{

    @Override
    public void eat() {
        System.out.println("Cat wants some fish...");
    }

    @Override
    public void hunt() {
        System.out.println("Cat catch mouse");
    }
}
