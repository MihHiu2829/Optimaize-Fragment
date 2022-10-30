package com.example.fragment_02.ViewModel;

import androidx.lifecycle.ViewModel;

public class M001_mainVM extends ViewModel {
        private int Content ;
        private int DrawableID ;
        private String name ;
        private int vID ;

    public int getContent() {
        return Content;
    }

    public void setContent(int content) {
        Content = content;
    }

    public int getDrawableID() {
        return DrawableID;
    }

    public void setDrawableID(int drawableID) {
        DrawableID = drawableID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getvID() {
        return vID;
    }

    public void setvID(int vID) {
        this.vID = vID;
    }
}
