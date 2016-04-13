package com.ellexdev.passwordkeeper.model;

/**
 * Created by xander on 04/04/2016.
 */
public class Account {

    private int id;
    private String name;
    private AccountType accountType;
    private String login;
    private String password;
    private boolean loginWithEmail;
    private Account emailAccount;

    public Account() {
    }

    public Account(AccountType accountType) {
        this.accountType = accountType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoginWithEmail() {
        return loginWithEmail;
    }

    public void setLoginWithEmail(boolean loginWithEmail) {
        this.loginWithEmail = loginWithEmail;
    }

    public Account getEmailAccount() {
        return emailAccount;
    }

    public void setEmailAccount(Account emailAccount) {
        this.emailAccount = emailAccount;
    }
}
