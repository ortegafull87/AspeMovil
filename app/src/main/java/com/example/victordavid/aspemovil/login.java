package com.example.victordavid.aspemovil;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.victordavid.aspemovil.DAO.DBHelper;
import com.example.victordavid.aspemovil.Util.Utils;

public class login extends AppCompatActivity {

    private Utils utils = new Utils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        setContentView(R.layout.activity_login);
    }

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;

    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validatePassword(String password) {
        return password.length() > 5;
    }

    public void onClick(View v) {
        new Utils().hideKeyboard();
        TextInputLayout usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);

        String username = usernameWrapper.getEditText().getText().toString();
        String password = passwordWrapper.getEditText().getText().toString();
        if (!validateEmail(username)) {
            usernameWrapper.setError("Not a valid email address!");
        } else if (!validatePassword(password)) {
            passwordWrapper.setError("Not a valid password!");
        } else {
            usernameWrapper.setErrorEnabled(false);
            passwordWrapper.setErrorEnabled(false);
            doLogin();
        }
    }

    public void doLogin() {
        utils.showMessage(getApplicationContext(),"Bienvenido");
        // TODO: login procedure; not within the scope of this tutorial.
        Intent intent = new Intent(this,Home.class);
        startActivity(intent);
    }
}
