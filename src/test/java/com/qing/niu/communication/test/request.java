package com.qing.niu.communication.test;

import com.qing.niu.communication.request.SocketRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
public class request extends BaseSpringTest{

    @Autowired
    private SocketRequest socketRequest;

    @Test
    public void post() throws Exception{
        Map<String,String> requestMap = new HashMap<>();
        requestMap.put("merchantNo","6666");
        requestMap.put("merchantName","google");
        requestMap.put("orderNo","123456");
        requestMap.put("amount","1");
        requestMap.put("tradeTime", new SimpleDateFormat("yyyyMmddHHmmssSSS").format(new Date()));
        String response = socketRequest.postFromSocket("http://127.0.0.1:28380/demo",requestMap,false,null,80,20000,20000);
        log.info("{}",response);
        Thread.sleep(20000L);
    }
}
