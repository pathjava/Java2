// Oleg Kiselev
// 24.07.2020, 19:02

// Oleg Kiselev
// 09.07.2020, 12:40

package ru.progwards.java2.lessons.http.auxiliaryfiles;

import ru.progwards.java2.lessons.http.model.Account;
import ru.progwards.java2.lessons.http.service.impl.StoreServiceImpl;

import java.util.Date;

public class AccountsCreatorToMemory implements AccountsCreator {

    /* данный класс и метод созданы только для тестирования функционала */
    @Override
    public void creator() {
        Account account;
        for (int i = 1; i <= 10; i++) {
            account = new Account();
            account.setDate(new Date());
            account.setHolder("Account_" + i);
            account.setPin(i);
            account.setId("" + i);
            account.setAmount(150 * i);
            new StoreServiceImpl().insert(account);
        }
    }

}
