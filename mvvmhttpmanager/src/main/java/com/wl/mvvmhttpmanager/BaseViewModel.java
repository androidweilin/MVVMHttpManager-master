package com.wl.mvvmhttpmanager;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.wl.mvvmhttpmanager.utils.TUtil;

/**
 * @author freak
 * @date 2019/01/25
 */

public class BaseViewModel<T extends AbstractRepository> extends AndroidViewModel {
    public T mRepository;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        mRepository = TUtil.getNewInstance(this, 0);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (mRepository != null) {
            mRepository.unDisposable();
            mRepository.unSubscribe();
        }

    }
}
