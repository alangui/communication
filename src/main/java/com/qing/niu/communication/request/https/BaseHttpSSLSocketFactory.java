package com.qing.niu.communication.request.https;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2018/10/31
 */
public class BaseHttpSSLSocketFactory extends SSLSocketFactory{

    private SSLContext getSSLContext() {
        SSLContext context = null;
        try {
            context = SSLContext.getInstance("SSL");
            context.init(null, new TrustManager[] { BaseHttpX509TrustManager.manger }, null);
            return context;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return context;
    }

    @Override
    public Socket createSocket(InetAddress arg0, int arg1, InetAddress arg2, int arg3) throws IOException {
        return getSSLContext().getSocketFactory().createSocket(arg0, arg1, arg2, arg3);
    }

    @Override
    public Socket createSocket(String arg0, int arg1, InetAddress arg2, int arg3) throws IOException, UnknownHostException {
        return getSSLContext().getSocketFactory().createSocket(arg0, arg1, arg2, arg3);
    }

    @Override
    public Socket createSocket(InetAddress arg0, int arg1) throws IOException {
        return getSSLContext().getSocketFactory().createSocket(arg0, arg1);
    }

    @Override
    public Socket createSocket(String arg0, int arg1) throws IOException, UnknownHostException {
        return getSSLContext().getSocketFactory().createSocket(arg0, arg1);
    }

    @Override
    public String[] getSupportedCipherSuites() {
        return null;
    }

    @Override
    public String[] getDefaultCipherSuites() {
        return null;
    }

    @Override
    public Socket createSocket(Socket arg0, String arg1, int arg2, boolean arg3) throws IOException {
        return getSSLContext().getSocketFactory().createSocket(arg0, arg1, arg2, arg3);
    }

}
