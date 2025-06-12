package com.nextgen.data.platform.datafoundation.order_inventory_pract.stream_creation;

/* 1. convert a primitive stream (like IntStream, LongStream, DoubleStream)
        back to various types, including collections, arrays, and objects.
   2. Get a primitive value from primitive stream
*/

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStreamToObj {

    static class Student{
        private int age;
        private String name;

        Student(int age) {
            this.age = age;
            this.name = "Custom Name"+age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        // To Array
        int[] arr = IntStream.rangeClosed(1,7).toArray(); // output: [1, 2, 3, 4, 5, 6, 7]

        // To Collection
        List<Integer> list = IntStream.of(20,40, 30).boxed().toList();
        Set<Integer> set = IntStream.of(90, 10, 100).boxed().collect(Collectors.toSet());
        Map<Integer, Integer> map = IntStream.of(20, 500, 1).boxed()
                .collect(Collectors.toMap(x->x, x-> (x+ "").length()));
         // output: {1=1, 20=2, 500=3}

        // Custom object
        IntStream ids = IntStream.of(1, 5,8);
        IntStream idList = IntStream.of(3, 5,6);
        List<Student> studentList = ids.mapToObj(Student::new).toList();
        // output: [Student{age=1, name='Custom Name1'}, Student{age=5, name='Custom Name5'}, Student{age=8, name='Custom Name8'}]

        Map<Integer, String> studentMap = idList.mapToObj(Student::new).collect(Collectors.toMap(Student::getAge, Student::getName));
        // output: {3=Custom Name3, 5=Custom Name5, 6=Custom Name6}

        /* ************************************** Get a primitive value from primitive stream ****************************************** */

        // reduce(),sum,count
        int total = IntStream.rangeClosed(8,10).sum();
        long TotalCount = IntStream.of(8,10,11).count();
        int totalMulti = IntStream.rangeClosed(2,7).reduce(1, (a,b) -> a*b);


        // To Summary Statistics
        IntStream input = IntStream.of(1, 40, 60);
        IntStream input2 = IntStream.of(1, 4, 6);
        IntStream input3 = IntStream.of(1, 10, 100);
        IntSummaryStatistics summary = input.summaryStatistics();
        int maxV  = summary.getMax(); // return primitive value
        int minV  = summary.getMin();
        long countInt = input2.count();
        int sum = input3.sum();

        // To Optional or Single Value -->> max(),min(), average(), findFirst(),findAny();

        OptionalDouble valOptional = IntStream.of(1, 4, 6).average(); // To Optional
        double avgValue = valOptional.isPresent() ? valOptional.getAsDouble() : 0.0; // Single Value

        OptionalLong optVal = LongStream.rangeClosed(8L, 12L).findFirst(); // To Optional
        long priLong = optVal.orElse(0L); // Single Value

        int anyVal = IntStream.of(27,34, 60).findAny().orElse(0);
        int minVal = IntStream.of(1, 40, 16).min().orElseGet(() -> 0);
        int maxVal = IntStream.of(1, 60, 16).min().orElseThrow(() -> new RuntimeException(" No value found"));

        /* Common terminal operations on Optional / OptionalInt:
            get() / getAsInt()/ getAsDouble()/ getAsLong()

            orElse(default)

            orElseGet(Supplier)

            orElseThrow()

            ifPresent(Consumer)

        */

    }
}
