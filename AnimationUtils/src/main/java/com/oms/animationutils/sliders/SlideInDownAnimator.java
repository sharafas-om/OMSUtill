package com.oms.animationutils.sliders;

import android.animation.ObjectAnimator;
import android.view.View;

import com.oms.animationutils.BaseViewAnimator;

public class SlideInDownAnimator extends BaseViewAnimator {
    @Override
    public void prepare(View target) {
        int distance = target.getTop() + target.getHeight();
        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target, "alpha", 0, 1),
                ObjectAnimator.ofFloat(target, "translationY", -distance, 0)
        );
    }
}
