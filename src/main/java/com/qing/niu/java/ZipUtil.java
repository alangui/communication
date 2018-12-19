package com.qing.niu.java;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2018/12/19
 */
@Slf4j
public class ZipUtil {

    private static final int buffer = 2048;

    /**
     * 解压单个文件
     *
     * @param path zip压缩文件路径
     * @param desFile 解压后目标文件(不传的话解压文件与压缩文件同路径)
     */
    public static void unSingleZipFile(String path, File desFile){
        String savePath = path.substring(0,path.lastIndexOf("."));
        File file = null;
        if (null == desFile) {
            file = new File(savePath);
        }else {
            file = desFile;
        }
        ZipFile zipFile = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            zipFile = new ZipFile(path);
            String zipEntryName = savePath.substring(savePath.lastIndexOf("/")+1);
            ZipEntry zipEntry = zipFile.getEntry(zipEntryName);

            inputStream = zipFile.getInputStream(zipEntry);
            fileOutputStream = new FileOutputStream(file);

            byte[] buf = new byte[buffer];
            int count = -1;
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream,buffer);
            while((count = inputStream.read(buf)) != -1){
                fileOutputStream.write(buf,0,count);
            }
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            fileOutputStream.close();
            inputStream.close();
            zipFile.close();
        } catch (IOException e) {
            log.warn("IO异常:{}",Throwables.getStackTraceAsString(e));
        } finally {
            try {
                if (null != bufferedOutputStream){
                    bufferedOutputStream.close();
                }
                if (null != fileOutputStream){
                    fileOutputStream.close();
                }
                if (null != inputStream){
                    inputStream.close();
                }
                if (null != zipFile){
                    zipFile.close();
                }
            } catch (IOException e) {
                log.warn("IO流关闭异常:{}",Throwables.getStackTraceAsString(e));
            }
        }
    }

    public static void main(String[] args) throws Exception{
        String filePath = "/data/zipfile/1900008721All2018-04-03.csv.zip";
        File file = new File("/data/zipfile/1900008721All2018-04-03.txt");
        unSingleZipFile(filePath,file);
        Thread.sleep(2000L);
        file.delete();
    }
}
