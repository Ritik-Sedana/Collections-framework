import java.io.*;
import java.util.*;

public class App  {

    public static void main(String[] args)
    {
        learnArrayList();
        learnStack();
        learnQueue();
    }

    public static void learnArrayList() {
        System.out.println("<......ArrayList...........>");
        ArrayList<String> arr = new ArrayList<>(); // can be stored in type list
        arr.add("test");
        arr.add("test2");
        System.out.println(arr);
        // size = n
        // if increased new size = n + n/2 + 1


        arr.add(1, "test between"); // at particular index
        System.out.println(arr);

        List<String> arr2 = new LinkedList<>(); // as linkedlist also implements list interface


        arr2.addAll(arr);
        System.out.println(arr2);

        List<String> arr3 = new ArrayList<>(arr2); // same thing
        System.out.println(arr3);

        arr3.remove(1);
        System.out.println(arr3);

        arr3.remove(String.valueOf("test"));

        System.out.println(arr3);
        System.out.println(arr3.contains("test2"));
        arr3.set(0,"change value");
        System.out.println(arr3);

        arr3.clear();

        System.out.println(arr3.size());


        // iteration

        for (int i = 0; i< arr.size(); ++i) {
            System.out.println(arr.get(i));
        }
        for (String s : arr) {
            System.out.println(s);
        }
        Iterator<String> itr = arr.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

    }
    public static void learnStack() {
        System.out.println("<........Stack.........>");
        // push pop peek
        Stack<Integer> st = new Stack<Integer>();
        st.push(1);
        st.push(2);
        st.push(3);


        System.out.println(st);
        System.out.println(st.peek());

        System.out.println(st.pop());
        System.out.println(st);



    }

    public static void  learnQueue() {
        System.out.println("<.......Queue..........>");

        Queue<Integer> queue = new LinkedList<>(); //   linked list implements queue interface internally
        queue.offer(1); // return false if unsuccessful
        queue.add(2); // return exception if unsuccessful
        queue.offer(3);
        System.out.println(queue);
        System.out.println(queue.poll()); // show null if empty
        System.out.println(queue.remove()); // throw exception if empty

        System.out.println(queue.peek()); //top element gives null if empty
        System.out.println(queue.element()); // throws exception if empty
        
    }
}
