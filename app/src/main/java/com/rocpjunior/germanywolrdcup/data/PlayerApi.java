package com.rocpjunior.germanywolrdcup.data;

import com.rocpjunior.germanywolrdcup.domain.Reply;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlayerApi {

    @GET("teste.json")
    Call <Reply> getPlayers();
}
