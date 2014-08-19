package com.srinivas.bodagala.bookmyshow;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.srinivas.bodagala.bookmyshow.BookMyShowObject.BookMyShow.ArrayShowTimes;
import com.srinivas.bodagala.bookmyshow.BookMyShowObject.BookMyShow.ArrayShowTimes.ArrayVenues;

public class ShowTimingsActivity extends SherlockFragmentActivity implements
		OnClickListener {

	/*
	 * This is the second Activity that lists all the shows for a movie at a
	 * particular date
	 */

	private String movieTit;
	private String movieLang;
	private String movieDate;
	private int arrayVenSize;

	private TextView movieTitleTv;
	private TextView dateTv;
	private RelativeLayout dateChangeRl;
	private ListView lv;

	// // POJO class objects
	private BookMyShowObject obj;
	private ArrayShowTimes arrShoTimsObj;
	private ArrayList<ArrayVenues> arrVenuesObj;

	/* Adapter declaration for listview displaying shows at different venues */
	private ShowTimingsAdapter adapter;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.show_timings_activity);

		obj = getIntent().getExtras().getParcelable("Array_Show_Times");

		movieTitleTv = (TextView) findViewById(R.id.textView1);
		dateTv = (TextView) findViewById(R.id.textView4);
		dateChangeRl = (RelativeLayout) findViewById(R.id.relativeLayout2);
		lv = (ListView) findViewById(R.id.listView1);
		/*
		 * showtimesFl = (FrameLayout) findViewById(R.id.frameLayout2);
		 * moreInfoFl = (FrameLayout) findViewById(R.id.frameLayout3);
		 */

		arrShoTimsObj = obj.getBookMyShow().getArrShowTimes().get(0);
		arrVenuesObj = arrShoTimsObj.getArrVenues();
		arrayVenSize = arrVenuesObj.size();
		// System.out.println(arrayVenSize);
		movieTit = obj.getBookMyShow().getArrVenue().get(0).getEventName();
		movieLang = obj.getBookMyShow().getArrVenue().get(0).getLanguage();
		movieDate = arrShoTimsObj.getShowDateDisplay();

		movieTitleTv.setText(movieTit + "- " + movieLang);
		dateTv.setText(movieDate);

		adapter = new ShowTimingsAdapter(ShowTimingsActivity.this, arrVenuesObj);
		lv.setAdapter(adapter);

		dateChangeRl.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (arrayVenSize == 0) {
					Toast.makeText(getApplicationContext(),
							"There are no different dates available to change",
							Toast.LENGTH_SHORT).show();
				} else {

					Intent timingsIntent = new Intent(ShowTimingsActivity.this,
							SelectDateActivity.class);
					timingsIntent.putExtra("Array_Show_Times2",
							(BookMyShowObject) obj);
					startActivityForResult(timingsIntent, 1);
				}

			}
		});

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.frameLayout2:
			Toast.makeText(getApplicationContext(), "Clicked Showtimes",
					Toast.LENGTH_SHORT).show();
			break;

		case R.id.frameLayout3:
			Toast.makeText(getApplicationContext(), "Clicked moreInfo",
					Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		switch (requestCode) {
		case 1:

			if (resultCode == RESULT_OK) {
				arrShoTimsObj = data.getParcelableExtra("arrShoTimsObj");
				arrVenuesObj.clear();
				arrVenuesObj = arrShoTimsObj.getArrVenues();

				adapter.notifyDataSetChanged();
				adapter = new ShowTimingsAdapter(ShowTimingsActivity.this,
						arrVenuesObj);

				lv.setAdapter(adapter);

				movieDate = arrShoTimsObj.getShowDateDisplay();
				dateTv.setText(movieDate);

				// System.out.println(arrShoTimsObj.getShowDateDisplay());
			}

			break;
		}
	}

	// Adapter class for the listview
	static class ShowTimingsAdapter extends BaseAdapter {

		private Context context;
		private ArrayList<ArrayVenues> arrVenuesObj;

		public ShowTimingsAdapter(Context context,
				ArrayList<ArrayVenues> arrVenuesObj) {
			// TODO Auto-generated constructor stubis

			this.context = context;
			this.arrVenuesObj = arrVenuesObj;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return arrVenuesObj.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return arrVenuesObj.get(position);
		}

		@Override
		public long getItemId(int position) {
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
				view = inflater.inflate(R.layout.show_timings_list_item, null);
				holder = new ViewHolder();

				holder.venueTitAdpTv = (TextView) view
						.findViewById(R.id.textView1);
				holder.venueShowsTitAdpTv = (TextView) view
						.findViewById(R.id.textView2);
				view.setTag(holder);

			} else
				holder = (ViewHolder) view.getTag();

			String venueName = arrVenuesObj.get(position).getVenueName();
			StringBuilder showTimes = new StringBuilder();

			int venuShowSize = arrVenuesObj.get(position).getArrShowTimes()
					.size();

			for (int i = 0; i < venuShowSize; i++) {
				showTimes.append(arrVenuesObj.get(position).getArrShowTimes()
						.get(i).getShowTimeDisplay()
						+ "   ");
			}

			holder.venueTitAdpTv.setText(venueName);
			holder.venueShowsTitAdpTv.setText(showTimes.toString());
			return view;
		}

		private static class ViewHolder {
			private TextView venueTitAdpTv;
			private TextView venueShowsTitAdpTv;
		}

	}
}
