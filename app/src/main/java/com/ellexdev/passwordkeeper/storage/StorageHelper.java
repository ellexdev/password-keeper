package com.ellexdev.passwordkeeper.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.ellexdev.passwordkeeper.model.Account;
import com.ellexdev.passwordkeeper.model.AccountType;
import com.ellexdev.passwordkeeper.model.Settings;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xander on 13/04/2016.
 */
public class StorageHelper {

    private final static String NAME_PREFIX = "pk_storage_";
    private final static String NAME_VERSION = "1";

    private final static String KEY_ACCOUNTS = "accounts";
    private final static String KEY_ACCOUNTS_COUNT = "accounts_count";
    private final static String KEY_SETTINGS = "settings";

    private SharedPreferences sharedPreferences;

    public StorageHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(NAME_PREFIX + NAME_VERSION, Context.MODE_PRIVATE);
    }

    public int accountsCount() {
        return sharedPreferences.getInt(KEY_ACCOUNTS_COUNT, 0);
    }

    public void saveAccounts(List<Account> accounts) {
        storeAccounts(accounts);
    }

    public List<Account> listAccounts() {
        return loadAccounts();
    }

    public List<Account> listAccounts(final AccountType accountType) {
        return filterAccounts(new AccountFilter() {
            @Override
            public boolean isSuitable(Account account) {
                return account.getAccountType() == accountType;
            }
        });
    }

    public List<Account> searchAccounts(final String name) {
        return filterAccounts(new AccountFilter() {
            @Override
            public boolean isSuitable(Account account) {
                return account.getName().toLowerCase().contains(name.toLowerCase());
            }
        });
    }

    public void saveSettings(Settings settings) {
        storeSettings(settings);
    }

    public Settings getSettings() {
        return loadSettings();
    }



    private List<Account> filterAccounts(AccountFilter accountFilter) {
        List<Account> accounts = loadAccounts();
        List<Account> filteredAccounts = new ArrayList<>();
        for (Account account : accounts) {
            if (accountFilter.isSuitable(account)) {
                filteredAccounts.add(account);
            }
        }
        return filteredAccounts;
    }

    private List<Account> loadAccounts() {
        String accountsJson = sharedPreferences.getString(KEY_ACCOUNTS, null);
        if (accountsJson != null) {
            Gson gson = new Gson();
            return gson.fromJson(accountsJson, new TypeToken<ArrayList<Account>>(){}.getType());
        }
        return new ArrayList<>();
    }

    private boolean storeAccounts(List<Account> accounts) {
        if (accounts != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String accountsJson = gson.toJson(accounts);
            editor.putString(KEY_ACCOUNTS, accountsJson);
            editor.putInt(KEY_ACCOUNTS_COUNT, accounts.size());
            editor.apply();
            return true;
        }
        return false;
    }

    private Settings loadSettings() {
        String settingsJson = sharedPreferences.getString(KEY_SETTINGS, null);
        if (settingsJson != null) {
            Gson gson = new Gson();
            return gson.fromJson(settingsJson, Settings.class);
        }
        return null;
    }

    private boolean storeSettings(Settings settings) {
        if (settings != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String settingsJson = gson.toJson(settings);
            editor.putString(KEY_SETTINGS, settingsJson);
            editor.apply();
            return true;
        }
        return false;
    }

    private interface AccountFilter {

        boolean isSuitable(Account account);

    }

}
