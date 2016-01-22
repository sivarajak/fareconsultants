package com.sms.fareconsultant.rs.bo;

import java.util.List;

import com.sms.fareconsultant.rs.dto.UserDTO;

public interface IUserBO {
	
	List<UserDTO> findAllUsers();
	
	UserDTO findById(long id);
	
	boolean isUserExist(UserDTO userDTO);
	
	void saveUser(UserDTO userDTO);
	
	void updateUser(UserDTO userDTO);
	
	void deleteUserById(long id);
	
	void deleteAllUsers();

}
