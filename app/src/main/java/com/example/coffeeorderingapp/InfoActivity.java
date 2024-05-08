package com.example.coffeeorderingapp;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InfoActivity extends AppCompatActivity {

    ImageView imageView;
    ImageButton plusQuantity, minusQuantity;
    TextView quantityNumber, drinkName, coffeePrice;
    CheckBox addToppings, addExtraCream;
    Button addToCart;
    int quantity;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imageView = findViewById(R.id.imageViewInfo);
        plusQuantity = findViewById(R.id.addQuantity);
        minusQuantity = findViewById(R.id.subQuantity);
        quantityNumber = findViewById(R.id.quantity);
        drinkName = findViewById(R.id.drinkNameInInfo);
        coffeePrice = findViewById(R.id.coffeePrice);
        addToppings = findViewById(R.id.addToppings);
        addExtraCream = findViewById(R.id.addCream);
        addToCart = findViewById(R.id.addToCart);

        drinkName.setText("Green Tea");

        plusQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                displayQunatity();
            }
        });

        minusQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantity == 0){
                    Toast.makeText(InfoActivity.this, "Invalid Quantity", Toast.LENGTH_LONG).show();
                }
                else{
                    quantity--;
                    displayQunatity();
                }
            }
        });
    }

    private void displayQunatity(){
        quantityNumber.setText(String.valueOf(quantity));
    }
}