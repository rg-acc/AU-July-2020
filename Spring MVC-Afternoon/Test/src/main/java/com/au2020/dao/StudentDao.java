package com.au2020.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.au2020.model.Student;

public class StudentDao {

	Map<String, Student> hm = new HashMap<String, Student>();   
    
	public void save(Student s){    
		hm.put(s.getId(), s);
	}    
	public void update(Student s){    
		hm.put(s.getId(), s);   
	}    
	public void delete(String id){    
		 hm.remove(id);
	}    
	public Student getStudentById(String id){    
	    return hm.get(id);     
	}    
	public List<Student> getStudents(){    
		List<Student> valueList = new ArrayList(hm.values());
		return valueList;
	}    

	public boolean idExist(String id){    
		return hm.containsKey(id);

	} 
}

