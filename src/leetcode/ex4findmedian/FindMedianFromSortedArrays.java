package leetcode.ex4findmedian;

import util.Util;

/**
 * @ProjectName: algocollection
 * @Package: leetcode.ex4findMedianSortedArrays
 * @ClassName: FindMedianFromSortedArrays
 * @Author: myname
 * @Description: ${description}
 * @Date: 2018/10/23 10:41
 * @Version: 1.0
 */
public class FindMedianFromSortedArrays {
    public static int findMedianSortedArrays(int[] arr1,int[] arr2){
        int n1=arr1.length;
        int n2=arr2.length;
        int n = n1+n2;
        int[] arr = new int[n];
        for(int i=0;i<n1;i++)
            arr[i]=arr1[i];
        for(int j=0;j<n2;j++)
            arr[j+n1]=arr2[j];
        int p = findMedia(arr);
        return 0;
    }
    public static int findMedia(int[] arr){
        int n = arr.length;
        
        return 1;
    }
    //单路快速排序
    public static void quickSort(int[] arr){
        quick(arr,0,arr.length-1);
    }
    //单路快排
    private static void quick(int[] arr,int l,int r){
        if(l>r){
            return;
        }
        int p = partition(arr,l,r);
        quick(arr,l,p-1);
        quick(arr,p+1,r);
    }
    //找出p 使得[l,p)都小于arr[p]
    private static int partition(int[] arr,int l,int r){
        Util.swap(arr,l,Util.getRandom(l,r));
        int v = arr[l];
        int j = l;
        for(int i=l;i<=r;i++){
            if(arr[i]<v){
                Util.swap(arr,i,j+1);
                j++;
            }
        }
        Util.swap(arr,l,j);
        return j; //[l...j) 都小于arr[j]
    }
    //不小心写成三路快排了...
    private static void quick3ways(int[] arr,int l,int r){
        if(l>r)
            return;
        Util.swap(arr,l,Util.getRandom(l,r));
        int v = arr[l];
        int i =l,lt=l,gt=r+1;
        while( i<gt ){
            if( arr[i]<v ){
                Util.swap(arr,i,lt+1);
                lt++;
                i++;
            }else if( arr[i]>v ){
                Util.swap(arr,i,gt-1);
                gt--;
            }else{
                i++;
            }
        }
        Util.swap(arr,l,lt);
        // [l,lt-1] [gt,r]
        quick3ways(arr,l,lt-1);
        quick3ways(arr,gt,r);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,4};
        int[] arr2 = new int[]{5,6,7,8};

//        int[] arr = Util.createArray(10,1,20);
//        Util.printArray(arr);
//        quick3ways(arr,0,arr.length-1);
//        quickSort(arr);
//        Util.printArray(arr);
        int[] arr_1 = Util.createArray(5,1,10);
        int[] arr_2 = Util.createArray(5,11,20);
        Util.printArray(arr_1);
        Util.printArray(arr_2);
        findMedianSortedArrays(arr_1,arr_2);

    }
}
