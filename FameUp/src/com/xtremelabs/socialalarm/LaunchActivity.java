package com.xtremelabs.socialalarm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.xtremelabs.socialalarm.util.FacebookUtil;
import com.xtremelabs.socialalarm.util.FacebookUtil.FacebookTaskListener;

public class LaunchActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		findViewById(R.id.fbLoginButton).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				FacebookUtil.loginToFacebook(LaunchActivity.this, mLoginListener);
			}
		});

//		findViewById(R.id.pickRing).setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				RingUtil.pickRing(LaunchActivity.this);
//			}
//		});

	}

	private FacebookUtil.FacebookTaskListener mLoginListener = new FacebookTaskListener() {

		@Override
		public void onComplete() {
			Intent intent = new Intent(LaunchActivity.this, AlarmListActivity.class);
			startActivity(intent);
		}
	};
}