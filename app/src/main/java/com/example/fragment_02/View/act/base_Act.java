package com.example.fragment_02.View.act;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.example.fragment_02.R;
import com.example.fragment_02.View.frg.baseFrg;
import com.example.fragment_02.View.onMainCallBack;

import java.lang.reflect.Constructor;

public abstract class base_Act <T extends ViewBinding,M extends ViewModel>
        extends AppCompatActivity implements View.OnClickListener, onMainCallBack {

    T binding ;
    M viewModel ;

    public void showFragment(String TAG, Object data, boolean isBack) {
        try {
            Class<?> clazz = Class.forName(TAG);  // trỏ vào 1 fragment class ;
            Constructor<?> cons = clazz.getConstructor();
            baseFrg<?, ?> frg = (baseFrg<?, ?>) cons.newInstance();  // tạo ra 1 thực thể từ lớp Fragment
            frg.setData(data);
            frg.setCallBack(this);
            FragmentTransaction trans = getSupportFragmentManager()
                    .beginTransaction();
            if (isBack)
                trans.addToBackStack(null);
            trans.replace(R.id.Ln_Main, frg, TAG).commit();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = InitViewbinding() ;
        viewModel = new ViewModelProvider(this).get(ClassVM()) ;
        initViews() ;
        setContentView(binding.getRoot());
    }

    protected abstract void initViews();

    protected abstract Class<M> ClassVM();

    protected abstract T InitViewbinding();

    @Override
    public void onClick(View view) {
            //do nothing  ;
    }
}
