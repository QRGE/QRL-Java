package org.qrl.juc.thread.model.OneValue;


/**
 * producer - consumer 操作值的模式
 * producer 每次只生产一个值
 * consumer 每次只获取一个值
 */
public class Value {

    private String value = "";

    public void setValue(){
        synchronized (this){
            while (!value.equals("")){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String value = System.currentTimeMillis() + "-" + System.nanoTime();
            System.out.println("set设置的值: " + value);
            this.value = value;
            this.notifyAll(); // 避免getValue全部进入WAITING状态
        }
    }

    public void getValue(){
        synchronized (this){
            while (value.equals("")){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String oldValue = value;
            this.value = "";
            this.notifyAll(); // 避免setValue全部进入WAITING状态

            System.out.println("get的值为: " + oldValue);
        }
    }
}
