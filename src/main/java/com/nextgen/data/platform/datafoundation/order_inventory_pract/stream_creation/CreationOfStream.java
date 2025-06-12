package com.nextgen.data.platform.datafoundation.order_inventory_pract.stream_creation;

import java.util.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

// create a stream instance from the multiple sources
        /* 1. Empty Stream
        *  2. Stream of Collection
        *  3. Stream of Array
        *  4. Stream of Primitives
        *  5. Stream of String
        *  6. Stream of File
        * */
public class CreationOfStream {
    public static void main(String[] args) {

        Stream<String> streamStr = Stream.of("Bob","Sam","Tom");

        // Stream of Integer, Long, Double object, not primitive.
        Stream<Integer> streamIntObj = Stream.of(1,2,3);
        Stream<Long> streamLongObj = Stream.of(1L,2L,3L);
        Stream<Double> streamDoubleObj = Stream.of(10.00,2.20,3.20);

        // 1. Empty Stream
        Stream<String> emptyStr = Stream.empty();

        // 2. Stream of Collection
        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();

        List<String> names = Arrays.asList("Bob","Sam","Tom");
        Stream<List<String>>  namesTest = Stream.of(names);
        Stream<String> listOfStr = names.stream();

        Set<Integer> intSet = new HashSet<>(Arrays.asList(1, 4, 8));
        Stream<Integer> intObjStream = intSet.stream();

        // 3. Stream of Array and create a stream out of an existing array or of part of an array:
        String[] strArr = {"Bob","Sam","Tom"};
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> arrOfStream = Stream.of(strArr); // trick?
        Stream<String> streamFromArr = Arrays.stream(strArr);
        Stream<String> streamFromPartArr = Arrays.stream(strArr, 1,2);
        streamFromPartArr.forEach(System.out::println); // sam

        // Stream of Primitives
        IntStream intStream = IntStream.range(1, 3); //  range(int startInclusive, int endExclusive)
        intStream.forEach(System.out::println); // print primitive int
        LongStream longStream = LongStream.rangeClosed(1, 3); // rangeClosed(int startInclusive, int endInclusive)

        // Stream of String
        String s = "String input";
        IntStream streamOfChars = s.chars();
        streamOfChars.forEach(System.out::println);
    }
}
