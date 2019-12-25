

import android.content.Context
import com.example.mvvmbasicstrcture.MyApplication
import com.example.mvvmbasicstrcture.R
import com.example.mvvmbasicstrcture.helper.Utils
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

open class BaseAPITask {

    val NO_INTERNET = 210

    private fun isInternetAvailable(context: Context): Boolean {
        return Utils.isConnected(context)
    }

    private fun noInternetError(context: Context): String {
        return context.resources.getString(R.string.e_no_internet)
    }


    protected fun <T> getRequest(
        request: Observable<Response<T>>,
        mListener: OnResponseListener,
        requestCode: Int
    ): DisposableObserver<*>? {
        return if (isInternetAvailable(MyApplication.getInstance())) {
            request.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(APICallback(mListener, requestCode, request))
        } else {
            mListener.onResponseError(noInternetError(MyApplication.getInstance()), requestCode, NO_INTERNET)
            null
        }

    }

}