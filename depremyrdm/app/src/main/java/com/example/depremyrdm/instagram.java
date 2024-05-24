package com.example.depremyrdm;
import com.facebook.FacebookSdk;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class instagram extends AppCompatActivity {
    private static final String INSTAGRAM_PACKAGE_NAME = "com.instagram.android";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hikaye paylaşma butonuna tıklanıldığında
        findViewById(R.id.insta).setOnClickListener(view -> {
            // Instagram uygulamasının yüklü olup olmadığını kontrol et
            if (isInstagramInstalled()) {
                // Hikaye paylaşma intenti
                Intent intent = new Intent("com.instagram.share.ADD_TO_STORY");
                intent.setDataAndType(Uri.parse("image/*"), null);
                Resources res = getResources();
                int drawableId = res.getIdentifier("instamesaj", "drawable", getPackageName());
                Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getPackageName() + "/drawable/instamesaj");
                intent.putExtra(Intent.EXTRA_STREAM, imageUri);

                // Instagram uygulamasını başlat
                intent.setPackage(INSTAGRAM_PACKAGE_NAME);
                startActivityForResult(intent, 0);
            } else {
                // Instagram yüklü değilse kullanıcıya bildir
                Toast.makeText(instagram.this, "Instagram uygulaması yüklü değil.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isInstagramInstalled() {
        PackageManager pm = getPackageManager();
        try {
            pm.getPackageInfo(INSTAGRAM_PACKAGE_NAME, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
