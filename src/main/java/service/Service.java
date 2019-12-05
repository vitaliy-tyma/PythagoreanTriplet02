package service;

import java.math.BigDecimal;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class Service {
    /**
     * Find Pythogorean triplet
     * <p>
     * Pythogorean triplet (a, b, c) is defined by the equation a2 + b2 = c2.
     *
     * int[] input = new int[] {1,3,56,8,0,2,3,64,12,44,21,1, 9};
     * Result is [5] items:
     * [[1 5 12], [1 12 6], [2 5 13], [4 5 8], [5 7 13]]
     *
     * @param input - int []
     */
    public void start(int[] input) {
        System.out.println("Start");
        int inputLength = input.length;
        System.out.println("Input:");
        printArrayWith2spaces(input);
        printIndexesWith2spaces(input);

        List<resultIndexesTriplet> result = new LinkedList<>();

        Map<Integer, Integer> worker1 = fillWorkerMap(input);


        for (int i = 0; i < inputLength; i++) {
            Integer value1 = input[i];

            for (int j = i+1; j < inputLength; j++) {
                Integer value2 = input[j];

                BigDecimal value3 = BigDecimal.valueOf((value1*value1 + value2*value2)^(1/2));
                int value3integer = value3.intValue();

                if (!Integer.toString(value3integer).equals(value3.toString())){
                    System.out.println("ERROR FOUND [" + value3 + " != " + value3integer + "]");
                }

                if (worker1.containsKey(value3integer)) {
                    int index3 = worker1.get(value3integer);
                    if (index3 != j) {
                        result.add(new resultIndexesTriplet(i + 1, j + 1, index3 + 1));
                    }
                }

            }


        }


        System.out.println("\nResult is [" + result.size() + "] items:");
        System.out.println(result.toString());
        System.out.println("Stop");
    }

    private Map<Integer, Integer> fillWorkerMap(int[] input) {
        Map<Integer, Integer> worker1 = new LinkedHashMap<>(input.length);
        for (int i1 : input) {
            worker1.put(i1, 0);
        }
        return worker1;
    }

    private void printIndexesWith2spaces(int[] input) {
        System.out.print("[");
        for (int i = 1; i <= input.length; i++){
            int digitsCount = Integer.toString(input[i-1]).length();

            while (--digitsCount > 0){
                System.out.print(" ");
            }
            System.out.print(String.format("%2s,",i));
        }
        System.out.print("]");
        System.out.println();

    }

    private void printArrayWith2spaces(int[] input) {
        System.out.print("[");
        for (int i = 1; i <= input.length; i++){
            int digitsCount = Integer.toString(input[i-1]).length();

            while (--digitsCount > 0){
                System.out.print(" ");
            }
            System.out.print(String.format("%2s,",input[i-1]));
        }
        System.out.print("]");
        System.out.println();
    }

    /**
     * Class for three items
     */
    class resultIndexesTriplet {
        int[] resultIndexesTriplet = new int[3];

        resultIndexesTriplet(int i1, int i2, int i3){
            resultIndexesTriplet[0] = i1;
            resultIndexesTriplet[1] = i2;
            resultIndexesTriplet[2] = i3;
        }

        @Override
        public String toString() {
            return "[" +resultIndexesTriplet[0] + " " +
                    resultIndexesTriplet[1] + " " +
                    resultIndexesTriplet[2] + "]";
        }
    }
}
