package com.kavy.rookiespringbootredis.util;

/**
 * 冒泡排序
 */
public class TestBubbleSort {
    public static void main(String[] args) {
        int [] arr= {2,23,13,44,6,18};
       // sort(arr);
        bubbleSort(arr);
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]+" ");
        }
    }

    public static void sort(int arr[]) {

        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=0;j<arr.length-1-i;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

    }

    public static void bubbleSort(int arr []){
    int temp = 0;
        for (int i = 0; i < arr.length-1 ; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


}