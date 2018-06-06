package com.company;

public class Main {

    public static void main(String[] args) {
        SkipList<Integer> sl = new SkipList<>(20);
        sl.add(5);
        sl.add(20);
        sl.add(35);
        sl.add(14);
        sl.add(9);
        sl.add(34);
        sl.add(17);
        sl.add(13);
        sl.add(4);
        sl.add(22);
        sl.add(33);
        System.out.println(sl.printAllLevel());
    }
}
