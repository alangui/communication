package com.qing.niu.workstation.log;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/5/13 20:54
 * @ProjectName communication
 * @Version 1.0.0
 */
@Setter
@Getter
@ToString
@Slf4j
public class MainLog {

    public static void main(String[] args) {
        log.info("{}{}{}{}{}","a","b","c","d","e");
    }
}
