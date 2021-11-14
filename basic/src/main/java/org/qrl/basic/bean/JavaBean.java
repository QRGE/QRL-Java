package org.qrl.basic.bean;

import java.io.Serializable;

/**
 * JavaBean规范:
 * <li>所有属性为 private</li>
 * <li>提供默认构造方法</li>
 * <li>提供 getter 和 setter</li>
 * <li>实现 serializable 接口</li>
 *
 * 目前并不清楚这些规范的意义, 就我个人而言利用方法去操作成员变量的代码会比较直观易懂 <br/>
 * serializable 接口目前没怎么碰到过它的实际用处, 偶尔在学一些序列化的地方有涉及到 <br/>
 * 而且我比较喜欢 @Data
 *
 * @Author: QR
 * @Date: 2021/7/12-17:22
 */
@SuppressWarnings("all")
public class JavaBean implements Serializable {

    private Integer id;

    private String name;

    public JavaBean(Integer id, String beanName) {
        this.id = id;
        this.name = beanName;
    }

    public JavaBean() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
