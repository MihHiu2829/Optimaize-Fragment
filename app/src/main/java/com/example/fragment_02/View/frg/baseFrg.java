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
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.example.fragment_02.View.onMainCallBack;
import com.example.fragment_02.ViewModel.M001_mainVM;

public abstract class baseFrg<T extends ViewBinding,M extends ViewModel> extends Fragment implements View.OnClickListener {

    protected Context context ;
    protected T binding ;
    protected M viewModel ;
    protected Object mdata;
    protected onMainCallBack callBack ;




//    public static String getTAG() {
//        return TAG;
//    }


    public void setData(Object data) {
        this.mdata = data;
    }

    public abstract void setCallBack(onMainCallBack callBack) ;

    @Override
    public final void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context  = context ;
    }

    @Nullable
    @Override
    public final View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       binding = initViewBinding(inflater,container);
       viewModel = new ViewModelProvider(this).get(ClassVM());
        initViews() ;
       return binding.getRoot() ;
       
    }

    protected abstract void initViews();

    protected abstract T initViewBinding(LayoutInflater inflater, ViewGroup container);

    protected abstract Class<M> ClassVM();

    @Override
    public void onClick(View view) {
                view.startAnimation(AnimationUtils.loadAnimation(context, androidx.appcompat.R.anim.abc_fade_in));
                doClick(view) ;
    }

    protected  void doClick(View view)
    {
        // do nothing ;
    }
}
