package test;


import java.sql.Timestamp;


public class User {
	           private int userId;
	           private String username;
	           private String password;
	           private String email;
	           private String role;
	           private Timestamp s;

				

				public int getUserId() {
					return userId;
				}

				public void setUserId(int userId) {
					this.userId = userId;
				}

				public String getUsername() {
					return username;
				}

				public void setUsername(String username) {
					this.username = username;
				}

				public Timestamp getS() {
					return s;
				}

				public void setS(Timestamp s2) {
					this.s = s2;
				}

				@Override
				public String toString() {
					return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", email="
							+ email + ", role=" + role + ", s=" + s + "]";
				}

				public String getPassword() {
					return password;
				}

				public void setPassword(String password) {
					this.password = password;
				}

				public String getEmail() {
					return email;
				}

				public void setEmail(String email) {
					this.email = email;
				}

				public String getRole() {
					return role;
				}

				public void setRole(String role) {
					this.role = role;
				}

}			

				


