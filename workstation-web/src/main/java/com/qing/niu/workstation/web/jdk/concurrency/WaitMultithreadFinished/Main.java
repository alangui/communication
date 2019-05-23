package com.qing.niu.workstation.web.jdk.concurrency.WaitMultithreadFinished;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2019/1/5 15:38
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        VideoConference videoConference = new VideoConference(5);
        new Thread(videoConference).start();

        for (int i = 0; i < 5; i++){
            Participants participants = new Participants(videoConference,"partivipant " + i);
            new Thread(participants).start();
        }
    }
}
