package cn.demo.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {
    Button mButton1,mButton2,mButton3;
    TextView mTextView2;
    int mCount=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFind();
        initData();
        initEvent();
    }

    private void initEvent() {
        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id =v.getId();
                switch (id){
                    case R.id.button1:
                        sendWatchWater();
                        break;
                    case R.id.button2:
                        sendPostrInThread();
                        break;
                    case R.id.button3:
                        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(intent);
                        break;
                }
            }
        };
        mButton1.setOnClickListener(onClickListener);
        mButton2.setOnClickListener(onClickListener);
        mButton3.setOnClickListener(onClickListener);
    }

    private void initData() {
        //注册事件
        //de.greenrobot.event.EventBus.getDefault().register(MainActivity.this);
        EventBus.getDefault().register(MainActivity.this);
    }

    /*

    onEvent:如果使用onEvent作为订阅函数，那么该事件在哪个线程发布出来的，
    onEvent就会在这个线程中运行，也就是说发布事件和接收事件线程在同一个线程。使用这个方法时，
    在onEvent方法中不能执行耗时操作，如果执行耗时操作容易导致事件分发延迟。

    onEventMainThread:如果使用onEventMainThread作为订阅函数，那么不论事件是在哪个线程中发布出来的，
    onEventMainThread都会在UI线程中执行，接收事件就会在UI线程中运行，
    这个在Android中是非常有用的，因为在Android中只能在UI线程中跟新UI，
    所以在onEvnetMainThread方法中是不能执行耗时操作的。

    onEventBackground:如果使用onEventBackgrond作为订阅函数，那么如果事件是在UI线程中发布出来的，
    那么onEventBackground就会在子线程中运行，如果事件本来就是子线程中发布出来的，
    那么onEventBackground函数直接在该子线程中执行。

    onEventAsync：使用这个函数作为订阅函数，那么无论事件在哪个线程发布，都会创建新的子线程在执行onEventAsync.
     */
    /***
     * 重写事件的回调函数
     * @param event
     */
    /*
    public void onEvent(Water event) {
        mTextView1.setText(event.toString());
    };
    */
    public void onEventMainThread(WatchWater event) {
        mTextView2.setText(event.toString());
    };
    public void onEventMainThread(SendPost event) {
        mTextView2.setText(event.toString());
    };

    private void  initFind() {
        mButton1= (Button) findViewById(R.id.button1);
        mButton2= (Button) findViewById(R.id.button2);
        mButton3= (Button) findViewById(R.id.button3);
        mTextView2= (TextView) findViewById(R.id.textView2);
    }

    private void sendWatchWater(){
        WatchWater water=new WatchWater(1,"送乐百氏","今天加班送水，在主线程中",mCount++ );
        EventBus.getDefault().post(water);
    }
    private void sendPostrInThread(){
        new Thread(){
            @Override
            public void run() {
                String name=Thread.currentThread().getName();
                SendPost  sendPost=new SendPost(1,"送快递","亲，你的快递到了，请签收"+name+"中",mCount++ );
                EventBus.getDefault().post(sendPost);
            }
        }.start();
    }

}
