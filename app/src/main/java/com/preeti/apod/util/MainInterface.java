package com.preeti.apod.util;

import com.preeti.apod.data.ApodImage;

/**
 * Created by Game on 22-09-17.
 */

public interface MainInterface {

    public interface MainView {

        void showProgress();

        void hideProgress();

        void showAPODImage(ApodImage apodImage);

        void showAPODVideo(ApodImage apodImage);
    }

    public interface MainPresenter {

        void loadData();

        void receivedApodData(ApodImage apodImage);
    }

    public interface MainModel {

        void getAPODImage(MainPresenter presenter);
    }

}
