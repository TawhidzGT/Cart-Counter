package com.example.cartcounter;

import androidx.lifecycle.ViewModel;

public class RightCenterViewModel extends ViewModel {

    void setCart()
    {
        mainActivityViewModel.setCount();
    }

}
