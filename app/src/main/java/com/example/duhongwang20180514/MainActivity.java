package com.example.duhongwang20180514;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.duhongwang20180514.fragment.Duanzi_Fragment;
import com.example.duhongwang20180514.fragment.Find_Fragment;
import com.example.duhongwang20180514.fragment.TuiJian_Fragment;
import com.example.duhongwang20180514.fragment.Video_Fragment;
import com.hjm.bottomtabbar.BottomTabBar;
import butterknife.BindView;
import butterknife.ButterKnife;

//Fragment页面分类显示
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bottom_tab_bar)
    BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //初始化Fragment
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(50, 50)      //图片大小
                .setFontSize(12)                       //字体大小
                .setTabPadding(4, 6, 10)//选项卡的间距
                .setChangeColor(Color.BLUE, Color.BLACK)     //选项卡的选择颜色
                .addTabItem("推荐", R.drawable.tui, TuiJian_Fragment.class)
                .addTabItem("段子", R.drawable.duan, Duanzi_Fragment.class)
                .addTabItem("发现", R.drawable.find, Find_Fragment.class)
                .addTabItem("视频", R.drawable.video, Video_Fragment.class)
                .isShowDivider(true)    //是否包含分割线
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                        Log.i("TGA", "位置：" + position + "      选项卡：" + name);
                    }
                });
    }

}
