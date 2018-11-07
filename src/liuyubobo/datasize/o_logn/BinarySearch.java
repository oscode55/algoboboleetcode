package liuyubobo.datasize.o_logn;

import liuyubobo.o_n_2.SelectSort;
import util.Util;

/**
 * @ProjectName: algocollection
 * @Package: liuyubobo.o_logn
 * @ClassName: BinarySearch
 * @Author: myname
 * @Description: ${description}
 * @Date: 2018/10/18 1:02
 * @Version: 1.0
 */
public class BinarySearch {
    /**
     * 二分查找
     * time O(logN)
     * space O(1)
     */
    public static int binarySearch(int[] arr,int target){
        int l = 0;
        int r =arr.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]<target){
                l = mid+1;
            }else if(arr[mid]>target){
                r = mid-1;
            }else{
                return mid;
            }
        }
//        throw new IllegalArgumentException("not found target element!");
        return -1;
    }

    /**
     * 二分查找递归法
     * time O(logN)
     * space O(N)
     * 在 [l,r]之间查找目标元素
     * @param arr
     * @param l 左边界
     * @param r 右边界
     * @param target
     * @return
     */
    public static int binarySearchRecursion(int arr[],int l,int r,int target){
        if(l>r){
            return -1;
        }
        int mid = l +(r-l)/2;
        if(arr[mid] < target){
            return binarySearchRecursion(arr,mid+1,r,target);
        }else if( arr[mid] > target){
            return binarySearchRecursion(arr,l,mid-1,target);
        }else{
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] arr = Util.createArray(10,1,30);
        SelectSort.sort(arr);
        Util.printArray(arr);
        System.out.println(binarySearch(arr,2));
    }
}
