/**
 * @author: Wxj
 * 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * <p>输入描述:
 * strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * <p>输出描述:
 * [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
package com.company.brush.hashtable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> solution(String[] strs) {
        // 初始化一个哈希表，key：分组标准字符串（按字符排序），value：同一组的字符串
        Map<String, List<String>> groupMap = new HashMap<>();

        for (String str : strs) {
            // 将字符串转为字符数组排序，作为分组基准
            System.out.println(str);
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String groupKey = Arrays.toString(chars);
            // 当前字符串str已经属于某一分组，将str添加到该分组；
            // 当前字符串str不属于已经存在的分组，新建分组，并将str添加到该分组
            List<String> groupValue = groupMap.getOrDefault(groupKey, new ArrayList<>());
            groupValue.add(str);
            groupMap.put(groupKey, groupValue);
        }
        return new ArrayList<>(groupMap.values());
    }

    public static void main(String[] args) {
        System.out.println("请输入一个字符串数组：");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String sub = s.substring(1, s.length() - 1);
        String[] strs = sub.split(", ");
        for (int i = 0; i < strs.length; i++) {
            strs[i] = strs[i].substring(1, strs[i].length() - 1);
        }
        System.out.println(JSON.toJSONString(solution(strs)));
    }
}
