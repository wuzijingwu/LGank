package text.bwei.com.lgank;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import text.bwei.com.lgank.fragment.HomeFragment;
import text.bwei.com.lgank.fragment.MeFragment;
import text.bwei.com.lgank.read.ReadsFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_tab_bar)
    BottomTabBar mBottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mBottomTabBar.init(getSupportFragmentManager())
                .addTabItem("Home", R.drawable.bottom_home, HomeFragment.class)
                .addTabItem("Read", R.drawable.bottom_read, ReadsFragment.class)
                .addTabItem("Me", R.drawable.bottom_me, MeFragment.class);


    }
}
