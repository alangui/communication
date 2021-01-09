package com.qing.niu.workstation.design.pattern.chainofresponsibility;

/**
 * <p>
 *     责任链-处理者抽象对象
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2021/1/5
 * @ProjectName communication
 * @Version 1.0.0
 */
public abstract class Handler {

    private Handler next;

    public void setNext(Handler handler) {
        this.next = handler;
    }

    public Handler getNext() {
        return this.next;
    }

    /**
     * 处理请求方法
     *
     * @param request 请求
     */
    public abstract void handleRequest(String request);
}
