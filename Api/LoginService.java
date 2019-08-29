package com.example.ln.energy_saving_system.Api;

import com.example.ln.energy_saving_system.Bean.LoginDemo;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {
    //登录接口
    @POST("queryclientlogin")
    Call<LoginDemo> getlogin(@Body RequestBody requestBody);
}
