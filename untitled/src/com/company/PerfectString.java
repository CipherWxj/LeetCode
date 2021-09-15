package com.company;

import java.util.*;

public class PerfectString{
    public static int solution(String str){
        int len = str.length();
        if(len < 2){
            return 0;
        }
        if(len == 2){
            if(str.charAt(0) != str.charAt(1)){
                return 1;
            }else{
                return 0;
            }
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 0;
        int minCount = Integer.MAX_VALUE;
        for(int i = 0; i < str.length();i++){
            char ch = str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Character,Integer>  kvpair : map.entrySet()){
            list.add(kvpair.getValue());
        }
        Collections.sort(list);
        int sizeList = list.size();
        for(int j = sizeList - 1; j >= 0; j--){
            int cur = list.get(j);
            for(int i = 0; i < sizeList; i++){
                count += Math.abs(list.get(i) - cur);
            }
            minCount = Math.min(count,minCount);
        }
        return minCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String str = sc.next();
        int s = solution(str);
        System.out.println(s);
    }
}