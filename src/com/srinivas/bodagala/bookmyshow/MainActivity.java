package com.srinivas.bodagala.bookmyshow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;
import com.srinivas.bodagala.bookmyshow.BookMyShowObject.BookMyShow.ArrayVenue;

public class MainActivity extends SherlockFragmentActivity {

	/* MainActivity is the first activity in the app */

	private ListView lv;
	private ProgressDialog pDiag;

	// Adapter declaration for listview
	private MoviesAdapter adapter;

	// Volley library object declaration for making request to server
	private JsonObjectRequest jsonObjReq;

	// server url used to fetch JSON
	private String url = "http://data.in.bookmyshow.com/getData.aspx?cmd=GETVENUESHOWTIMESBYEVENT&f=json&cc=&lt=&lg=&dt=&ec=ET00020365&sr=MWEST&t=a54a7b3aba576256614a";

	// POJO class objects for parsing JSON
	private BookMyShowObject obj;
	private ArrayList<ArrayVenue> arrVenue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ActionBar aBar = getSupportActionBar();
		aBar.setCustomView(R.layout.actionbar_title);
		aBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

		lv = (ListView) findViewById(R.id.listView1);

		pDiag = new ProgressDialog(MainActivity.this);
		pDiag.setMessage("Please Wait");

		adapter = new MoviesAdapter(MainActivity.this, arrVenue);

		makeRequestToServer();
		// lv.setAdapter(adapter);

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int pos,
					long id) {
				// TODO Auto-generated method stub

				/*
				 * calling next activity called ShowTimingsActivity, that have
				 * all the details of the timings of shows
				 */
				Intent timingsIntent = new Intent(MainActivity.this,
						ShowTimingsActivity.class);
				timingsIntent.putExtra("Array_Show_Times",
						(BookMyShowObject) obj);
				startActivity(timingsIntent);
			}

		});
	}

	// Method for making request to server using GET Method
	private void makeRequestToServer() {
		// TODO Auto-generated method stub
		pDiag.show();

		jsonObjReq = new JsonObjectRequest(Method.GET, url, null,
				new Response.Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {
						// TODO Auto-generated method stub
						String result = response.toString();

						// Calling Gson class library for JSON parsing
						Gson gson = new Gson();
						obj = gson.fromJson(result, BookMyShowObject.class);

						adapter = new MoviesAdapter(MainActivity.this, obj
								.getBookMyShow().getArrVenue());
						adapter.notifyDataSetChanged();
						lv.setAdapter(adapter);

						pDiag.dismiss();
					}

				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub

						NetworkResponse response = error.networkResponse;

						if (response == null) {

							// Shows a Toast message when there is no internet
							// connectivity.
							Toast.makeText(getApplicationContext(),
									"Bad Internet connection",
									Toast.LENGTH_SHORT).show();
							pDiag.dismiss();
						}
					}
				}) {

			/**
			 * Passing some request headers
			 * */
			@Override
			public Map<String, String> getHeaders() throws AuthFailureError {
				HashMap<String, String> headers = new HashMap<String, String>();
				;
				headers.put("Content-Type", "application/json");
				return headers;
			}
		};

		// Making request to server
		BookMyShow.getInstance().addToRequestQueue(jsonObjReq);

	}

	// Adapter for the listview
	static class MoviesAdapter extends BaseAdapter {

		private Context context;
		private ArrayList<ArrayVenue> arrVenue;

		// Url for fetching image from Youtube using video id
		private String youtubeImageUrl = "http://img.youtube.com/vi/";

		public MoviesAdapter(Context context, ArrayList<ArrayVenue> arrVenue) {
			// TODO Auto-generated constructor stub
			this.context = context;
			this.arrVenue = arrVenue;

		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return arrVenue.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return arrVenue.get(position);
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
				view = inflater.inflate(R.layout.listview_items, null);
				holder = new ViewHolder();

				holder.thumbNailAdpIv = (ImageView) view
						.findViewById(R.id.imageView1);
				holder.movieTitAdpTv = (TextView) view
						.findViewById(R.id.textView1);
				holder.movieGenreAdpTv = (TextView) view
						.findViewById(R.id.textView2);
				holder.movieLangAdpTv = (TextView) view
						.findViewById(R.id.textView3);
				holder.movieLenAdpTv = (TextView) view
						.findViewById(R.id.textView4);
				holder.movieActorsAdpTv = (TextView) view
						.findViewById(R.id.textView5);
				view.setTag(holder);

			} else
				holder = (ViewHolder) view.getTag();

			String movieTitle = arrVenue.get(position).getEventName();
			String movieGenre = arrVenue.get(position).getGenre();
			String movieLanguage = arrVenue.get(position).getLanguage();
			String movieLength = arrVenue.get(position).getLength();
			String movieActors = arrVenue.get(position).getActors();
			String youtubeUrl = arrVenue.get(position).getTrailerURL();
			String videoId = getYoutubeVideoId(youtubeUrl);

			holder.movieTitAdpTv.setText(movieTitle);
			holder.movieGenreAdpTv.setText("Genre:" + movieGenre);
			holder.movieLangAdpTv.setText("Language:" + movieLanguage);
			holder.movieLenAdpTv.setText("Length:" + movieLength);
			holder.movieActorsAdpTv.setText("Actors:" + movieActors);

			if (videoId != null) {

				/*
				 * calling UrlImageViewHelper class from urlImageViewHelper
				 * library for lazy loading of images in the listview.
				 */
				UrlImageViewHelper.setUrlDrawable(holder.thumbNailAdpIv,
						youtubeImageUrl + videoId + "/hqdefault.jpg");

			} else
				UrlImageViewHelper.setUrlDrawable(holder.thumbNailAdpIv, null);

			return view;
		}

		private static class ViewHolder {

			private ImageView thumbNailAdpIv;
			private TextView movieTitAdpTv;
			private TextView movieGenreAdpTv;
			private TextView movieLangAdpTv;
			private TextView movieLenAdpTv;
			private TextView movieActorsAdpTv;
		}

	}

	// Method for returning You-tube video Id
	public static String getYoutubeVideoId(String youtubeUrl) {

		String video_id = "";
		if (youtubeUrl != null && youtubeUrl.trim().length() > 0
				&& youtubeUrl.startsWith("http")) {

			String expression = "^.*((youtu.be"
					+ "\\/)"
					+ "|(v\\/)|(\\/u\\/w\\/)|(embed\\/)|(watch\\?))\\??v?=?([^#\\&\\?]*).*";
			CharSequence input = youtubeUrl;
			Pattern pattern = Pattern.compile(expression,
					Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(input);
			if (matcher.matches()) {
				String groupIndex1 = matcher.group(7);
				if (groupIndex1 != null && groupIndex1.length() == 11)
					video_id = groupIndex1;
			}
		}
		return video_id;

	}
}
