package com.drturner.leetcode.problem438;

import java.util.*;

/**
 * ClassName: Subsequence
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/21
 * Version: 1.0
 */
public class Subsequence {
    Set<Integer> result=new HashSet<>();
//    String ss="abc";
    public void findAnagramsNaive(String s, int index, String p, String ss, int length) {
        String pp = p.substring(0);
        if (pp==null||pp.length()==0){
            result.add(index-length);
            return;
        }
        if (index==s.length()||index+pp.length()>s.length()) return;

     //   StringBuilder sb=new StringBuilder(p);
        int in = pp.indexOf(s.charAt(index));
        if (in==-1){
            findAnagramsNaive(s,index+1,ss,ss,length);
            return;
        }
        String newP = pp.substring(0, in) + pp.substring(in+1);
        findAnagramsNaive(s,index+1,newP,ss,length);
        findAnagramsNaive(s,index+1,ss,ss,length);
    }
    public List<Integer> findAnagramsSub(String s, String p){
        List<Integer> res=new ArrayList<>();
        if (s==null||p==null||s.length()<p.length()) return res;
        HashMap<Character,Integer> map=new HashMap<>();
        HashMap<Character,Integer> mapS=new HashMap<>();
        for (int i=0;i<p.length();i++){
            if (map.containsKey(p.charAt(i))){
                map.put(p.charAt(i),map.get(p.charAt(i))+1);
            }
            else {
                map.put(p.charAt(i),1);
            }
            if (mapS.containsKey(s.charAt(i))){
                mapS.put(s.charAt(i),mapS.get(s.charAt(i))+1);
            }
            else {
                mapS.put(s.charAt(i),1);
            }
        }

        boolean flag=true;
        for (Character c:map.keySet()) {
            if (!mapS.containsKey(c)||!map.get(c).equals(mapS.get(c))){
                flag=false;
                break;
            }
        }
        if (flag) res.add(0);

        for (int i=1;i<=s.length()-p.length();i++){
            if (mapS.containsKey(s.charAt(i+p.length()-1))){
                mapS.put(s.charAt(i+p.length()-1),mapS.get(s.charAt(i+p.length()-1))+1);
            }
            else {
                mapS.put(s.charAt(i+p.length()-1),1);
            }
            mapS.put(s.charAt(i-1),mapS.get(s.charAt(i-1))-1);
            if (mapS.get(s.charAt(i-1))==0) mapS.remove(s.charAt(i-1));
            boolean f=true;
            for (Character c:map.keySet()) {
                //
                if (!mapS.containsKey(c)||!map.get(c).equals(mapS.get(c))){
                    f=false;
                    break;
                }
            }
            if (f) res.add(i);

        }
        return res;
    }
    public List<Integer> findAnagrams(String s, String p) {
        if (s==null||p==null) return new ArrayList<>(result);
        findAnagramsNaive(s,0,p,p,p.length());
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        String s="cbaebabacd";

        String p="abc";
        Subsequence subsequence = new Subsequence();
        List<Integer> res = subsequence.findAnagramsSub(s, p);
       // String s1 = p.substring(0, 1);
        System.out.println(s);
        System.out.println(res);
    }
}
