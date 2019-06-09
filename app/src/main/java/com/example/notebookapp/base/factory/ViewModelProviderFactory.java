package com.example.notebookapp.base.factory;


import com.example.notebookapp.base.ui.BaseViewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * A provider factory that persists ViewModels {@link ViewModel}.
 */
public class ViewModelProviderFactory<V extends BaseViewModel> implements ViewModelProvider.Factory {

    private BaseViewModel viewModel;


    public ViewModelProviderFactory(BaseViewModel baseViewModel) {
        viewModel = baseViewModel;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        //noinspection unchecked
        if (modelClass.isAssignableFrom(viewModel.getClass())) {
            return (T) viewModel;
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}
