package cn.demo.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import de.greenrobot.event.EventBus;

public class Main2Activity extends AppCompatActivity {
    int mCount=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void watchWater(View v){
        WatchWater water=new WatchWater(1,"送乐百氏","今天加班送水，第二个Activity中向主Activity发送",mCount++ );

        EventBus.getDefault().post(water);
    }
    public void sendPost(View v){
        SendPost post=new SendPost(1,"送面膜","今天加班送快递，第二个Activity中向主Activity发送",mCount++ );

        EventBus.getDefault().post(post);
    }
}
