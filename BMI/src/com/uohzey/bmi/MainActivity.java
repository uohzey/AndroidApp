package com.uohzey.bmi;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity {
	//ctrl+1 代码错误提示
	//ctrl+shift+o 全局导包
	private EditText highEdit;
	private EditText weightEdit;
	private RadioGroup sexGroup;
	private RadioButton manButton;
	private RadioButton womanButton;
	
	private String sex="男";
	//重写onCreate方法
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//调用父类的onCreate方法
		super.onCreate(savedInstanceState);
		//加载布局文件
		setContentView(R.layout.activity_main);
		//初始化view 强制类型转化 (Java三大特性:封装 继承 多态)
		highEdit=(EditText) findViewById(R.id.high_edit);
		weightEdit=(EditText) findViewById(R.id.weight_edit);
		sexGroup=(RadioGroup) findViewById(R.id.sex_group);
		manButton=(RadioButton) findViewById(R.id.man_rbtn);
		womanButton=(RadioButton) findViewById(R.id.woman_rbtn);
		sexGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch (checkedId) {
				case R.id.man_rbtn:
					manButton.setChecked(true);
					womanButton.setChecked(false);
					sex="男";
					break;
				case R.id.woman_rbtn:
					manButton.setChecked(false);
					womanButton.setChecked(true);
					sex="女";
					break;
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	/**
	 * 监听计算按钮时间
	 * 1.方法必须是public类型
	 * 返回值必须是void类型
	 * 
	 * @param view
	 */
    public void calculateBmi(View view) {
		Toast.makeText(MainActivity.this, "点击了计算按钮", Toast.LENGTH_LONG).show();
		String high=highEdit.getText().toString().trim();
		String weight=weightEdit.getText().toString().trim();
		if(TextUtils.isEmpty(high)){
			highEdit.setError("请确认您已经输入身高信息");
			return;
		}
		if(TextUtils.isEmpty(weight)){
			weightEdit.setError("请确认您已经输入体重信息");
			return;
		}
		double bmi=10000*Double.valueOf(weight)/
				(Double.valueOf(high)*Double.valueOf(high));
		Toast.makeText(MainActivity.this, "BMI"+bmi,Toast.LENGTH_LONG).show();
		Intent intent=new Intent(MainActivity.this,
				ResultActivity.class);
		//往intent对象中存入值(key-value键值对的形式存储)
		intent.putExtra("BMI", bmi);
		intent.putExtra("SEX", sex);
		//开始调转页面
		startActivity(intent);
	}
}
