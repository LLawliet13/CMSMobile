package com.example.cmsmobile.validation;

import com.example.cmsmobile.entity.Account;

public class AccountValidation {
    public static boolean validate(Account account) throws Exception {
        if(account.getUsername().isEmpty())
            throw new Exception("User name is empty");
        return true;
    }
}
