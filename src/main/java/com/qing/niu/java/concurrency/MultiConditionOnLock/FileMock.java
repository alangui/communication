package com.qing.niu.java.concurrency.MultiConditionOnLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/1/4
 */
public class FileMock {

    private Logger logger = LoggerFactory.getLogger(FileMock.class);

    private String[] content;

    private int index;

    public FileMock(int size, int length){
        content = new String[size];
        for (int i = 0; i < size; i++){
            StringBuffer stringBuffer = new StringBuffer(length);
            for (int j = 0; j < length; j++){
                int random = (int)Math.random() * 255;
                stringBuffer.append(random);
            }
            content[i] = stringBuffer.toString();
        }
        index = 0;
    }

    public boolean hasMoreLines(){
        return index < content.length;
    }

    public String getLines(){
        if (this.hasMoreLines()){
            logger.info("mock :{}",(content.length - index));
            return content[index++];
        }
        return null;
    }
}
