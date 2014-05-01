package io.yuji.fameup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import io.yuji.fameup.util.FacebookUtil;
import io.yuji.fameup.util.FacebookUtil.FacebookTaskListener;

public class LaunchActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

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
