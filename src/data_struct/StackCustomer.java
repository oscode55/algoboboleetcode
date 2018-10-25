package data_struct;

import java.util.LinkedList;

/**
 * @ProjectName: 栈定义
 */
public class StackCustomer <T>{
    private LinkedList<T> data;
    public StackCustomer(){
        data = new LinkedList();
    }
    public void push(T e){
        data.addLast(e);
    }
    public T pop(){
        return data.removeLast();
    }
    public boolean isEmpty(){
        return data.size()==0;
    }
    public static void printStackCustomer(StackCustomer stackCustomer){
        System.out.print("栈打印: ");
        while(!stackCustomer.isEmpty()){
            System.out.print(stackCustomer.pop()+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        StackCustomer<Integer> stackCustomer = new StackCustomer<>();
        stackCustomer.push(1);
        stackCustomer.push(2);
        stackCustomer.push(3);
        while(!stackCustomer.isEmpty()){
            System.out.println(stackCustomer.pop());
        }
    }
}
