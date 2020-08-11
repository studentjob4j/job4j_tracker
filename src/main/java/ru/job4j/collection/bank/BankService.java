package ru.job4j.collection.bank;

import java.util.*;

public class BankService {

    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
               User user = findByPassport(passport) ;
               if (user != null) {
                   List<Account> list = users.get(user);
                   if (!list.contains(account)) {
                       list.add(account);
                   }
               }
    }

    public User findByPassport(String passport) {
        User result = null;
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                result = key;
                break;
            }

        }
        return result;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
                User user = findByPassport(passport);
                if (user != null) {
                    List<Account> temp = users.get(user);
                    for (Account account : temp) {
                        if (account.getRequisite().equals(requisite)) {
                            result = account;
                            break;
                        }
                    }
                }


        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dеstRequisite, double amount) {
        boolean rsl = true;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, dеstRequisite);
        if ((src == null || src.getBalance() < amount) || dest != null) {
            rsl = false;
        } else {
            double temp = dest.getBalance();
            dest.setBalance(temp + amount);
            double temp2 = src.getBalance();
            src.setBalance(temp2 - amount);
        }

        return rsl;
    }
}
