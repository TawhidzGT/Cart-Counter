package com.example.cartcounter;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class RightCenterFragment extends Fragment {

    private RightCenterViewModel mViewModel;
    private TextView counter;

    public static RightCenterFragment newInstance() {
        return new RightCenterFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.right_center_fragment, container, false);
        Button button = view.findViewById(R.id.btnclick);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something when the corky is clicked
                MainActivity.cart_count++;
                Log.d("lfe",MainActivity.cart_count+" ");
                mViewModel.setIndex(String.valueOf(MainActivity.cart_count));
                mViewModel.getText().observe(RightCenterFragment.this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        counter.setText(s);
                    }
                });
            }
        });
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RightCenterViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.cart_layout,menu);
        final MenuItem menuItem = menu.findItem(R.id.action_addcart);

        View actionView = menuItem.getActionView();
        counter = actionView.findViewById(R.id.notification_badge);
        counter.setText(String.valueOf(MainActivity.cart_count));


        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuItem);
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


}
