package com.drturner.Howi;

import java.util.*;


/**
 * ClassName: HJ102
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/4
 * Version: 1.0
 */
public class HJ102 {
/*    static class Helper{
        Character c;
        int freq;

        public Helper(Character c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }*/
    public static void main(String[] args) {
        class Helper{
            Character c;
            int freq;

            public Helper(Character c, int freq) {
                this.c = c;
                this.freq = freq;
            }
        }
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            char[] str = s.toCharArray();
            HashMap<Character,Integer> map=new HashMap<>();
            for (int i=0;i<str.length;i++){
                if (map.containsKey(str[i])){
                    map.put(str[i],map.get(str[i])+1);
                }
                else if (str[i]<=255){
                    map.put(str[i],1);
                }
            }
            int i=0;
            Helper[] result=new Helper[map.size()];
            for (Character c:map.keySet()){
                result[i++]=new Helper(c,map.get(c));
            }
            Arrays.sort(result,(o1,o2)->{
                return o1.freq==o2.freq?o1.c-o2.c:(o2.freq-o1.freq);
            });
            for (Helper helper:result){
                System.out.print(helper.c);
            }
            System.out.println();
        }

    }






}
