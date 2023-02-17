package com.unosqare.pojo;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

public class Register implements Jsonable {

	private String email;
	private String password;

	
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
	
	@Override
	public String toJson() {
		final StringWriter writable = new StringWriter();
		try {
			this.toJson(writable);
		} catch (final IOException e) {
			System.out.println(e.getMessage());
		}
		return writable.toString();
	}
	
	public void toJson(Writer writable) throws IOException {
		final JsonObject json = new JsonObject();
		json.put("email", this.getEmail());
		json.put("password", this.getPassword());
		json.toJson(writable);
	}

}
