package Enumeration;

public enum CodeOrientation {
	
	NORD("N"), //$NON-NLS-1$
	SUD("S"), //$NON-NLS-1$
	EST("E"), //$NON-NLS-1$
	OUEST("W"), //$NON-NLS-1$
	;
	
	private String code;
	
	private CodeOrientation(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
	public static CodeOrientation getByCode(String code) { 
		if (code != null) {
			for (CodeOrientation value : values()) {
				if (value.code.equals(code)) {
					return value;
				}
			}
		}
		return null; 
	}

}
