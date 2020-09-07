package geektime.designpattern.桥接模式;

public class ServerNotification extends Notification {


    public ServerNotification(_1MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        msgSender.sendMsg("严重级别预警信息");
    }
}
