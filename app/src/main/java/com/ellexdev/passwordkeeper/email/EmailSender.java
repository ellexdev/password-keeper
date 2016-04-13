package com.ellexdev.passwordkeeper.email;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.ellexdev.passwordkeeper.model.Password;

/**
 * Created by xander on 13/04/2016.
 */
public class EmailSender {

    public static void sendRemindNotification(Password password, String email, Context context) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        i.putExtra(Intent.EXTRA_SUBJECT, "Password for " + password.getName());
        i.putExtra(Intent.EXTRA_TEXT, buildNotificationBody(password));
        try {
            context.startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private static String buildNotificationBody(Password password) {
        return "Name: " + password.getName() + "\n" + "Login: " + password.getUsername() + "\n" + "Password: " + password.getPassword();
    }

}
