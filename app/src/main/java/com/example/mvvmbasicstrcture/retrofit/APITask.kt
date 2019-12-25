import io.reactivex.disposables.Disposable

class APITask : BaseAPITask() {

    private val apiCall: APICall = Retrofit.getRetrofit().create(APICall::class.java)

    companion object Singleton {
        fun getInstance(): APITask {
            return APITask()
        }
    }
    // Example of Service call.
    /*fun isContentValid(listener: OnResponseListener, params: RegisterRequestModel): Disposable? {
        return getRequest(apiCall.isContentValid(params), listener, 1)
    }*/


}