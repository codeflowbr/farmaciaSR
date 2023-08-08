package com.codeflow.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LoginDTO {

	@JsonProperty("login")
	private String login;

	@JsonProperty("password")
	private String password;

}
