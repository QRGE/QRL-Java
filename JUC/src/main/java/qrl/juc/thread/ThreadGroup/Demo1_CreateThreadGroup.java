package qrl.juc.thread.ThreadGroup;

public class Demo1_CreateThreadGroup {

    public static void main(String[] args) {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println(mainGroup);

        ThreadGroup group1 = new ThreadGroup("Group1");
        System.out.println(group1);

        ThreadGroup group2 = new ThreadGroup(mainGroup, "Group2");
        System.out.println(group2);

        // 创建线程组的默认父线程组为ThreadGroup
        System.out.println(group1.getParent() == mainGroup);
        System.out.println(group2.getParent() == mainGroup);

        // 创建线程时未指定线程组时默认存在于父线程组
        Thread subThread1 = new Thread(() -> System.out.println(Thread.currentThread()), "SubThread1");
        System.out.println(subThread1);
        Thread subThread2 = new Thread(group1, () -> System.out.println(Thread.currentThread()), "SubThread1");
        System.out.println(subThread2);
        Thread subThread3 = new Thread(group2, () -> System.out.println(Thread.currentThread()), "SubThread1");
        System.out.println(subThread3);
    }
}
