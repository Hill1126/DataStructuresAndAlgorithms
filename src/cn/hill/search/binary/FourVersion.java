package cn.hill.search.binary;

import org.junit.Test;

/**
 * 实现关于二分查找的四个变种的代码
 * @author HILL
 * @version V1.0
 * @date 2019/8/26
 **/
public class FourVersion {

    @Test
    public void fun(){
        int[] arr = {2,7,8,8,8,88};
        System.out.println(findLastSmall(arr,888));
    }


    /**
     * 查找第一个值等于给定值的元素
     * @Author: HILL
     * @date: 2019/8/26 22:16
     *
     * @param arr 要查找的数组
     * @param num 要查找的值
     * @return: int 目标值在数组的索引
    **/
    public static int findFirstEquals(int[] arr , int num){
        if (arr == null ) {
            return -1;
        }
        //设定初始值
        int low = 0;
        int high = arr.length-1;

        while (low <= high ){

            int mid = low+( (high-low) >>1 );
            //大于目标值，更新high的下标
            if (arr[mid] > num){
                high = mid-1;
            }else if (arr[mid] < num){
                low = mid+1;
            }else{
                //找到目标值，但不清楚是否是第一个
                if ( mid==0 || arr[mid-1] != num ) {
                    return mid;
                } else {
                    high = mid-1;
                }
             }
        }
        return -1;
    }

    /**
     * 查找数组中最后一个相同的元素的下标
     * @Author: HILL
     * @date: 2019/8/26 22:29
     *
     * @param arr 要查找的数组
     * @param num 要查找的值
     * @return: int 目标值在数组的索引
    **/
    public static int findLastEquals(int[] arr , int num){

        int low = 0;
        int high = arr.length-1;
        while (low<=high){
            int mid = low+( (high-low) >>1 );
            if (arr[mid] > num){
                high = mid-1;
            }else if (arr[mid] < num){
                low = mid+1;
            }else{
                if (mid == arr.length-1 || arr[mid+1] != num ){
                    return mid;
                }else {
                    low = mid+1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于目标值的下标，不包括自己
     * @Author: HILL
     * @date: 2019/8/26 23:02
     *
     * @param arr 要查找的数组
     * @param num 要查找的值
     * @return: int 第一个大于num的数在数组的索引
    **/
    public static int findFirstBig(int[] arr , int num){
        if (arr == null ) {
            return -1;
        }
        //设定初始值
        int low = 0;
        int high = arr.length-1;

        while (low <= high ){
            int mid = low+( (high-low) >>1 );
            if (arr[mid] > num){
                //当mid为0或者前一个数已经小与或等于num时
                if (mid == 0 || arr[mid-1] <= num ){
                    return mid;
                }else{
                    //大于时正常更新值
                    high = mid-1;
                }
            }else {
                //在小与或等于目标值时，都继续查找
                low = mid+1;
            }
        }
        return -1;
    }

    /**
     * 查找第最后一个小于目标值的下标，不包括自己
     * @Author: HILL
     * @date: 2019/8/26 23:02
     *
     * @param arr 要查找的数组
     * @param num 要查找的值
     * @return: int 最后一个小于num的数在数组的索引，没有则返回-1
     **/
    public static int findLastSmall(int[] arr , int num){
        if (arr == null ) {
            return -1;
        }
        //设定初始值
        int low = 0;
        int high = arr.length-1;

        while (low <= high ){
            int mid = low+( (high-low) >>1 );
            if (arr[mid] >= num){
                //在大于或等于目标值时，都继续查找
                high = mid-1;
            }else {
                //在找到小于目标的数值时，进行判断
                if (mid == arr.length-1 || arr[mid+1] >= num){
                    return mid;
                }
                low = mid+1;
            }
        }
        return -1;
    }




}
