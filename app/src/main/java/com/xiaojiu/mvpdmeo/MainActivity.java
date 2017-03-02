package com.xiaojiu.mvpdmeo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.xiaojiu.mvpdmeo.ui.activity.BaseActivity;
import com.xiaojiu.mvpdmeo.ui.fragment.HomeFragment;
import com.xiaojiu.mvpdmeo.ui.fragment.MoreFragment;
import com.xiaojiu.mvpdmeo.ui.fragment.OrderFragment;
import com.xiaojiu.mvpdmeo.ui.fragment.UserFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity{

    public static final String TAG = "MainActivity";
    @BindView(R.id.main_fragment_container)
    FrameLayout mainFragmentContainer;

    // 底部导航拦
    @BindView(R.id.main_bottome_switcher_container)
    LinearLayout mainBottomeSwitcherContainer;

    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        setListener();
    }

    private void init() {
        fragmentArrayList.add(new HomeFragment());
        fragmentArrayList.add(new OrderFragment());
        fragmentArrayList.add(new UserFragment());
        fragmentArrayList.add(new MoreFragment());

        onClickListener.onClick(mainBottomeSwitcherContainer.getChildAt(0));//默认点击事件
    }

    private void setListener() {
        //所有的孩子
        int childCount = mainBottomeSwitcherContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            FrameLayout fragment = (FrameLayout) mainBottomeSwitcherContainer.getChildAt(i);
            fragment.setOnClickListener(onClickListener);
        }
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int index = mainBottomeSwitcherContainer.indexOfChild(view);
            changeUI(index);
            changeFragment(index);
        }
    };

    /**
     *
     * @param index 通过index 改变相对应的index
     */
    private void changeFragment(int index) {
        Fragment fragment = fragmentArrayList.get(index);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container,fragment)
                .commit();
    }

    /**
     * 改变Index点击的状态
     * @param index
     */
    private void changeUI(int index) {
        int childCount = mainBottomeSwitcherContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            //i是否与index相同
            //相同:则是不可用状态,enable = false
            if (i == index){
//                mainBottomeSwitcherContainer.getChildAt(i).setEnabled(false);
                setEnable(mainBottomeSwitcherContainer.getChildAt(i),false);
            }else {
                setEnable(mainBottomeSwitcherContainer.getChildAt(i),true);
            }
        }
    }

    private void setEnable(View childAt, boolean b) {
        childAt.setEnabled(b);
        if (childAt instanceof ViewGroup){
            int childCount = ((ViewGroup) childAt).getChildCount();
            for (int i = 0; i < childCount; i++) {
                setEnable(((ViewGroup) childAt).getChildAt(i),b);
            }
        }
    }
}
