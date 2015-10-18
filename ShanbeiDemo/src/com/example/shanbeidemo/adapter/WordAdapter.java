package com.example.shanbeidemo.adapter;

import java.util.ArrayList;
import com.example.shanbeidemo.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class WordAdapter extends BaseAdapter {
	Context context;
	ArrayList<String> data;

	public WordAdapter(Context context, ArrayList<String> data) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.data = data;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view;
		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(R.layout.list_item,
					null);
		} else {
			view = convertView;

		}
		TextView tv = (TextView) view.findViewById(R.id.text1);
		tv.setText(data.get(position).toString());
		return view;
	}

}
