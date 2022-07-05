package com.ruoyi.common.utils.meo;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/7/1 10:41
 * @desc
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("-12 : " + diff(-12));
        System.out.println("-11 : " + diff(-11));
        System.out.println("-10 : " + diff(-10));
        System.out.println("-9 : " + diff(-9));
        System.out.println("-8 : " + diff(-8));
        System.out.println("-7 : " + diff(-7));
        System.out.println("-6 : " + diff(-6));
        System.out.println("-5 : " + diff(-5));
        System.out.println("-4 : " + diff(-4));
        System.out.println("-3 : " + diff(-3));
        System.out.println("-2 : " + diff(-2));
        System.out.println("-1 : " + diff(-1));
        System.out.println("-0 : " + diff(-0));
        System.out.println("1 : " + diff(1));
        System.out.println("2 : " + diff(2));
        System.out.println("3 : " + diff(3));
        System.out.println("4 : " + diff(4));
        System.out.println("5 : " + diff(5));
        System.out.println("6 : " + diff(6));
        System.out.println("7 : " + diff(7));
        System.out.println("8 : " + diff(8));
        System.out.println("9 : " + diff(9));
        System.out.println("10 : " + diff(10));
        System.out.println("11 : " + diff(11));
        System.out.println("12 : " + diff(12));


    }

    public static int diff(int diffX) {
        return 	diffX < -8 ? -3 : diffX < -4 ? -2 : diffX < -1 ? -1: diffX < 1 ? 0 : diffX < 4 ? 1 : diffX < 8 ? 2 : 3;
    }
}
