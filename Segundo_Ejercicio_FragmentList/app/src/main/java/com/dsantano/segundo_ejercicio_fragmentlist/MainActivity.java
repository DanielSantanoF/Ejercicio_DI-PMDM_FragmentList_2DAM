package com.dsantano.segundo_ejercicio_fragmentlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dsantano.segundo_ejercicio_fragmentlist.models.AmazonProduct;
import com.dsantano.segundo_ejercicio_fragmentlist.models.IAmazonProductListener;

public class MainActivity extends AppCompatActivity implements IAmazonProductListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onAmazonItemClick(AmazonProduct a) {

    }
}
