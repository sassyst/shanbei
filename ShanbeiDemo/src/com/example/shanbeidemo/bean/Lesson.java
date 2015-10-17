package com.example.shanbeidemo.bean;

import java.util.ArrayList;

public class Lesson {
	int id;
	String title;
	String articles;
	String translation;
	ArrayList<String> wordslist;

	public int getId() {
		return id;
	}

	public void setNum(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArticles() {
		return articles;
	}

	public void setArticles(String articles) {
		this.articles = articles;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public ArrayList<String> getWordslist() {
		return wordslist;
	}

	public void setWordslist(ArrayList<String> wordslist) {
		this.wordslist = wordslist;
	}

}
