package com.qing.niu.workstation.design.pattern.factory;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/23
 * @ProjectName communication
 * @Version 1.0.0
 */
public abstract class Application {

    /**
     * create
     *
     * @return product
     */
    abstract Product create();

    public Product getProduct() {
        return create();
    }
}
