package com.example.shanbeidemo.ui.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.shanbeidemo.R;
import com.example.shanbeidemo.adapter.LessonsAdapter;
import com.example.shanbeidemo.bean.Lesson;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;

public class MainActivity extends Activity {

	public static String TAG = "MainActivity";
	private LessonsAdapter eListAdapter;
	ArrayList<Lesson> allLessons = new ArrayList<Lesson>();
	List<Map<String, String>> groupData = new ArrayList<Map<String, String>>();
	List<List<Map<String, String>>> childDataList = new ArrayList<List<Map<String, String>>>();
	ExpandableListView lessonelv;
	int lessonnum = 0;
	ArrayList<String> unit;
	Map<String, List<String>> map;
	Button btn_back;
	Button btn_level;
	String file_words = "json_wordlist";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		initData();
		initView();
		initEvent();
	}

	private void initEvent() {
		// TODO Auto-generated method stub
		lessonelv.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						ArticleDetailActivity.class);
				intent.putExtra("file_name", "json" + id);
				startActivity(intent);
				Toast.makeText(MainActivity.this, "Lesson " + id,
						Toast.LENGTH_LONG).show();
				return false;
			}
		});

	}

	private void initView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_main);
		lessonelv = (ExpandableListView) findViewById(R.id.lv_lesson);
		eListAdapter = new LessonsAdapter(MainActivity.this, map, unit);
		lessonelv.setAdapter(eListAdapter);

	}

	private void initData() {
		// TODO Auto-generated method stub
		unit = new ArrayList<String>();
		map = new HashMap<String, List<String>>();
		int Unit_id;
		for (int i = 0; i < 10; i++) {
			Unit_id = i + 1;
			unit.add("Unit " + Unit_id);
			List<String> list = new ArrayList<String>();
			for (int j = 0; j < 9; j++) {
				lessonnum++;
				list.add("Lesson" + lessonnum);
			}
			map.put("Unit " + Unit_id, list);
		}

	}
}
