package com.example.cartcounter;


import androidx.lifecycle.ViewModel;

public class LeftTabViewModel extends ViewModel {

    void setCart() {

        mainActivityViewModel.setCount();
    }

}


    /*
    private MutableLiveData<String> mCountText = new MutableLiveData<>();

    public void setIndex(String index) {
        mCountText.setValue(index);

       private LiveData<String> mText = Transformations.map(mCountText, new Function<String, String>() {
       @Override
       public String apply(String input) {
           return input;
       }
    });

        LiveData<String> getText() {
        mCountText= (MutableLiveData<String>) mainActivityViewModel.getText();
        return mCountText;

    }
    }*/

