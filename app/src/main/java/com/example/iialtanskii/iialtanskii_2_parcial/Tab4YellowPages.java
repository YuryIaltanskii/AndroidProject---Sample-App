package com.example.iialtanskii.iialtanskii_2_parcial;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Tab4YellowPages extends Fragment{

    private ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab4yellowpages, container, false);
        return rootView;

    }

    public void onActivityCreated(Bundle savedInstance){
        super.onActivityCreated(savedInstance);
        listView = (ListView) getActivity().findViewById(android.R.id.list);
        Resources res = getResources();
        String [] cities = res.getStringArray(R.array.Pages);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, cities);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView< ?> arg0, View arg1, int arg2,long arg3) {

                switch(arg2) {
                    case 0:
                        final TextView url1 = new TextView(getContext());
                        final SpannableString s =
                                new SpannableString(getContext().getText(R.string.url1));
                        Linkify.addLinks(s, Linkify.WEB_URLS);
                        url1.setText(s);
                        url1.setMovementMethod(LinkMovementMethod.getInstance());

                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                        String phone = "Phone: 61 2 9241 2277";
                        String address = "Address: 1 Macquarie Pl, Sydney NSW 2000";
                        String hours = "Working hours: 7AM - 10PM";
                        alertDialog.setTitle("Info");
                        alertDialog.setView(url1);
                        alertDialog.setMessage(phone +"\n"+ address +"\n"+ hours +"\n");
                        alertDialog.show();
                        return;
                    case 1:
                        final TextView url2 = new TextView(getContext());
                        final SpannableString s1 =
                                new SpannableString(getContext().getText(R.string.url2));
                        Linkify.addLinks(s1, Linkify.WEB_URLS);
                        url2.setText(s1);
                        url2.setMovementMethod(LinkMovementMethod.getInstance());

                        AlertDialog.Builder alertDialog1 = new AlertDialog.Builder(getContext());
                        String phone1 = "Phone: 61 2 9251 5192";
                        String address1 = "Address: Customs House, 31 Alfred St, Sydney NSW 2000";
                        String hours1 = "Working hours: 12 - 3PM";
                        alertDialog1.setTitle("Info");
                        alertDialog1.setView(url2);
                        alertDialog1.setMessage(phone1 +"\n"+ address1 +"\n"+ hours1 +"\n");
                        alertDialog1.show();
                        return;
                    case 2:
                        final TextView url3 = new TextView(getContext());
                        final SpannableString s2 =
                                new SpannableString(getContext().getText(R.string.url3));
                        Linkify.addLinks(s2, Linkify.WEB_URLS);
                        url3.setText(s2);
                        url3.setMovementMethod(LinkMovementMethod.getInstance());

                        AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(getContext());
                        String phone2 = "Phone: 61 2 9251 5988";
                        String address2 = "Address: Phillip St and Bridge Street, Sydney NSW 2000";
                        String hours2 = "Working hours: 10AM - 5PM";
                        alertDialog2.setTitle("Info");
                        alertDialog2.setView(url3);
                        alertDialog2.setMessage(phone2 +"\n"+ address2 +"\n"+ hours2 +"\n");
                        alertDialog2.show();
                        return;
                    case 3:
                        final TextView url4 = new TextView(getContext());
                        final SpannableString s3 =
                                new SpannableString(getContext().getText(R.string.url4));
                        Linkify.addLinks(s3, Linkify.WEB_URLS);
                        url4.setText(s3);
                        url4.setMovementMethod(LinkMovementMethod.getInstance());

                        AlertDialog.Builder alertDialog3 = new AlertDialog.Builder(getContext());
                        String phone3 = "Phone: 61 2 9252 1144";
                        String address3 = "Address: Albert St and Phillip St, Sydney NSW 2000";
                        String hours3 = "Working hours: 10AM - 5PM";
                        alertDialog3.setTitle("Info");
                        alertDialog3.setView(url4);
                        alertDialog3.setMessage(phone3 +"\n"+ address3 +"\n"+ hours3 +"\n");
                        alertDialog3.show();
                        return;
                    case 4:
                        final TextView url5 = new TextView(getContext());
                        final SpannableString s4 =
                                new SpannableString(getContext().getText(R.string.url5));
                        Linkify.addLinks(s4, Linkify.WEB_URLS);
                        url5.setText(s4);
                        url5.setMovementMethod(LinkMovementMethod.getInstance());

                        AlertDialog.Builder alertDialog4 = new AlertDialog.Builder(getContext());
                        String phone4 = "Phone: 61 2 9259 7000";
                        String address4 = "Address: 30 Pitt St, Sydney NSW 2000";
                        String hours4 = "Working hours: 24Hs";
                        alertDialog4.setTitle("Info");
                        alertDialog4.setView(url5);
                        alertDialog4.setMessage(phone4 +"\n"+ address4 +"\n"+ hours4 +"\n");
                        alertDialog4.show();
                        return;
                    case 5:
                        final TextView url6 = new TextView(getContext());
                        final SpannableString s5 =
                                new SpannableString(getContext().getText(R.string.url6));
                        Linkify.addLinks(s5, Linkify.WEB_URLS);
                        url6.setText(s5);
                        url6.setMovementMethod(LinkMovementMethod.getInstance());

                        AlertDialog.Builder alertDialog5 = new AlertDialog.Builder(getContext());
                        String phone5 = "Phone: 61 2 9253 90002";
                        String address5 = "117 Macquarie St, Sydney NSW 2000";
                        String hours5 = "Working hours: 24Hs";
                        alertDialog5.setTitle("Info");
                        alertDialog5.setView(url6);
                        alertDialog5.setMessage(phone5 +"\n"+ address5 +"\n"+ hours5 +"\n");
                        alertDialog5.show();
                        return;

                }



            };
        });
    }
}
