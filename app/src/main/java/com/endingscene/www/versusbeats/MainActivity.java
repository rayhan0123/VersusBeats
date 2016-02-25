package com.endingscene.www.versusbeats;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ConnectivityManager cManager=(ConnectivityManager)getSystemService(MainActivity.this.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=cManager.getActiveNetworkInfo();
        if(networkInfo !=null && networkInfo.isConnected()){

            myWebView = (WebView) findViewById(R.id.webMain);
            WebSettings webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.setWebViewClient(new MobWebClient());
            myWebView.loadUrl("http://versusbeats.com/");
                }
        else {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("NO INTERNET !");
            alertDialog.setMessage("Check Internet Connection/ Connect To Internet");
            // Alert dialog button
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Try Again",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Alert dialog action goes here
                            // onClick button code here
                            dialog.dismiss();// use dismiss to cancel alert dialog
                        }
                    });
            alertDialog.show();


        }




    }

    @Override
    public void onBackPressed() {
        if(myWebView.canGoBack())
        {
            myWebView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}
