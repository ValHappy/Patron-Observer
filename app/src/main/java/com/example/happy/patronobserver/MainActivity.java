package com.example.happy.patronobserver;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements DialogoColor.MiListener{

    private ConstraintLayout padre;
    private Button btn_color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        padre = findViewById(R.id.padre);
        btn_color = findViewById(R.id.btn_color);

        btn_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Abrir el dialogo
                DialogoColor dialogoColor = new DialogoColor();
                dialogoColor.setListener(MainActivity.this);
                dialogoColor.show(getSupportFragmentManager(), "miDialogo");

            }
        });
    }


    @Override
    public void onChangeColor(String color) {

        switch (color){
            case "Blanco":
                padre.setBackgroundColor(Color.WHITE);
                break;
            case "Gris":
                padre.setBackgroundColor(Color.GRAY);
                break;
            case "Negro":
                padre.setBackgroundColor(Color.BLACK);
                break;
        }
    }
}
