package com.phamquanghuy.dao;

import java.util.List;

import com.phamquanghuy.model.Model;

public interface IStudentDAO {
	List<Model> selectAll();
	List<Model> selectByName(String name);
	List<Model> selectByClass(String name);
	List<Model> selectByNameAndClass(String name, String nameClass);
	
	void InsertStudent(Model student);
	void deleteStudent(String id);
	Model selectById(String id);
	Model updateById(Model m);
	Model updateDiemById(Model m);
}
