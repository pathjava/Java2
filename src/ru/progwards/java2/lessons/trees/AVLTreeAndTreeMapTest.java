// Oleg Kiselev
// 13.06.2020, 20:01

package ru.progwards.java2.lessons.trees;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class AVLTreeAndTreeMapTest {
    private final AvlTree<Integer, Integer> avlTreeNumbers = new AvlTree<>();
    private final Map<Integer, Integer> treeMapNumbers = new TreeMap<>();

    private final AvlTree<Integer, String> avlTreeWords = new AvlTree<>();
    private final Map<Integer, String> treeMapWords = new TreeMap<>();

    private final List<Integer> sortedNumbers = new ArrayList<>();
    private final List<Integer> sortedShuffleNumbers = new ArrayList<>();
    private final List<Integer> randomNumbers = new ArrayList<>();
    private final List<Integer> randomShuffleNumbers = new ArrayList<>();
    private final List<String> tokensList = new ArrayList<>();
    private final int COUNT_LOOP = 5;

    public void testing(String tokensFile) {
        fillingData(tokensFile);
        testAddToAvlTreeAndTreeMapSortedNum();
        testAddToAvlTreeAndTreeMapRandomNum();
        testAddToAvlTreeAndTreeMapString();
        testDeleteFromAvlTreeAndTreeMapSortedNum();
        testDeleteFromAvlTreeAndTreeMapRandomNum();
        testFindValueInAvlTreeAndTreeMapSortedNum();
        testFindValueInAvlTreeAndTreeMapRandomNum();
    }

    private void testAddToAvlTreeAndTreeMapSortedNum() {
        List<Long> resultAvl = testAddToAvlTreeSortedNum();
        List<Long> resultMap = testAddToTreeMapSortedNum();
        resultTests(resultAvl, resultMap, "addSort");
    }

    private List<Long> testAddToAvlTreeSortedNum() {
        List<Long> results = new ArrayList<>();
        int count = 0;
        while (count < COUNT_LOOP) {
            long start = System.currentTimeMillis();
            for (int num : sortedNumbers)
                avlTreeNumbers.put(num, num);
            long end = System.currentTimeMillis();
            results.add(end - start);
            avlTreeNumbers.clear();
            count++;
        }
        return results;
    }

    private List<Long> testAddToTreeMapSortedNum() {
        List<Long> results = new ArrayList<>();
        int count = 0;
        while (count < COUNT_LOOP) {
            long start = System.currentTimeMillis();
            for (int num : sortedNumbers)
                treeMapNumbers.put(num, num);
            long end = System.currentTimeMillis();
            results.add(end - start);
            treeMapNumbers.clear();
            count++;
        }
        return results;
    }

    private void testAddToAvlTreeAndTreeMapRandomNum() {
        List<Long> resultAvl = testAddToAvlTreeRandomNum();
        List<Long> resultMap = testAddToTreeMapRandomNum();
        resultTests(resultAvl, resultMap, "addRand");
    }

    private List<Long> testAddToAvlTreeRandomNum() {
        List<Long> results = new ArrayList<>();
        int count = 0;
        while (count < COUNT_LOOP) {
            long start = System.currentTimeMillis();
            for (int num : randomNumbers)
                avlTreeNumbers.put(num, num);
            long end = System.currentTimeMillis();
            results.add(end - start);
            avlTreeNumbers.clear();
            count++;
        }
        return results;
    }

    private List<Long> testAddToTreeMapRandomNum() {
        List<Long> results = new ArrayList<>();
        int count = 0;
        while (count < COUNT_LOOP) {
            long start = System.currentTimeMillis();
            for (int num : randomNumbers)
                treeMapNumbers.put(num, num);
            long end = System.currentTimeMillis();
            results.add(end - start);
            treeMapNumbers.clear();
            count++;
        }
        return results;
    }

    private void testAddToAvlTreeAndTreeMapString() {
        List<Long> resultAvl = testAddToAvlTreeString();
        List<Long> resultMap = testAddToTreeMapString();
        resultTests(resultAvl, resultMap, "addWords");
    }

    private List<Long> testAddToAvlTreeString() {
        List<Long> results = new ArrayList<>();
        int count = 0;
        while (count < COUNT_LOOP) {
            int num = 0;
            long start = System.currentTimeMillis();
            for (String str : tokensList) {
                avlTreeWords.put(num, str);
                num++;
            }
            long end = System.currentTimeMillis();
            results.add(end - start);
            avlTreeWords.clear();
            count++;
        }
        return results;
    }

    private List<Long> testAddToTreeMapString() {
        List<Long> results = new ArrayList<>();
        int count = 0;
        while (count < COUNT_LOOP) {
            int num = 0;
            long start = System.currentTimeMillis();
            for (String str : tokensList) {
                treeMapWords.put(num, str);
                num++;
            }
            long end = System.currentTimeMillis();
            results.add(end - start);
            treeMapWords.clear();
            count++;
        }
        return results;
    }

    private void testDeleteFromAvlTreeAndTreeMapSortedNum() {
        List<Long> resultAvl = testDeleteFromAvlTreeSortedNum();
        List<Long> resultMap = testDeleteFromTreeMapSortedNum();
        resultTests(resultAvl, resultMap, "delSort");
    }

    private List<Long> testDeleteFromAvlTreeSortedNum() {
        List<Long> results = new ArrayList<>();
        int count = 0;
        while (count < COUNT_LOOP) {
            for (int num : sortedNumbers)
                avlTreeNumbers.put(num, num);
            long start = System.currentTimeMillis();
            for (int num : sortedShuffleNumbers)
                avlTreeNumbers.delete(num);
            long end = System.currentTimeMillis();
            results.add(end - start);
            avlTreeNumbers.clear();
            count++;
        }
        return results;
    }

    private List<Long> testDeleteFromTreeMapSortedNum() {
        List<Long> results = new ArrayList<>();
        int count = 0;
        while (count < COUNT_LOOP) {
            for (int num : sortedNumbers)
                treeMapNumbers.put(num, num);
            long start = System.currentTimeMillis();
            for (int num : sortedShuffleNumbers)
                treeMapNumbers.remove(num);
            long end = System.currentTimeMillis();
            results.add(end - start);
            treeMapNumbers.clear();
            count++;
        }
        return results;
    }

    private void testDeleteFromAvlTreeAndTreeMapRandomNum() {
        List<Long> resultAvl = testDeleteFromAvlTreeRandomNum();
        List<Long> resultMap = testDeleteFromTreeMapRandomNum();
        resultTests(resultAvl, resultMap, "delRand");
    }

    private List<Long> testDeleteFromAvlTreeRandomNum() {
        List<Long> results = new ArrayList<>();
        int count = 0;
        while (count < COUNT_LOOP) {
            for (int num : randomNumbers)
                avlTreeNumbers.put(num, num);
            long start = System.currentTimeMillis();
            for (int num : randomShuffleNumbers)
                if (avlTreeNumbers.containsKey(num))
                    avlTreeNumbers.delete(num);
            long end = System.currentTimeMillis();
            results.add(end - start);
            avlTreeNumbers.clear();
            count++;
        }
        return results;
    }

    private List<Long> testDeleteFromTreeMapRandomNum() {
        List<Long> results = new ArrayList<>();
        int count = 0;
        while (count < COUNT_LOOP) {
            for (int num : randomNumbers)
                treeMapNumbers.put(num, num);
            long start = System.currentTimeMillis();
            for (int num : randomShuffleNumbers)
                treeMapNumbers.remove(num);
            long end = System.currentTimeMillis();
            results.add(end - start);
            treeMapNumbers.clear();
            count++;
        }
        return results;
    }

    private void testFindValueInAvlTreeAndTreeMapRandomNum() {
        List<Long> resultAvl = testFindValueInAvlTreeRandomNum();
        List<Long> resultMap = testFindValueInTreeMapRandomNum();
        resultTests(resultAvl, resultMap, "findRand");
    }

    private List<Long> testFindValueInAvlTreeRandomNum() {
        List<Long> results = new ArrayList<>();
        int count = 0;
        while (count < COUNT_LOOP) {
            for (int num : randomNumbers)
                avlTreeNumbers.put(num, num);
            long start = System.currentTimeMillis();
            for (int num : randomShuffleNumbers)
                avlTreeNumbers.find(num);
            long end = System.currentTimeMillis();
            results.add(end - start);
            avlTreeNumbers.clear();
            count++;
        }
        return results;
    }

    private List<Long> testFindValueInTreeMapRandomNum() {
        List<Long> results = new ArrayList<>();
        int count = 0;
        while (count < COUNT_LOOP) {
            for (int num : randomNumbers)
                treeMapNumbers.put(num, num);
            long start = System.currentTimeMillis();
            for (int num : randomShuffleNumbers)
                treeMapNumbers.get(num);
            long end = System.currentTimeMillis();
            results.add(end - start);
            treeMapNumbers.clear();
            count++;
        }
        return results;
    }

    private void testFindValueInAvlTreeAndTreeMapSortedNum() {
        List<Long> resultAvl = testFindValueInAvlTreeSortedNum();
        List<Long> resultMap = testFindValueInTreeMapSortedNum();
        resultTests(resultAvl, resultMap, "findSort");
    }

    private List<Long> testFindValueInAvlTreeSortedNum() {
        List<Long> results = new ArrayList<>();
        int count = 0;
        while (count < COUNT_LOOP) {
            for (int num : sortedNumbers)
                avlTreeNumbers.put(num, num);
            long start = System.currentTimeMillis();
            for (int num : sortedNumbers)
                avlTreeNumbers.find(num);
            long end = System.currentTimeMillis();
            results.add(end - start);
            avlTreeNumbers.clear();
            count++;
        }
        return results;
    }

    private List<Long> testFindValueInTreeMapSortedNum() {
        List<Long> results = new ArrayList<>();
        int count = 0;
        while (count < COUNT_LOOP) {
            for (int num : sortedNumbers)
                treeMapNumbers.put(num, num);
            long start = System.currentTimeMillis();
            for (int num : sortedNumbers)
                treeMapNumbers.get(num);
            long end = System.currentTimeMillis();
            results.add(end - start);
            treeMapNumbers.clear();
            count++;
        }
        return results;
    }

    private void resultTests(List<Long> resAvl, List<Long> resMap, String operation) {
        Collections.sort(resAvl);
        Collections.sort(resMap);

        String str = null;
        if (operation.contains("addSort"))
            str = "Время добавления сортированных чисел в";
        else if (operation.contains("addRand"))
            str = "Время добавления рандомных чисел в";
        else if (operation.contains("addWords"))
            str = "Время добавления слов в";
        else if (operation.contains("delSort"))
            str = "Время удаления сортированных чисел из";
        else if (operation.contains("delRand"))
            str = "Время удаления рандомных чисел из";
        else if (operation.contains("findRand"))
            str = "Время поиска по рандомным ключам в";
        else if (operation.contains("findSort"))
            str = "Время поиска по сортированным ключам в";

        System.out.println("Количество тестовых циклов: " + COUNT_LOOP + "\n");
        System.out.printf("%-39s %-12s %-12s %n", str, "AVL Tree", "TreeMap");
        System.out.printf("%-41s %-12d %d %n", "Минимальное время теста: ", resAvl.get(0), resMap.get(0));
        System.out.printf("%-41s %-12.1f %.1f %n", "Среднее арифметическое время теста: ",
                calculateAverageTestsTime(resAvl), calculateAverageTestsTime(resMap));
        System.out.printf("%-41s %-12d %d %n%n", "Максимальное время теста: ",
                resAvl.get(resAvl.size() - 1), resMap.get(resMap.size() - 1));
    }

    private double calculateAverageTestsTime(List<Long> results) {
        Double sum = 0.0;
        for (Long result : results)
            sum += result;
        return sum / results.size();
    }

    public void fillingData(String tokensFile) {
        IntStream.range(0, 1000000).forEachOrdered(sortedNumbers::add);
        IntStream.range(0, 1000000).map(i -> ThreadLocalRandom.current()
                .nextInt(10, 500000 + 1)).forEachOrdered(randomNumbers::add);
        readFile(tokensFile);
        sortedShuffleNumbers.addAll(sortedNumbers);
        Collections.shuffle(sortedShuffleNumbers);
        randomShuffleNumbers.addAll(randomNumbers);
        Collections.shuffle(randomShuffleNumbers);
    }

    private void readFile(String file) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file)),
                StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s");
                Arrays.stream(words).filter(str -> str.matches("[a-zA-Zа-яёА-ЯЁ]+"))
                        .forEachOrdered(tokensList::add);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        AVLTreeAndTreeMapTest test = new AVLTreeAndTreeMapTest();
        test.testing("C:\\Intellij Idea\\programming\\HelloWorld\\src\\ru\\progwards\\java2\\lessons\\trees\\wiki.train.tokens");
    }
}
