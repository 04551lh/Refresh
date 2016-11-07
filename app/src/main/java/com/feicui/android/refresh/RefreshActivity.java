package com.feicui.android.refresh;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class RefreshActivity extends Activity {
    ListView lv_data;
    ArrayList<String> mList;
    MyAdapter myAdapter;
    Handler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        initView();
    }

    private void initView(){
        lv_data = (ListView) findViewById(R.id.lv_data);
        mList = new ArrayList<String>();
        for (int i = 0; i < 10; i++){
            String Data = String.valueOf(i);
            mList.add(Data);
        }
        myAdapter = new MyAdapter(this, mList);
        lv_data.setAdapter(myAdapter);

        myHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 0x001:
                        myAdapter.notifyDataSetChanged();
                        break;
                }
            }
        };

        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(), 3000, 3000);
    }

    class MyTimerTask extends TimerTask{

        @Override
        public void run() {
            mList.removeAll(mList);
            for ( int i = 10 ; i < 20; i++) {
                String Data = String.valueOf(i);
                mList.add(Data);
            }
            Message mMessage = Message.obtain();
            mMessage.what = 0x001;
            myHandler.sendMessage(mMessage);
        }
    }
}
