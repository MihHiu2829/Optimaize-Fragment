package com.example.fragment_02.View.frg;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragment_02.App;
import com.example.fragment_02.R;
import com.example.fragment_02.View.onMainCallBack;
import com.example.fragment_02.ViewModel.Common_VM;
import com.example.fragment_02.databinding.M002DetailActBinding;

public class m002_mainDetail extends baseFrg<M002DetailActBinding, Common_VM> {
    private int index ;
 private   Object mData ;
    private static final int DrawbleIDs[] = {R.drawable.icon_bird,R.drawable.icon_penguin,R.drawable.icon_checken,R.drawable.icon_dog} ;
      private static final  String Name[] = {"Trym","Cánh cụt","Gà","Cho"} ;
        @Override
    protected void initViews() {
        int az = (int)((Object[])mData)[1] ;
        String name = (String)((Object[])mData)[0] ;
        binding.ivImageAnimal.setImageResource(az);
        binding.tvNameAnimal.setText(name);
            binding.btLeft.setOnClickListener(v-> doPrevious(v));
            binding.btRight.setOnClickListener(v-> doNext(v));
             binding.btConfirm.setOnClickListener(v -> doReturn());
    }

    @Override
    protected M002DetailActBinding initViewBinding(LayoutInflater inflater, ViewGroup container) {
        return M002DetailActBinding.inflate(inflater,container,false);
    }

    @Override
    protected Class<Common_VM> ClassVM() {
        return Common_VM.class;
    }

    private void doReturn() {
        App.getInstance().getStorage().DrawableID = DrawbleIDs[index];
        App.getInstance().getStorage().name = Name[index];
        callBack.backPrevious();

    }

    private void doNext(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(context, androidx.appcompat.R.anim.abc_fade_in));
        if(index < DrawbleIDs.length-1)
            index++ ;
        binding.ivImageAnimal.setImageResource(DrawbleIDs[index]);
        binding.tvNameAnimal.setText(Name[index]);
    }

    private void doPrevious(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(context, androidx.appcompat.R.anim.abc_fade_in));

        if(index > 0)
            index-- ;
        binding.ivImageAnimal.setImageResource(DrawbleIDs[index]);
        binding.tvNameAnimal.setText(Name[index]);
    }

@Override
    public void setData(Object data) {
        mData = data ;
    }

    @Override
    public void setCallBack(onMainCallBack callBack) {
        this.callBack = callBack ;
    }
}
