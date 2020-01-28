package com.login.login.util;

import javax.xml.bind.DatatypeConverter;

import com.login.login.model.Usuario;

public class Authenticator {
	private static final String prefix = "MachadoDeAssis";

	public static String encode(Usuario usuario) {
		return DatatypeConverter.printHexBinary((prefix + usuario).getBytes());

	}

	public static boolean isValid(String token) {
		byte strByte[] = DatatypeConverter.parseHexBinary(token);
		String newToken = new String(strByte);
		return newToken.startsWith(prefix);
	}
}
