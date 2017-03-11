package com.pratamawijaya.rxjava2retrofit.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pratamawijaya.rxjava2retrofit.data.model.PostResponse;
import io.reactivex.Flowable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by pratama
 * Date : Mar - 3/11/17
 * Project Name : RxJava2Retrofit
 */

public interface PratamaServices {

  @GET("get_recent_posts/") Flowable<PostResponse> getRecentPosts(@Query("page") int page);

  class Creator {
    public static PratamaServices newServices() {
      Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

      Retrofit retrofit = new Retrofit.Builder().baseUrl("https://pratamawijaya.com/api/")
          .addConverterFactory(GsonConverterFactory.create(gson))
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .build();

      return retrofit.create(PratamaServices.class);
    }
  }
}
