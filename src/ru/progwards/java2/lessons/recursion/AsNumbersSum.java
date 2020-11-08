// Oleg Kiselev
// 08.05.2020, 15:16

package ru.progwards.java2.lessons.recursion;

import java.util.*;
import java.util.stream.IntStream;

public class AsNumbersSum {
    private static final List<String> list = new ArrayList<>();

    public static String asNumbersSumTwo(int number, String str) {
        int result = 0;
//        System.out.println(number + str);
        list.add(number + str);

        if (number <= 1) {
            result = 1;
        } else {
            for (int i = 1; i < number / 2 + 1; i++) {
                asNumbersSumTwo(number - i, "-" + i + str);
            }
        }
        return String.valueOf(result);
    }

    private static final Map<String, String> sortedMap = new TreeMap<>(Collections.reverseOrder());

    public static void sortNumber() {
        for (String s : list) {
            int[] numArr = Arrays.stream(s.split("-")).sorted(Comparator.reverseOrder()).mapToInt(Integer::parseInt).toArray();

            StringBuilder str = new StringBuilder();
            IntStream.range(0, numArr.length).forEachOrdered(i -> {
                str.append(numArr[i]).append(i == numArr.length - 1 ? "" : "+");
            });
            sortedMap.put(str.toString(), str.toString());
        }

        int count = 0;
        for (String value : sortedMap.values()) {
            System.out.print(count != sortedMap.size() - 1 ? value + " = " : value);
            count++;
        }
    }


    public static void main(String[] args) {
//        asNumbersSum(5);

        asNumbersSumTwo(5, "");

//        list.forEach(System.out::println);

//        System.out.println("---------------------");

        sortNumber();

//        sortedMap.forEach((k,v) -> System.out.println(v));
    }


    /* Реализовать класс, AsNumbersSum, содержащий метод
     * public static String asNumbersSum(int number), который раскладывает параметр number,
     * как всевозможные уникальные комбинации сумм натуральных чисел, например:
     * 5 = 4+1 = 3+2 = 3+1+1 = 2+2+1 = 2+1+1+1 = 1+1+1+1+1

     * Строка должна содержать результат, отформатированный точно, как указано в примере.
     * Повторные комбинации не допускаются, например, если а строке уже есть 3+2, то 2+3 там быть не должно.
     * Задача должна быть решена методом рекурсии, циклы использовать запрещено.
     */

    // https://overcoder.net/q/698976/%D0%B4%D0%BB%D1%8F-%D0%B7%D0%B0%D0%B4%D0%B0%D0%BD%D0%BD%D0%BE%D0%B3%D0%BE-%D1%86%D0%B5%D0%BB%D0%BE%D0%B3%D0%BE-%D1%87%D0%B8%D1%81%D0%BB%D0%B0-a-%D0%BD%D0%B0%D0%B9%D0%B4%D0%B8%D1%82%D0%B5-%D0%B2%D1%81%D0%B5-%D1%83%D0%BD%D0%B8%D0%BA%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D0%B5-%D0%BA%D0%BE%D0%BC%D0%B1%D0%B8%D0%BD%D0%B0%D1%86%D0%B8%D0%B8-%D0%BD%D0%B0%D1%82%D1%83%D1%80%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D1%85
}
