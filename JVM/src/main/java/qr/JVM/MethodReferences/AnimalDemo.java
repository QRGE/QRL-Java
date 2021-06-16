package qr.JVM.MethodReferences;

public class AnimalDemo {

    // 多态的方法以用一般都为晚期以用
    public void showAnimal(Animal a){
        a.eat();
    }

    // 接口需要传入实现类更是晚期的方法以用
    public void showHunt(Hunt h){
        h.hunt();
    }
}
