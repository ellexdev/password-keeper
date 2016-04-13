package com.ellexdev.passwordkeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xander on 13/04/2016.
 */
public class EditAccountActivity extends AppCompatActivity {

    @Bind(R.id.account_name)
    public EditText accountNameInput;

    @Bind(R.id.account_type)
    public AppCompatSpinner accountTypeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);

    }

}
