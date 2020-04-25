package com.nurma.myretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nurma.myretrofit.api.models.Post;
import com.nurma.myretrofit.api.services.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpdateActivity extends AppCompatActivity {
    private EditText upt_nim,upt_nama,upt_alamat,upt_jk,upt_nomor;
    private Button btnUbah;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        upt_nim = findViewById(R.id.upt_nim);
        upt_nama = findViewById(R.id.upt_nama);
        upt_alamat = findViewById(R.id.upt_alamat);
        upt_jk = findViewById(R.id.upt_jk);
        upt_nomor=findViewById(R.id.upt_nomor);
        btnUbah=findViewById(R.id.btnUbah);

        Intent mIntent = getIntent();
        upt_nim.setText(mIntent.getStringExtra("Nim"));
        upt_nim.setTag(upt_nim.getKeyListener());
        upt_nim.setKeyListener(null);
        upt_nama.setText(mIntent.getStringExtra("Nama"));
        upt_alamat.setText(mIntent.getStringExtra("Alamat"));
        upt_jk.setText(mIntent.getStringExtra("JK"));
        upt_nomor.setText(mIntent.getStringExtra("Telepon"));

        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nim = upt_nim.getText().toString().trim();
                String nama = upt_nama.getText().toString().trim();
                String alamat = upt_alamat.getText().toString().trim();
                String jk = upt_jk.getText().toString().trim();
                String telepon =  upt_nomor.getText().toString().trim();

                Retrofit retrofit;
                retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.105:8080/retrofit/api/").addConverterFactory(GsonConverterFactory.create()).build();
                ApiInterface apiInterface = retrofit.create(ApiInterface.class);
                Call<Post> call = apiInterface.updatePost(nim,nama,alamat,jk,telepon);
                call.enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(UpdateActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(UpdateActivity.this,MainActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                        Toast.makeText(UpdateActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
