package com.uohzey.tom;

import java.util.HashMap;

import android.R.integer;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
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
	private SoundPool soundPool=null;
	private Handler handler=null;
	private HashMap<Integer, Integer> hashMap=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initBreathAnim();
		handler=new Handler();
		hashMap=new HashMap<Integer, Integer>();
		soundPool=new SoundPool(4, AudioManager.STREAM_MUSIC,0);
		hashMap.put(1, soundPool.load(MainActivity.this, R.raw.p_knockout3,1));
		hashMap.put(2, soundPool.load(MainActivity.this, R.raw.p_poke_foot3,1));
		hashMap.put(3, soundPool.load(MainActivity.this, R.raw.p_poke_tail13,1));
		hashMap.put(4, soundPool.load(MainActivity.this, R.raw.pillow5,1));
		lookBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				/**
				 * soundID播放源
				 * leftValume左声道
				 * rightValume右声道
				 */
				soundPool.play(hashMap.get(1), 1, 1, 0, 0,1);
				startAnim(R.drawable.look_animal);
			}			
		});
		talkBtn.setOnClickListener(new OnClickListener() {
			@Override
			
			public void onClick(View v) {
				soundPool.play(hashMap.get(2), 1, 1, 0, 0,1);
				startAnim(R.drawable.talk_animal);
			}
		});
		fartBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				soundPool.play(hashMap.get(3), 1, 1, 0, 0,1);
				startAnim(R.drawable.fart_animal);
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
	private void startAnim(int resId) {
		lookBtn.setClickable(false);
		talkBtn.setClickable(false);
		fartBtn.setClickable(false);
		// TODO Auto-generated method stub
		bg.setBackgroundResource(resId);
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
				lookBtn.setClickable(true);
				talkBtn.setClickable(true);
				fartBtn.setClickable(true);
				bg.setBackgroundResource(R.drawable.breath_animal);
				AnimationDrawable bgAnim= (AnimationDrawable) bg.getBackground();
				bgAnim.start();
				
			}
		}, time);
	}
}
