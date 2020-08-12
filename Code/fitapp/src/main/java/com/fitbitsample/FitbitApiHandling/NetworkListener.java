package com.fitbitsample.FitbitApiHandling;

import java.util.Map;


public interface NetworkListener<T> {

    void success(T t);

    void headers(Map<String, String> header);

    void failure();
}
