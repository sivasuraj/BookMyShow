package com.srinivas.bodagala.bookmyshow;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.srinivas.bodagala.bookmyshow.BookMyShowObject.BookMyShow.ArrayShowTimes;

public class SelectDateActivity extends SherlockFragmentActivity {
	
	/*
	 * SelectDateActivity is the actvity used to choose the dates from list of
	 * dates available for the show
	 */

	// POJO class objects
	private BookMyShowObject obj;
	private ArrayList<ArrayShowTimes> arrShoTims;

	// private ArrayShowTimes arrShoTimsObj;

	private ListView lv;

	// Adapter declaration for listview
	private SelectDateAdapter adapter;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.select_date_activity);

		obj = getIntent().getExtras().getParcelable("Array_Show_Times2");
		lv = (ListView) findViewById(R.id.listView1);

		arrShoTims = obj.getBookMyShow().getArrShowTimes();

		adapter = new SelectDateAdapter(SelectDateActivity.this, arrShoTims);
		lv.setAdapter(adapter);

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int pos,
					long id) {
				// TODO Auto-generated method stub
				Intent resultIntent = new Intent();
				resultIntent.putExtra("arrShoTimsObj",
						(ArrayShowTimes) adapter.getItemAtPosition(pos));
				setResult(RESULT_OK, resultIntent);
				finish();
			}
		});

	}

	// Adapter for the listview
	static class SelectDateAdapter extends BaseAdapter {

		private Context context;
		private ArrayList<ArrayShowTimes> arrShoTims;

		public SelectDateAdapter(Context context,
				ArrayList<ArrayShowTimes> arrShoTims) {
			// TODO Auto-generated constructor stub
			this.context = context;
			this.arrShoTims = arrShoTims;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return arrShoTims.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return arrShoTims.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View view, ViewGroup parent) {
			// TODO Auto-generated method stub

			ViewHolder holder = null;

			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			if (view == null) {
				view = inflater.inflate(R.layout.select_date_list_item, null);
				holder = new ViewHolder();

				holder.dateTitAdpTv = (TextView) view
						.findViewById(R.id.textView1);
				view.setTag(holder);
			} else
				holder = (ViewHolder) view.getTag();

			String showDateDisplay = arrShoTims.get(position)
					.getShowDateDisplay();

			holder.dateTitAdpTv.setText(showDateDisplay);
			return view;
		}

		private static class ViewHolder {
			private TextView dateTitAdpTv;
		}

	}

}
