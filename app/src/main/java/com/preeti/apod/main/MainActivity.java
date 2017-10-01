package com.preeti.apod.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.preeti.apod.R;
import com.preeti.apod.data.ApodImage;
import com.preeti.apod.util.MainInterface;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainInterface.MainView{

    MainInterface.MainPresenter mainPresenter;

    @BindView(R.id.apod_imageView)
    ImageView apodImageView;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

      
    }

    private void init() {
        ButterKnife.bind(this);
        mainPresenter = new MainPresenterImpl(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.loadData();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showAPODImage(ApodImage apodImage) {
        apodImageView.setVisibility(View.VISIBLE);
        Picasso.with(this).load(apodImage.getUrl()).into(apodImageView);
    }
}
