package text.bwei.com.deam;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private void initFloatingActionsMenu(View view) {
        // 添加 右下角的白色+号按钮
        final ImageView fabIcon = new ImageView(this);
        fabIcon.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher, null));
        final FloatingActionButton fabButton = new FloatingActionButton.Builder(this)
                .setContentView(fabIcon)
                .setPosition(FloatingActionButton.POSITION_BOTTOM_LEFT)
                .build();

        SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(this);

        ImageView imageViewQuit = new ImageView(this);
        ImageView imageViewTool = new ImageView(this);
        ImageView imageViewPalette = new ImageView(this);
        ImageView imageViewCamera = new ImageView(this);
        imageViewQuit.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher, null));
        imageViewTool.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher, null));
        imageViewPalette.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher, null));
        imageViewCamera.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher, null));

        SubActionButton buttonQuit = rLSubBuilder.setContentView(imageViewQuit).build();
        SubActionButton buttonPalette = rLSubBuilder.setContentView(imageViewPalette).build();
        SubActionButton buttonTool = rLSubBuilder.setContentView(imageViewTool).build();
        SubActionButton buttonCamera = rLSubBuilder.setContentView(imageViewCamera).build();

        // Build the menu with default options: light theme, 90 degrees, 72dp
        // radius.
        // Set 4 default SubActionButtons
        // FloatingActionMenu通过attachTo(fabButton)附着到FloatingActionButton
        final FloatingActionMenu buttonToolMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(buttonPalette)
                .addSubActionView(buttonCamera)
                .addSubActionView(buttonTool)
                .addSubActionView(buttonQuit)
                .setStartAngle(0)
                .setEndAngle(-90)
                .attachTo(fabButton)
                .build();

        // Listen menu open and close events to animate the button content view
        buttonToolMenu.setStateChangeListener(new FloatingActionMenu.MenuStateChangeListener() {
            @Override
            public void onMenuOpened(FloatingActionMenu menu) {
                // 增加按钮中的+号图标顺时针旋转45度
                // Rotate the icon of fabButton 45 degrees clockwise
                fabIcon.setRotation(0);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 45);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(fabIcon, pvhR);
                animation.start();
            }

            @Override
            public void onMenuClosed(FloatingActionMenu menu) {
                // 增加按钮中的+号图标逆时针旋转45度
                // Rotate the icon of fabButton 45 degrees
                // counter-clockwise
                fabIcon.setRotation(45);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 0);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(fabIcon, pvhR);
                animation.start();
            }
        });

//        RxView.clicks(buttonQuit)
//                .throttleFirst(1, TimeUnit.SECONDS)
//                .compose(this.bindUntilEvent(FragmentEvent.DESTROY))
//                .subscribe(v -> {
//                    Voip.getInstance().hangUpCall(callId);
//                    finishActivity();
//                });
//
//        RxView.clicks(buttonPalette)
//                .throttleFirst(1, TimeUnit.SECONDS)
//                .compose(this.bindUntilEvent(FragmentEvent.DESTROY))
//                .subscribe(v -> {
//                    buttonToolMenu.close(true);
//                    //                    buttonToolMenu.collapse();
//                    dialogPalette.show();
//                });
//
//        RxView.clicks(buttonCamera)
//                .throttleFirst(1, TimeUnit.SECONDS)
//                .compose(this.bindUntilEvent(FragmentEvent.DESTROY))
//                .subscribe(v -> {
//                    buttonToolMenu.close(true);
//                    //                    buttonToolMenu.collapse();
//                    dialogSelectImage.show();
//                });
    }



}
