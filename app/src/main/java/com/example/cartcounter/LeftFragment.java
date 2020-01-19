package com.example.cartcounter;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class LeftFragment extends Fragment {

    private LeftTabViewModel mViewModel;
    private TextView counter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.left_fragment, container, false);

        mViewModel = ViewModelProviders.of(this).get(LeftTabViewModel.class);

        Button button = view.findViewById(R.id.btnclick);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.setCart();
            }
        });
        setHasOptionsMenu(true);
        return view;
    }



    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.cart_layout, menu);
        final MenuItem menuItem = menu.findItem(R.id.action_addcart);

        View actionView = menuItem.getActionView();
        counter = actionView.findViewById(R.id.notification_badge);
        mainActivityViewModel.getCount().observe(LeftFragment.this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer s) {
                counter.setText(String.valueOf(s));
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }

}

     /*
        //counter.setText(String.valueOf(MainActivity.cart_count));

        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuItem);
            }
        });
    */
