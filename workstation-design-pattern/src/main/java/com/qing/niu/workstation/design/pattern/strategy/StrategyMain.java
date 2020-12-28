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
public class StrategyMain {

    public static void main(String[] args) {
        StrategyContext context = new StrategyContext();
        context.setStrategy(new ConcreteStrategyA());
        context.strategyMethod();
        System.out.println("===================");
        context.setStrategy(new ConcreteStrategyB());
        context.strategyMethod();
    }
}
