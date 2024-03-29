package org.qrl.stream.list.flat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 把字符串列表转换成字符列表
 */
public class SplitWords {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("Ni");
        words.add("Hao");
        words.add("Wa");
        String newWord = words.stream()
                // 借助 map 将每个 string 分解成单个字符的 string[]
                .map(word -> word.split(""))
                // 先用 Arrays 的 stream 方法将数据转换成字符串流, 再用 flatMap 将多个 stream 整合成一个 stream
                // flat 扁的, 将多个 stream 整合成一个 stream
                .flatMap(Arrays::stream)
                .collect(Collectors.joining(", "));
        System.out.println(newWord);
    }
}
