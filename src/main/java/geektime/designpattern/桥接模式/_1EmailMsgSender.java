package geektime.designpattern.桥接模式;

public class _1EmailMsgSender implements _1MsgSender {
    @Override
    public void sendMsg(String msg) {
        System.out.println("邮箱发送消息：" + msg);
    }
}
