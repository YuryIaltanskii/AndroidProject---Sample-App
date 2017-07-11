package com.example.iialtanskii.iialtanskii_2_parcial;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.Preference.OnPreferenceChangeListener;
import android.support.v4.content.IntentCompat;
import android.view.MenuItem;
import android.widget.Toast;

public class Options extends PreferenceActivity {
    public static final int RESULT_CODE_THEME_UPDATED = 1;
    ListPreference itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /*SharedPreferences prefs = getSharedPreferences("sharedPref",Context.MODE_PRIVATE);
        String themeName = prefs.getString("themeName", "Blue");
        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("pref_syncConnectionType", "Blue").apply();
        if (themeName.equals("Default")) {
            setTheme(R.style.AppTheme);
        } else if (themeName.equals("Red")) {
            Toast.makeText(this, "set theme", Toast.LENGTH_SHORT).show();
            setTheme(R.style.RedTheme);
        } else if (themeName.equals("Green")) {
            Toast.makeText(this, "set theme", Toast.LENGTH_SHORT).show();
            setTheme(R.style.GreenTheme);
        } else if (themeName.equals("Blue")) {
            Toast.makeText(this, "set theme", Toast.LENGTH_SHORT).show();
            setTheme(R.style.BlueTheme);

        }
        Toast.makeText(this, "Theme has been reset to " + themeName,
        Toast.LENGTH_SHORT).show();*/

        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        itemList = (ListPreference) findPreference("pref_color");

        itemList.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                String[] text = getResources().getStringArray(R.array.color_values);
                if (preference.getKey().equals("Default")) {
                    setTheme(R.style.AppTheme);
                } else if (preference.getKey().equals("Red")) {
                    setTheme(R.style.RedTheme);
                } else if (preference.getKey().equals("Green")) {
                    setTheme(R.style.GreenTheme);
                } else if (preference.getKey().equals("Blue")) {
                    setTheme(R.style.BlueTheme);
                }
                return true;
            }
        });

        itemList.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                Toast.makeText(getApplicationContext(), "toast", Toast.LENGTH_SHORT).show();
                System.out.println("Toasted");
                return false;
            }
        });
    }

    public static class SetFrag extends PreferenceFragment {
        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }

    public class RefershActivityOnPreferenceChangeListener implements OnPreferenceChangeListener {
        private final int resultCode;
        public RefershActivityOnPreferenceChangeListener(int resultCode) {
            this.resultCode = resultCode;
        }

        @Override
        public boolean onPreferenceChange(Preference p, Object newValue) {
            setResult(resultCode);
            return true;
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

        }
        return super.onOptionsItemSelected(item);
    }
}
