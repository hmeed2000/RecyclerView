package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
 private RecyclerView recyclerView;
 private FloatingActionButton floatingActionButton;
 private Toolbar toolbar;
private CarRVAdapter adapter;
public DatabaseAccess db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       toolbar = findViewById(R.id.A_M_toolbar);
        setSupportActionBar(toolbar);
     recyclerView = findViewById(R.id.A_M_RV);
      floatingActionButton = findViewById(R.id.A_M_floating);

//
     db =  DatabaseAccess.getInstance(this);
       db.open();
//     ArrayList<Car> cars = db.getALLCars();
//    db.close();
//       adapter = new CarRVAdapter(cars);


       recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager lm = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(lm);
        recyclerView.setHasFixedSize(true);

   }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.main_search).getActionView();
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
