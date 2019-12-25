package com.example.mvvmbasicstrcture.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * base pojo class for all incoming responses
 * contains only message and code
 * change key if needed.
 */

public class BaseResponse<T> implements Serializable {


    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private T data;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "BaseResponse{" +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
