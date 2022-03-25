package com.example.demoapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Class> list;
    private ClassAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        buildRecyclerView();
    }

    private void buildRecyclerView() {
        list = new ArrayList<>();

        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "24", "USA"));
        students.add(new Student("Peter", "27", "Canada"));

        List<Student> students1 = new ArrayList<>();
        students1.add(new Student("Andy", "21", "Indian"));
        students1.add(new Student("Bob", "23", "Russian"));
        students1.add(new Student("Okao", "20", "Japan"));

        list.add(new Class("Class 1", students));
        list.add(new Class("Class 2", students1));

        adapter = new ClassAdapter(list, this);
        LinearLayoutManager manager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
}