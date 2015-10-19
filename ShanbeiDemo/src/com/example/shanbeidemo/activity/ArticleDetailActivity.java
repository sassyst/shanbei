package com.example.shanbeidemo.activity;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.example.shanbeidemo.R;
import com.example.shanbeidemo.adapter.WordAdapter;
import com.example.shanbeidemo.bean.Lesson;
import com.example.shanbeidemo.ui.NewWordListView;
import com.example.shanbeidemo.ui.SideBar;
import com.example.shanbeidemo.ui.SideBar.OnTouchingLetterChangedListener;
import com.example.shanbeidemo.utils.ReadDataFromFile;
import com.example.shanbeidemo.utils.TextUtilTools;
import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ArticleDetailActivity extends Activity {
	String Result = "";
	int lesson_id;
	String lesson_title;
	String file_name;
	ReadDataFromFile read = null;
	TextView tv_title;
	TextView tv_article;
	TextView translation;
	TextView lessonid;
	NewWordListView word_lv;
	Lesson bean;
	int level = 0;
	SideBar sb_level;
	TextView dialog;
	Button btn_back;
	ToggleButton btn_level;
	boolean showHight = false;
	String article;
	String str_translation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_article);
		file_name = getIntent().getExtras().getString("file_name");
		initData();
		initView();

	}

	private void bindData() {
		// TODO Auto-generated method stub
		if (bean != null) {
			tv_title.setText(bean.getTitle());
			tv_article.setText(article);
			translation.setText(str_translation);
			lessonid.setText("Lesson " + bean.getId());
			WordAdapter adapter = new WordAdapter(ArticleDetailActivity.this,
					bean.getWordslist());
			word_lv.setAdapter(adapter);
			// UIUtils.setListViewHeight(word_lv);
		}
		btn_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		btn_level.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					sb_level.setVisibility(View.VISIBLE);
					showHight = true;
				} else {
					sb_level.setVisibility(View.GONE);
					showHight = false;
					tv_article.setText(article);
				}
			}
		});
		sb_level.setTextView(dialog);
		sb_level.setOnTouchingLetterChangedListener(new OnTouchingLetterChangedListener() {

			@Override
			public void onTouchingLetterChanged(int s) {
				// TODO Auto-generated method stub
				if (showHight) {
					Log.i("debug", "now level is :" + s);
					hightlight(s);
				}
			}
		});
	}

	private void initData() {
		try {
			InputStreamReader inputReader = new InputStreamReader(
					getResources().getAssets().open(file_name));
			read = new ReadDataFromFile(inputReader);
			bean = read.getLessonData();
			article = bean.getArticles().replaceAll("\\n", "\n")
					.replaceAll("\\r", "\r");
			str_translation = bean.getTranslation().replaceAll("\\n", "\n")
					.replaceAll("\\r", "\r");
			Log.i("debug", article);
		} catch (Exception e) {
			Toast.makeText(ArticleDetailActivity.this, "Not found File",
					Toast.LENGTH_SHORT).show();
		}

	}

	private void initView() {
		dialog = (TextView) findViewById(R.id.dialog);
		sb_level = (SideBar) findViewById(R.id.sidrbar);
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_article = (TextView) findViewById(R.id.tv_article);
		translation = (TextView) findViewById(R.id.tv_trn);
		lessonid = (TextView) findViewById(R.id.lesson_id);
		word_lv = (NewWordListView) findViewById(R.id.lv_wordlist);
		btn_back = (Button) findViewById(R.id.btn_back);
		btn_level = (ToggleButton) findViewById(R.id.btn_level);
		bindData();

	}

	private void hightlight(int level) {
		ArrayList<String> levelwordlist = new ArrayList<String>();
		try {
			InputStreamReader inputReader = new InputStreamReader(
					getResources().getAssets().open("nce4_words"));
			read = new ReadDataFromFile(inputReader);
			levelwordlist = read.getTheLevelWord(level);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		tv_article.setText(Html.fromHtml(TextUtilTools
				.highlight(article, levelwordlist).replaceAll("\n", "<br>")
				.replaceAll("\r", " &nbsp")));
	}
}
