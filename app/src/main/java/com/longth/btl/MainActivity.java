package com.longth.btl;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.longth.btl.models.Model;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        ArrayList<Model> models = new ArrayList<>();
        RecyclerAdapter adapter = new RecyclerAdapter(models);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        EditText text1 = (EditText) findViewById(R.id.input_1);
        EditText text2 = (EditText) findViewById(R.id.input_2);
//        RadioGroup gender = (RadioGroup) findViewById(R.id.radio_group);
        Button buttonSubmit = (Button) findViewById(R.id.button_submit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                RadioButton selectedGender = (RadioButton) findViewById(gender.getCheckedRadioButtonId());
                models.add(new Model(text1.getText().toString(), text2.getText().toString()));
                adapter.notifyDataSetChanged();
            }
        });
    }
}