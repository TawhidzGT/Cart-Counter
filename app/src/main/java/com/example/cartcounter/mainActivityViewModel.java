package com.example.cartcounter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class mainActivityViewModel extends ViewModel {

    public static MutableLiveData<String> mCountText = new MutableLiveData<>();

    static void CounterMain()
    {
        MainActivity.cart_count++;
        mCountText.setValue(String.valueOf(MainActivity.cart_count));
    }

    static LiveData<String> getText() {

        return mCountText;
    }

}
