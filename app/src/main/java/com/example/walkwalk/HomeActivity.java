package com.example.walkwalk;

import android.content.Intent;
import android.os.Bundle;

import com.example.walkwalk.ViewPaper.AnalyzeFragment;
import com.example.walkwalk.ViewPaper.BottomAdapter;
import com.example.walkwalk.ViewPaper.MyInfoFragment;
import com.example.walkwalk.ViewPaper.SportsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private BottomNavigationView mBv;
    private ViewPager mVp;
    private static String TAG="主页面";
    private String user_name,user_pwd,user_sex,user_age;
//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.tab_sport:
//                    mTextMessage.setText(R.string.title_sport);
//                    return true;
//                case R.id.tab_analyze:
//                    mTextMessage.setText(R.string.title_analyze);
//                    return true;
//                case R.id.tab_my:
//                    mTextMessage.setText(R.string.title_myinfo);
//                    return true;
//            }
//            return false;
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        user_name=intent.getStringExtra("UserName");
        user_pwd=intent.getStringExtra("UserPwd");
        user_sex=intent.getStringExtra("UserSex");
        user_age=intent.getStringExtra("UserAge");
        Log.d(TAG, "用户："+user_name+" "+user_sex+" ");
        //不同性别显示不同的图标
        if(user_sex.equals("男")){
            setContentView(R.layout.activity_home_m);
        }else{
            setContentView(R.layout.activity_home_w);
        }
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        initView();
    }
    private void initView() {
        mBv = (BottomNavigationView) findViewById(R.id.nav_view);
        mVp = (ViewPager) findViewById(R.id.viewpaper);
//        BottomAdapterNavigationViewHelper.disableShiftMode(mBv);

        //这里可true是一个消费过程，同样可以使用break，外部返回true也可以
        mBv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab_sport:
                        mVp.setCurrentItem(0);
                        return true;

                    case R.id.tab_analyze:
                        mVp.setCurrentItem(1);
                        return true;

                    case R.id.tab_my:
                        mVp.setCurrentItem(2);
                        return true;

                }
                return false;
            }
        });

        //数据填充
        setupViewPager(mVp);
        //ViewPager监听
        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBv.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //禁止ViewPager滑动
        //        mVp.setOnTouchListener(new View.OnTouchListener() {
        //                    @Override
        //                    public boolean onTouch(View v, MotionEvent event) {
        //                        return true;
        //                    }
        //                });
    }

    private void setupViewPager(ViewPager viewPager) {
        BottomAdapter adapter = new BottomAdapter(getSupportFragmentManager());
        adapter.addFragment(new SportsFragment());
        adapter.addFragment(new AnalyzeFragment());
        adapter.addFragment(new MyInfoFragment());
        viewPager.setAdapter(adapter);
    }


}
