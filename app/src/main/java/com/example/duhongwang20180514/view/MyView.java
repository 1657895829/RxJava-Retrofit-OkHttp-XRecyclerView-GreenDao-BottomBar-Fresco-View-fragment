package com.example.duhongwang20180514.view;

import com.example.duhongwang20180514.bean.NewsBean;

/**
 * Created   by    Dewey
 */

public interface MyView {
    void onSuccess(NewsBean newsBean);
    void onFailure();
}
