package com.nextgen.data.platform.datafoundation.order_inventory_pract.stream_creation;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


// https://www.baeldung.com/java-stream-of-and-intstream-range
// https://neesri.medium.com/primitive-type-in-stream-java-8-fb587f5c1e5b

   /*
   ## Creating a primitive stream from
      1. Collection. 2. IntStream.range(1, 5). 3. IntStream.rangeClosed(1, 5). 4. IntStream.of()
      5. Array
   ## Converting a primitive stream back to a collection or array[toArray]:
   ## Performing operations on a primitive stream
   ## when to use mapToObj? or mapToInt, mapToLong, or mapToDouble?
   */
/*Practice :: converting user IDs to database user objects(https://chatgpt.com/share/6835464c-934c-800d-aa74-cb589aff9b30)
*
* */

public class CreatingPrimitiveStream {
    public static void main(String[] args) {
        // ## Common Ways to Create Primitive Streams in Java 8

        // Static factory methods --> range() , rangeClose(), of(), empty()
        IntStream.rangeClosed(1, 5);
        IntStream.range(1, 5);
        IntStream.of(10,2, 4,70); // IntStream with random numbers
        IntStream.empty();

        // 1. From Array to IntStream
        int[] arr = new int[]{1,2,4};
        IntStream arrSt = Arrays.stream(arr);

        // 2. From Collection
        List<Integer> list = Arrays.asList(1, 3 , 5);
        IntStream fromCollection = list.stream().mapToInt(Integer::intValue);


        // ## Converting Stream<T> into primitive stream [mapToInt, mapToLong, or mapToDouble]
        IntStream fromList = list.stream().mapToInt(Integer::intValue);

        List<Long> listLong = Arrays.asList(1L, 3L , 5L);
        LongStream fromLongList = listLong.stream().mapToLong(Long::longValue);

        // ## Converting primitive stream into a object stream
        IntStream nums = IntStream.rangeClosed(1, 5);
        Stream<String> str = nums.mapToObj( i-> "Number "+ i);
         // str.forEach(System.out::println);

        IntStream arrInt = Arrays.stream(arr);
        Stream<Integer> streamOfInteger = arrInt.boxed();

    }
}

/*
Note:
   1. String[] strA = {"a", "b"};
   Stream<String>  st = Arrays.stream(strA);
   ***** no no ****
   2. Stream<Integer> intSm = Arrays.stream(arr);

   3. List<int[]> list = Arrays.asList(arr);

   4. Integer::intValue --> return int value from wrapper integer
      -- Integer val = Integer,valueOf(10);
          int intVal = val.intValue()

   5. Wrapper object map into corresponding primitive type
      -- mapToInt, mapToLong, or mapToDouble

   6. return optional --> average,min , max

   Use mapToObj() When:
        You have a primitive stream like IntStream, LongStream, or DoubleStream.

        You want to map each primitive value to an object.

        You want to transform values into strings, custom objects, etc.

    7. IllegalStateException -> stream already being used

*/
