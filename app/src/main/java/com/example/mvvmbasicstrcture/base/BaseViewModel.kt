import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    protected var mDisposable: CompositeDisposable? = null


    override fun onCleared() {
        super.onCleared()
        mDisposable?.dispose()
    }

}