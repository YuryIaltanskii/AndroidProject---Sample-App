package com.example.iialtanskii.iialtanskii_2_parcial;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.Marker;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import static java.security.AccessController.getContext;

public class TabActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    Session session = null;
    ProgressDialog pdialog = null;
    Context context = null;
    EditText sub, msg;
    String subject, textMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.country_image);
        tabLayout.getTabAt(1).setIcon(R.drawable.map_image);
        tabLayout.getTabAt(2).setIcon(R.drawable.yellow_pages);
        tabLayout.getTabAt(3).setIcon(R.drawable.contacts_image);
    }

    public void onClick(View v) {

        context = this;

        Button login = (Button) findViewById(R.id.btn_submit);
        sub = (EditText) findViewById(R.id.et_sub);
        msg = (EditText) findViewById(R.id.et_text);

        login.setOnClickListener(this);

        //rec = reciep.getText().toString();
        subject = sub.getText().toString();
        textMessage = msg.getText().toString();

        // Setear las propiedades de conexión
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        // Crear una sesión nueva usando las credenciales proporcionadas por el usuario
        session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("grezmind@gmail.com", "Argentum9");
            }
        });

        pdialog = ProgressDialog.show(context, "", "Sending Mail...", true);

        RetreiveFeedTask task = new RetreiveFeedTask();
        task.execute(); // Ejecutar el RetrieveFeedTask (la operación corre en el background)
    }

    // RetrieveFeedTask - Crear y enviar el email. AsyncTask - hacer la operación en el Background
    class RetreiveFeedTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            try{
                Message message = new MimeMessage(session);
                //message.setFrom(new InternetAddress("grezmind@gmail.com")); // Comentar esta linea para permitir a la app usar cualquier gmail
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("grezmind@gmail.com"));
                message.setSubject(subject);
                message.setContent(textMessage, "text/html; charset=utf-8");
                Transport.send(message);
            } catch(MessagingException e) {
                e.printStackTrace();
            } catch(Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        // Mostrar mensaje después de la ejecución exitosa y limpiar los campos de entrada
        @Override
        protected void onPostExecute(String result) {
            pdialog.dismiss();
            msg.setText("");
            sub.setText("");
            Toast.makeText(getApplicationContext(), "Message sent", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.action_about:
                Intent aboutIntent = new Intent().setClass(TabActivity.this, About.class);
                startActivity(aboutIntent);
                return true;
            case R.id.action_settings:
                Intent dbIntent = new Intent().setClass(TabActivity.this, Options.class);
                startActivity(dbIntent);
                return true;
            case R.id.action_login:
                SharedPreferences prefs = getSharedPreferences("sharedPref",Context.MODE_PRIVATE);
                String user = prefs.getString("user", "");
                AlertDialog alertDialog = new AlertDialog.Builder(TabActivity.this).create();
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

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Tab1Country tab1 = new Tab1Country();
                    return tab1;
                case 1:
                    Tab2Map tab2 = new Tab2Map();
                    return tab2;
                case 2:
                    Tab4YellowPages tab4 = new Tab4YellowPages();
                    return tab4;
                case 3:
                    Tab3ContactUs tab3 = new Tab3ContactUs();
                    return tab3;
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "About Sydney";
                case 1:
                    return "Map";
                case 2:
                    return "Yellow Pages";
                case 3:
                    return "Contact Us";
            }
            return null;
        }
    }
}