package pa6Android.org;
import java.util.*;
import java.io.*;

import android.util.Log;

public class Concentration
{
	public static Scanner scanner = new Scanner (System.in);

	private ConcentrationGMaker g;
	private boolean gameOver = false;
	
	/**
	 * Loads a level based on a single string.  The levels are read from getting information from two seperate text files
	 */
	public void loadLevel() 
	{
		
		Scanner alist;
		Log.d("LoaderAscanner", "ugh!Ascanner");
		LinkedList <String> questions = new LinkedList<String>();
	
		questions.add("Fire");
		questions.add("Grass");
		questions.add("Air");
		
		LinkedList <String> answers = new LinkedList<String>();
			
		answers.add("Burns?");
		answers.add("Grows?");
		answers.add("Blows?");
			
		this.g = new ConcentrationGMaker(3,2, questions, answers); 
	}
	/**
	 *  Plays the game and keeps track of which cards were picked
	 */
	
	public ConcentrationGMaker getMaker()
	{
		return g;
	}

}
