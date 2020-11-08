// Oleg Kiselev
// 13.05.2020, 15:35

package ru.progwards.java2.lessons.generics;

import java.util.Arrays;
import java.util.Objects;

public class DynamicArray<T> {

    private T[] arr;

    public DynamicArray() {
    }

    private int realSize() {
        return (int) Arrays.stream(arr).filter(Objects::nonNull).count();
    }

    private void add(T element) {
        if (arr.length == realSize()) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[realSize()] = element;
    }

    private void insert(int pos, T element) {
        if (pos < 0 || pos > arr.length - 1)
            return;

        if (arr.length == realSize()) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }

        T[] tempArr = Arrays.copyOfRange(arr, pos, arr.length);

        arr[pos] = element;

        int index = 0;
        for (int i = pos + 1; i < arr.length; i++) {
            arr[i] = tempArr[index];
            index++;
        }
    }

    private void remove(int pos) {
        if (pos < 0 || pos > arr.length - 1)
            return;

        T[] tempArr = Arrays.copyOfRange(arr, pos + 1, arr.length);
        arr = Arrays.copyOf(arr, arr.length - 1);

        int index = 0;
        for (int i = pos; i < arr.length; i++) {
            arr[i] = tempArr[index];
            index++;
        }
    }

    private void get(int pos) {
        if (pos < 0 || pos > arr.length - 1)
            return;

        System.out.println(arr[pos]);
    }

    private void size() {
        System.out.println(realSize());
    }


    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.arr = new Integer[]{5, 1, 14, 34, 22, 3, 1, 3, 100, 17};

        /*
         * со строками работает, только в тестовых методах надо к i + "строка"
         * */
//        DynamicArray<String> dynamicArray = new DynamicArray<>();
//        dynamicArray.arr = new String[]{"Михаил", "Алексей", "Сергей", "Игорь", "Даша", "Лена", "Bill", "Mike", "Alex"};

        for (int i = 1; i <= 15; i++) {
            dynamicArray.add(i * 2);
        }

        for (int i = 1; i < 10; i += 2) {
            dynamicArray.insert(i + 3, i + 50);
        }

        for (int i = 0; i < 10; i += 3) {
            dynamicArray.remove(4 + i);
        }

        dynamicArray.get(5);

        dynamicArray.size();

        System.out.println(Arrays.toString(dynamicArray.arr));
    }
}
