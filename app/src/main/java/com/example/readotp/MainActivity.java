package com.example.readotp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.readotp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        requestSMSPermission();
        new OTP_RECEIVER().setEditText(binding.optEdt);

    }

    private void requestSMSPermission() {
        String permission= Manifest.permission.RECEIVE_SMS;
        int grant= ContextCompat.checkSelfPermission(this,permission);
        if (grant!= PackageManager.PERMISSION_GRANTED){
            String[] permission_list=new String[1];
            permission_list[0]=permission;

            ActivityCompat.requestPermissions(this,permission_list,1);

        }
    }
}