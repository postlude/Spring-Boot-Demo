package com.example.demo.service;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TestDao;

@Service
public class HelloService {
	@Autowired
	private TestDao testDao;
	
	public Map<String, Map<String, Object>> getTest() throws Exception {
		return Collections.singletonMap("test", testDao.getName(1));
	}
}
