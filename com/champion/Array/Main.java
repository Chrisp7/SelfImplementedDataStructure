package com.champion.Array;

import com.champion.Stack;

public class Main {

    public static void main(String[] args) {
        /*
        Array<Integer> arr= new Array<Integer>(6);
        for(int i=0;i<5;i++){
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.add(2,100);
        System.out.println(arr);
        arr.addLast(101);
        System.out.println(arr);
        arr.delete(2);
        System.out.println(arr.toString());
        */
        Stack<Integer> s=new ArrayStack<>();
        for (int i=0;i<5;i++){
            s.push(i);
            System.out.println(s);
        }
        s.pop();
        System.out.println(s);
        System.out.println(s.peek());



    }
}
