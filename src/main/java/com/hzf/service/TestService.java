package com.hzf.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hzf.dao.TestDemoMapper;
import com.hzf.model.TestDemo;

@Service
public class TestService {

	@Resource
	private TestDemoMapper mapper;
	
	
	public void persist(TestDemo testDemo) {
		mapper.insertSelective(testDemo);
	}
	
}
