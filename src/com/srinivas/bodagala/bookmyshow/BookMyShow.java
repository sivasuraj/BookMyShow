package com.srinivas.bodagala.bookmyshow;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import android.app.Application;
import android.text.TextUtils;

public class BookMyShow extends Application {

	/*
	 * The app has three activities named MainActivity, ShowTimingsActivity, and
	 * SelectDateActivity
	 * 
	 * 1st Activity class MainActivity.java 2nd Activity class
	 * ShowTimingsActivity.java 3rd Activity class SelectDateActivity.java
	 * 
	 * Used four 3rd party libraries in the app named volley, Gson,
	 * Urlimageviewhelper and SherlockActionbar
	 * 
	 * BookMyShowObject is the POJO class used for parsing JSON from server.
	 * Used GSON library for parsing JSON
	 */

	private static BookMyShow bookMyShow;

	private RequestQueue mRequestQueue;
	private ImageLoader mImageLoader;

	public static final String TAG = BookMyShow.class.getSimpleName();

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();

		bookMyShow = this;
	}

	public static BookMyShow getInstance() {
		return bookMyShow;
	}

	// Volley Library Methods
	public RequestQueue getRequestQueue() {
		if (mRequestQueue == null) {
			mRequestQueue = Volley.newRequestQueue(getApplicationContext());
		}

		return mRequestQueue;
	}

	public ImageLoader getImageLoader() {
		getRequestQueue();
		if (mImageLoader == null) {
			mImageLoader = new ImageLoader(this.mRequestQueue,
					new LruBitmapCache());
		}
		return this.mImageLoader;
	}

	public <T> void addToRequestQueue(Request<T> req, String tag) {
		// set the default tag if tag is empty
		req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
		getRequestQueue().add(req);
	}

	public <T> void addToRequestQueue(Request<T> req) {
		req.setTag(TAG);
		getRequestQueue().add(req);
	}

	public void cancelPendingRequests(Object tag) {
		if (mRequestQueue != null) {
			mRequestQueue.cancelAll(tag);
		}
	}

}
