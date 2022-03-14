package com.bighao.project.mvp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by Hao on 2021/7/14
 */
public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {
    private Reference<Context> mContext;
    private Reference<V> mViewRef;

    public BasePresenter(Context context, V view) {
        mContext = new WeakReference<>(context);
        attachView(view);
    }

    @Override
    public void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
    }

    @Override
    public Context getContext() {
        return null == mContext ? null : mContext.get();
    }

    @Override
    public V getView() {
        return null == mViewRef ? null : mViewRef.get();
    }


    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    @Override
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    @Override
    public void release() {
        detachView();
        if (mContext != null) {
            mContext.clear();
            mContext = null;
        }
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {

    }
}
