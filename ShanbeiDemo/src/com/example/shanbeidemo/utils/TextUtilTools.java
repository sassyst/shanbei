package com.example.shanbeidemo.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.util.Log;

public class TextUtilTools {
	public static String highlight(String str, ArrayList<String> words) {
		// TODO Auto-generated method stub
		// int startIndex = 0;
		Pattern pattern = Pattern.compile("\\w+");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			if (words.contains(matcher.group())) {
				String newChar = "<font color=\"#ff0000\">" + matcher.group()
						+ "</font>";
				str = String.valueOf(str.replace(matcher.group(), newChar));
				Log.i("debug", "level word in article ---->" + matcher.group());
			}
			Log.i("debug", "word in article ---->" + matcher.group());
		}
		return str.toString();
	}
}
