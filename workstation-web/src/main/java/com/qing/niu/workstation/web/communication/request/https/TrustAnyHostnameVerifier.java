package com.qing.niu.workstation.web.communication.request.https;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2018/10/31
 */
public class TrustAnyHostnameVerifier implements HostnameVerifier{

    @Override
    public boolean verify(String hostname, SSLSession session) {
        return true;
    }

}
