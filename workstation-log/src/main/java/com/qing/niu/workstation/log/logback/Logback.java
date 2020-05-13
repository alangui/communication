package com.qing.niu.workstation.log.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/5/13 20:55
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Logback {

    private static Logger logger = LoggerFactory.getLogger(Logback.class);

    public static void main(String[] args) {
        MDC.put("TRACE_LOG_ID", UUID.randomUUID().toString());
        logger.info("hello {} {}","world","!");
    }
}
