package org.d3ifcool.service.helpers;

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * Finpro
 * Copyright (C) 27/03/2019.
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
public class Constant {

    public Constant() {
    }

    public static final class ObjectConstanta {

        public static final String JUDUL_STATUS_TERSEDIA = "tersedia"; // judul yang di buat dosen
        public static final String JUDUL_STATUS_PENDING = "pending"; // judul yang di buat mahasiswa
        public static final String JUDUL_STATUS_DITOLAK = "ditolak";
        public static final String JUDUL_STATUS_DIGUNAKAN = "digunakan";
        public static final String JUDUL_STATUS_ARSIP = "arsip";
        public static final String JUDUL_STATUS_MENUNGGU = "Menunggu persetujuan";
        public static final String JUDUL_STATUS_DISETUJUI = "Judul disetujui";

        // -----------------------------------------------------------------------------------------
        public static final String PACKAGE_ROOT = "id.frogobox.cataloguemovie";
        public static final String PACKAGE_PATH_ACTIVITIES = PACKAGE_ROOT+".views.activities";
        public static final String PATH_MAIN_ACTIVITY = PACKAGE_PATH_ACTIVITIES+".MainActivity";
        // -----------------------------------------------------------------------------------------

        public static final String PREF_NAME = "LOGIN";
        public static final String LOGIN = "IS_LOGIN";
        public static final String USERNAME = "USERNAME";
        public static final String PENGGUNA = "PENGGUNA";

        public static final String DSN_NIP = "DSN_NIP";
        public static final String DSN_NIP_TEMP = "DSN_NIP_TEMP";
        public static final String DSN_NAMA = "DSN_NAMA";
        public static final String DSN_FOTO = "DSN_FOTO";
        public static final String DSN_EMAIL = "DSN_EMAIL";
        public static final String DSN_KONTAK = "DSN_KONTAK";
        public static final String DSN_KODE = "DSN_KODE";
        public static final String DSN_STATUS = "DSN_STATUS";

        public static final String MHS_NIM = "MHS_NIM";
        public static final String MHS_NAMA = "MHS_NAMA";
        public static final String MHS_FOTO = "MHS_FOTO";
        public static final String MHS_EMAIL = "MHS_EMAIL";
        public static final String MHS_KONTAK = "MHS_KONTAK";
        public static final String MHS_STATUS = "STATUS";
        public static final String MHS_ANGKATAN = "ANGKATAN";
        public static final String MHS_ID_JUDUL = "MHS_ID_JUDUL";
        public static final String MHS_ID_PROYEK_AKHIR = "MHS_ID_PROYEK_AKHIR";

        public static final String KOOR_NIP = "KOOR_NIM";
        public static final String KOOR_NAMA = "KOOR_NAMA";
        public static final String KOOR_KODE = "KOOR_KODE";
        public static final String KOOR_EMAIL = "KOOR_EMAIL";
        public static final String KOOR_KONTAK = "KOOR_KONTAK";
        public static final String KOOR_FOTO = "KOOR_FOTO";
        public static final String KOOR_USERNAME = "USERNAME_KOOR";

        public static final String BIMBINGAN_DITOLAK = "Bimbingan Ditolak!";
        public static final String BIMBINGAN_DIACC = "Bimbingan Telah Di-Acc!";

        public static final String STATUS_BIMBINGAN_PENDING = "pending";
        public static final String STATUS_BIMBINGAN_DISETUJUI = "disetujui";

        public static final int JUMLAH_BIMBINGAN_SIDANG = 16;
        public static final int JUMLAH_MONEV_SIDANG = 6;

        public static final String STATUS_SIDANG_LULUS = "Lulus";
        public static final String STATUS_SIDANG_LULUS_BERSYARAT = "Lulus";



    }

}
