// Oleg Kiselev
// 04.06.2020, 18:22

// Oleg Kiselev
// 03.06.2020, 12:27

package ru.progwards.java2.lessons.reflection.testfiles;

public class Person {

    private static String name;
    private int age;
    private String city;
    protected final double height = 1.80;
    public boolean lock = true;

    private enum Days {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}

    public Person(int age, String city, boolean lock) {
        this.age = age;
        this.city = city;
        this.lock = lock;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Person.name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getHeight() {
        return height;
    }

    private static void testMethod() {

    }
}
