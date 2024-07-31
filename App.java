import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class App  {

    public static void main(String[] args)
    {
//        learnArrayList();
//        learnStack();
//        learnQueue();
        learnStream();
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

    public static void learnStream() {
        System.out.println("<.......Stream..........>");

        //When invoking methods that has the stream parameters, an empty stream can be helpful in order to avoid the nullpointer exceptions.
        // an empty stream is created here
        Stream<String> str = Stream.empty();

// printing elements in Stream
        str.forEach(System.out::println);


        // for ArrayList
        Collection<String> colln = Arrays.asList("J2EE", "JAVA", "Hibernate", "Spring");
        Stream<String> stream1 = colln.stream();
        stream1.forEach(System.out::println);

// for List
        List<String> lst = Arrays.asList("J2EE", "JAVA", "Hibernate", "Spring");
        Stream<String> stream2 = lst.stream();
        stream2.forEach(System.out::println);

// for HashSet
        Set<String> st = new HashSet<>(lst);
        Stream<String> stream3 = st.stream();
        stream3.forEach(System.out::println);
// Array can be made as a Stream source
        Stream<String> strOfArray = Stream.of("a1", "b1", "c1", "d1");
        strOfArray.forEach(System.out::println);

// making from the existing array or from the partion of the array:
        String ar[] = new String[] {"a","b"};
        Stream<String> stream4 = Arrays.stream(ar); //Stream.of
        stream4.forEach((x) -> System.out.println(x));

        Stream stream5 = Stream.builder().add("1").add("2").build();
        stream5.forEach(System.out::println);


        Stream.generate(new Random()::nextInt)
                .limit(6).forEach(System.out::println);
//static <E> Stream<E> iterate(E st, Predicate<E> hasNext, UnaryOperator<E> next)
        Stream<Double> stream6 = Stream.iterate(2.0, decimal -> decimal > 0.1, decimal -> decimal / 2);

// printing the values
        stream6.forEach(System.out::println);
        //Java 8 gives the facility for the creation of streams out of the three primitive types: int, long and double. As the Stream<E> is the generic interface, and there is no way for using the primitives as the type parameter with generics, a total of the three new special interfaces were made: IntStream, LongStream, DoubleStream.
        int s = IntStream.range(1, 3).sum();
        int s2 = IntStream.rangeClosed(1, 4).sum();

        System.out.println("Sum of the operation of intStreamRangeTest : " + s + " " + s2);
        // Making a LongStream
        LongStream lg = LongStream.of(-7L, -9L, -11L);

// Keeping the elements count in the LongStream
        long totalCount = lg.count();

// Printing the elements count
        System.out.println("The total count is: " + totalCount);
        DoubleStream dg = DoubleStream.of(-8D, -9D, -10D);

// Keeping the elements count in the DoubleStream
        long totalCountD = dg.count();

// Printing the elements count
        System.out.println("The total count is: " + totalCountD);
        IntStream strmOfChar = "javaTpoint".chars();
        long characterCount = strmOfChar.count();
        System.out.println("The total number of character count is: " + characterCount);


        List<String> elemnts = Stream.of("a1", "b1", "c1").filter(element -> element.contains("a1")).collect(Collectors.toList());
        Optional<String> anyEle = elemnts.stream().findAny();
        Optional<String> firstEle = elemnts.stream().findFirst();
        System.out.println(firstEle);
//        Stream<String> stream7 = Stream.of("a1", "b1", "c1").filter(element -> element.contains("b1"));
//        Optional<String> a = stream7.findAny();
//        Optional<String> b = stream7.findFirst(); // the stream is inaccessible here
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");
        names.stream()
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println);
// Output:
// Alice
        List<Integer> numbers = List.of(1, 2, 2, 3, 3, 3, 4);
        numbers.stream()
                .distinct()
                .forEach(System.out::println);
// Output:
// 1
// 2
// 3
// 4
        List<String> names2 = List.of("Alice", "Bob", "Charlie");
        names2.stream()
                .map(String::length)
                .forEach(System.out::println);
// Output:
// 5
// 3
// 7
        List<Integer> numbers3 = List.of(1, 2, 3, 4, 5);
        numbers3.stream()
                .limit(3) // max size
                .forEach(System.out::println);
// Output:
// 1
// 2
// 3

        List<String> names4 = List.of("Charlie", "Alice", "Bob");
        names4.stream()
                .sorted()
                .forEach(System.out::println);
// Output:
// Alice
// Bob
// Charlie

        List<Integer> numbers6 = List.of(1, 2, 3, 4, 5);
        int sum = numbers6.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);
// Output: 15
        List<String> names1 = List.of("Alice", "Bob", "Charlie");
        List<String> collectedNames = names1.stream()
                .collect(Collectors.toList());
        collectedNames.forEach(System.out::println);
// Output:
// Alice
// Bob
// Charlie
        List<Integer> numberss = List.of(1, 2, 3, 4, 5);
        Optional<Integer> minNumber = numberss.stream()
                .min(Integer::compareTo);
        minNumber.ifPresent(System.out::println);
// Output: 1

        List<String> names22 = List.of("Alice", "Bob", "Charlie");
        long count = names22.stream().count();
        System.out.println(count);
// Output: 3
        List<Integer> numbersss = List.of(1, 2, 3, 4, 5);
        boolean anyMatch = numbersss.stream()
                .anyMatch(n -> n > 3);
        System.out.println(anyMatch);
// Output: true
        List<Integer> numbers8 = List.of(1, 2, 3, 4, 5);
        Optional<Integer> maxNumber = numbers8.stream()
                .max(Integer::compareTo);
        maxNumber.ifPresent(System.out::println);
// Output: 5
        List<Integer> numbers0 = List.of(1, 2, 3, 4, 5);
        boolean noneMatch = numbers0.stream()
                .noneMatch(n -> n > 5);
        System.out.println(noneMatch);
// Output: true
        List<Integer> number1s = List.of(1, 2, 3, 4, 5);
        boolean allMatch = number1s.stream()
                .allMatch(n -> n > 0);
        System.out.println(allMatch);
// Output: true



/*The map method is an intermediate operation in Java Streams that takes each element in the stream and applies a function to it, transforming it into a new element. This transformation produces a new stream of the transformed elements.*/




    }
}
