package geektime.designpattern.桥接模式;

public class _1TelephoneMsgSender implements _1MsgSender {
    @Override
    public void sendMsg(String msg) {
        System.out.println("电话发送消息: " + msg);
    }
}
