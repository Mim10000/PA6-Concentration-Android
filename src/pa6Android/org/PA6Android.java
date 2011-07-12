package pa6Android.org;

import pa6Android.org.Music;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class PA6Android extends Activity implements OnClickListener {
    	
	
	private EditText et1;
	private EditText et2;
	static String p1Name;
	static String p2Name;
	
	     protected void onCreate(Bundle bundle) {
	         super.onCreate(bundle);

	         setContentView(R.layout.main);

	     
	         et1 = (EditText) findViewById(R.id.editText1);
	         et2 = (EditText) findViewById(R.id.editText2);
	     	
	         //Deals with the Music Player
	         setVolumeControlStream(AudioManager.STREAM_MUSIC);
	         Music.create(this, R.raw.mourningwind);
	         Music.start(this);
	         
	         View continueButton = findViewById(R.id.cButton);
	         continueButton.setOnClickListener(this); 
	         
	         
	     }
	     public void onClick(View v) {
	           
	    	p1Name = et1.getText().toString();
	    	p2Name = et2.getText().toString();
	    	 
	      Intent x=new Intent(this, Game.class);
	      startActivity(x);
	     }
	     protected void onDestroy()
	     {
	     	super.onDestroy();
	     	Music.stop(this);
	     }
}
	