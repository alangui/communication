package com.qing.niu.communication.sftp;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * <p>
 *     Sftp工具类
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2018/12/24
 */
public class SftpTool {

    public static final Logger logger = LoggerFactory.getLogger(SftpTool.class);

    private String host;

    private String username;

    private int port;

    public SftpTool(String host, String username, int port){
        this.host = host;
        this.username = username;
        this.port = port;
    }

    /**
     * 下载文件
     *
     * @param downloadFilePath 要下载的文件所在绝对路径
     * @param downloadFileName 要下载的文件名(sftp服务器上的文件名)
     * @param saveFile 文件存放位置（文件名+文件所在绝对路径）
     * @param authTypeMode 用户认证方式
     */
    public void download(String downloadFilePath, String downloadFileName, File saveFile, AuthTypeMode authTypeMode) throws Exception{
        Assert.notNull(downloadFilePath,"download file absolute path is not null");
        Assert.notNull(downloadFileName,"download file is not null");
        Assert.notNull(saveFile,"save file location is not null");
        Assert.notNull(authTypeMode,"auth type way is not null");

        OutputStream outputStream = null;
        ChannelSftp sftp = null;
        try {
            JSch jsch = new JSch();
            logger.info("获取SFTP服务器连接username:{},host:{},port:{}",username,host,port);
            Session session = jsch.getSession(username,host,port);
            logger.info("连接成功建立");
            if (AuthTypeEnum.RSA.getCode().equals(authTypeMode.getAuthType())){
                jsch.addIdentity(authTypeMode.getAuthValue(),"");
            }else {
                session.setPassword(authTypeMode.getAuthValue());
            }
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking","no");
            sshConfig.put("PreferredAuthentications","publickey,gssapi-with-mic,keyboard-interactive,password");
            session.setConfig(sshConfig);
            session.connect();
            logger.info("用户" + username + "成功登陆");
            Channel channel = session.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;

            logger.info("待下载文件地址为:" + downloadFilePath + ",文件名为:" + downloadFileName);
            sftp.cd(downloadFilePath);
            sftp.ls(downloadFileName);
            outputStream = new FileOutputStream(saveFile);
            sftp.get(downloadFileName,outputStream);
            logger.info("文件下载完成！");
        } finally {
            if (null != outputStream){
                outputStream.close();
            }
            if(sftp != null && sftp.isConnected()){
                sftp.disconnect();
            }
        }
    }

    /**
     * authType = PASSWORD，authValue = password
     * authType = rsa，authValue = rsa文件路径
     */
    class AuthTypeMode{
        private String authType;

        private String authValue;

        AuthTypeMode(String authType, String authValue){
            this.authType = authType;
            this.authValue = authValue;
        }

        String getAuthType(){
            return authType;
        }

        String getAuthValue(){
            return authValue;
        }
    }

    enum AuthTypeEnum {

        PASSWORD("PASSWORD","密码认证"),

        RSA("RSA","rsa密钥认证");

        private String code;

        private String desc;

        AuthTypeEnum(String code, String desc){
            this.code = code;
            this.desc = desc;
        }

        public String getCode(){
            return this.code;
        }
    }

    public static void main(String[] args) throws Exception{
        SftpTool sftpTool = new SftpTool("192.168.67.144","sftpuser",22);
        //下载文件
        File saveFile = new File("/data/sftp/download.txt");
        sftpTool.download("/admin","1900008721All2018-04-03.csv",saveFile,sftpTool.new AuthTypeMode(AuthTypeEnum.PASSWORD.getCode(),"alan123456"));
    }
}
