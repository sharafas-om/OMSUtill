package com.oms.downloader.internal;

import android.content.Context;

import com.oms.downloader.Constants;
import com.oms.downloader.Downloader;
import com.oms.downloader.DownloaderConfig;
import com.oms.downloader.database.AppDbHelper;
import com.oms.downloader.database.DbHelper;
import com.oms.downloader.database.NoOpsDbHelper;
import com.oms.downloader.httpclient.DefaultHttpClient;
import com.oms.downloader.httpclient.HttpClient;

public class ComponentHolder {

    private final static ComponentHolder INSTANCE = new ComponentHolder();
    private int readTimeout;
    private int connectTimeout;
    private String userAgent;
    private HttpClient httpClient;
    private DbHelper dbHelper;

    public static ComponentHolder getInstance() {
        return INSTANCE;
    }

    public void init(Context context, DownloaderConfig config) {
        this.readTimeout = config.getReadTimeout();
        this.connectTimeout = config.getConnectTimeout();
        this.userAgent = config.getUserAgent();
        this.httpClient = config.getHttpClient();
        this.dbHelper = config.isDatabaseEnabled() ? new AppDbHelper(context) : new NoOpsDbHelper();
        if (config.isDatabaseEnabled()) {
            Downloader.cleanUp(30);
        }
    }

    public int getReadTimeout() {
        if (readTimeout == 0) {
            synchronized (ComponentHolder.class) {
                if (readTimeout == 0) {
                    readTimeout = Constants.DEFAULT_READ_TIMEOUT_IN_MILLS;
                }
            }
        }
        return readTimeout;
    }

    public int getConnectTimeout() {
        if (connectTimeout == 0) {
            synchronized (ComponentHolder.class) {
                if (connectTimeout == 0) {
                    connectTimeout = Constants.DEFAULT_CONNECT_TIMEOUT_IN_MILLS;
                }
            }
        }
        return connectTimeout;
    }

    public String getUserAgent() {
        if (userAgent == null) {
            synchronized (ComponentHolder.class) {
                if (userAgent == null) {
                    userAgent = Constants.DEFAULT_USER_AGENT;
                }
            }
        }
        return userAgent;
    }

    public DbHelper getDbHelper() {
        if (dbHelper == null) {
            synchronized (ComponentHolder.class) {
                if (dbHelper == null) {
                    dbHelper = new NoOpsDbHelper();
                }
            }
        }
        return dbHelper;
    }

    public HttpClient getHttpClient() {
        if (httpClient == null) {
            synchronized (ComponentHolder.class) {
                if (httpClient == null) {
                    httpClient = new DefaultHttpClient();
                }
            }
        }
        return httpClient.clone();
    }

}
