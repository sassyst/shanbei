package com.example.shanbeidemo.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.example.shanbeidemo.bean.Lesson;
import com.example.shanbeidemo.bean.Word;

public class ReadDataFromFile {
	private ArrayList<Word> allWords = new ArrayList<Word>();
	int NumberOfWord = 0;
	InputStreamReader inputReader;

	public ReadDataFromFile(InputStreamReader inputReader) {
		// TODO Auto-generated constructor stub
		this.inputReader = inputReader;
	}

	public ArrayList<Word> loadAllWords() {

		Pattern word_exp = Pattern.compile("[a-zA-Z]+");// 定义正则表达式匹配单词
		Pattern number_exp = Pattern.compile("([0-9])$");// 定义正则表达式匹配shuzi
		// Map<Integer, List<String>> allWords;
		try {

			BufferedReader br = new BufferedReader(inputReader);

			String strLine;
			br.readLine();
			while ((strLine = br.readLine()) != null) {
				Word addword = new Word();
				int blank = 0;
				int level = -1;
				StringBuffer sbuf = new StringBuffer();
				Matcher matcher_word = word_exp.matcher(strLine);
				Matcher matcher_num = number_exp.matcher(strLine);
				while (matcher_word.find()) {// 是否匹配单词
					String word = matcher_word.group();
					if (blank == 0) {
						sbuf.append(word);
					} else {
						sbuf.append(" " + word);
					}
					blank++;
				}
				while (matcher_num.find()) {
					level = Integer.parseInt(matcher_num.group());
				}
				if (sbuf != null && sbuf.toString() != null && level != -1) {
					addword.setWord(sbuf.toString());
					addword.setLevel(level);

					allWords.add(addword);
					Log.i("json", addword.getWord().toString());

				}

			}
			// Close the input streamd
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allWords;
	}

	public ArrayList<String> getTheLevelWord(int level) {
		this.loadAllWords();
		ArrayList<String> theLevelWords = new ArrayList<String>();
		for (int position = 0; position < allWords.size(); position++) {
			if (allWords.get(position).getLevel() <= level) {
				theLevelWords.add(allWords.get(position).getWord());
				Log.i("debug", allWords.get(position).getWord());
			}
		}
		return theLevelWords;
	}

	public Lesson getLessonData() {
		// TODO Auto-generated method stub
		Lesson bean = new Lesson();
		String Result = "";
		try {

			BufferedReader bufReader = new BufferedReader(inputReader);
			String line = "";
			while ((line = bufReader.readLine()) != null)
				Result += line;
			JSONObject jsonObject;

			ArrayList<String> newwordlist = new ArrayList<String>();
			jsonObject = new JSONObject(Result);
			bean.setId(JSONUtils.getInt(jsonObject, "lesson_id", 1));
			bean.setTitle(JSONUtils.getString(jsonObject, "title", " "));
			bean.setArticles(JSONUtils.getString(jsonObject, "articles", " "));
			bean.setTranslation(JSONUtils.getString(jsonObject, "translation",
					" "));
			JSONArray wordsArray = jsonObject.getJSONArray("wordslist");
			for (int j = 0; j < wordsArray.length(); j++) {
				Log.i("json", wordsArray.getString(j));
				newwordlist.add((String) wordsArray.getString(j));
			}

			bean.setWordslist(newwordlist);
			bufReader.close();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bean;
	}

}
