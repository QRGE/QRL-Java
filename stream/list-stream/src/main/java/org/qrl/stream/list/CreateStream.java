package org.qrl.stream.list;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author QR
 * @Date 2021/10/31 7:57 AM
 */
public class CreateStream {

    @Test
    public void streamOfTest(){
        // 利用 Stream.of() 创建任意类型的流
        Stream<String> strStream = Stream.of("Java 8", "Java 11", "Java 17");
        List<String> strs = strStream.collect(Collectors.toList());
        strs.forEach(System.out::println);
    }
}
