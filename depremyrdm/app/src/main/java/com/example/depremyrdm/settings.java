package com.example.depremyrdm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class settings extends AppCompatActivity {

    private EditText etFirstName, etLastName, etPhoneNumber, etAddress;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);

        etFirstName = findViewById(R.id.adEditText);
        etLastName = findViewById(R.id.soyadEditText);
        etPhoneNumber = findViewById(R.id.telefonEditText);
        etAddress = findViewById(R.id.adresEditText);
        btnSave = findViewById(R.id.kayıtButton);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserInfo();
            }
        });
        Button btnGoruntule = findViewById(R.id.goruntuButton);
        btnGoruntule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showUserInfo();
            }
        });
    }

    private void saveUserInfo() {
        String firstName = etFirstName.getText().toString().trim();
        String lastName = etLastName.getText().toString().trim();
        String phoneNumber = etPhoneNumber.getText().toString().trim();
        String address = etAddress.getText().toString().trim();


        Toast.makeText(this, "Kullanıcı bilgileri kaydedildi!", Toast.LENGTH_SHORT).show();
    }
    private void showUserInfo() {
        String firstName = etFirstName.getText().toString().trim();
        String lastName = etLastName.getText().toString().trim();
        String phoneNumber = etPhoneNumber.getText().toString().trim();
        String address = etAddress.getText().toString().trim();

        String userInfo = "Ad: " + firstName + "\n"
                + "Soyad: " + lastName + "\n"
                + "Telefon: " + phoneNumber + "\n"
                + "Adres: " + address;

        Toast.makeText(this, userInfo, Toast.LENGTH_LONG).show();
    }
}

