package com.lx.utils;

import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HTTPUtils {

	public static final int DAY_CONSTELLATION = 1;

	private final static  int HTTP_POST = -1;
	private final static int HTTP_GET = -2;

	/**
	 * 
	 * http://api.uihoo.com/astro/astro.http.php?fun=day&id=星座ID&format=数据格式
	 * 
	 * URL参数说明 ===============================================
	 * 
	 * @param string
	 *            fun 函数类型(day,tomorrow,week,month,year,love)
	 * @param integer
	 *            id 星座编号(必填)
	 * @param string
	 *            format 数据格式(json,jsonp,xml)
	 * @param string
	 *            callback 只有当数据格式为jsonp时,callback参数才有效
	 *            =========================================
	 **/
	public static Object getDayConstellation(String[] parmas) {

		StringBuffer sb = new StringBuffer("http://api.uihoo.com/astro/astro.http.php?");
		sb.append("fun=").append(parmas[0]).append("&id=").append(parmas[1]).append("format=json");
		return getObjectHttp(HTTP_GET,sb.toString());
	}

	private static Object getObjectHttp(int type, String url) {

		Object resultObject = null;
		HttpClient client = new DefaultHttpClient();
		switch (type) {
		case HTTP_GET:
			HttpGet httpget = new HttpGet(url);
			try {
				HttpResponse res = client.execute(httpget);
				if (res.getStatusLine().getStatusCode() == 200) {
					resultObject = EntityUtils.toString(res.getEntity(),
							"utf-8");
				}

			} catch (Exception e) {
				e.printStackTrace();
				resultObject = "请求失败";
			}

			break;
		case HTTP_POST:
			HttpPost httpPost = new HttpPost(url);

			try {
				HttpResponse res = client.execute(httpPost);
				if (res.getStatusLine().getStatusCode() == 200) {
					resultObject = EntityUtils.toString(res.getEntity(),
							"utf-8");
				}

			} catch (Exception e) {
				e.printStackTrace();
				resultObject = "请求失败";
			}
			break;

		default:
			break;
		}

		return resultObject;
	}

}
