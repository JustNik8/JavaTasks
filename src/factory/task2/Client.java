package factory.task2;

import factory.task2.chairs.Chair;

public class Client {
    private Chair chair;


    public void setChair(Chair chair) {
        this.chair = chair;
    }

    public void sit(){
        chair.sit();
    }
}
