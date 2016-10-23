package com.android_in_5_minutes.myrecyclerviewapplication_video5;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by renato on 01/08/2016.
 */
public class MyObjectProvider {

    Context context;

    public MyObjectProvider(Context context) {
        this.context = context;
    }

    public ArrayList<MyObject> getObjects() {

        ArrayList<MyObject> myObjects = new ArrayList<>();

        for (int i=1; i<=6; i++) {
            MyObject myObject = new MyObject();
            myObject.setImageId(context.getResources().getIdentifier("img_".concat(String.valueOf(i)), "drawable", context.getPackageName()));
            myObject.setText("Image: "+i);
            myObject.setFavorite(false);
            myObjects.add(myObject);
        }

        return myObjects;
    }

    public class MyObject {

        int imageId;
        String text;
        boolean favorite;

        public boolean isFavorite() {
            return favorite;
        }

        public void setFavorite(boolean favorite) {
            this.favorite = favorite;
        }

        public int getImageId() {
            return imageId;
        }

        public void setImageId(int imageId) {
            this.imageId = imageId;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

    }
}
