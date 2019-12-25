package com.example.mvvmbasicstrcture.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * acts as a container of any response containing single object
 * <pre>
 * example :
 * if the response is like below :
 * {
 *     "code" : xyz
 *     "message" : xyz
 *     "data" : {
 *         pojo class
 *     }
 * }
 *     Then, pojo class will be automatically mapped to generic param T if the response class extend BaseObjectResponse like below:
 *
 *     class MyApiResponse extends BaseObjectResponse<DataModel>
 *            --your response--            --model inside data key--
 * </pre>
 *
 * @param <T> data model generated from object inside response
 */
public class BaseObjectResponse<T> extends BaseResponse {

    //change key if needed
    @SerializedName("data")
    @Expose
    private T data;

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "BaseObjectResponse{" +
                "data=" + data +
                "} " + super.toString();
    }
}
