package com.jaravir.tekila.base.auth;

public enum Privilege {
	READ ("R"),
	INSERT ("I"),
	UPDATE ("U"),
	DELETE ("D"),
	EXECUTE ("E"),
	CALL ("C");

	private final String code;

	Privilege(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public static Privilege convertFromCode(String code) {
		for (Privilege permission : values())
			if (permission.getCode().equals(code))
				return permission;

		return null;
	}
}
