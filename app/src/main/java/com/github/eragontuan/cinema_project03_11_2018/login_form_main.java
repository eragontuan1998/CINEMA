package com.github.eragontuan.cinema_project03_11_2018;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.Switch;

public class login_form_main extends AppCompatActivity implements View.OnClickListener {

    ConstraintLayout mConstraintLayout;
    AnimationDrawable mAnimationDrawable;
    Button mButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animationLOGIN();

        references_to_widget();

        mButtonLogin.setOnClickListener(this);
    }

    private void references_to_widget() {
        mButtonLogin = (Button) findViewById(R.id.buttonLogin);

    }

    //TODO: Animation For Login
    private void animationLOGIN() {
        mConstraintLayout = (ConstraintLayout) findViewById(R.id.login_Form_main);
        mAnimationDrawable = (AnimationDrawable) mConstraintLayout.getBackground();
        mAnimationDrawable.setEnterFadeDuration(4500);
        mAnimationDrawable.setExitFadeDuration(4500);
        mAnimationDrawable.start();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case (R.id.buttonLogin):
                startActivityForResult(new Intent(this,News_Film.class),RESULT_OK);
                break;

        }
    }
}
