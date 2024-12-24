package com.example.lab3;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.graphics.Color;
import androidx.appcompat.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    String[] food={"Банан", "Яблоко", "Груша"};
    boolean[] food_c={false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.button);
        btn2=findViewById(R.id.button2);
        btn3=findViewById(R.id.button3);
        btn4=findViewById(R.id.button4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Кнопка 1 нажата", Toast.LENGTH_SHORT).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast mytost = Toast.makeText(getApplicationContext(), "Кнопка 2 нажата", Toast.LENGTH_LONG);
                mytost.setGravity(Gravity.TOP,0,0);
                mytost.show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Кнопка 3")
                        .setIcon(R.drawable.test_icon)
                        .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                btn1.setTextColor(Color.RED);
                                btn2.setTextColor(Color.RED);
                                btn3.setTextColor(Color.RED);
                                btn4.setTextColor(Color.RED);
                            }
                        })
                        .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getApplicationContext(), "Вы закрыли окно", Toast.LENGTH_LONG).show();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Что висит, но нельзя скушать?")
                        .setMultiChoiceItems(food, food_c, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                food_c[i]=b;
                            }
                        })
                        .setPositiveButton("Проверить", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (food_c[2] && !food_c[0] && !food_c[1]){
                                    Toast mytost = Toast.makeText(getApplicationContext(), "Верно", Toast.LENGTH_LONG);
                                    mytost.setGravity(Gravity.CENTER,0,0);
                                    mytost.show();
                                }
                                else{
                                    btn1.setVisibility(View.INVISIBLE);
                                    btn2.setVisibility(View.INVISIBLE);
                                    btn3.setVisibility(View.INVISIBLE);
                                    btn4.setVisibility(View.INVISIBLE);
                                }
                            }
                        })
                        .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .setCancelable(false);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}