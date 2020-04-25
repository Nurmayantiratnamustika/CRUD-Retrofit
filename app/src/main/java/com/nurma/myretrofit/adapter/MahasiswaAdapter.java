package com.nurma.myretrofit.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nurma.myretrofit.R;
import com.nurma.myretrofit.UpdateActivity;
import com.nurma.myretrofit.api.models.Post;

import java.util.ArrayList;
import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.ViewHolder> {

    List<Post> mahasiswaList;
    Context mContext;

    public MahasiswaAdapter(Context context, List<Post> mahasiswaList){
        this.mContext = context;
        this.mahasiswaList = mahasiswaList;
    }

    @NonNull
    @Override
    public MahasiswaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mahasiswa, parent, false);
        return new ViewHolder(itemView);
    }

    public void setMahasiswaList(List<Post> mahasiswaList){
        this.mahasiswaList=mahasiswaList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaAdapter.ViewHolder holder, int position) {
        final Post itemMahasiswa = mahasiswaList.get(position);
        holder.tvNama.setText(itemMahasiswa.getNama());
        holder.tvNim.setText(itemMahasiswa.getNim());
        holder.tvAlamat.setText(itemMahasiswa.getAlamat());
        holder.tvJenisKelamin.setText(itemMahasiswa.getJeniskelamin());
        holder.tvTelepon.setText(itemMahasiswa.getTelepon());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), UpdateActivity.class);
                mIntent.putExtra("Nim", mahasiswaList.get(position).getNim());
                mIntent.putExtra("Nama", mahasiswaList.get(position).getNama());
                mIntent.putExtra("Alamat", mahasiswaList.get(position).getAlamat());
                mIntent.putExtra("JK",mahasiswaList.get(position).getJeniskelamin());
                mIntent.putExtra("Telepon",mahasiswaList.get(position).getTelepon());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mahasiswaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama;
        TextView tvNim;
        TextView tvAlamat;
        TextView tvJenisKelamin;
        TextView tvTelepon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNim= itemView.findViewById(R.id.tvNim);
            tvAlamat=itemView.findViewById(R.id.tvAlamat);
            tvJenisKelamin=itemView.findViewById(R.id.tvJenisKelamin);
            tvTelepon=itemView.findViewById(R.id.tvTelepon);

        }
    }
}
