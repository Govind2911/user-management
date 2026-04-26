package project_User_Management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/* This package we created fore the configuration in spring most of the configuration will done automatically for custom
   we use this annotation and the BCryptPasswordEncoder is used to secure the paasword by encoding the password which is 
   stored in the database where no one can see or use it bcz i was encrypted.
 */
@Configuration
public class Password {
    
	@Bean  
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
