package ru.job4j.collection.bank;

import java.util.*;

public class BankService {

    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        Optional.ofNullable(findByPassport(passport))
        .flatMap(user -> Optional.ofNullable(users.get(user)))
        .ifPresent(x -> x.add(account));
    }

    public User findByPassport(String passport) {
        return users.keySet().stream()
               .filter(x -> x.getPassport().equals(passport))
               .findFirst().orElse(null);
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
      Optional<User> user =  Optional.ofNullable(findByPassport(passport));
      Optional<Account> result = Optional.empty();
      if (user.isPresent()) {
          List<Account> temp = users.get(user.get());
           result = Optional.of(temp.stream()
                   .filter(x -> x.getRequisite().equals(requisite))
                   .findFirst().get());
      }
       return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = true;
        Optional<Account> src = ((findByRequisite(srcPassport, srcRequisite)));
        Optional<Account> dest = ((findByRequisite(destPassport, destRequisite)));
        if (!src.isPresent() || src.get().getBalance() < amount || !dest.isPresent()) {
            rsl = false;
        } else {
            double temp = dest.get().getBalance();
            dest.get().setBalance(temp + amount);
            double temp2 = src.get().getBalance();
            src.get().setBalance(temp2 - amount);
        }
        return rsl;
    }
}
