package com.chenxiao.rxjavastudy.rxjavastudy;

import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by chenxiao on 18/1/3.
 */

public class OKHttpServer {

    private static volatile OKHttpServer okHttpServer;

    OkHttpClient client;

    private OKHttpServer() {
        client = new OkHttpClient();
    }


    public static OKHttpServer getInstance() {
        if (okHttpServer == null) {
            synchronized (OKHttpServer.class) {
                if (okHttpServer == null) {
                    okHttpServer = new OKHttpServer();
                }

            }
        }
        return okHttpServer;
    }


    public String run(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            String result = response.body().string();
            System.out.print(result);
            return result;
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }


    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * POST提交Json数据
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }


    /**
     * POST提交键值对
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public String post2(String url, HashMap<String, String> hashMap) throws IOException {
        FormBody.Builder formBuilder = new FormBody.Builder();
        Set keys = hashMap.keySet();
        for (Object key : keys) {
            formBuilder.add((String) key, hashMap.get(key));
        }
        FormBody formBody = formBuilder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            String result = response.body().string();
            System.out.print(result);
            return result;
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }
}


