// Oleg Kiselev
// 13.05.2020, 20:17

package ru.progwards.java2.lessons.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FruitBox<T extends Fruit> extends ArrayList<T> implements Comparable<FruitBox<T>> {

    private void addFruit(List<T> list) {
        addAll(list);
    }

    private double getWeight() {
        return stream().mapToDouble(Fruit::getWeight).sum();
    }

    private void moveTo(FruitBox<T> box) {
        if (box.isEmpty() || this.isEmpty())
            return;

        box.addAll(this);

        clear();
    }

    private int comparisonFruitBoxes(FruitBox<?> box) {
        int result = this.compareTo(box);
        return Integer.compare(result, 0);
    }

    @Override
    public int compareTo(FruitBox fruit) {
        /* данный способ кастит до int, поэтому возможны неточности сравнения */
//        return (int) (this.getWeight() - fruit.getWeight());

        if (this.getWeight() < fruit.getWeight())
            return -1;
        else if (fruit.getWeight() < this.getWeight())
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        Apple applesOne = new Apple(1.0);
        Apple applesTwo = new Apple(1.0);
        Orange orangesOne = new Orange(1.5);
        Orange orangesTwo = new Orange(1.5);


        FruitBox<Apple> fruitBoxOne = new FruitBox<>();
        IntStream.range(0, 3).mapToObj(i -> List.of(applesOne, applesTwo)).forEach(fruitBoxOne::addFruit);

        FruitBox<Apple> fruitBoxThree = new FruitBox<>();
        for (int i = 0; i < 2; i++)
            fruitBoxThree.addFruit(List.of(applesOne, applesTwo));

        FruitBox<Orange> fruitBoxTwo = new FruitBox<>();
        for (int i = 0; i < 3; i++)
            fruitBoxTwo.addFruit(List.of(orangesOne, orangesTwo));

        FruitBox<Orange> fruitBoxFour = new FruitBox<>();
        for (int i = 0; i < 2; i++)
            fruitBoxFour.addFruit(List.of(orangesOne, orangesTwo));

        System.out.println(fruitBoxOne.comparisonFruitBoxes(fruitBoxTwo));
        System.out.println("-----------------");

        fruitBoxOne.moveTo(fruitBoxThree);
        fruitBoxThree.forEach(System.out::println);
        System.out.println("-----------------");

        fruitBoxOne.forEach(System.out::println);
        System.out.println(fruitBoxOne.getWeight());
        System.out.println("-----------------");
        fruitBoxThree.forEach(System.out::println);
        System.out.println(fruitBoxThree.getWeight());
        System.out.println("-----------------");
        fruitBoxTwo.forEach(System.out::println);
        System.out.println(fruitBoxTwo.getWeight());
        System.out.println("-----------------");
        fruitBoxFour.forEach(System.out::println);
        System.out.println(fruitBoxFour.getWeight());
        System.out.println("-----------------");


    }
}
