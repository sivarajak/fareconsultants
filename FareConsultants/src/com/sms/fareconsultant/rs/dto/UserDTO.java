package com.sms.fareconsultant.rs.dto;

public class UserDTO {
	
	private long id;
	
	private String userName;
	
	private String firstName;
    
    private String lastName;
    
    public UserDTO() {
    	
    }
    
    public UserDTO(String userName, String firstName, String lastName) {
    	this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
