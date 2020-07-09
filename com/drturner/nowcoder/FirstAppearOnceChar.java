package com.drturner.nowcoder;

import java.util.*;

/**
 * ClassName: FirstAppearOnceChar
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/4
 * Version: 1.0
 */
public class FirstAppearOnceChar {
    LinkedList<Character> list=new LinkedList<>();
    Set<Character> sst =new HashSet<>();

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        list.offerLast(ch);
        if (sst.contains(ch)) sst.remove(ch);
        else sst.add(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        while (!list.isEmpty()&&!sst.contains(list.peekFirst())) list.pollFirst();
        return !list.isEmpty()?list.peekFirst():'#';
    }

    public static void main(String[] args) {
        FirstAppearOnceChar firstAppearOnceChar = new FirstAppearOnceChar();
        String s="google";
        for (int i=0;i<s.length();i++){
            firstAppearOnceChar.Insert(s.charAt(i));
            char c = firstAppearOnceChar.FirstAppearingOnce();
            System.out.println(c);
        }
    }
}
