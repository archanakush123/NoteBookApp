package com.example.notebookapp.base.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notebookapp.base.factory.ViewModelProviderFactory;
import com.google.android.material.appbar.AppBarLayout;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

/**
 * This class is base class for Fragment.s
 *
 * @param <T> Data Binding Type
 * @param <V> View Model Type
 */
public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel> extends Fragment {


    private BaseActivity mActivity;
    private T mViewDataBinding;
    private V mViewModel;


    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    protected abstract int getBindingVariable();

    /**
     * @return layout resource id
     */
    public abstract @LayoutRes
    int getLayoutId();


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            this.mActivity = (BaseActivity) context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        return mViewDataBinding.getRoot();
    }

    /**
     * This implementation create ViewModel
     *
     * @param viewModel
     * @param viewModelClass
     */
    public void createViewModel(BaseViewModel viewModel, Class<V> viewModelClass) {
        ViewModelProviderFactory factory = new ViewModelProviderFactory<>(viewModel);
        mViewModel = ViewModelProviders.of(this, factory).get(viewModelClass);
    }


    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.executePendingBindings();
    }

    /**
     * This implementation return base Activity for current Fragment.
     *
     * @return
     */
    public BaseActivity getBaseActivity() {
        return mActivity;
    }


    /**
     * This implementation return  View Data Binding of T type
     *
     * @return
     */
    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    /**
     * This implementation return View Model for V type
     *
     * @return
     */
    public V getViewModel() {
        return mViewModel;
    }

    /**
     * This implementation handle collapsing layout mode.
     *
     * @param collapseLayout
     * @param toolbar
     * @param titleView
     */
    public void handleCollapsingLayout(AppBarLayout collapseLayout, Toolbar toolbar, View titleView) {
        collapseLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            verticalOffset = Math.abs(verticalOffset);
            if (appBarLayout != null) {
                int difference = appBarLayout.getTotalScrollRange() - toolbar.getHeight();
                if (verticalOffset >= difference) {
                    titleView.setVisibility(View.VISIBLE);
                } else {
                    titleView.setVisibility(View.GONE);

                }
            }
        });
    }
}
