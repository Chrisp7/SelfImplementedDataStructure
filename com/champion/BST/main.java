package com.champion.BST;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by CP on 10/08/2018.
 */
public class main {
    public static void main(String args[]) {
        BST<Integer> bst = new BST<>();

        int[] arr={5,3,6,8,4,2};
        for (int num:arr){
            bst.add(num);
        }
        /*
        System.out.println("**********pre order recursive way**********");
        bst.preOrder();
        System.out.println("**********pre order not recursive**********");
        bst.preOrderNR();
        */
        System.out.println("**********level order**********");
        bst.levelOrder();
        bst.remove(5);
        System.out.println("**********level order**********");
        bst.levelOrder();

        /*
        Random random = new Random();
        int n = 10;
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!bst.isEmpty())
            list.add(bst.removeMin());


        System.out.println(list);

        for (int i = 0; i < list.size() - 1; i++)
            if (list.get(i) > list.get(i + 1))
                throw new IllegalArgumentException("error, the tree doesn't remove minimum item correctly");
        System.out.println("test completed");
        */
    }

}
