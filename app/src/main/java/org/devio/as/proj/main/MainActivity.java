package org.devio.as.proj.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.devio.as.proj.main.R;
import org.devio.as.proj.main.logic.MainActivityLogic;
import org.devio.as.proj.main.logic.MainActivityLogic.ActivityProvider;
import org.devio.hi.common.ui.component.HiBaseActivity;

public class MainActivity extends HiBaseActivity implements ActivityProvider {
    private MainActivityLogic activityLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityLogic = new MainActivityLogic(this, savedInstanceState);
    }
}
