package com.example.prodigy_ad_02;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTask;
    Button btnAdd;
    RecyclerView recyclerView;

    ArrayList<String> tasks;

    TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTask = findViewById(R.id.editTask);
        btnAdd = findViewById(R.id.btnAdd);
        recyclerView = findViewById(R.id.recyclerView);

        tasks = new ArrayList<>();

        adapter = new TaskAdapter(this,tasks);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);

        btnAdd.setOnClickListener(v -> {

            String task =
                    editTask.getText().toString();

            if(!task.isEmpty()){
                tasks.add(task);
                adapter.notifyDataSetChanged();
                editTask.setText("");
            }
        });
    }
}
