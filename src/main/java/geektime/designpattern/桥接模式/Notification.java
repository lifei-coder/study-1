package geektime.designpattern.桥接模式;

public abstract class Notification {

    protected _1MsgSender msgSender;

    public Notification(_1MsgSender msgSender) {
        this.msgSender = msgSender;
    }

    public abstract void notify(String message);

}
