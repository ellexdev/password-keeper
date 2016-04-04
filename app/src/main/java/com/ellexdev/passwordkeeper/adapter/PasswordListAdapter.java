package com.ellexdev.passwordkeeper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ellexdev.passwordkeeper.R;
import com.ellexdev.passwordkeeper.model.Password;

import java.util.List;

/**
 * Created by xander on 04/04/2016.
 */
public class PasswordListAdapter extends BaseAdapter {

    private Context context;
    private List<Password> passwordList;

    public PasswordListAdapter(Context context, List<Password> passwordList) {
        this.context = context;
        this.passwordList = passwordList;
    }

    @Override
    public int getCount() {
        return passwordList != null ? passwordList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return passwordList.get(position);
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
        Password password = (Password) getItem(position);
        TextView itemText = (TextView) convertView.findViewById(R.id.list_text);
        itemText.setText(password.getName());
        return convertView;
    }
}
