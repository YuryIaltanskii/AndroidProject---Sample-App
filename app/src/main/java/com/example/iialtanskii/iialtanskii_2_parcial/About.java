package com.example.iialtanskii.iialtanskii_2_parcial;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class About extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tab,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_about:
                Intent aboutIntent = new Intent().setClass(About.this, About.class);
                startActivity(aboutIntent);
                return true;
            case R.id.action_settings:
                Intent dbIntent = new Intent().setClass(About.this, Options.class);
                startActivity(dbIntent);
                return true;
            case R.id.action_login:
                SharedPreferences prefs = getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
                String user = prefs.getString("user", "");
                AlertDialog alertDialog = new AlertDialog.Builder(About.this).create();
                alertDialog.setTitle("Login Info");
                alertDialog.setMessage("Logged in as: " + user);
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
