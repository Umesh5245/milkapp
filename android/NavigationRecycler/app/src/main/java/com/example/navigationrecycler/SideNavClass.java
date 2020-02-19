package com.example.navigationrecycler;

import android.widget.ImageView;

public class SideNavClass {
    String name;
    int icon;

    public SideNavClass(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }
}
