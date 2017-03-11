package com.pratamawijaya.rxjava2retrofit.ui.main;

import android.util.Log;
import com.pratamawijaya.rxjava2retrofit.data.PratamaServices;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by pratama
 * Date : Mar - 3/11/17
 * Project Name : RxJava2Retrofit
 */

public class MainPresenter {
  private MainView view;
  private PratamaServices services;
  private CompositeDisposable compositeDisposable;

  public MainPresenter() {
    services = PratamaServices.Creator.newServices();
  }

  public void attachView(MainView view) {
    this.view = view;
    compositeDisposable = new CompositeDisposable();
  }

  public void detachView() {
    compositeDisposable.dispose();
  }

  public void getData() {
    view.showLoading(true);
    Disposable getRecent = services.getRecentPosts(1)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(postResponse -> {
          Log.d("tag", "getData: " + postResponse.posts.size());
          view.showData(postResponse.posts);
        }, throwable -> {
          Log.e("tag", "getData: " + throwable.getLocalizedMessage());
        }, () -> view.showLoading(false));

    compositeDisposable.add(getRecent);
  }
}
