package com.zhoukun.managementbackground.platform.model;

/**
 *
 * @author zhangjun
 *
 */
public class ApiResponse<T>
{
	private String code;

	private String message;

	private T data;


	/**
	 * 默认错误码
	 */
	public static final String CODE_FAIL_DEFAULT = "0";
	public static final String CODE_SUCCESS = "1";
	public static final String CODE_UNKNOWN = "500";

	public static final String NO_AUTH_ERROR = "419";

	private ApiResponse(String code, T data, String message)
	{
		this.code = code;
		this.data = data;
		this.message = message;
	}

	public static final ApiResponse success()
	{
		return new ApiResponse(CODE_SUCCESS, null, null);
	}

	public static final ApiResponse success(Object data)
	{
		return new ApiResponse(CODE_SUCCESS, data, null);
	}

	public static final ApiResponse success(Object data, String message)
	{
		return new ApiResponse(CODE_SUCCESS, data, message);
	}

	public static final ApiResponse failed(String code, String message)
	{
		return new ApiResponse(code, null, message);
	}

	public static final ApiResponse failed(String code, Object data, String message) {
		return new ApiResponse(code, data, message);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
