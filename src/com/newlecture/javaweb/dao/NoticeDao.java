package com.newlecture.javaweb.dao;

import java.util.List;

import com.newlecture.javaweb.entity.Notice;

public interface NoticeDao {
	List<Notice> getList(int page, String query);
	int getCount();
	Notice get(String id);
	int update(String id, String title, String content);
}
