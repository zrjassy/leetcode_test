package com.HUAWEI.Q22_4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-15 23:01
 **/
public class Q17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int num = sc.nextInt();


        s = s.substring(1, s.length() - 1);
        String[] str = s.split(",");
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (String temp : str) {
            int x = Integer.parseInt(temp);
            if (x <= 3) list1.add(x);
            else list2.add(x);
        }

        


    }

}
