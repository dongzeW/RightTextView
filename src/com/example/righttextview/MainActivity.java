package com.example.righttextview;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.widget.TextView;

import com.view.my.MyTextView;

public class MainActivity extends Activity {
	private MyTextView tv;
	private TextView rtv;
	String nameString = "君不见，黄河之水天上来，奔流到海不复回.君不见，高堂明镜悲白发，朝如青丝暮成雪。"
			+ "人生得意须尽欢，莫使金樽空对月。";

	// String nameString = "君不见";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		DisplayMetrics dm = new DisplayMetrics();
		dm = getResources().getDisplayMetrics();
		int width = dm.widthPixels;
		int num = width / 24; // 一行显示多少个字
		int line = nameString.length() / num;// 行数
		tv = (MyTextView) findViewById(R.id.my_tv);
		tv.setHeight(line * 24 * 2);
		rtv = (TextView) findViewById(R.id.my_r_tv);
		rtv.setText(nameString);
		rtv.setHeight(500);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
