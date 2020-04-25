package com.nurma.myretrofit.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Post {
    @SerializedName("nim")
    private String nim;

    @SerializedName("nama")
    private  String nama;

    @SerializedName("alamat")
    private  String alamat;

    @SerializedName("jeniskelamin")
    private String jeniskelamin;

    @SerializedName("telepon")
    private String telepon;

    public Post(String nim, String nama, String alamat, String jeniskelamin, String telepon) {
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
        this.jeniskelamin = jeniskelamin;
        this.telepon = telepon;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }

    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
}
