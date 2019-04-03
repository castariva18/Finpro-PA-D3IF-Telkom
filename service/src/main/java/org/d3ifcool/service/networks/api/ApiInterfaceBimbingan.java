package org.d3ifcool.service.networks.api;

import org.d3ifcool.service.models.Bimbingan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static org.d3ifcool.service.networks.bridge.ApiUrl.FinproUrl.PARAMETER_BIMBINGAN;
import static org.d3ifcool.service.networks.bridge.ApiUrl.FinproUrl.PATH_DELETE;
import static org.d3ifcool.service.networks.bridge.ApiUrl.FinproUrl.PATH_UPDATE;
import static org.d3ifcool.service.networks.bridge.ApiUrl.FinproUrl.URL_BIMBINGAN;
import static org.d3ifcool.service.networks.bridge.ApiUrl.FinproUrl.VAR_BIMBINGAN;

/**
 * Created by ikhsan ramadhan
 * =========================================
 * Finpro
 * Copyright (C) 3/2/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhamad Ikhsan Ramadhan
 * E-mail   : ikhsanramadhan28@gmail.com
 * Majors   : D3 Teknik Informatika 2016
 * Campus   : Telkom University
 * -----------------------------------------
 */
public interface ApiInterfaceBimbingan {

    @FormUrlEncoded
    @GET(URL_BIMBINGAN)
    Call<Bimbingan> createBimbingan(
            @Field("bimbingan_review") String bimbingan_review,
            @Field("bimbingan_judul") String bimbingan_judul,
            @Field("bimbingan_tanggal") String bimbingan_tanggal,
            @Field("proyek_akhir_id") int proyek_akhir_id
    );

    @POST(URL_BIMBINGAN + PATH_UPDATE + PARAMETER_BIMBINGAN)
    Call<Bimbingan> updateBimbingan(@Path(VAR_BIMBINGAN) int bimbingan_id,
                                    @Field("bimbingan_review") String bimbingan_review,
                                    @Field("bimbingan_judul") String bimbingan_judul,
                                    @Field("bimbingan_tanggal") String bimbingan_tanggal
    );

    @GET(URL_BIMBINGAN)
    Call<List<Bimbingan>> getBimbingan();

    @POST(URL_BIMBINGAN + PATH_DELETE + PARAMETER_BIMBINGAN)
    Call<Bimbingan> deleteBimbingan(@Path(VAR_BIMBINGAN) String bimbingan_id);

}
