package com.zolve.demo.voca.service;

import com.zolve.demo.voca.exception.VocaException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VocaService {

    private static Map<String,Integer> wallets = new HashMap<>();
    private static Map<String, List<String>> transactionLog = new HashMap<>();
    private static final int minimumBalance = 5000;

    public void createWallet(String phoneNumber) throws VocaException {
        if(!wallets.containsKey(phoneNumber))
            wallets.put(phoneNumber, minimumBalance);
        else
            throw new VocaException("The wallet already exists for this user");
    }

    public int getBalance(String phoneNumber) throws VocaException {
        if(wallets.containsKey(phoneNumber))
            return wallets.get(phoneNumber);
        else
            throw new VocaException("The wallet for this user doesn't exist");
    }

    public void credit(String phoneNumber, int amount) throws VocaException {
        if(wallets.containsKey(phoneNumber)) {
            wallets.put(phoneNumber, wallets.get(phoneNumber)+amount);
            List<String> logs = transactionLog.get(phoneNumber);
            logs.add("Your wallet is credited with Rs. "+amount);
            transactionLog.put(phoneNumber, logs);
        } else
            throw new VocaException("The wallet for this user doesn't exist");
    }

    public void debit(String phoneNumber, int amount) throws VocaException {
        synchronized (this) {
            if (wallets.containsKey(phoneNumber)) {
                if (wallets.get(phoneNumber) - amount >= minimumBalance) {
                    wallets.put(phoneNumber, wallets.get(phoneNumber) - amount);
                    List<String> logs = transactionLog.get(phoneNumber);
                    logs.add("Your wallet is debited with Rs. "+amount);
                    transactionLog.put(phoneNumber, logs);
                } else {
                    throw new VocaException("The user with wallet " + phoneNumber + " doesn't have enough balance");
                }
            } else
                throw new VocaException("The wallet for this user doesn't exist");
        }
    }

}
