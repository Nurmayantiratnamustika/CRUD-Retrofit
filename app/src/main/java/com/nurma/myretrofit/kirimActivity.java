package com.nurma.myretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nurma.myretrofit.api.models.Post;
import com.nurma.myretrofit.api.services.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class kirimActivity extends AppCompatActivity {
    private EditText edt_nim,edt_nama,edt_alamat,edt_jk,edt_nomor;
    private Button btnProses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kirim);
        edt_nim = findViewById(R.id.edt_nim);
        edt_nama = findViewById(R.id.edt_nama);
        edt_alamat = findViewById(R.id.edt_alamat);
        edt_jk = findViewById(R.id.edt_jk);
        edt_nomor = findViewById(R.id.edt_nomor);
        btnProses=findViewById(R.id.btnProses);
        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nim = edt_nim.getText().toString().trim();
                String nama = edt_nama.getText().toString().trim();
                String alamat = edt_alamat.getText().toString().trim();
                String jk = edt_jk.getText().toString().trim();
                String nomor = edt_nomor.getText().toString().trim();

                Retrofit retrofit;
                retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.105:8080/retrofit/api/").addConverterFactory(GsonConverterFactory.create()).build();
                ApiInterface apiInterface = retrofit.create(ApiInterface.class);
                Call<Post> call = apiInterface.createPost(nim,nama,alamat,jk,nomor);
                call.enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(kirimActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(kirimActivity.this,MainActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                        Toast.makeText(kirimActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
