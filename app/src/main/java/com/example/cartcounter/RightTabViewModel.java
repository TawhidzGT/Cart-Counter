package com.example.cartcounter;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class RightTabViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> mCountText = new MutableLiveData<>();

    private LiveData<String> mText = Transformations.map(mCountText, new Function<String, String>() {
        @Override
        public String apply(String input) {
            return input;
        }
    });

    void setCart()
    {
        MainActivity.cart_count++;
        mCountText.setValue(String.valueOf(MainActivity.cart_count));
    }

    LiveData<String> getText() {
        return mCountText;
    }

    /*  public void setIndex(String index) {
        mCountText.setValue(index);
    }
*/
}
