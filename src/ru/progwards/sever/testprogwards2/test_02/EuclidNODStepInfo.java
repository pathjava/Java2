// Oleg Kiselev
// 07.05.2020, 12:51

package ru.progwards.sever.testprogwards2.test_02;

public class EuclidNODStepInfo {
    static int nod(int x, int y) {
        System.out.println("прямой ход, x = " + x + ", y = " + y);
        int result = 0;
        if (x == y)
            result = x;
        else
            result = x > y ? nod(x - y, y) : nod(x, y - x);
        System.out.println("обратный ход, x = " + x + ", y = " + y);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(nod(12, 53));
    }
}
