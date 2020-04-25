package com.nurma.myretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nurma.myretrofit.adapter.MahasiswaAdapter;
import com.nurma.myretrofit.api.models.Post;
import com.nurma.myretrofit.api.services.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Post> mahasiswaList;
    private MahasiswaAdapter mahasiswaAdapter;
    ApiInterface apiInterface;
    FloatingActionButton add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvMahasiswa);
        add = findViewById(R.id.btn_add);
        mahasiswaList = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mahasiswaAdapter = new MahasiswaAdapter(getApplicationContext(),mahasiswaList);
        recyclerView.setAdapter(mahasiswaAdapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,kirimActivity.class);
                startActivity(intent);
            }
        });

        Retrofit retrofit;
        retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.105:8080/retrofit/api/").addConverterFactory(GsonConverterFactory.create()).build();
        apiInterface = retrofit.create(ApiInterface.class);
        Call<List<Post>> call = apiInterface.getSemuaMahasiswa();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
               mahasiswaList = response.body();
               mahasiswaAdapter.setMahasiswaList(mahasiswaList);
                }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();
            }
        });
    }

}

