package com.nextin.sqlitedatabaseapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try (MyDbHelper helperClass = new MyDbHelper(this)){

            helperClass.addData("kshitij","kshitij@gmail.com",945632102);
            helperClass.addData("ram","ram@gmail.com",945639102);
            helperClass.addData("om","om@gmail.com",366874521);
            helperClass.addData("veer","veer@gmail.com",658741260);
            helperClass.addData("rahul","rahul@gmail.com",945632102);
            helperClass.addData("raj","raj@gmail.com",569874123);
            helperClass.addData("radha","radha@gmail.com",945632102);
            helperClass.addData("rishi","rishi@gmail.com",945632102);
            helperClass.addData("kavi","kavi@gmail.com",852147306);
            helperClass.addData("pooja","pooja@gmail.com",741203698);

        }
    }
}