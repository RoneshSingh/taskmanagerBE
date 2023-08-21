package com.tekeo.tasksmanager.validation;

public class UserValidation {
	private boolean exists;
	
	public UserValidation(boolean exists) {
		this.exists = exists;
	}

	public boolean isExists() {
		return exists;
	}

	public void setExists(boolean exists) {
		this.exists = exists;
	}
	

}