package com.example.shanbeidemo.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {
	/**
	 * 从json中获取字符串值， 如果该字段不存在或值为NULL则返回给定的默认值
	 * 
	 * @param json
	 *            需要解析的JSONObject
	 * @param key
	 *            需要解析的key
	 * @param defaultValue
	 *            key不存在或者为NULL时返回的默认值
	 * @return String
	 * @throws org.json.JSONException
	 */
	public static String getString(JSONObject json, String key,
			String defaultValue) throws JSONException {

		if (json == null || json.isNull(key)) {
			return defaultValue;
		}

		return json.getString(key);
	}

	/**
	 * 从json中获取整数值， 如果该字段不存在则返回给定的默认值
	 * 
	 * @param json
	 *            需要解析的JSONObject
	 * @param key
	 *            需要解析的key
	 * @param defaultValue
	 *            key不存在或者为NULL时返回的默认值
	 * @return int
	 * @throws org.json.JSONException
	 */
	public static int getInt(JSONObject json, String key, int defaultValue) {
		if (json.isNull(key)) {
			return defaultValue;
		}
		try {
			return json.getInt(key);
		} catch (JSONException e) {
			return defaultValue;
		}
	}

	/**
	 * 从json中获取double值， 如果该字段不存在则返回给定的默认值
	 * 
	 * @param json
	 *            需要解析的JSONObject
	 * @param key
	 *            需要解析的key
	 * @param defaultValue
	 *            key不存在或者为NULL时返回的默认值
	 * @return double
	 * @throws org.json.JSONException
	 */
	public static double getDouble(JSONObject json, String key,
			double defaultValue) {
		if (json.isNull(key)) {
			return defaultValue;
		}
		try {
			return json.getDouble(key);
		} catch (JSONException e) {
			return defaultValue;
		}
	}

	/**
	 * 从json中获取布尔值， 如果该字段不存在则返回给定的默认值
	 * 
	 * @param json
	 *            需要解析的JSONObject
	 * @param key
	 *            需要解析的key
	 * @param defaultValue
	 *            key不存在或者为NULL时返回的默认值
	 * @return boolean
	 * @throws org.json.JSONException
	 */
	public static boolean getBoolean(JSONObject json, String key,
			boolean defaultValue) throws JSONException {
		if (json.isNull(key)) {
			return defaultValue;
		}

		return json.getBoolean(key);
	}

	/**
	 * 从json中获取long值， 如果该字段不存在则返回给定的默认值
	 * 
	 * @param json
	 *            需要解析的JSONObject
	 * @param key
	 *            需要解析的key
	 * @param defaultValue
	 *            key不存在或者为NULL时返回的默认值
	 * @return long
	 * @throws org.json.JSONException
	 */
	public static long getLong(JSONObject json, String key, long defaultValue)
			throws JSONException {
		if (json.isNull(key)) {
			return defaultValue;
		}
		return json.getLong(key);
	}

	/**
	 * 从json中获取JSONArray， 如果该字段不存在则返回null
	 * 
	 * @param json
	 *            需要解析的JSONObject
	 * @param key
	 *            需要解析的key
	 * @return JSONArray
	 * @throws org.json.JSONException
	 */
	public static JSONArray getJSONArray(JSONObject json, String key)
			throws JSONException {
		if (json == null || json.isNull(key)) {
			return null;
		}
		return json.getJSONArray(key);
	}

	/**
	 * 从json中获取JSONObject， 如果该字段不存在则返回null
	 * 
	 * @param json
	 *            需要解析的JSONObject
	 * @param key
	 *            需要解析的key
	 * @return JSONObject
	 * @throws org.json.JSONException
	 */
	public static JSONObject getJSONObject(JSONObject json, String key)
			throws JSONException {
		if (json == null || json.isNull(key)) {
			return null;
		}
		return json.getJSONObject(key);
	}
}
