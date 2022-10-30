package com.example.fragment_02.View.frg;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragment_02.R;
import com.example.fragment_02.View.onMainCallBack;
import com.example.fragment_02.ViewModel.Common_VM;
import com.example.fragment_02.databinding.M000FlashBinding;

public class m000_flash extends baseFrg<M000FlashBinding, Common_VM> {




    public  void setCallBack(onMainCallBack callBack) {
        this.callBack = callBack ;
    }

    @Override
    protected void initViews() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callBack.showFragment(m001_mainAct.class.getName(),null, false);
            }
        },1500) ;
    }

    @Override
    protected M000FlashBinding initViewBinding(LayoutInflater inflater, ViewGroup container) {
        return M000FlashBinding.inflate(inflater,container,false);
    }

    @Override
    protected Class<Common_VM> ClassVM() {
        return Common_VM.class;
    }
}
