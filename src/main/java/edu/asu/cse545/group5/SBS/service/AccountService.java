package edu.asu.cse545.group5.SBS.service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.asu.cse545.group5.SBS.model.Account;
import edu.asu.cse545.group5.SBS.repo.AccountRepo;

@Service
public class AccountService {
    private final AccountRepo accountRepo;

    @Autowired
    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public Account addAccount(Account account) {
        account.setAccountNum(generatePrimaryKey());
        return accountRepo.save(account);
    }

    public long generatePrimaryKey() {
        long key = ThreadLocalRandom.current().nextLong(1000000000L, 10000000000L);
        while (isPrimaryKeyAvailable(key) == false) {
            key = ThreadLocalRandom.current().nextLong(1000000000L, 10000000000L);
        }
        return key;
    }

    public boolean isPrimaryKeyAvailable(long primaryKey) {
        Optional<Account> account = accountRepo.findAccountByAccountNum(primaryKey);
        boolean isKeyAvailable = !(account.isPresent());
        if (isKeyAvailable) {
            return true;
        } else {
            return false;
        }
    }
    
}
