package geektime.designpattern.桥接模式;



public class NormalNotification extends Notification {

    public NormalNotification(_1MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        msgSender.sendMsg("正常预警信息");
    }
}


