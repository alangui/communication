package com.qing.niu.communication.request;

import com.google.common.base.Throwables;
import com.qing.niu.communication.request.https.BaseHttpSSLSocketFactory;
import com.qing.niu.communication.request.https.TrustAnyHostnameVerifier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.*;
import java.util.Map;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2018/10/31
 */
@Slf4j
@Service
public class SocketRequest {

    public String postFromSocket(String requestUrl, Map<String,String> requestMap, boolean isProxy, String proxyAddress,
                        int proxyPort, int connnectionTimeout, int readTimeout){
        log.info("建立socket连接");
        long start = System.currentTimeMillis();
        String requestStr = null;
        String responseStr = "";

        HttpURLConnection conn = null;
        OutputStream outputStream = null;
        PrintStream printStream = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            requestStr = getParamStr(requestMap, "utf8");
            log.info("输出流:{}",requestStr);
            URL url = new URL(requestUrl);
            if (isProxy){
                InetSocketAddress inetSocketAddress = new InetSocketAddress(proxyAddress,proxyPort);
                Proxy proxy = new Proxy(Proxy.Type.HTTP,inetSocketAddress);
                conn = (HttpURLConnection) url.openConnection(proxy);
            }else {
                conn = (HttpURLConnection) url.openConnection();
            }
            // 连接超时时间
            conn.setConnectTimeout(connnectionTimeout);
            // 读取结果超时时间
            conn.setReadTimeout(readTimeout);
            // 可读
            conn.setDoInput(true);
            // 可写
            conn.setDoOutput(true);
            // 取消缓存
            conn.setUseCaches(false);
            conn.setRequestProperty("Content-type","application/x-www-form-urlencoded;charset=utf-8");
//            conn.setRequestProperty("Content-type","text/html");
            conn.setRequestMethod("POST");
            if ("https".equalsIgnoreCase(url.getProtocol())){
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) conn;
                httpsURLConnection.setSSLSocketFactory(new BaseHttpSSLSocketFactory());
                httpsURLConnection.setHostnameVerifier(new TrustAnyHostnameVerifier());
            }
            conn.connect();
            //发送数据
            outputStream = conn.getOutputStream();
            printStream = new PrintStream(outputStream,false,"utf-8");
            printStream.print(requestStr);
            printStream.flush();
            //接受数据
            StringBuilder stringBuilder = new StringBuilder(2048);
            inputStream = conn.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream,"utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String temp = null;
            while (null != (temp = bufferedReader.readLine())){
                stringBuilder.append(temp);
            }
            int status;
            status = conn.getResponseCode();
            if (status == 200){
                responseStr = stringBuilder.toString();
            }
            return responseStr;
        } catch (Exception e) {
            log.error("建立socket连接异常:{}",Throwables.getStackTraceAsString(e));
            throw new RuntimeException("建立socket连接异常");
        } finally {
            long end = System.currentTimeMillis();
            log.info("socket连接耗时:{}毫秒",end - start);
            closeStream(outputStream, printStream, inputStream, inputStreamReader, bufferedReader);
            if (null != conn) {
                conn.disconnect();
            }
        }
    }

    public String getParamStr(Map<String,String> requestParam, String encoding) throws UnsupportedEncodingException{
        if (encoding == null || "".equals(encoding)) {
            encoding = "utf-8";
        }
        StringBuffer stringBuffer = new StringBuffer("");
        String reqstr = "";
        if (null != requestParam && 0 != requestParam.size()) {
            for (Map.Entry<String, String> keyMap : requestParam.entrySet()) {
                stringBuffer.append(keyMap.getKey() + "="
                        + (null == keyMap.getValue() || "".equals(keyMap.getValue()) ? "" : URLEncoder.encode(keyMap.getValue(), encoding))
                        + "&");
            }
            reqstr = stringBuffer.substring(0, stringBuffer.length() - 1);
        }
        return reqstr;
    }

    private void closeStream(OutputStream outputStream, PrintStream printStream, InputStream inputStream, InputStreamReader inputStreamReader,
                             BufferedReader bufferedReader) {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (Exception e) {
        }
        try {
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
        } catch (Exception e) {
        }
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Exception e) {
        }
        try {
            if (printStream != null) {
                printStream.close();
            }
        } catch (Exception e) {
        }
        try {
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Exception e) {
            log.info("流关闭异常!");
        }
    }
}
