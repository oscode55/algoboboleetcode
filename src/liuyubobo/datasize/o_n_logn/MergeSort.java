package liuyubobo.datasize.o_n_logn;

import util.Util;

/**
 * @ProjectName: algocollection
 * @Package: liuyubobo.o_n_logn
 * @ClassName: MergeSort
 * @Author: myname
 * @Description: ${description}
 * @Date: 2018/10/18 9:00
 * @Version: 1.0
 */
public class MergeSort {
    public static void sort(int arr[]){
        mergeSort(arr,0,arr.length-1);
    }
    private static void mergeSort(int arr[],int l,int r){
        if(l>=r){
            return;
        }
        int mid = l+(r-l)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
    private static void merge(int arr[],int l,int mid,int r){
        int i=l,j=mid+1;
        int[] aux=new int[r-l+1];
        for(int x=l;x<=r;x++){
            aux[x-l]=arr[x];
        }
        for(int k=l;k<=r;k++){
            if(i>mid){
                arr[k]=aux[j-l];
                j++;
            }else if(j>r){
                arr[k]=aux[i-l];
                i++;
            }else if(aux[i-l]<aux[j-l]){
                arr[k]=aux[i-l];
                i++;
            }else{
                arr[k]=aux[j-l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = Util.createArray(10,1,20);
        Util.printArray(arr);
        MergeSort.sort(arr);
        Util.printArray(arr);
    }
}
