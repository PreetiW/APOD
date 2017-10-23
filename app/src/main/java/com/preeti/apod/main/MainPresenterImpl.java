package com.preeti.apod.main;

import com.preeti.apod.data.ApodApiImpl;
import com.preeti.apod.data.ApodImage;
import com.preeti.apod.util.MainInterface;

/**
 * Created by Game on 22-09-17.
 */

public class MainPresenterImpl implements MainInterface.MainPresenter {

    private MainInterface.MainView mainView;
    private MainInterface.MainModel mainModel;
    private static final String VIDEO_TYPE = "video";

    public MainPresenterImpl(MainInterface.MainView mainView){
        this.mainView = mainView;
        mainModel = new ApodApiImpl();
    }

    @Override
    public void loadData() {
        mainView.showProgress();
        mainModel.getAPODImage(this);
    }

    @Override
    public void receivedApodData(ApodImage apodImage) {
        mainView.hideProgress();
        if(apodImage.getMedia_type().equals(VIDEO_TYPE)){
            mainView.showAPODVideo(apodImage);
        } else {
            mainView.showAPODImage(apodImage);
        }
    }
}
