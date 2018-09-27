package com.uohzey.tom;

import android.R.integer;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	private RelativeLayout bg;
	private Button lookBtn;
	private Button talkBtn;
	private Button fartBtn;
	
	private Handler handler=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initBreathAnim();
		handler=new Handler();
		lookBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bg.setBackgroundResource(R.drawable.look_animal);
				AnimationDrawable AnimationDrawable=(AnimationDrawable) bg.getBackground();
				//开始播放动画
				AnimationDrawable.setOneShot(true);
				AnimationDrawable.start();
				int time=0;
				//AnimationDrawable.getNumberOfFrames() 得到动画中所有帧数
				for (int i = 0; i < AnimationDrawable.getNumberOfFrames(); i++) {
					time+=AnimationDrawable.getDuration(i);
				}
				handler.postDelayed(new Runnable() {
					
					@Override
					public void run() {
						bg.setBackgroundResource(R.drawable.breath_animal);
						AnimationDrawable bgAnim= (AnimationDrawable) bg.getBackground();
						bgAnim.start();
						
					}
				}, time);
			}
		});
		}
	/**
	 * 初始化默认动画
	 */
	private void initBreathAnim() {
		bg=(RelativeLayout) findViewById(R.id.bg);
		AnimationDrawable bgAnim=(AnimationDrawable) bg.getBackground();
		//开始播放动画
		bgAnim.start();
	}
	//初始化view操作
	private void initView() {
		lookBtn=(Button) findViewById(R.id.look_btn);
		talkBtn=(Button) findViewById(R.id.talk_btn);
		fartBtn=(Button) findViewById(R.id.fart_btn);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
