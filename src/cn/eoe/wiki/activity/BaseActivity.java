package cn.eoe.wiki.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import cn.eoe.wiki.WikiApplication;
/**
 * 所有activity的基类，在这里可以处理一些所有页面都需要初始化的代码
 * @author <a href="mailto:kris1987@qq.com">Kris.lee</a>
 * @data  2012-8-2
 * @version 1.0.0
 */
public class BaseActivity extends Activity {
	public static final String 		ACTION_EXIT = "cn.eoe.wiki.ACTION_EXIT";
	protected WikiApplication mWikiApplication;
	protected BaseActivity mContext;
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		mWikiApplication = WikiApplication.getApplication();
		registerReceiver(exitReceiver, new IntentFilter(ACTION_EXIT));
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(exitReceiver);
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}
	
	public WikiApplication getWikiApplication() {
		return mWikiApplication;
	}

	/**
	 * receive the exit broadcast
	 */
	private BroadcastReceiver exitReceiver= new BroadcastReceiver() {
		
		@Override
		public void onReceive(Context context, Intent intent) {
			if(ACTION_EXIT.equals(intent.getAction()))
			{
				mContext.finish();
			}
		}
	};
}