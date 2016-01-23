package com.sms.fareconsultant.rs.bo;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.fareconsultant.rs.dto.UserDTO;
import com.sms.fareconsultant.rs.model.User;
import com.sms.fareconsultant.rs.repository.UserRepository;

@Service
public class UserBO implements IUserBO {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserDTO> findAllUsers() {
		List<User> users = userRepository.findAll();
		return convertToDTOs(users);
	}

	@Override
	public UserDTO findById(long id) {
		User user = userRepository.findById(id);
		return convertToDTO(user);
	}

	@Override
	public UserDTO findByUserName(String userName) {
		User user = userRepository.findByUserName(userName);
		return convertToDTO(user);
	}

	@Override
	public boolean isUserExist(UserDTO userDTO) {
		return findByUserName(userDTO.getUserName()) != null ? true : false;
	}

	@Override
	public void saveUser(UserDTO userDTO) {
		User user = convertToModel(userDTO);
		userRepository.save(user);
		
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO) {
		User user = userRepository.findById(userDTO.getId());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		userRepository.save(user);		
		return convertToDTO(user);
	}

	@Override
	public void deleteUserById(long id) {
		User user = userRepository.findById(id);
		userRepository.delete(user);
	}
	
	private List<UserDTO> convertToDTOs(List<User> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }
	
	private UserDTO convertToDTO(User model) {
		
		UserDTO dto = null;
		if(model != null) {
			dto = new UserDTO();
	        dto.setId(model.getId());
	        dto.setUserName(model.getUserName());
	        dto.setFirstName(model.getFirstName());
	        dto.setLastName(model.getLastName());
		}
 
        return dto;
    }
	
	private User convertToModel(UserDTO userDTO) {
		User user = new User();
 
		user.setId(userDTO.getId());
		user.setUserName(userDTO.getUserName());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
 
        return user;
    }

}
