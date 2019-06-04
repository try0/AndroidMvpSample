package jp.try0.android.mvpsample.content.main;

import android.util.Log;

import javax.inject.Inject;

import jp.try0.android.mvpsample.usecase.IMainUseCase;

public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View view;

    @Inject
    IMainUseCase useCase;

    @Inject
    public MainPresenter(MainContract.View view){
        this.view = view;
    }

    @Override
    public void print() {
        Log.i("MainPresenter", "print");

        useCase.print();

        view.printedInformation();
    }
}
