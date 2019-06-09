package com.example.notebookapp.base.ui;

import android.os.Bundle;
import android.util.Log;

import com.example.notebookapp.base.factory.ViewModelProviderFactory;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;


/**
 * This class is base class for Activities .
 *
 * @param <T> Data Binding class
 * @param <V> View Model Class
 */
public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity {

    public static final String TAG = BaseActivity.class.getSimpleName();

    private T mViewDataBinding;
    private V mViewModel;

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract int getBindingVariable();

    /**
     * @return layout resource id
     */
    protected abstract @LayoutRes
    int getLayoutId();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());


    }


    /**
     * This implementation create View Model for activity
     *
     * @param viewModel
     * @param viewModelClass
     */
    public void createViewModel(BaseViewModel viewModel, Class<V> viewModelClass) {
        ViewModelProviderFactory factory = new ViewModelProviderFactory<>(viewModel);
        mViewModel = ViewModelProviders.of(this, factory).get(viewModelClass);
    }

    /**
     * This implementation return ViewModel class of V type
     *
     * @return V --> ViewModel
     */
    public V getViewModel() {
        return mViewModel;
    }

    /**
     * This implementation return View Data Binding class of T type
     *
     * @return T --> DataBinding
     */
    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    /**
     * This implementation set Toolbar back icon and handle click
     */
    protected void setToolBarBack(Toolbar toolBar, String title) {
        try {
//            toolBar.setNavigationIcon(R.drawable.back);
            toolBar.setTitle(title);
            toolBar.setNavigationOnClickListener((view) -> {
                onBackPressed();
            });
        } catch (Exception ex) {
            Log.e(TAG, "Error on set toolbar " + ex.getMessage());
        }
    }


}
