package com.example.fragment_02.View.act;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragment_02.R;
import com.example.fragment_02.View.frg.baseFrg;
import com.example.fragment_02.View.frg.m000_flash;
import com.example.fragment_02.View.onMainCallBack;
import com.example.fragment_02.ViewModel.Common_VM;
import com.example.fragment_02.databinding.AchomeMainBinding;

import java.lang.reflect.Constructor;

public class HomeActivity extends base_Act<AchomeMainBinding, Common_VM> implements onMainCallBack {
    protected void initViews() {
        showFragment(m000_flash.class.getName(),null,false);
    }
    @Override
    protected Class<Common_VM> ClassVM() {
        return Common_VM.class;
    }

    @Override
    protected AchomeMainBinding InitViewbinding() {
        return AchomeMainBinding.inflate(getLayoutInflater());
    }

    @Override
    public void backPrevious() {
        onBackPressed();
    }


}