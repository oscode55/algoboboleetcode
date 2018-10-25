package liuyubobo.o_n_2;

import util.Util;

/**
 * @ProjectName: algocollection
 * @Package: liuyubobo.o_n_2
 * @ClassName: SelectSort
 * @Author: myname
 * @Description: ${description}
 * @Date: 2018/10/17 1:36
 * @Version: 1.0
 */
public class SelectSort {
    /**
     * 选择排序法
     * 时间复杂度O(N^2)
     * 空间复杂度O(1)
     */
    //O(N^2)
    public static void sort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                Util.swap(arr,minIndex,i);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = Util.createArray(10,1,10);
        Util.printArray(arr);
        SelectSort.sort(arr);
        Util.printArray(arr);
    }
}
