package com.example.cartcounter;

import androidx.lifecycle.ViewModel;

public class LeftCenterViewModel extends ViewModel {

    void setCart()
    {
        mainActivityViewModel.setCount();
    }
}
