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
	//ctrl+1 ���������ʾ
	//ctrl+shift+o ȫ�ֵ���
	private EditText highEdit;
	private EditText weightEdit;
	private RadioGroup sexGroup;
	private RadioButton manButton;
	private RadioButton womanButton;
	
	private String sex="��";
	//��дonCreate����
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//���ø����onCreate����
		super.onCreate(savedInstanceState);
		//���ز����ļ�
		setContentView(R.layout.activity_main);
		//��ʼ��view ǿ������ת�� (Java��������:��װ �̳� ��̬)
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
					sex="��";
					break;
				case R.id.woman_rbtn:
					manButton.setChecked(false);
					womanButton.setChecked(true);
					sex="Ů";
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
	 * �������㰴ťʱ��
	 * 1.����������public����
	 * ����ֵ������void����
	 * 
	 * @param view
	 */
    public void calculateBmi(View view) {
		Toast.makeText(MainActivity.this, "����˼��㰴ť", Toast.LENGTH_LONG).show();
		String high=highEdit.getText().toString().trim();
		String weight=weightEdit.getText().toString().trim();
		if(TextUtils.isEmpty(high)){
			highEdit.setError("��ȷ�����Ѿ����������Ϣ");
			return;
		}
		if(TextUtils.isEmpty(weight)){
			weightEdit.setError("��ȷ�����Ѿ�����������Ϣ");
			return;
		}
		double bmi=10000*Double.valueOf(weight)/
				(Double.valueOf(high)*Double.valueOf(high));
		Toast.makeText(MainActivity.this, "BMI"+bmi,Toast.LENGTH_LONG).show();
		Intent intent=new Intent(MainActivity.this,
				ResultActivity.class);
		//��intent�����д���ֵ(key-value��ֵ�Ե���ʽ�洢)
		intent.putExtra("BMI", bmi);
		intent.putExtra("SEX", sex);
		//��ʼ��תҳ��
		startActivity(intent);
	}
}
