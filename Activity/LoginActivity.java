package com.example.ln.energy_saving_system.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ln.energy_saving_system.Api.LoginService;
import com.example.ln.energy_saving_system.Base.BaseActivity;
import com.example.ln.energy_saving_system.Bean.LoginDemo;
import com.example.ln.energy_saving_system.MainActivity;
import com.example.ln.energy_saving_system.R;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class
LoginActivity extends BaseActivity {
    final private static String URL = "http://47.105.103.77:9931/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int intiLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LoginService loginService = retrofit.create(LoginService.class);
        //RequestBody
        String jsonStr = "{\"loginname\":\"101\","+ "" + "\"clienttype\":\"L01\",\"password\":\"670B14728AD9902AECBA32E22FA4F6BD\"}";
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"), jsonStr);
        Call<LoginDemo> call = loginService.getlogin(requestBody);
        call.enqueue(new Callback<LoginDemo>() {
            @Override
            public void onResponse(Call<LoginDemo> call, Response<LoginDemo> response) {
                Toast.makeText(LoginActivity.this, "请求成功的数据"+response.body().getUsername(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<LoginDemo> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "请求失败" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
