package com.uohzey.bmi;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.TextureView;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends Activity {
	private ImageView resultImg;
	private TextView resultTv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		resultImg=(ImageView) findViewById(R.layout.activity_result);
		resultTv=(TextView) findViewById(R.id.result_tv)：
		//得到intent对象
		Intent intent=getIntent();
		//拿出intent对象中从MainActivity中传过来的sex值跟bmi值
		String sex=intent.getStringExtra("SEX");
		double bmi=intent.getDoubleExtra("BMI", -1);
		Log.d("ResultActivity", "sex="+sex+",bmi="+bmi);
		if(sex.equals("男")){
			if(bmi<=18.4){
				resultImg.setImageResource(R.drawable.bmi_1);
				resultTv.setText
				("BMI:"+bmi+"\n提示:偏瘦\n"+"性别"+sex);
			}
			else if(bmi>18.4&&bmi<=23.9){
				resultImg.setImageResource(R.drawable.bmi_1);
				resultTv.setText
				("BMI:"+bmi+"\n提示:正常\n"+"性别"+sex);
			}
			else if(bmi<=27.9&&bmi>23.9){
				resultImg.setImageResource(R.drawable.bmi_1);
				resultTv.setText
				("BMI:"+bmi+"\n提示:偏胖\n"+"性别"+sex);
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

}
