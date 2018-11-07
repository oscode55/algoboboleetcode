package liuyubobo.datasize;

import liuyubobo.datasize.o_n_logn.MergeSort;
import util.Util;

import java.util.Arrays;

/**
 * 测试数据规模 时间复杂度的实际耗时理解
 */
public class DataSizeMain {
    public static void main(String[] args) {
        //数据规模倍乘测试findMax

        for(int i=10;i<=40;i++){
            int n = (int) Math.pow(2,i);
            int[] arr = Util.createArray(n,0,100000000);
//            int[] arr = Util.createOrderArray(n);

            long start = System.currentTimeMillis();
//            FindElement.findMax(arr);//O(N)
//            SelectSort.sort(arr);//O(N^2)
//            BinarySearch.binarySearch(arr,0);//O(logN)
            MergeSort.sort(arr);
            long end = System.currentTimeMillis();

            System.out.print("data size 2^"+i+" ");
            System.out.println("time cost:"+ (end-start) );
        }
    }
}
