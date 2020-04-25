package com.drturner.leetcode.problem406;

import java.util.ArrayList;
import java.util.Arrays;

public class ReconstructHeight {
    class Person implements Comparable{
        private int height;
        private int no;

        public Person(int height, int no) {
            this.height = height;
            this.no = no;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "height=" + height +
                    ", no=" + no +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            Person p2 = (Person) o;
            if (this.height<p2.height){
                return -1;
            }
            else if (this.height==p2.height&&this.no>p2.no){
                return -1;
            }
            else if (this.height==p2.height&&this.no==p2.no){
                return 0;
            }
            else{
                return 1;
            }
        }
    }
    //输入:
    //[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
    //
    //输出:
    //[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
    static ArrayList<Person> result=new ArrayList<>();
    public int[][] reconstructQueue(int[][] people) {
        int[][] res=new int[people.length][2];
        if (people.length==0||people[0].length==0) return res;
     //   Person[] persons=new Person[people.length];
      //  for (int i=0;i<people.length;i++) {
      //      persons[i]=new Person(people[i][0],people[i][1]);
    //    }
        Arrays.sort(people,(o1,o2)->{
            if (o1[0]==o2[0]) return o2[1]-o1[1];
            else return o1[0]-o2[0];
        });
        for (int i=people.length-2;i>=0;i--){
            int big=0;
            for (int j=i+1;j<people.length;j++){
                if (big==people[j-1][1]){
                    break;
                }
                if (people[j][0]>=people[j-1][0]){
                    big++;
                }
                if (big<=people[j-1][1]){
                    int t1=people[j-1][0];
                    int t2=people[j-1][1];
                    people[j-1][0]=people[j][0];
                    people[j-1][1]=people[j][1];
                    people[j][0]=t1;
                    people[j][1]=t2;
                }
            }
        }
     //   for (Person p:persons) {
     //       System.out.println(p);
    //    }
        /*
        for (int i=persons.length-2;i>=0;i--){
            int big=0;
            for (int j=i+1;j<persons.length;j++){
                if (big==persons[j-1].no){
                    break;
                }
                if (persons[j].height>=persons[j-1].height){
                    big++;
                }
                if (big<=persons[j-1].no){
                    Person t=persons[j-1];
                    persons[j-1]=persons[j];
                    persons[j]=t;
                }
            }
        }

        for (int i=0;i<persons.length;i++) {
            res[i][0]=persons[i].height;
            res[i][1]=persons[i].no;
        }
*/
        return people;
    }
    public int[][] reconstructQueueSub(Person[] persons,int L,int R) {

        return null;
    }

    public static void main(String[] args) {
        int[][] people={{2,4},{3,4},{9,0},{0,6},{7,1},{6,0},{7,3},{2,5},{1,1},{8,0}};
        ReconstructHeight reconstructHeight = new ReconstructHeight();
        int[][] ints = reconstructHeight.reconstructQueue(people);
        for (int[] ele:ints) {
            for (int e:ele) {
                System.out.print(e+" ");
            }
            System.out.println();
        }

    }
}
