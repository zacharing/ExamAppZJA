
package edu.saintjoe.cs.brianc.examtwo;
//Exam Activity
//Forked from Brian Capouch on April 8
//Changed by Zachary Aring on April 8


//Importing what you plan to use 
import com.google.devtools.simple.runtime.components.Component;
import com.google.devtools.simple.runtime.components.HandlesEventDispatching;
import com.google.devtools.simple.runtime.components.android.Form;

import com.google.devtools.simple.runtime.components.android.Button;
import com.google.devtools.simple.runtime.components.android.Label;
import com.google.devtools.simple.runtime.components.android.HorizontalArrangement;
import com.google.devtools.simple.runtime.components.android.TextBox;


import com.google.devtools.simple.runtime.events.EventDispatcher;

//only class for app
public class ExamActivity extends Form implements HandlesEventDispatching {

//"components" of the app
	private HorizontalArrangement line1, line2, line3, line4;
	private Button incButton;
	private Label resultLabel;
	private Label promptLabel;
	private TextBox inputBox;
	private Label outputLabel;
	int temp;
	

 void $define() {
 	// main screen
     this.BackgroundColor(COLOR_WHITE);
     
     //containers for widgets
     line1 = new HorizontalArrangement(this);
     line2 = new HorizontalArrangement(this);
     line3 = new HorizontalArrangement(this);
     line4 = new HorizontalArrangement(this);

     //user interface
     promptLabel = new Label(line1, "Enter a number:");
     inputBox = new TextBox(line1);
     inputBox.NumbersOnly(true);
   
     incButton = new Button(line2,"Double It:"); 
     
     resultLabel = new Label(line3,"");
     
     outputLabel = new Label(line4, "");
 
     //let runtime know which events to report
     EventDispatcher.registerEventForDelegation(this, "ButtonClick", "Click");
    
 } 
 @Override
 public boolean dispatchEvent(Component component, String id, String eventName,
         Object[] args) {
 	
	 //blocks of app invetor
	    if (component.equals(incButton) && eventName.equals("Click")){
	    	temp = Integer.parseInt(inputBox.Text());
	    	temp *= 2;
	    	resultLabel.Text(String.valueOf(temp));
	        return true;
	     } 
	    
	    if (component.equals(resultLabel) && eventName.equals("Click")) {
	    	outputLabel.Text("You pushed me!!");
	    	return true;
	    }
    return true;
	} 
} //end class activity
