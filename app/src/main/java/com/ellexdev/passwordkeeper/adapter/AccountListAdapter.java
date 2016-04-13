package com.ellexdev.passwordkeeper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ellexdev.passwordkeeper.R;
import com.ellexdev.passwordkeeper.model.Account;

import java.util.List;

/**
 * Created by xander on 04/04/2016.
 */
public class AccountListAdapter extends BaseAdapter {

    private Context context;
    private List<Account> accountList;

    public AccountListAdapter(Context context, List<Account> accountList) {
        this.context = context;
        this.accountList = accountList;
    }

    @Override
    public int getCount() {
        return accountList != null ? accountList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return accountList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
        }
        Account account = (Account) getItem(position);
        TextView itemText = (TextView) convertView.findViewById(R.id.list_text);
        itemText.setText(account.getName());
        return convertView;
    }

    public List<Account> getAccountList() {
        return accountList;
    }
}
