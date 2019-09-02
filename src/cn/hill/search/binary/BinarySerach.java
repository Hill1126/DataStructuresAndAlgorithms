package cn.hill.search.binary;

/**
 * 计算一个数的平方根，输入的必须是正数
 * @author HILL
 * @version V1.0
 * @date 2019/8/25
 **/
public class BinarySerach {
    public static void main(String[] args) {
        System.out.print(sqrt(0.25d));
    }

    /**
     * 计算一个数的平方根，输入的必须是正数
     * @Author: HILL
     * @date: 2019/8/26 14:40
     * @param num 需要计算的数
     * @return: java.lang.Double 返回平方根，精度是小数点后6位
    **/
    public static double sqrt(Double num){

        if (num == null) {
            return 0d;
        }
        double low = 1;
        double high = num;
        //判断num是从0到1还是其它范围
        if(num<1){
            low = 0;
        }
        double result = 0d;
        double mid = 0d;
        while (true){
            mid= (high+low)/2;
            result = mid * mid;
            if(result>=num && result<num+0.000001){
                break;
            }else if (result>num){
                high = mid;
            }else{
                low = mid;
            }
        }

        return mid;
    }

}
