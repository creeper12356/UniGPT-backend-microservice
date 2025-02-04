package com.unigpt.chat.utils;

public class SetProxy {
    public static void setProxy() {
        String proxyPort = System.getenv("HTTP_PROXY_PORT");
        proxyPort = proxyPort == null ? "7890" : proxyPort;
        String proxyHost = System.getenv("HTTP_PROXY_HOST");
        proxyHost = proxyHost == null ? "127.0.0.1" : proxyHost;
        
        System.setProperty("http.proxyHost", proxyHost);
        System.setProperty("http.proxyPort", proxyPort);
        System.setProperty("https.proxyHost", proxyHost);
        System.setProperty("https.proxyPort", proxyPort);
    }

    public static void unsetProxy() {
        System.clearProperty("http.proxyHost");
        System.clearProperty("http.proxyPort");
        System.clearProperty("https.proxyHost");
        System.clearProperty("https.proxyPort");
    }
}
