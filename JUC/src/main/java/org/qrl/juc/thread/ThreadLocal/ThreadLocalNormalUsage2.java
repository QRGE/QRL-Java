package org.qrl.juc.thread.ThreadLocal;

public class ThreadLocalNormalUsage2 {

}

class Service1{
    public void process(){
        User user = new User("ToolMam");
        UserContextHolder.holder.set(user);
    }
}

class Service2{
    public void process(){
        User user = UserContextHolder.holder.get();
        System.out.println(user.name);
    }
}

class UserContextHolder {
    public static ThreadLocal<User> holder = new ThreadLocal<>();
}

class User{
    String name;

    public User(String name) {
        this.name = name;
    }
}
