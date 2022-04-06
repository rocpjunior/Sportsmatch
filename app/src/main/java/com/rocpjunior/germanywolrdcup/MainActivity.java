package com.rocpjunior.germanywolrdcup;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.rocpjunior.germanywolrdcup.adapter.PlayerAdapter;
import com.rocpjunior.germanywolrdcup.data.PlayerApi;
import com.rocpjunior.germanywolrdcup.databinding.ActivityMainBinding;
import com.rocpjunior.germanywolrdcup.domain.Reply;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PlayerApi playerApi;
    private PlayerAdapter playersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupHttpClient();
        setupApi();
        setupPlayersList();
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://sportsmatch.com.br/teste/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        playerApi = retrofit.create(PlayerApi.class);
    }

    private void setupPlayersList() {
        binding.PlayerGermanRV.setHasFixedSize(true);
        binding.PlayerGermanRV.setLayoutManager(new LinearLayoutManager(this));
        binding.PlayerGermanRV.setAdapter(playersAdapter);
        setupApi();
    }

    private void setupApi() {
        playerApi.getPlayers().enqueue(new Callback<Reply>() {
            @Override
            public void onResponse(Call<Reply> call, Response<Reply> response) {
                if(response.isSuccessful()){
                    Reply reply = response.body();
                    playersAdapter = new PlayerAdapter(reply);
                    binding.PlayerGermanRV.setAdapter(playersAdapter);
                } else {
                    //TODO
                }
            }

            @Override
            public void onFailure(Call<Reply> call, Throwable e) {
                e.printStackTrace();
                //TODO
            }
        });
    }
}
