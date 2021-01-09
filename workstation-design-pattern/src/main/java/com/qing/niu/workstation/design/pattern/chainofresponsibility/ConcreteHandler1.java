package com.qing.niu.workstation.design.pattern.chainofresponsibility;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2021/1/5
 * @ProjectName communication
 * @Version 1.0.0
 */
public class ConcreteHandler1 extends Handler {

    private final static String ONE = "one";

    @Override
    public void handleRequest(String request) {
        if (request.equals(ONE)) {
            System.out.println("处理者1处理该请求");
        } else {
            Handler handler = getNext();
            if (null != handler) {
                handler.handleRequest(request);
            } else {
                System.out.println("没有处理者处理该任务！");
            }
        }
    }
}
