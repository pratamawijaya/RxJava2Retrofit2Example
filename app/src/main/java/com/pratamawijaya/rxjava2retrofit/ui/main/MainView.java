package com.pratamawijaya.rxjava2retrofit.ui.main;

import com.pratamawijaya.rxjava2retrofit.data.model.PostModel;
import java.util.List;

/**
 * Created by pratama
 * Date : Mar - 3/11/17
 * Project Name : RxJava2Retrofit
 */

public interface MainView {
  void showLoading(boolean show);

  void showData(List<PostModel> posts);
}
