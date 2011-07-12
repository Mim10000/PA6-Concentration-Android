package pa6Android.org;

import java.io.FileNotFoundException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends Activity{
	
	//Keeps Track of the first card that people picked
	private int pickedCards = 0;
	
	
	private Concentration c = new Concentration();
	
	//Temp Button used for testing
	Button Pick1 = null;
	Button Pick2 = null;
	
	Button buttonA1;
	Button buttonA2;
	Button buttonB1;
	Button buttonB2;
	Button buttonC1;
	Button buttonC2;
	
	Player p1;
	Player p2;
	
	//figures out who gets the point
	Player pTemp;
	
	TextView p1Score;
	TextView p2Score;
	
	TextView result;
	
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        Music.create(this, R.raw.cardflip);
        
        c.loadLevel();
        
        setContentView(R.layout.game);
        
        //Changes Player1s Name
        TextView tp1 = (TextView) findViewById(R.id.Player1);
        tp1.setText(PA6Android.p1Name);
        
        //Changes Playe2s Name
        TextView tp2 = (TextView) findViewById(R.id.Player2);
        tp2.setText(PA6Android.p2Name);
        
        //result initialized
        result = (TextView) findViewById(R.id.result);

        
        //Adds Players and makes new game
        p1 = new Player(PA6Android.p1Name);
        p2 = new Player(PA6Android.p2Name);
        pTemp = p1;
		        
        //Changes Player1s Score
        p1Score = (TextView) findViewById(R.id.Player1Score);
        p1Score.setText(""+p1.getScore());
        
        //Changes Player2s Score
        p2Score = (TextView) findViewById(R.id.Player2Score);
        p2Score.setText(""+p2.getScore());
        
        
      //ButtonA1 Button
        buttonA1 = (Button) findViewById(R.id.buttonA1);
        buttonA1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) 
        {        	
        	if (buttonA1.getText().toString().equals(""))
        	{
        		if(pickedCards == 0)
        		{
        			buttonA1.setText(""+c.getMaker().getMatrix()[0][0]);
        			Pick1 = buttonA1;
        			pickedCards++;
        		}
        		else
        		{
        			buttonA1.setText(""+c.getMaker().getMatrix()[0][0]);
        			Pick2= buttonA1;
        			checkCards(Pick1,Pick2);
        		}
        	}
        }
        });
        //ButtonA2 Button
        buttonA2 = (Button) findViewById(R.id.buttonA2);
        buttonA2.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) 
        {        	
        	if (buttonA2.getText().toString().equals(""))
        	{
    			buttonA2.setText(""+c.getMaker().getMatrix()[0][1]);
        		if(pickedCards == 0)
        		{
        			Pick1= buttonA2;
        			pickedCards++;
        		}
        		else
        		{
        			Pick2= buttonA2;
        			checkCards(Pick1,Pick2);
        		}
        	}
        }
        });
        //ButtonB1 Button
        buttonB1 = (Button) findViewById(R.id.buttonB1);
        buttonB1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) 
        {
        	
        	if (buttonB1.getText().toString().equals(""))
        	{
    			buttonB1.setText(""+c.getMaker().getMatrix()[1][0]);
        		if(pickedCards == 0)
        		{
        			Pick1= buttonB1;
        			pickedCards++;
        		}
        		else
        		{
        			Pick2= buttonB1;
        			checkCards(Pick1,Pick2);
        		}
        	}
        }
        });
        //ButtonB2 Button
        buttonB2 = (Button) findViewById(R.id.buttonB2);
        buttonB2.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) 
        {
             	if (buttonB2.getText().toString().equals(""))
             	{
         			buttonB2.setText(""+c.getMaker().getMatrix()[1][1]);
             		if(pickedCards == 0)
             		{
             			Pick1= buttonB2;
             			pickedCards++;
             		}
             		else
             		{
             			Pick2= buttonB2;
             			checkCards(Pick1,Pick2);
             		}
             	}
        }
        });
        //ButtonC1 Button
        buttonC1 = (Button) findViewById(R.id.buttonC1);
        buttonC1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) 
        {        	
        	if (buttonC1.getText().toString().equals(""))
         	{
     			buttonC1.setText(""+c.getMaker().getMatrix()[2][0]);

         		if(pickedCards == 0)
         		{
         			Pick1= buttonC1;
         			pickedCards++;
         		}
         		else
         		{
         			Pick2= buttonC1;
         			checkCards(Pick1,Pick2);
         		}
         	}
        }
        });
        //ButtonC2 Button
        buttonC2 = (Button) findViewById(R.id.buttonC2);
        buttonC2.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) 
        {
        	if (buttonC2.getText().toString().equals(""))
         	{
     			buttonC2.setText(""+c.getMaker().getMatrix()[2][1]);

         		if(pickedCards == 0)
         		{
         			Pick1= buttonC2;
         			pickedCards++;
         		}
         		else
         		{
         			Pick2= buttonC2;
         			checkCards(Pick1,Pick2);
         		}
         	}
        }
        });
    }
    /**
     * Checks to see how many cards were drawn
     */
    public void checkCards(Button b1, Button b2)
    {
    	Music.start(this);
    	if(c.getMaker().getQA().get(b1.getText()).equals(b2.getText()) || c.getMaker().getQA().get(b2.getText()).equals(b1.getText()))
    	{
    		
    		pTemp.match();
			p1Score.setText(""+p1.getScore());
	    	p2Score.setText(""+p2.getScore());

	    	Context context = getApplicationContext();
	    	CharSequence text = "Hello toast!";
	    	int duration = Toast.LENGTH_SHORT;

	    	Toast toast = Toast.makeText(context, ""+b1.getText() + " and " + b2.getText() + " is a match",duration);
	    	toast.show();
	    	
    		pickedCards = 0;
    		//Simple fix, should be changed
    		if(p1.getScore()+p2.getScore() == 3)
    		{
    			if(p1.getScore()>p2.getScore())
    			{
    				p1.win();
    		        result.setText(p1.getName() + " Won!");
    			}
    			else
    			{
    				p2.win();
    				result.setText(p2.getName() + " Won!");
    			}
    		}
    	}
    	else
    	{
    	
    		if (pTemp == p1)
    		{
    			pTemp = p2;
    		}
    		else
    		{
    	    	pTemp = p1;
    		}
    		    	
    		
    		Context context = getApplicationContext();
	    	CharSequence text = "Hello toast!";
	    	int duration = Toast.LENGTH_LONG;

	    	Toast toast = Toast.makeText(context, ""+b1.getText() + " and " + b2.getText() + " is not a match, " + pTemp.getName() + "'s turn",duration);
	    	toast.show();
    		
    		
    		b1.setText("");
    		b2.setText("");
    		
    		pickedCards = 0;
    	}
    	//Changes Player
    
    }
} 


