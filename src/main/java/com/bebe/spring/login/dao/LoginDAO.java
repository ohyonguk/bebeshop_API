package com.bebe.spring.login.dao;

import java.util.List;

import com.bebe.spring.vo.UsersVO;

public interface LoginDAO {
	
	UsersVO selectUsers(UsersVO usersVO);
	
	int insertUsers(UsersVO usersVO);
	
	int idCheck(UsersVO usersVO);

	public UsersVO find_passwd(UsersVO usersVO);
	
	public List<UsersVO> find_id(UsersVO usersVO);
	
	public int selectSocialLogin(UsersVO usersVO);
	
	public int insertSocialLogin(UsersVO usersVO);
}
