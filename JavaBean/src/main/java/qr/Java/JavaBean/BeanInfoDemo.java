package qr.Java.JavaBean;

import java.beans.*;

public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

        // 属性描述
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            System.out.println("PropertyName: " + propertyDescriptor.getName());
            System.out.println("PropertyType: " + propertyDescriptor.getPropertyType());
            System.out.println("PropertyReadMethod: " + propertyDescriptor.getReadMethod());
            System.out.println("PropertyWriteMethod: " + propertyDescriptor.getWriteMethod());
            System.out.println("----------------------------------------");
        }

        // 方法描述
        MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
        for (MethodDescriptor methodDescriptor : methodDescriptors) {
            System.out.println(methodDescriptor);
        }
    }
}
