


interface OnResponseListener {

    fun <T> onResponseReceived(response: T, requestCode: Int)

    fun onResponseError(message: String, requestCode: Int, responseCode: Int)


}
