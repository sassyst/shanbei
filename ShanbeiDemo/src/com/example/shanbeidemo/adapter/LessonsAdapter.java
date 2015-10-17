package com.example.shanbeidemo.adapter;

import java.util.List;
import java.util.Map;

import com.example.shanbeidemo.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class LessonsAdapter extends BaseExpandableListAdapter {
	List<String> unit = null;
	Map<String, List<String>> lessons = null;
	Context context;

	public LessonsAdapter(Context context, Map<String, List<String>> lessons,
			List<String> unit) {
		this.unit = unit;
		this.lessons = lessons;
		this.context = context;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		String key = unit.get(groupPosition);
		return (lessons.get(key).get(childPosition));
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return groupPosition * 10 + childPosition + 1;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		String key = unit.get(groupPosition);
		String lessonnum = lessons.get(key).get(childPosition);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.expandable_list_item, null);
		}
		TextView tv = (TextView) convertView.findViewById(R.id.tv_item);
		tv.setText(lessonnum);
		return tv;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		String key = unit.get(groupPosition);
		int size = lessons.get(key).size();
		return size;
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return unit.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return unit.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.expandable_list_item, null);
		}
		TextView tv = (TextView) convertView.findViewById(R.id.tv_item);
		tv.setText(unit.get(groupPosition));
		return tv;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}

}
