package com.dsc.android.bootcamp1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RecyclerViewData implements Serializable {

    @SerializedName("image")
    @Expose
    private  String image;
    @SerializedName("name")
    @Expose
    private  String name;
    @SerializedName("number")
    @Expose
    private  String phoneno;



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

}
