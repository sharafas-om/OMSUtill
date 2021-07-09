package com.oms.downloader.request;

import com.oms.downloader.Priority;


public interface RequestBuilder {

    RequestBuilder setHeader(String name, String value);

    RequestBuilder setPriority(Priority priority);

    RequestBuilder setTag(Object tag);

    RequestBuilder setReadTimeout(int readTimeout);

    RequestBuilder setConnectTimeout(int connectTimeout);

    RequestBuilder setUserAgent(String userAgent);

}
