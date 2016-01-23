package com.sms.fareconsultant.rs.bo;

import java.util.List;

import com.sms.fareconsultant.rs.dto.UserDTO;

public interface IUserBO {
	
	List<UserDTO> findAllUsers();
	
	UserDTO findById(long id);
	
	UserDTO findByUserName(String userName);
	
	boolean isUserExist(UserDTO userDTO);
	
	void saveUser(UserDTO userDTO);
	
	UserDTO updateUser(UserDTO userDTO);
	
	void deleteUserById(long id);

}
