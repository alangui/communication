package com.qing.niu.workstation.design.pattern.strategy;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/28
 * @ProjectName communication
 * @Version 1.0.0
 */
public class StrategyContext {

    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod() {
        this.strategy.strategyMethod();
    }
}
