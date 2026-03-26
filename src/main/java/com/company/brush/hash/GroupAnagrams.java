package com.company.brush.hash;

import java.util.*;

/**
 * @author: wangxinjian
 * 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * <p>输入描述:
 * strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * <p>输出描述:
 * [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class GroupAnagrams {
    private static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) return Collections.singletonList(Arrays.asList(strs));
        // 初始化哈希表, key:遍历过且经过排序的源字符串, value:源单词下的遍历过的所有字母异位词数组
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 将字符串转换成字符数组,从小到大排序,做为源字符
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String original = Arrays.toString(chars);
            // 如果源字符存在,直接将字符串存放在其对应的值List里
            if (map.containsKey(original)) {
                map.get(original).add(str);
            } else { // 如果源字符不存在,新建映射关系,注意要用new ArrayList<>,否则add会抛异常
                map.put(original, new ArrayList<>(Collections.singletonList(str)));
            }
        }
        // 将哈希表中的所有值取出,组装数组返回
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}