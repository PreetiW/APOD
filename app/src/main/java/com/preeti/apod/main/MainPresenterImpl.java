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
    public void receivedAPODImage(ApodImage apodImage) {
        mainView.hideProgress();
        mainView.showAPODImage(apodImage);
    }
}
