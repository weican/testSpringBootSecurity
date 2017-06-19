package com.example.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.dao.UserMapper;

@Component
public class UserService implements UserDetailsService{
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;

	@Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		UserDetails user = null;
    	SqlSession sqlSession = null;
    	try {
	    	System.out.println("UserService is called!!!...input userName:" + name);
	    	sqlSession = sqlSessionFactory.openSession();
	    	com.example.model.User myuser = sqlSession.getMapper(UserMapper.class).getByName(name);

	    	List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
	        authList.add(new SimpleGrantedAuthority("ROLE_USER"));
	    	user =  new User(myuser.getEmail(), myuser.getPassword(), authList);
	    	System.out.println("UserService is called!!!.........user.getUsername():\t" + user.getUsername());
	    	System.out.println("UserService is called!!!.........user.getPassword():\t" + user.getPassword());
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		sqlSession.close();
    	}
    	return user;
    }
	
	

}
