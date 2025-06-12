package com.nextgen.data.platform.datafoundation.order_inventory_pract.stream_creation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*Intermediate Operations

        filter(predicate) — filter values

        map(function) — transform values

        flatMap(...) — flatten streams

        distinct() — unique values

        sorted() — sort values

        peek(...) — debug/intermediate action without altering stream
*/
public class IntStreamIntermediateOperations {

    public static void main(String[] args) {

       IntStream distinctVal  =  IntStream.of(2,5,2,7,3,5).distinct(); // 2,5,7,3
       IntStream sortedVal = distinctVal.sorted(); // 2,3,5,7
       int[] value1 = sortedVal.toArray(); // [2,3,5,7]

       IntStream res  = IntStream.rangeClosed(2,10).filter(x -> x % 2 == 0); // 4 6 8 10
       List<Integer> list = res.map(x-> x / 2).boxed().toList(); // [1, 2, 3, 4, 5]

        int firstVal = IntStream.range(2,6).peek(System.out::println).findAny().orElse(0); // 2
        StringBuilder sb = new StringBuilder();

    }
}
