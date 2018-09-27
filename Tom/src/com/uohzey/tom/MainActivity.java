package com.uohzey.tom;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	private RelativeLayout bg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bg=(RelativeLayout) findViewById(R.id.bg);
		AnimationDrawable bgAnim=(AnimationDrawable) bg.getBackground();
		bgAnim.start();
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
