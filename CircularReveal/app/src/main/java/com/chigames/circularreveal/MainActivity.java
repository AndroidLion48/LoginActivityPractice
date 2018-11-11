package com.chigames.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;

import com.chigames.circularreveal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Binds all the view to this class.
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


    }

    public void load(View view) {

        // Shrinks the button
        animateButtonWidth();

        // Fades out the Text and shows progress bar
        fadeOutTextAndSetProgressDialog();

        // Loading is complete, move to next activity.
        nextAction();
    }

    private void animateButtonWidth() {

        // set this animator to the width of signInBtn
        // Returns a ValueAnimator that animates between int values.
        ValueAnimator anim = ValueAnimator.ofInt(mainBinding.signInBtn.getMeasuredWidth(), getFinalWidth());

        //Listen for start.
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                // On Start/update we set the signInBtn's width to the current animation Value.
                int value = (Integer) animation.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = mainBinding.signInBtn.getLayoutParams();
                layoutParams.width = value;

                // Refresh the signInBtn's view to update it.
                mainBinding.signInBtn.requestLayout();
            }
        });


        anim.setDuration(250);
        anim.start();
    }

    private void fadeOutTextAndSetProgressDialog(){

        mainBinding.signInTv.animate()
                .alpha(0)
                .setDuration(250)
                .setListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation)
            {
                super.onAnimationEnd(animation);
                showProgressDialog();
            }
        }).start();

    }

    private void showProgressDialog() {
        mainBinding.progressBar.getIndeterminateDrawable().setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_IN);
        mainBinding.progressBar.setVisibility(View.VISIBLE);
    }

    private void nextAction() {
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                revealButton();
                fadOutProgressDialog();
                delayedStartNextActivity();
            }
        }, 2000);
    }

    private void revealButton() {
        mainBinding.signInBtn.setElevation(0f);
        mainBinding.revealView.setVisibility(View.VISIBLE);

        int x = mainBinding.revealView.getWidth();
        int y = mainBinding.revealView.getHeight();

        int startX = (int) (getFinalWidth() / 2 + mainBinding.signInBtn.getX());
        int startY = (int) (getFinalWidth() / 2 + mainBinding.signInBtn.getY());

        float radius = Math.max(x, y) * 1.2f;

        Animator reveal = ViewAnimationUtils.createCircularReveal(mainBinding.revealView, startX, startY, getFinalWidth(), radius);
        reveal.setDuration(350);
        reveal.addListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation)
            {
                super.onAnimationEnd(animation);
                finish();
            }
        });

        reveal.start();
    }

    private void fadOutProgressDialog() {

        mainBinding.progressBar.animate()
                .alpha(0f)
                .setDuration(200)
                .start();

    }

    private void delayedStartNextActivity() {

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                overridePendingTransition(0, 0);
            }
        }, 200);
    }

    private int getFinalWidth() {

        return (int) getResources().getDimension(R.dimen.get_width);
    }
}
