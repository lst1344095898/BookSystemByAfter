package com.springboot.service;


import com.springboot.entity.State;

import java.util.Date;

public interface RegisterService {
	 State<Boolean> register(String username, String password, String e_mail, String birthday,
					String grade, String user_code, String sex, String interest, String introduce );
}
