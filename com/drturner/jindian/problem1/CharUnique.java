package com.drturner.jindian.problem1;

import java.util.HashSet;
import java.util.Set;

public class CharUnique {
    Set<Character> set=new HashSet<>();
    public boolean isUnique(String astr) {
        if (astr==null||astr.length()==0) return false;
        for(int i=0;i<astr.length();i++){
            set.add(astr.charAt(i));
        }
        return set.size()==astr.length();
    }
}
