package org.d3ifcool.service.network;

import org.d3ifcool.service.models.Informasi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import static org.d3ifcool.service.network.ApiUrl.FinproUrl.PARAMETER_INFORMASI;
import static org.d3ifcool.service.network.ApiUrl.FinproUrl.URL_INFORMASI;

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * Finpro
 * Copyright (C) 26/02/2019.
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
public interface ApiInterfaceInformasi {

    @FormUrlEncoded
    @POST(URL_INFORMASI)
    Call<Informasi> createInformasi (
            @Field("informasi_judul") String informasi_judul,
            @Field("informasi_isi") String informasi_isi,
            @Field("penerbit") String penerbit
    );

    @FormUrlEncoded
    @PUT(URL_INFORMASI + PARAMETER_INFORMASI)
    Call<Informasi> updateInformasi (
            @Path("informasi") int informasi_id,
            @Field("informasi_judul") String informasi_judul,
            @Field("informasi_isi") String informasi_isi
    );

    @GET(URL_INFORMASI)
    Call<List<Informasi>> getInformasi();

    @DELETE(URL_INFORMASI + PARAMETER_INFORMASI)
    Call<Informasi> deleteInformasi (
            @Path("informasi") int informasi_id
    );

}
