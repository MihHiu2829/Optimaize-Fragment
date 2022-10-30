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

import com.example.fragment_02.R;
import com.example.fragment_02.View.onMainCallBack;
import com.example.fragment_02.ViewModel.M001_mainVM;
import com.example.fragment_02.databinding.M001MainActBinding;

public class m001_mainAct extends baseFrg<M001MainActBinding,M001_mainVM> {




    @Override
    public void setCallBack(onMainCallBack callBack) {
        this.callBack = callBack ;
    }

    @Override
    protected void initViews() {
        binding.ivBird.setOnClickListener(v -> gotoContent(v, R.drawable.icon_bird,R.string.contentBird));
        binding.ivChecken.setOnClickListener(v -> gotoContent(v, R.drawable.icon_checken,R.string.contentChecken));
        binding.ivDog.setOnClickListener(v -> gotoContent(v, R.drawable.icon_dog,R.string.contentDog));
        binding.ivPenguin.setOnClickListener(v -> gotoContent(v, R.drawable.icon_penguin,R.string.contentPenguin));
        binding.btDetail.setOnClickListener(v -> gotoDetail());
    }

    @Override
    protected M001MainActBinding initViewBinding(LayoutInflater inflater, ViewGroup container) {
        return M001MainActBinding.inflate(inflater,container,false);
    }

    @Override
    protected Class<M001_mainVM> ClassVM() {
        return M001_mainVM.class;
    }

    private void gotoDetail() {
            callBack.showFragment(m002_mainDetail.class.getName(),(new Object[]{viewModel.getName(),viewModel.getDrawableID()}),true);
    }

    private void gotoContent(View view, int DrawableID, int content) {
            view.startAnimation(AnimationUtils.loadAnimation(context, androidx.appcompat.R.anim.abc_fade_in));
            viewModel.setContent(content);
            viewModel.setDrawableID(DrawableID);

            binding.btDetail.setEnabled(true);
            binding.tvContentAnimal.setText(viewModel.getContent());
            viewModel.setName(view.getContentDescription().toString());
            viewModel.setvID(view.getId());
    }
}
