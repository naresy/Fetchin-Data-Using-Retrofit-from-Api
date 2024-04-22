package com.example.app.activity;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.app.R;
import com.example.app.adapter.Adapter;
import com.example.app.model.Contact;
import com.example.app.retrofit.ApiClient;
import com.example.app.retrofit.ApiInterface;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<Contact> contacts;
    private Adapter adapter;
    private ApiInterface apiInterface;
    ProgressBar progressBar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.prograss);
        recyclerView = findViewById(R.id.recycleview);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);

        // Create a custom SpanSizeLookup where the first item spans both columns
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position == 3 ? 1 : 1;
            }
        });
        recyclerView.setLayoutManager(layoutManager);

  fetchContact("users","");
        //
    }


        public void fetchContact (String type, String key){

            apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

            Call<List<Contact>> call = apiInterface.getContact(type, key);
            call.enqueue(new Callback<List<Contact>>() {
                @Override
                public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                    progressBar.setVisibility(View.GONE);

                    contacts = response.body();
                    adapter = new Adapter(contacts, MainActivity.this);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<List<Contact>> call, Throwable t) {
                    progressBar.setVisibility(View.GONE);

                    Toast.makeText(MainActivity.this, "Seems Your connection too poor swipe the screen\n", Toast.LENGTH_LONG).show();
                }
            });
        }
    }


