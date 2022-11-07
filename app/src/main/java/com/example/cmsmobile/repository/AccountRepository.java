package com.example.cmsmobile.repository;

import android.content.Context;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.cmsmobile.dao.AccountDAO;
import com.example.cmsmobile.dao.RoleDAO;
import com.example.cmsmobile.entity.Account;
import com.example.cmsmobile.entity.CMSDatabase;
import com.example.cmsmobile.entity.Role;

import java.util.List;

public class AccountRepository {
    private AccountDAO accountDAO;

    public AccountRepository(Context context) {
        accountDAO = CMSDatabase.getInstance(context).accountDAO();
    }

    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public void addAccount(Account account){
        accountDAO.insert(account);
    }
//    public void execute(){
//        accountDAO.insert(new Account(5, "Namprodz123@gmail.com", "namnguyen123", "namprodz123", "HN", "0982231418", 2, 6));
//    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public Account getAccountByEmail(String email) throws Exception {
        return accountDAO.findByEmail(email).orElseThrow(()->
             new Exception("No Account Found")
        );
    }
    public List<Account> getAllAccounts(){
        return accountDAO.getAll();
    }

    public void updateAccount(Account account){
        accountDAO.updateAccount(account);
    }
    public Account Login(String email, String password){
        List<Account> accountList = accountDAO.getAll();
        for (Account acc : accountList) {
            if(acc.getEmail().equals(email) && acc.getPassword().equals(password)){
                return acc;
            }
            
        }
        return null;
    }
}
