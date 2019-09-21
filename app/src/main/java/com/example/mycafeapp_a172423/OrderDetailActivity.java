package com.example.mycafeapp_a172423;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class OrderDetailActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton imgBtnDial, imgBtnBrowser, imgBtnMail;
    TextView tvName, tvItem;
    String name;
    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        imgBtnDial = findViewById(R.id. img_btn_dialer);
        imgBtnBrowser = findViewById(R.id. img_btn_web);
        imgBtnMail = findViewById(R.id. img_btn_mail);

        tvName = findViewById(R.id. tv_name);
        tvItem = findViewById(R.id. tv_item);

        //retrieve the passed data
        Intent intent = getIntent();
        quantity = intent.getIntExtra("quantity", 0);
        name = intent.getStringExtra("name");

        //set value for text view
        tvName.setText(name);
        tvItem.setText(quantity + " latte");

        imgBtnMail.setOnClickListener(this);
        imgBtnDial.setOnClickListener(this);
        imgBtnBrowser.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            //check by id
            case R. id. img_btn_dialer:
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel: 01133274736"));

                //check if there any app that can handle this operation
                if(callIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(callIntent);
                } else {
                    Toast.makeText(OrderDetailActivity.this, "Sorry no app can handle this action.", Toast.LENGTH_SHORT).show();
                }

                break;
            case R. id. img_btn_mail:
                Intent mailIntent = new Intent(Intent.ACTION_SEND);
                mailIntent.setType("text/plain");
                mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your order from myCafeApp");
                mailIntent.putExtra(Intent.EXTRA_TEXT, "Information about your order.");
                mailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"eizs798@gmail.com"});
                if(mailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mailIntent);
                } else {
                    Toast.makeText(OrderDetailActivity.this, "Sorry no app can handle this action.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R. id. img_btn_web:
                Uri webpage = Uri.parse("https://google.com");
                Intent webintent = new Intent(Intent.ACTION_VIEW, webpage);

                if(webintent.resolveActivity(getPackageManager()) != null) {
                    startActivity(webintent);
                } else {
                    Toast.makeText(OrderDetailActivity.this, "Sorry no app can handle this action.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
