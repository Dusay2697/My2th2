package com.example.lje.my2th;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import static com.example.lje.my2th.R.id.button;

public class TabLayoutActivity extends AppCompatActivity {
    MyView myView;
    Thread myThread;
    MyRunnable myRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        myView = (MyView)findViewById(R.id.myView);
        startSubThread();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout =
                (TabLayout) findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText("Thread"));
        tabLayout.addTab(tabLayout.newTab().setText("DB"));
        tabLayout.addTab(tabLayout.newTab().setText("Map"));



        final ViewPager viewPager =
                (ViewPager) findViewById(R.id.pager);

        final PagerAdapter adapter = new TabPagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {//현재 선택된 탭 번호를 기준으로 뷰페이져의 현재 페이지를 설정하기 위해 구현됨
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void startSubThread()
    {
        myRunnable = new MyRunnable();
        myThread = new Thread(myRunnable);
        myThread.setDaemon(true);
        myThread.start();
    }

    android.os.Handler mainHandler = new android.os.Handler()
    {
        public void handleMessage(Message msg)
        {
            if (msg.what == 0)
            {
                myView.invalidate();
            }
        }
    };

    public class MyRunnable implements Runnable
    {
        @Override
        public void run()
        {
            while(mainHandler!=null)
            {
                try
                {
                    myView.i = myView.i + 0.6f;
                    Message msg = Message.obtain();
                    msg.what = 0;
                    mainHandler.sendMessage(msg);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                try
                {
                    Thread.sleep(10);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }


    //public void onClick(View v) {


    //}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tab_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
