

/**
 * Created by LJE on 2017-11-24.
 */

package com.example.lje.my2th;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;



//사용자가 탭 항목을 선택할 때 화면에 보여줄 프래그먼트를 관리하기 위해 프래그먼트페이저어댑터의 새로운 서브 클래스를 추가
public class TabPagerAdapter extends FragmentPagerAdapter {

    int tabCount;

    public TabPagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.tabCount = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0://요청 페이지 번호를 식별하고 해당 프래그먼트 인스턴스 반환
                Tab1Fragment tab1 = new Tab1Fragment();
                return tab1;
            case 1:
                Tab2Fragment tab2 = new Tab2Fragment();
                return tab2;
            case 2:
                Tab3Fragment tab3 = new Tab3Fragment();
                return tab3;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {//이 클래스 인스턴스가 생성될 때 전달된 페이지 개수 반환
        return tabCount;
    }
}


