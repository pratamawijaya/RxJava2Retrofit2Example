package com.pratamawijaya.rxjava2retrofit.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.pratamawijaya.rxjava2retrofit.R;
import com.pratamawijaya.rxjava2retrofit.data.model.PostModel;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

  private MainPresenter presenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    presenter = new MainPresenter();
  }

  @Override protected void onStart() {
    super.onStart();
    presenter.attachView(this);
    presenter.getData();
  }

  @Override protected void onStop() {
    super.onStop();
    presenter.detachView();
  }

  @Override public void showLoading(boolean show) {
    if (show) {

    } else {

    }
  }

  @Override public void showData(List<PostModel> posts) {
    for (PostModel data : posts) {
      Log.d("tag", "showData: " + data.title);
    }
  }
}
