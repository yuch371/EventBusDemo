package cn.demo.eventbus;

/**
 * Created by yuch on 2016/4/19.
 */
public class SendPost {
    private  int       msgType;   //1,2,3
    private  String    title="送快递";
    private  String    msgText="亲，你的快递到了";
    private  int      count;

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public SendPost(int msgType, String title, String msgText, int count) {
        this.msgType = msgType;
        this.title = title;
        this.msgText = msgText;
        this.count = count;
    }

    @Override
    public String toString() {
        return "msgType="+msgType+",title="+title+",msgText="+msgText+",count="+count;
    }
}
