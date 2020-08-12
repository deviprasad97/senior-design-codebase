package com.fitbitsample.FitbitApiHandling;

import java.util.Map;
/*
    This class serves as Listener for the Network Handler
 */

public interface NetworkListener<T> {

    void success(T t);

    void headers(Map<String, String> header);

    void failure();
}
