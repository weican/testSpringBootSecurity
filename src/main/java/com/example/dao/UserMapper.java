package com.example.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.model.User;

@Mapper
public interface UserMapper {
	
	public User getByName(String name);

}
