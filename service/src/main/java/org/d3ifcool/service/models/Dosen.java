package org.d3ifcool.service.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * Finpro
 * Copyright (C) 24/12/2018.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Line     : bullbee117
 * Phone    : 081357108568
 * Majors   : D3 Teknik Informatika 2016
 * Campus   : Telkom University
 * -----------------------------------------
 * id.amirisback.frogobox
 */
public class Dosen implements Parcelable {
    @Expose
    @SerializedName("dsn_nip")
    private String dsn_nip;

    @Expose
    @SerializedName("dsn_nama")
    private String dsn_nama;

    @Expose
    @SerializedName("dsn_kode")
    private String dsn_kode;

    @Expose
    @SerializedName("dsn_kontak")
    private String dsn_kontak;

    @Expose
    @SerializedName("dsn_foto")
    private String dsn_foto;

    @Expose
    @SerializedName("dsn_email")
    private String dsn_email;

    @Expose
    @SerializedName("dsn_status")
    private String dsn_status;

    @Expose
    @SerializedName("username")
    private String username;

    public Dosen(String dsn_nip, String dsn_nama, String dsn_kode, String dsn_kontak, String dsn_foto, String dsn_email, String dsn_status, String username) {
        this.dsn_nip = dsn_nip;
        this.dsn_nama = dsn_nama;
        this.dsn_kode = dsn_kode;
        this.dsn_kontak = dsn_kontak;
        this.dsn_foto = dsn_foto;
        this.dsn_email = dsn_email;
        this.dsn_status = dsn_status;
        this.username = username;
    }

    public String getDsn_nip() {
        return dsn_nip;
    }

    public void setDsn_nip(String dsn_nip) {
        this.dsn_nip = dsn_nip;
    }

    public String getDsn_nama() {
        return dsn_nama;
    }

    public void setDsn_nama(String dsn_nama) {
        this.dsn_nama = dsn_nama;
    }

    public String getDsn_kode() {
        return dsn_kode;
    }

    public void setDsn_kode(String dsn_kode) {
        this.dsn_kode = dsn_kode;
    }

    public String getDsn_kontak() {
        return dsn_kontak;
    }

    public void setDsn_kontak(String dsn_kontak) {
        this.dsn_kontak = dsn_kontak;
    }

    public String getDsn_foto() {
        return dsn_foto;
    }

    public void setDsn_foto(String dsn_foto) {
        this.dsn_foto = dsn_foto;
    }

    public String getDsn_email() {
        return dsn_email;
    }

    public void setDsn_email(String dsn_email) {
        this.dsn_email = dsn_email;
    }

    public String getDsn_status() {
        return dsn_status;
    }

    public void setDsn_status(String dsn_status) {
        this.dsn_status = dsn_status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.dsn_nip);
        dest.writeString(this.dsn_nama);
        dest.writeString(this.dsn_kode);
        dest.writeString(this.dsn_kontak);
        dest.writeString(this.dsn_foto);
        dest.writeString(this.dsn_email);
        dest.writeString(this.dsn_status);
        dest.writeString(this.username);
    }

    protected Dosen(Parcel in) {
        this.dsn_nip = in.readString();
        this.dsn_nama = in.readString();
        this.dsn_kode = in.readString();
        this.dsn_kontak = in.readString();
        this.dsn_foto = in.readString();
        this.dsn_email = in.readString();
        this.dsn_status = in.readString();
        this.username = in.readString();
    }

    public static final Creator<Dosen> CREATOR = new Creator<Dosen>() {
        @Override
        public Dosen createFromParcel(Parcel source) {
            return new Dosen(source);
        }

        @Override
        public Dosen[] newArray(int size) {
            return new Dosen[size];
        }
    };
}
