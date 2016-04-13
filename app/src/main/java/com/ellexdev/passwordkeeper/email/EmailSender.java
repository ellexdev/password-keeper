package com.ellexdev.passwordkeeper.email;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.ellexdev.passwordkeeper.model.Account;

/**
 * Created by xander on 13/04/2016.
 */
public class EmailSender {

    public static void sendRemindNotification(Account account, String email, Context context) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        i.putExtra(Intent.EXTRA_SUBJECT, "Account for " + account.getName());
        i.putExtra(Intent.EXTRA_TEXT, buildNotificationBody(account));
        try {
            context.startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private static String buildNotificationBody(Account account) {
        return "Name: " + account.getName() + "\n" + "Login: " + account.getLogin() + "\n" + "Password: " + account.getPassword();
    }

}
