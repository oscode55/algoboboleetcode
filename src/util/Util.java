package util;

public class Util {
    public static int getRandom(int l,int r){
        return l+(int)(Math.random()*(r-l+1));
    }
    public static void swap(Object[] objects,int i,int j){
        Object temp=objects[i];
        objects[i]=objects[j];
        objects[j]=temp;
    }
    public static void swap(int[] objects,int i,int j){
        int temp=objects[i];
        objects[i]=objects[j];
        objects[j]=temp;
    }
    //2-4 3 [0,3)
    public static void createArray(int arr[],int l,int r){
        for(int i=0;i<arr.length;i++){
            arr[i]=l+ (int)( Math.random()*(r-l+1) );
        }
    }
    public static int[] createArray(int n,int l,int r){
        int[] newArray = new int[n];
        createArray(newArray,l,r);
        return newArray;
    }
    public static int[] createOrderArray(int n){
        int[] newArray = new int[n];
        for(int i=0;i<newArray.length;i++){
            newArray[i] = i;
        }
        return newArray;
    }
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(Util.getRandom(0, 3) + " ");
        }
    }
}
