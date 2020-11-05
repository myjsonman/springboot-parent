package com.kavy.rookiespringbootredis.util;

/**
 * 选择排序
 */
public class TestSelectSort {
    public static void main(String[] args) {
        int [] arr = {8,100,15,30,88,66,22};
//        sort(arr);
        selectSort(arr);
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]+" ");
        }
    }
    public static void sort(int arr[]){
        int tem = 0;
        for (int i = 0; i < arr.length -1; i++) {

            //用来记录最小值索引的位置
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {

                if (arr[minIndex]>arr[j]){
                    //遍历
                    minIndex = j;
                }
            }

            //找到的最小值和i的位置交换
            if (i!=minIndex ) {
                tem = arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex] = tem;
            }
        }
    }

    public static  void selectSort(int [] arr) {
      int tem = 0;
      for (int i = 0;i<arr.length -1;i++){
          int min =i;
          for (int j = i+1; j <arr.length ; j++) {
              if (arr[min]>arr[j]){
                  min = j;
              }
          }

          if (i!=min) {
              tem = arr[i];
              arr[i] = arr[min];
              arr[min] = tem;
          }
      }
    }
}
