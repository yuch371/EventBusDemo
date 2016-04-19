package cn.demo.eventbus;

/**
 * Created by Administrator on 2016/4/19.
 */
public class WatchWater {
    private  int       msgType;   //1,2,3
    private  String    title="查水表的";
    private  String    msgText="快开门,查你家水表的";
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

    public WatchWater(int msgType, String title, String msgText, int count) {
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
