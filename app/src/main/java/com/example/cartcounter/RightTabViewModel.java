package com.example.cartcounter;

import androidx.lifecycle.ViewModel;

public class RightTabViewModel extends ViewModel {

    void setCart()
    {
        mainActivityViewModel.setCount();
    }
}
