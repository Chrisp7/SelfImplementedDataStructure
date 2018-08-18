package com.champion.Array;

/**
 * Created by CP on 01/08/2018.
 */
public class Student {
    private String name;
    private int score;

    public Student(String name,int score){
        this.name=name;
        this.score=score;
    }

    @Override
    public String toString(){
        return String.format("Student Name: %s, Score: %d",name,score);
    }

    public static void main(String args[]){
        Array<Student> sarr= new Array<Student>();
        sarr.addLast(new Student("陈鹏",100));
        sarr.addLast(new Student("孙丹",59));
        System.out.println(sarr);
    }
}
