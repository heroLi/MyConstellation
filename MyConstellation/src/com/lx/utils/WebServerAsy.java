package com.lx.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

public class WebServerAsy extends AsyncTask<String, Integer, Object>{

	private Context context;
	private Handler mHandler;
	private String[] params;
	private int type;
	
	
	private ProgressDialog progressDialog = null;
	public WebServerAsy() {
	}
	public WebServerAsy(Context c,Handler h) {
		this.context = c;
		this.mHandler = h;
	}
	
	public  void sendExecuteDialog(String[] params,int type) {
		if(progressDialog==null){
			progressDialog = new ProgressDialog(context);
			progressDialog.setMessage("加载中");
			progressDialog.show();
		}
		this.params = params;
		this.type = type;
		this.execute(params);

	}
	public void sendExecuteNo(String[] params,int type) {
		this.params = params;
		this.type = type;
		this.execute(params);
	}
	
	@Override
	protected Object doInBackground(String... arg0) {
		return doBackWork(params,type);
	}
	
	@Override
	protected void onPostExecute(Object result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if(progressDialog!=null){
			progressDialog.dismiss();progressDialog=null;
		}
		if(null!=result){
			Message msg = new Message();
			msg.what = type;
			msg.obj = result;
			mHandler.sendMessage(msg);
		}
		
	}
	
	private Object doBackWork(String[] params,int type ) {
		Object result = null;
		switch (type) {
		case HTTPUtils.DAY_CONSTELLATION:
			result = HTTPUtils.getDayConstellation(params);
			break;

		default:
			break;
		}
		return result;
	}

}
