package ge.barbare.ui;

import android.graphics.Color;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.github.paolorotolo.appintro.model.SliderPage;

import androidx.fragment.app.Fragment;

public class IntroActivity extends AppIntro {
    /*
    should store strings in resources
    */

    private static final String TITLE  = "ბარბარე";
    private static final String DESCRIPTION = "აღწერა";
    private static final int BACKGROUND_COLOR = Color.parseColor("#ec407a");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SliderPage sliderPage = new SliderPage();
        sliderPage.setTitle(TITLE);
        sliderPage.setDescription(DESCRIPTION);
        sliderPage.setBgColor(BACKGROUND_COLOR);


        addSlide(AppIntroFragment.newInstance(sliderPage));


    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
    }
}
