package com.uohzey.constellation;

import com.uohzey.constellation.MainActivity;
import com.uohzey.constellation.ResultActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText monthEdit;
	private EditText daytEdit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		monthEdit=(EditText) findViewById(R.id.month_edit);
		daytEdit=(EditText) findViewById(R.id.day_edit);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
    public void calculate(View view) {
		Toast.makeText(MainActivity.this, "����˼��㰴ť", Toast.LENGTH_LONG).show();
		String month=monthEdit.getText().toString().trim();
		String day=daytEdit.getText().toString().trim();
		if(TextUtils.isEmpty(month)){
			monthEdit.setError("��ȷ�����Ѿ�����month");
			return;
		}
		if(TextUtils.isEmpty(day)){
			daytEdit.setError("��ȷ�����Ѿ�����day");
			return;
		}

		Intent intent=new Intent(MainActivity.this,
				ResultActivity.class);
		//��intent�����д���ֵ(key-value��ֵ�Ե���ʽ�洢)
		intent.putExtra("MON", Integer.valueOf(month));
		intent.putExtra("DAY", Integer.valueOf(day));

		//��ʼ��תҳ��
		startActivity(intent);
	}

}
