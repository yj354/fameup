package io.yuji.fameup;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import io.yuji.fameup.util.AlarmUtil;

public class AlarmEditorActivity extends Activity {
    
	private EditText mName;
//	private Button mBtnDate;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_editor);
        
        //custom font
        Typeface tf = Typeface.createFromAsset(getAssets(),
                "fonts/Futura.otf");
        TextView tv = (TextView) findViewById(R.id.name);
        tv.setTypeface(tf);
        //
        
        mName = (EditText) findViewById(R.id.alarm_name);
//        mBtnDate = (Button) findViewById(R.id.date_button);
//        
//        setDateButtonText(System.currentTimeMillis());
//        
//        mBtnDate.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				DatePickerDialog dateDialog = new DatePickerDialog(AlarmEditorActivity.this, null, 2011, 12, 12);
//				dateDialog.show();
//			}
//		});
        
        findViewById(R.id.done_button).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				onSetAlarmToTimePickerButtonPress();
				finish();
			}
		});
    }
	
//	private void setDateButtonText(long timeInMillis){
//		Time alarmTime = new Time();
//		alarmTime.set( timeInMillis );
//		
//		mBtnDate.setText(TimeFormatter.formatShortTime(alarmTime));
//	}
	
	public void onSetAlarmToTimePickerButtonPress() {
	    TimePicker timePicker = (TimePicker) findViewById(R.id.time_picker);
	    
	    AlarmUtil.onSetAlarmToTimePickerButtonPress(this, timePicker, mName.getText().toString());
	}
}
