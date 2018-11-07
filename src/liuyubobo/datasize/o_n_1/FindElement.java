package liuyubobo.datasize.o_n_1;

import util.Util;

/**
 * @ProjectName: algocollection
 * @Package: liuyubobo.o_n_1
 * @ClassName: FindElement
 * @Author: myname
 * @Description: ${description}
 * @Date: 2018/10/17 1:39
 * @Version: 1.0
 */
public class FindElement {
    /**
     * 查找数组元素中最大值O(n)
     * time O(n)
     * space O(1)
     * @param arr
     * @return
     */
    public static int findMax(int[] arr){
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] arr = Util.createArray(10,1,20);
        arr = new int[]{0,1,2,3,4,5,6};
        Util.printArray(arr);
        System.out.println("max: "+FindElement.findMax(arr));
      }
}
