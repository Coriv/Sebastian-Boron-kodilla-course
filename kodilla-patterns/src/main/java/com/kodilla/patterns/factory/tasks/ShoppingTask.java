package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task{

    final private String taskName;
    final private String whatToBuy;
    final private double quantity;
    private boolean isExecuted = false;


    public ShoppingTask(final String taskName, final String whatToBuy, final double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public void executeTask() {
    isExecuted = true;
    }
    @Override
    public String getTaskName() {
        return taskName;
    }
    @Override
    public boolean isTaskExecuted() {
        return isExecuted;
    }
}
