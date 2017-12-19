package text.bwei.com.lgank.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import text.bwei.com.lgank.R;
import text.bwei.com.lgank.android.ANDROIDFragment;
import text.bwei.com.lgank.fuli.FuliFragment;
import text.bwei.com.lgank.ios.IOSFragment;

/**
 * Created by dell on 2017/12/18.
 */

public class HomeFragment extends Fragment {
    @BindView(R.id.tablayout_home)
    TabLayout tablayout_home;
    @BindView(R.id.viewpager_home)
    ViewPager viewpager_home;

    private View view;
    private Unbinder unbinder;

    String[] strings = new String[]{"ANDROID", "IOS", "福利"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.homefragment, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        for (int i = 0; i < strings.length; i++) {
            tablayout_home.addTab(tablayout_home.newTab().setText(strings[i]));
        }

        viewpager_home.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (strings[position]) {
                    case "ANDROID":
                        fragment = new ANDROIDFragment();
                        break;
                    case "IOS":
                        fragment = new IOSFragment();
                        break;
                    case "福利":
                        fragment = new FuliFragment();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return strings.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return strings[position];
            }
        });

        tablayout_home.setupWithViewPager(viewpager_home);

    }
}
