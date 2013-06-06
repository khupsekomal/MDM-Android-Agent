package com.mdm;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class AgentSettingsActivity extends Activity {
	private String FROM_ACTIVITY = null;
	private String REG_ID = "";
	static final String[] OP_NAME = new String[] { "Operations", "Phone Info", "Change PIN code", "Change IP address"};
	private ArrayAdapter<String> listAdapter ; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agent_settings);
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			if(extras.containsKey("from_activity_name")){
				FROM_ACTIVITY = extras.getString("from_activity_name");
			}
			
			if(extras.containsKey("regid")){
				REG_ID = extras.getString("regid");
			}
		}
		
		listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow ,OP_NAME);
		 
		ListView listView = (ListView) findViewById(R.id.listview);  
		listView.setAdapter(listAdapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
			    // When clicked, show a toast with the TextView text
				if(position == 0){
					Intent intent = new Intent(AgentSettingsActivity.this,AvailableOperationsActivity.class);
					intent.putExtra("from_activity_name", FROM_ACTIVITY);
					intent.putExtra("regid", REG_ID);
					startActivity(intent);
				}else if(position == 1){
					Intent intent = new Intent(AgentSettingsActivity.this,DisplayDeviceInfo.class);
					intent.putExtra("from_activity_name", FROM_ACTIVITY);
					intent.putExtra("regid", REG_ID);
					startActivity(intent);
				}else if(position == 2){
					Intent intent = new Intent(AgentSettingsActivity.this,PinCodeActivity.class);
					intent.putExtra("from_activity_name", AgentSettingsActivity.class.getSimpleName());
					intent.putExtra("main_activity_name", FROM_ACTIVITY);
					intent.putExtra("regid", REG_ID);
					startActivity(intent);
				}else if(position == 3){
					Intent intent = new Intent(AgentSettingsActivity.this,SettingsActivity.class);
					intent.putExtra("from_activity_name", FROM_ACTIVITY);
					intent.putExtra("regid", REG_ID);
					startActivity(intent);
				}
			}
		});
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if (keyCode == KeyEvent.KEYCODE_BACK) {
	    	if(FROM_ACTIVITY != null && FROM_ACTIVITY.equals(Entry.class.getSimpleName())){
	    		Intent intent = new Intent(AgentSettingsActivity.this,Entry.class);
	    		startActivity(intent);
	    	}
	    	else if(FROM_ACTIVITY != null && FROM_ACTIVITY.equals(Authentication.class.getSimpleName())){
	    		Intent intent = new Intent(AgentSettingsActivity.this,Authentication.class);
	    		intent.putExtra("regid", REG_ID);
	    		startActivity(intent);
	    	}else if(FROM_ACTIVITY != null && FROM_ACTIVITY.equals(AllReadyRegistered.class.getSimpleName())){
	    		Intent intent = new Intent(AgentSettingsActivity.this,AllReadyRegistered.class);
	    		intent.putExtra("regid", REG_ID);
	    		startActivity(intent);
	    	}else if(FROM_ACTIVITY != null && FROM_ACTIVITY.equals(MainActivity.class.getSimpleName())){
	    		Intent intent = new Intent(AgentSettingsActivity.this,MainActivity.class);
	    		intent.putExtra("regid", REG_ID);
	    		startActivity(intent);
	    	}else if(FROM_ACTIVITY != null && FROM_ACTIVITY.equals(RegisterSuccessful.class.getSimpleName())){
	    		Intent intent = new Intent(AgentSettingsActivity.this,RegisterSuccessful.class);
	    		startActivity(intent);
	    	}else{
	    		finish();
	    	}
	        return true;
	    }
	    else if (keyCode == KeyEvent.KEYCODE_HOME) {
	    	/*Intent i = new Intent();
	    	i.setAction(Intent.ACTION_MAIN);
	    	i.addCategory(Intent.CATEGORY_HOME);
	    	this.startActivity(i);*/
	    	this.finish();
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.agent_settings, menu);
		return true;
	}

}
