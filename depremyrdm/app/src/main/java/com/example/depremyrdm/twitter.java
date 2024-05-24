package com.example.depremyrdm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class twitter extends AppCompatActivity {

    private static final String TWITTER_PACKAGE_NAME = "com.twitter.android";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton tweetButton = findViewById(R.id.twit2);
        tweetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTwitterInstalled()) {
                    tweet();
                } else {
                    Toast.makeText(twitter.this, "Twitter uygulaması yüklü değil.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isTwitterInstalled() {
        try {
            getPackageManager().getPackageInfo(TWITTER_PACKAGE_NAME, 0);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void tweet() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String tweetText = "ENKAZ ALTINDAYIM, KORDİNATLARIM: 40.9192, 29.1517 #deprem !";
        String tweetUrl = "https://twitter.com/intent/tweet?text=" + Uri.encode(tweetText);
        intent.setData(Uri.parse(tweetUrl));
        startActivity(intent);
    }
}
