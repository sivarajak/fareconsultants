package com.sms.fareconsultant.rs.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sms.fareconsultant.rs.dto.UserDTO;
import com.sms.fareconsultant.rs.model.User;
import com.sms.fareconsultant.rs.repository.UserRepository;

import static java.util.stream.Collectors.toList;

public class UserBO implements IUserBO {
	
	@Autowired
	private UserRepository repository;

	@Override
	public List<UserDTO> findAllUsers() {
		List<User> users = repository.findAll();
		return convertToDTOs(users);
	}

	@Override
	public UserDTO findById(long id) {
		User user = repository.findById(id);
		return convertToDTO(user);
	}

	@Override
	public boolean isUserExist(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void saveUser(UserDTO userDTO) {
		User user = convertToModel(userDTO);
		repository.save(user);
		
	}

	@Override
	public void updateUser(UserDTO userDTO) {
		User user = repository.findById(userDTO.getId());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		repository.save(user);		
	}

	@Override
	public void deleteUserById(long id) {
		User user = repository.findById(id);
		repository.delete(user);
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		
	}
	
	private List<UserDTO> convertToDTOs(List<User> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }
	
	private UserDTO convertToDTO(User model) {
		UserDTO dto = new UserDTO();
 
        dto.setId(model.getId());
        dto.setFirstName(model.getFirstName());
        dto.setLastName(model.getLastName());
 
        return dto;
    }
	
	private User convertToModel(UserDTO userDTO) {
		User user = new User();
 
		user.setId(userDTO.getId());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
 
        return user;
    }

}
