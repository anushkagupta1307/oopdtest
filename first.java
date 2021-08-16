package Assignment1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

//Sliding Window Maximum Problem in O(n) using dequeue
//Space- O(k)- for dequeue
/*
5
6 2
1 3 4 2 7 6
4 3
1 3 2 7
4 4
1 2 3 4
4 1
5 6 7 8
4 2
9 17 85 45
 */
public class MaximumProfit {

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int size= sc.nextInt();

        System.out.println("Enter the window size : ");
        int window=sc.nextInt();

        int[] arr= new int[size];

        System.out.println("Enter the array elements : ");
        for(int i=0; i<size;i++){
            arr[i]= sc.nextInt();
        }

        findMaximum(arr, window);

    }

    public static void findMaximum(int[] arr, int window){

        Deque<Integer> deque= new ArrayDeque<>();

        //this loop processes the first k elements
        for(int i=0; i<window ; i++){
            //elements are added in descending order in the deque
            while(!deque.isEmpty() && arr[i] > arr[deque.peekLast()]){
                deque.removeLast();
            }
            deque.addLast(i);

        }
        // this loop processes the remaining elements
        for(int i=window; i<arr.length; i++){
            //front of queue has greatest element
            System.out.println(arr[deque.peekFirst()]);

            //Remove elements which are not part of the window
            while(!deque.isEmpty() && deque.peekFirst()<=i-window)
                deque.removeFirst();

            //remove smaller elements
            while(!deque.isEmpty() && arr[i] >=arr[deque.peekLast()])
                deque.removeLast();

            //Add new elements to deque
            deque.addLast(i);
        }
        //to print last element
        System.out.print(arr[deque.peekFirst()]);

    }
}
