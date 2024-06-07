package com.nextin.sqlitedatabaseapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.nextin.sqlitedatabaseapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    TextView tvName , tvId , tvEmail, tvPhone ;
    ActivityMainBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tvId = findViewById(R.id.tvId);
        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);

        try (MyDbHelper helperClass = new MyDbHelper(this)) {

//            helperClass.addData("kshitij","kshitij@gmail.com",945632102);
//            helperClass.addData("ram","ram@gmail.com",945639102);
//            helperClass.addData("om","om@gmail.com",366874521);
//            helperClass.addData("veer","veer@gmail.com",658741260);
//            helperClass.addData("rahul","rahul@gmail.com",945632102);
//            helperClass.addData("raj","raj@gmail.com",569874123);
//            helperClass.addData("radha","radha@gmail.com",945632102);
//            helperClass.addData("rishi","rishi@gmail.com",945632102);
//            helperClass.addData("kavi","kavi@gmail.com",852147306);
//            helperClass.addData("pooja","pooja@gmail.com",741203698);


            ArrayList<ContactList> arrContacts = helperClass.fetchData();


            for (int i = 0; i < arrContacts.size(); i++) {

                Log.i("Contact List" ,"id :" +arrContacts.get(i).id+ ", name " +

                        ":"+arrContacts.get(i).name+" , email :"+arrContacts.get(i).email+ " , phone : "+arrContacts.get(i).phone_no);

            }


        }
    }

}