package com.cg.salon.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cg.salon.dto.LoginDto;
import com.cg.salon.dto.LoginResponse;
import com.cg.salon.dto.LoginSuccessMessage;
import com.cg.salon.entity.Login;
import com.cg.salon.exceptions.LoginException;
import com.cg.salon.exceptions.ValidateUserException;
import com.cg.salon.service.ILoginService;
import com.cg.util.LoginConstants;

/*
 * Created By Titas Sarkar
 */
@RestController
public class LoginRestController {

	@Autowired
	private ILoginService service;

	Logger logger = LoggerFactory.getLogger(LoginRestController.class);

	/*
	 * Controller Method for Login
	 */

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("login")
	public LoginResponse doLoginController(@Valid @RequestBody LoginDto logindto, BindingResult br)
			throws LoginException, ValidateUserException {
		if (!service.getAuthMap().isEmpty())
			throw new LoginException(LoginConstants.ALREADY_LOGGED_IN);
		if (br.hasErrors())
			throw new ValidateUserException(br.getFieldErrors());
		Login login = service.doLogin(logindto.getUserId(), logindto.getPassword());
		LoginResponse response = new LoginResponse();
		response.setToken(service.generateToken(login));
		response.setUserName(login.getUserName());
		response.setRole(login.getRole());
		response.setUserId(logindto.getUserId());
		return response;
	}

	/*
	 * Controller method for logging out
	 */

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "logout")
	public LoginSuccessMessage logout(@RequestHeader("token-id") String token, HttpServletRequest req) {
		service.getAuthMap().remove(token);
		return new LoginSuccessMessage(LoginConstants.LOGGED_OUT);
	}

}
