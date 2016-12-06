package beans;

public class User {

	private String email;
	private String password;
	private String message;
	
	public User() {

	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getMessage(){
		return message; 
	}
	public boolean Validate(){
		
		if (email.contains(" ")){
			message="Error: Space Detected";
			return false;
		}else if (!email.matches("[a-z0-9.]+@\\w+\\.\\w+")){
			message="Error: Email malformed";
			return false;
		}
		
		if (password.contains(" ")){
			message="Error: Space Detected";
			return false;
		}else if (password.length() < 8){
			message="Error: Password must be at least 8 characters ";
			return false;
		}
		
		return true;
	}
}
