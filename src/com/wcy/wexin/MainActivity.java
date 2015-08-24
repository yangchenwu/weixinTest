package com.wcy.wexin;

import android.app.Activity;
import android.nfc.Tag;
import android.os.Bundle;
import android.provider.MediaStore.Images.ImageColumns;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements OnClickListener {
	private LinearLayout ll1, ll2, ll3, ll4;
	private ImageView iv1, iv2, iv3, iv4;
	private FrameLayout frameLayout;
	WeiXinFragment weiXinFragment;
	AddressFragment addressFragment;
	FindFragment findFragment;
	SettingFragment settingFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initView();
		initEvent();
		setSelete(0);

	}

	private void initEvent() {
		ll1.setOnClickListener(this);
		ll2.setOnClickListener(this);
		ll3.setOnClickListener(this);
		ll4.setOnClickListener(this);
		
		

	}

	private void initView() {
		ll1 = (LinearLayout) findViewById(R.id.ll1);
		ll2 = (LinearLayout) findViewById(R.id.ll2);
		ll3 = (LinearLayout) findViewById(R.id.ll3);
		ll4 = (LinearLayout) findViewById(R.id.ll4);

		iv1 = (ImageView) findViewById(R.id.iv1);
		iv2 = (ImageView) findViewById(R.id.iv2);
		iv3 = (ImageView) findViewById(R.id.iv3);
		iv4 = (ImageView) findViewById(R.id.iv4);
		
		frameLayout=(FrameLayout) findViewById(R.id.framelayout);

	}

	private void setSelete(int i) {
		// 把图片设置为亮
		// 设置内容区域
		FragmentManager fm=getSupportFragmentManager();
		FragmentTransaction transaction=fm.beginTransaction();
		hideFragment(transaction);
		
		switch (i) {
		case 0:
			if(weiXinFragment==null){
			
				weiXinFragment=new WeiXinFragment();
				transaction.add(R.id.framelayout, weiXinFragment);
			}else{
			
				transaction.show(weiXinFragment);
			}
			iv1.setImageResource(R.drawable.tab_weixin_pressed);
		
			break;
		case 1:
			if(addressFragment==null){
				addressFragment=new AddressFragment();
				transaction.add(R.id.framelayout, addressFragment);
				
			}else{
				transaction.show(weiXinFragment);
			}
			
			iv2.setImageResource(R.drawable.tab_address_pressed);
			break;
		case 2:
			if(findFragment==null){
				findFragment=new FindFragment();
				transaction.add(R.id.framelayout, findFragment);
				
			}else{
				transaction.show(findFragment);
			}
			iv3.setImageResource(R.drawable.tab_find_frd_pressed);
			break;
		case 3:
			if(settingFragment==null){
				settingFragment=new SettingFragment();
				transaction.add(R.id.framelayout, settingFragment);
				
			}else{
				transaction.show(settingFragment);
			}
			iv4.setImageResource(R.drawable.tab_settings_pressed);
			break;

		}
		transaction.commit(); 
	}

	private void hideFragment(FragmentTransaction transaction) {
	
	if(weiXinFragment!=null){
		transaction.hide(this.weiXinFragment);
	}
	if(addressFragment!=null){
		transaction.hide(this.addressFragment);
	}
	if(findFragment!=null){
		transaction.hide(this.findFragment);
	}
	if(settingFragment!=null){
		transaction.hide(this.settingFragment);
	}
		
	}

	@Override
	public void onClick(View arg0) {

		resetimg(); // 让图片资源先变成未选中状态
		switch (arg0.getId()) {
		case R.id.ll1:
			setSelete(0); 
			break;

		case R.id.ll2:
			setSelete(1); 
			break;

		case R.id.ll3:
			setSelete(2); 
			break;

		case R.id.ll4:
			setSelete(3); 
			break;

		}

	}

	private void resetimg() {
		iv1.setImageResource(R.drawable.tab_weixin_normal);
		iv2.setImageResource(R.drawable.tab_address_normal);
		iv3.setImageResource(R.drawable.tab_find_frd_normal);
		iv4.setImageResource(R.drawable.tab_settings_normal);

	}

}
