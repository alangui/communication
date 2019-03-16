package com.qing.niu.communication.test;

import com.qing.niu.util.IpUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2019/3/16 18:08
 * @ProjectName communication
 * @Version 1.0.0
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        String ip = IpUtils.getLocalIP();
        String ipRename = ip.replaceAll("\\.","_");
        log.info("{}----------{}",ip,ipRename);
    }
}
