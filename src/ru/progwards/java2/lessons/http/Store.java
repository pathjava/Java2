

package ru.progwards.java2.lessons.http;


import ru.progwards.java2.lessons.http.model.Account;

import java.util.*;

public class Store {

    private static final Map<String, Account> store = new HashMap<>();

    static {
        for (int i = 0; i < 10; i++) {
            Account acc = new Account();
            Random random = new Random();
            String id = "" + i; //TODO - генерируем id от 0 до 9 для тестирования
//            String id = UUID.randomUUID().toString();
            acc.setId(id);
            acc.setPin(1000 + i);
            acc.setHolder("Account_" + i);
            acc.setDate(new Date(System.currentTimeMillis() + 365 * 24 * 3600 * 1000));
            acc.setAmount(Math.random() * 1_000_000);

            store.put(acc.getId(), acc);
        }
    }

    public static Map<String, Account> getStore() {
        return store;
    }
}
