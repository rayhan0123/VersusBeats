package com.endingscene.www.versusbeats;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Sabbir on 25-Feb-16.
 */
public class MobWebClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (Uri.parse(url).getHost().endsWith("versusbeats.com")) {
            return false;
        }

        Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(in);
        return true;
    }
}
