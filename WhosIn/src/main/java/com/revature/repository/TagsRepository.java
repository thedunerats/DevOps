package com.revature.repository;

import java.util.List;

import com.revature.model.Tags;

public interface TagsRepository {
	List<Tags> getAllTags();
	Tags getTagById(int id);
	void insertTag(Tags t);
	void deleteTag(Tags t);
	
	List<Tags> searchForTags(String str);
}
