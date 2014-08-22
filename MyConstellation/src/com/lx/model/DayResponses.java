package com.lx.model;

import java.util.List;

public class DayResponses {

	private List<ResultResponses> list;
	
	private String name;
	private String time;
	public List<ResultResponses> getList() {
		return list;
	}
	public void setList(List<ResultResponses> list) {
		this.list = list;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
