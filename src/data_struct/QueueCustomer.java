package data_struct;

import java.util.LinkedList;

/**
 * @ProjectName: algocollection
 * @Package: data_struct
 * @ClassName: QueueCustomer
 * @Date: 2018/10/17 10:37
 * @Version: 1.0
 */
public class QueueCustomer <T>{
    private LinkedList<T> data;
    public QueueCustomer(){
        data = new LinkedList<>();
    }
    public void enQueue(T e){
        data.addLast(e);
    }
    public T deQueue(){
        return data.removeFirst();
    }
    public boolean isEmpty(){
        return data.size()==0;
    }
    public static void printQueueCustomer(QueueCustomer queueCustomer){
        System.out.print("队列打印: ");
        while(!queueCustomer.isEmpty()){
            System.out.print(queueCustomer.deQueue()+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        QueueCustomer<Integer> queueCustomer = new QueueCustomer<>();
        queueCustomer.enQueue(1);
        queueCustomer.enQueue(2);
        queueCustomer.enQueue(3);
        while(!queueCustomer.isEmpty()){
            System.out.println(queueCustomer.deQueue());
        }
    }
}
