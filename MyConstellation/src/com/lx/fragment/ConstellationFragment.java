package com.lx.fragment;

import android.R.integer;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.lx.myconstellation.R;
import com.lx.myconstellation.ShowActivity;

/**
 * 星座
 * */
public class ConstellationFragment extends Fragment {

	/**
	 * 也叫做宝瓶座，起止时间为1月20日～2月18日； 排列第二的是双鱼座，起止时间为2月19日～3月20日；
	 * 排列第三的是白羊座，也叫做牧羊座，起止时间为3月21日～4月19日； 排列第四的是金牛座，起止时间为4月20日～5月20日；
	 * 排列第五的是双子座，起止时间为5月21日～6月21日； 排列第六的是巨蟹座，起止时间为6月22日～7月22日；
	 * 排列第七的是狮子座，起止时间为7月23日～8月22日； 排列第八的是处女座，也叫做室女座，起止时间为8月23日～9月22日；
	 * 排列第九的是天秤座，起止时间为9月23日～10月22日； 排列第十是的天蝎座，起止时间为10月23日～11月21日；
	 * 排列第十一的是射手座，也叫做人马座，起止时间为11月22日～12月21日；
	 * 排列第十二的是摩羯座，也叫做山羊座，因为“羯”就是一种羊，起止时间为12月22日～1月19日。
	 * **/
	private GridView gridView;

	private int[] imageId = new int[] { R.drawable.yunshi_shuiping,
			R.drawable.yunshi_shuangyu, R.drawable.yunshi_baiyang,
			R.drawable.yunshi_jinniu, R.drawable.yunshi_shuangzi,
			R.drawable.yunshi_juxie, R.drawable.yunshi_shizi,
			R.drawable.yunshi_chunv, R.drawable.yunshi_tiancheng,
			R.drawable.yunshi_tianxie, R.drawable.yunshi_sheshou,
			R.drawable.yunshi_mojie };
	
	private int[] id = new int[]{10,11,0,1,2,3,4,5,6,7,8,9};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater
				.inflate(R.layout.fragment_constellation, container,false);
		gridView = (GridView) view.findViewById(R.id.myGriView);
		gridView.setAdapter(new ImageAdapter());
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initData();
	}

	private void initData() {
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), ShowActivity.class);
				intent.putExtra("id", String.valueOf(id[arg2]));
				intent.putExtra("type", "day");
				startActivity(intent);
			}
		});
	}

	class ImageAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return imageId.length;
		}

		@Override
		public Object getItem(int arg0) {
			return imageId[arg0];
		}

		@Override
		public long getItemId(int arg0) {
			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			ViewHolder holder=null;
			if(arg1==null){
				holder = new ViewHolder();
				arg1 = LayoutInflater.from(getActivity()).inflate(R.layout.item_main_xingzuo, null);
				holder.iamgeView = (ImageView)arg1.findViewById(R.id.imageView);
				arg1.setTag(holder);
			}else {
				holder = (ViewHolder)arg1.getTag();
			}
			holder.iamgeView.setBackgroundResource(imageId[arg0]);
			return arg1;
		}

	}
	class ViewHolder{
		ImageView iamgeView;
	}
}
