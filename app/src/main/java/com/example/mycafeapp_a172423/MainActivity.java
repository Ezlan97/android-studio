package com.example.mycafeapp_a172423;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnMinus, btnCheckout;
    TextView tvQuantity;
    EditText etName;

    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hook all the variable with the id
        btnAdd = findViewById(R.id.btn_add);
        btnMinus = findViewById(R.id.btn_minus);
        btnCheckout = findViewById(R.id.btn_checkout);

        tvQuantity = findViewById(R.id.tv_quantity);
        etName = findViewById(R.id.et_name);

        quantity = 1;

        //change the value in the quantity
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                tvQuantity.setText(""+quantity);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity--;
                tvQuantity.setText(""+quantity);
            }
        });

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            String name;


            @Override
            public void onClick(View v) {
                name = etName.getText().toString();
                Toast.makeText(MainActivity.this,"Thank you " + name + " for order: " + quantity + " Latte.", Toast.LENGTH_SHORT).show();

                //change page
                Intent intent = new Intent(MainActivity.this, OrderDetailActivity.class);
                //pass data to new page
                intent.putExtra("name", name);
                intent.putExtra("quantity", quantity);
                startActivity(intent);
            }
        });
    }
}
