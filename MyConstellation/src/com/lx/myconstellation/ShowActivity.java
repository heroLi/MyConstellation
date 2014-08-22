package com.lx.myconstellation;

import org.apache.http.client.HttpClient;

import com.lx.utils.HTTPUtils;
import com.lx.utils.WebServerAsy;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

public class ShowActivity extends Activity {

	private TextView xingAll, xingWork, xingLove, xingMenoy, healthView,
			workView, numberView, colorView, allView, supeiView;

	String id, type, title;

	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			Log.d("星座运势", msg.obj.toString());
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_layout);
		initView();
	}

	private void initView() {
		xingAll = (TextView) findViewById(R.id.yunshi_zonghe);
		xingWork = (TextView) findViewById(R.id.yunshi_work);
		xingLove = (TextView) findViewById(R.id.yunshi_love);
		xingMenoy = (TextView) findViewById(R.id.yunshi_menoy);
		healthView = (TextView) findViewById(R.id.yunshi_health);
		workView = (TextView) findViewById(R.id.yunshi_talk);
		numberView = (TextView) findViewById(R.id.yunshi_number);
		colorView = (TextView) findViewById(R.id.yunshi_color);
		allView = (TextView) findViewById(R.id.yunshi_all);
		supeiView = (TextView) findViewById(R.id.yunshi_xingzuo);

		id = getIntent().getStringExtra("id");
		type = getIntent().getStringExtra("type");
		title = getIntent().getStringExtra("title");

		new WebServerAsy(this, mHandler).sendExecuteDialog(new String[] {
				"day", "" }, HTTPUtils.DAY_CONSTELLATION);

	}
}
