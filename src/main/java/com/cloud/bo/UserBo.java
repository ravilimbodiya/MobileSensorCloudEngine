package com.cloud.bo;

import com.cloud.entity.User;

public interface UserBo {
	
	void save(User user);
	
	void update(User user);
	
	void delete(User user);
	
	User findByUserName(String userName);

}
