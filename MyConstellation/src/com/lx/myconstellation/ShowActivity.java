package com.lx.myconstellation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.lx.utils.HTTPUtils;
import com.lx.utils.WebServerAsy;

public class ShowActivity extends Activity {

	private TextView xingAll, xingWork, xingLove, xingMenoy, healthView,
			workView, numberView, colorView, allView, supeiView;

	String id, type, title;

	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			Log.d("星座运势", msg.obj.toString());
//			DayResponses dayResponses = new DayResponses();
			// List<ResultResponses> list = new ArrayList<ResultResponses>();
			// JSONArray jsonArray = new JSONArray(msg.obj.toString());
			// for (int i = 0; i < jsonArray.length(); i++) {
			// ResultResponses responses = new ResultResponses();
			// JSONObject jsonObject=jsonArray.getJSONObject(i);
			// if(""!=jsonObject.get("title")){
			// responses.setTitle(jsonObject.get("title").toString().trim());
			// }
			// if(""!=jsonObject.get("rank")){
			// responses.setRank(jsonObject.get("rank").toString().trim());
			// }
			// if(""!=jsonObject.get("value")){
			// responses.setValues(jsonObject.get("value").toString().trim());
			// }
			// list.add(responses);
			// }
			
//			Gson gson = new Gson();
//			Type type = new TypeToken<List<ResultResponses>>() {
//			}.getType();
//			List<ResultResponses> list = gson
//					.fromJson(msg.obj.toString(), type);
//			initData(list);
			
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
	
//	private void initData(List<ResultResponses> list) {
//		healthView.setText(list.get(4).getValues());
//		workView.setText(list.get(5).getValues());
//		numberView.setText(list.get(6).getValues());
//		colorView.setText(list.get(7).getValues());
//		supeiView.setText(list.get(8).getValues());
//		allView.setText(list.get(9).getValues());
//	}
}
