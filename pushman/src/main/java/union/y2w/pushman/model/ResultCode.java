package union.y2w.pushman.model;

/**
 * 
 * 응답코드 및 메시지 정의 클래스
 * <p>
 *   - 1000번대 코드: 처리 성공 메시지<br>
 *   - 2000번대 코드: 처리 실패 메시지<br>
 *   - 9000번대 코드: 서버오류 메시지<br>
 * </p> 
 * 위의 범위 구분만 준수하고, 코드는 중복 되어도 관계없음 
 *
 */
public enum ResultCode {
	
	/*
	 * Success Code Range : 1000 ~ 1999
	 */		
	SUCCESS	("1000", "Success")
	,
	
	/*
	 * Fail Code Range : 2000 ~ 2999
	 */	
	FAILURE	("2000", "Failure")
	,
	
	/*
	 * Error Code Range : 9000 ~ 9999
	 */
	ERROR	("9000", "Error")
	;
	
	
	private String resCode;
	private String message;
	
	private ResultCode(String resCode, String message) {
		this.resCode = resCode;
		this.message = message;
	}

	public String getResCode() {
		return resCode;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
}
