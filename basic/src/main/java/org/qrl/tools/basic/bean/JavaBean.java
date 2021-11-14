package org.qrl.tools.basic.bean;

import java.io.Serializable;

/**
 * JavaBean规范:
 * - 所有属性为 private
 * - 提供默认构造方法
 * - 提供 getter 和 setter
 * - 实现 serializable 接口
 * @Author: QR
 * @Date: 2021/7/12-17:22
 */
@SuppressWarnings("all")
public class JavaBean implements Serializable {

    private Integer id;
    private String beanName;

    public JavaBean(Integer id, String beanName) {
        this.id = id;
        this.beanName = beanName;
    }

    public JavaBean() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
