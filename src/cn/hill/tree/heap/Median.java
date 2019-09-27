package cn.hill.tree.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 利用两个堆来求动态数据的中位数
 * @author HILL
 * @version V1.0
 * @date 2019/9/27
 **/
public class Median {

   /**
    * 大根堆存放的是小于中位数的元素，当有一个元素小于堆顶元素时，把它放入此位置
   **/
    PriorityQueue<Integer> bigHeap = new PriorityQueue<Integer>( Comparator.reverseOrder());
    /**
     * 小根堆则是存放大于中位数的元素
    **/
    PriorityQueue<Integer> smallHeap = new PriorityQueue<Integer>();
    public static void main(String[] args) {
       int[] arr = {4,5,6,7,1,2,3};
        Median k = new Median();
        Arrays.stream(arr).forEach((num)->{
            k.add(num);
            System.out.println("当前中位数"+k.getBin());
        });

        //删除元素
        k.remove(4);
        System.out.println(k.getBin());
        k.remove(1);
        System.out.println(k.getBin());


    }

    /**
     * 向动态数组添加一个数，判断两个堆的大小，根据不同的数值进行数据迁移。
     * @Author: HILL
     * @date: 2019/9/27 15:34
     *
     * @param num
     * @return: int
    **/
    public int add(Integer num){
        //根据两个根堆的大小进行判断放入哪一个根堆
        if (bigHeap.size()==0){
            bigHeap.add(num);
        }else if (bigHeap.peek()>=num){
            bigHeap.add(num);
        }else {
            smallHeap.add(num);
        }
        resize();

        return num;
    }

    /**
     * 每次进行组合的结构化修改时，都要检查是否需要移动根堆中的数据。
     * @Author: HILL
     * @date: 2019/9/27 16:11
    **/
    private void resize() {
        //添加完成，比较两根堆的size大小
        int moveNum = bigHeap.size()-smallHeap.size();
        //若大根堆的size比小根堆多2，则移除一个元素过去
        if (moveNum>1){
            smallHeap.add(bigHeap.poll());
        }else if (moveNum<=-1){
            bigHeap.add(smallHeap.poll());
        }
    }

    /**
     * 获取大根堆的堆顶元素，即组合的中位数
     * @Author: HILL
     * @date: 2019/9/27 16:10
     *
     * @return: int 返回的中位数
    **/
    public int getBin(){
        return bigHeap.peek();
    }

    /**
     * 去除两个堆中的一个数据，然后重新组合大小。
     * @Author: HILL
     * @date: 2019/9/27 16:11
     * @param num
     * @return: boolean
    **/
    public boolean remove(int num){
        Integer peek = bigHeap.peek();
        boolean s = num<=peek?bigHeap.remove(num):smallHeap.remove(num);
        resize();
        return s;
    }


}
