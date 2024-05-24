package com.example.depremyrdm;
import android.location.Location;
import android.Manifest;
import android.content.pm.PackageManager;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.media.AudioManager;
import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private static final int SMS_PERMISSION_REQUEST_CODE = 1;
    private static final String[] PHONE_NUMBERS = {"5551234567", "5559876543", "5557891234"};
    private static final String SMS_TEXT = "ENKAZ ALTINDAYIM, KORDİNATLARIM: 40.9192, 29.1517";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton btnPlaySound = findViewById(R.id.soundd);
        mediaPlayer = MediaPlayer.create(this, R.raw.danger);

        // Sesin yüksek sesli çalması için
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        if (audioManager != null) {
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
        }
        btnPlaySound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });

        ImageButton haritagecisButton = findViewById(R.id.haritagecisButton);
        ImageButton sendButton = findViewById(R.id.mesaj);
        haritagecisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton ayarButton = findViewById(R.id.ayar);
        ayarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // settings aktivitesini başlat
                Intent intent = new Intent(MainActivity.this, settings.class);
                startActivity(intent);
            }
        });



        sendButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if (checkPermission()) {
                   sendSMS();
               } else {
                   requestPermission();
               }
           }
        });

    }

    private boolean checkPermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
        return permissionCheck == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, SMS_PERMISSION_REQUEST_CODE);
    }

    private void sendSMS() {
        SmsManager smsManager = SmsManager.getDefault();
        for (String phoneNumber : PHONE_NUMBERS) {
            smsManager.sendTextMessage(phoneNumber, null, SMS_TEXT, null, null);
        }
        Toast.makeText(this, "SMS gönderildi.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == SMS_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                sendSMS();
            } else {
                Toast.makeText(this, "SMS izni reddedildi.", Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // MediaPlayer nesnesini serbest bırakmak icin
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}