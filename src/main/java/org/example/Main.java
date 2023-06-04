package org.example;

import java.util.HashMap;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] nums={1,1,1,2,2,3};
        Map<Integer,Integer> map=new HashMap<>();
        for(int number:nums){
            if(map.containsKey(number)){
                map.put(number,map.get(number)+1);
            }else {
                map.put(number,1);
            }
        }
        int count=0;
        List<Integer> list=new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x=entry.getValue();
            while (x<3 && x>0){
                list.add(entry.getKey());
                x--;
            }
        }
      for (int i=0;i<list.size();i++){
          System.out.println(list.get(i));
          nums[i]=list.get(i);
      }
        System.out.println(list.size()+"size");
    }
}