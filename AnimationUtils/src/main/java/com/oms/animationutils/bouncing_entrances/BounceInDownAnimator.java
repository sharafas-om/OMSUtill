package com.oms.animationutils.bouncing_entrances;

import android.animation.ObjectAnimator;
import android.view.View;

import com.oms.animationutils.BaseViewAnimator;

public class BounceInDownAnimator extends BaseViewAnimator {
    @Override
    public void prepare(View target) {
        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target, "alpha", 0, 1, 1, 1),
                ObjectAnimator.ofFloat(target, "translationY", -target.getHeight(), 30, -10, 0)
        );
    }
}
