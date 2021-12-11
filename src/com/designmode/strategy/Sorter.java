package com.designmode.strategy;

public class Sorter {
    //1、现在sort只能对int数组排序，那么如何对double/float甚至是对象数组进行排序呢？
    /*public static void sort(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            int minPos = i;
            for(int j=i+1;j<arr.length;j++){
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }

            swap(arr,i,minPos);
        }
    }
    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }*/

    //2、如何对Cat对象排序？
    //首先需要在Cat类中定义，猫对象如何比较大小
    /*public static void sort(Cat[] arr) {
        for(int i=0;i<arr.length-1;i++){
            int minPos = i;
            for(int j=i+1;j<arr.length;j++){
                minPos = arr[j].compareTo(arr[minPos])==-1  ? j : minPos;
            }

            swap(arr,i,minPos);
        }
    }
    static void swap(Cat[] arr, int i, int j) {
        Cat tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }*/

    //3、那如果是对狗排序呢？总不能再写一个sort方法吧
    //所以sort参数对象肯定不能写死，使用Comparable接口，以后sort就不用再修改了
    //
    public static void sort(Comparable[] arr) {
        for(int i=0;i<arr.length-1;i++){
            int minPos = i;
            for(int j=i+1;j<arr.length;j++){
                minPos = arr[j].compareTo(arr[minPos])==-1  ? j : minPos;
            }

            swap(arr,i,minPos);
        }
    }
    static void swap(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
