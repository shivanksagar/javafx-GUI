/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csio;

/*
=====================================================================================================
This is the code for the software made for the csio wheel chair the whole applications uses java fx GUI toolkit below in the code you will see the various amount 
components being imported into the code which then are later used to get values from the user and burnning them onto the desired  chip.
The following import's below are importing various things such as (scene controls) from java fx gui tooklit  library's

===========================================================================================================
*/

import java.awt.Image;         
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Tab;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Toggle;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;  
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;


/**
 *
 * @author Amit CSIO_MAIN
 */
public class CSIO_MAIN extends Application {
     /*
    ===============================================================================================
    below the variable have been decalred as static so that they maybe used and called anywhere in the project.
    ===============================================================================================
    
    */
       static int accelration = 1 ;
       static int  accelrationR = 1 ;  
       static  int accelrationT = 1 ; 
       static int decelration = 1; 
       static int decelrationR = 1 ; 
       static int decelrationT = 1 ;
       static  int speed =1 ; 
       static  int speedR = 1 ;
       static  int speedT =1 ;
       static int  value;
       static int value1;
       static int value2;
          
          

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

   /*
    ==========================================================================================
    below we are intioating our statusbar class as a singleton so they it may be called universally in any of the classes further created.
    ===========================================================================================
    
    */
    public static StatusBar statusBar;
    private String str;
    @Override
    public void init() {
    statusBar = new StatusBar();
    statusBar.setText("Status:Powered Up ");   
    }
    
    
    @Override
    public void start(Stage primaryStage) {
       
        /*
        ==============================================================================================
       All  the other spinner's of the gui are declared here and the value factory's are  created 
        ==============================================================================================
        */
        
        Spinner<Integer> ispinner = new Spinner<>(1, 100, 1);
         
        Spinner<Integer> ispinnerR = new Spinner<>(1, 100, 1);
        Spinner<Integer> ispinnerT = new Spinner<>(1, 100, 1);
        
        Spinner<Integer> dspinner = new Spinner<>(1, 100, 1);
        Spinner<Integer> dspinnerR = new Spinner<>(1, 100, 1);
        Spinner<Integer> dspinnerT = new Spinner<>(1, 100, 1);

        Spinner<Integer> sspinner = new Spinner<>(1, 100, 1);
        Spinner<Integer> sspinnerR = new Spinner<>(1, 100, 1);
        Spinner<Integer> sspinnerT = new Spinner<>(1, 100, 1);
        

        /*
        =================================================================================
        All the radiobuttons are declared below
        =================================================================================
        */          
        RadioButton HIGH = new RadioButton();        
        HIGH.setText("Joystick Throw HIGH");
        
        RadioButton LOW = new RadioButton();      
        LOW.setText("Joystick Throw LOW");
        
        RadioButton MEDIUM = new RadioButton();
        MEDIUM.setSelected(true);
        MEDIUM.setText("Joystick Throw MEDIUM");
        
        RadioButton ON = new RadioButton();
        ON.setText("Softreverse ON");
        
        RadioButton OFF = new RadioButton();
        OFF.setSelected(true);
        OFF.setText("Softreverse OFF");
        
        RadioButton Rwd = new RadioButton();
        Rwd.setText("Rear Wheel Drive");
        
        
        RadioButton Fwd = new RadioButton();
        Fwd.setText("Forward wheel Drive");
        Fwd.setSelected(true);
        
        /*
        ==================================================================================
        in the below code we are calling and intializing buttons here 
        from import javafx.scene.control.Button;
        
        ==================================================================================
        */

        Button abtn = new Button();
        Button arbtn = new Button();
        Button atbtn = new Button();
        Button dbtn = new Button();
        Button drbtn = new Button();
        Button dtbtn = new Button();
        Button sbtn = new Button();
        Button srbtn = new Button();
        Button stbtn = new Button();
        Button vbtn = new Button();
        
        /*
        ================================================================================
        in the below code we are calling and initalizing checkbox froom
        import javafx.scene.control.CheckBox;
       ================================================================================= 
        */
        
        CheckBox checkboxA = new CheckBox();
        
        CheckBox checkboxAr = new CheckBox();
        CheckBox checkboxAt = new CheckBox();
        CheckBox checkboxD = new CheckBox();
        CheckBox checkboxDr = new CheckBox();
        CheckBox checkboxDt = new CheckBox();
        CheckBox checkboxS = new CheckBox();
        CheckBox checkboxSr = new CheckBox();
        CheckBox checkboxSt = new CheckBox();
        
       
       /*
        ==============================================================================================
        3 Toggle group are created 
        *Joystickthrow
        *Softreverse     
        *Wheeldrive
        ================================================================================================
        */
        
        Label accellabel = new Label("Soft Reverse");     
        ToggleGroup Joystickthrow = new ToggleGroup();
        ToggleGroup Softreverse = new ToggleGroup();
        ToggleGroup Wheeldrive = new ToggleGroup();
       
        Joystickthrow.selectedToggleProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                Toggle i = Joystickthrow.getSelectedToggle();
               
                 RadioButton selectedButton = ((RadioButton)i);
                int value1 = ((RadioButton)i).isSelected()?1:0;
                   
                System.out.println(value1);
           
            }
        });
            
        Softreverse.selectedToggleProperty().addListener(new InvalidationListener(){
            @Override
            public void invalidated(Observable observable) {
               Toggle t = Softreverse.getSelectedToggle();
                RadioButton selectedButton = ((RadioButton)t);
                int value = ((RadioButton)t).isSelected()?1:0;
                if(selectedButton == ON) System.out.println("ON " + value);
                        else System.out.println("OFF " + value);
                
            }
        } );
        
            Wheeldrive.selectedToggleProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                
               Toggle t = Wheeldrive.getSelectedToggle();
              RadioButton selectedButton = ((RadioButton)t);
                int value2 = ((RadioButton)t).isSelected()?1:0;
                System.out.println(value2);
            }

        });
  /*
     All the buttons setting their texts in the below code       
            */
          
        
        abtn.setText("Accelration Forward Set");
        abtn.setLayoutX(10005);
        arbtn.setText("Accelration Reverse Set");
        arbtn.setLayoutX(10005);
        atbtn.setText("Accelration Turning Set");
        atbtn.setLayoutX(10005);
        atbtn.setStyle("-fx-background-image: url('C:/Users/Amit CSIO/Documents/NetBeansProjects/CSIO/src/Turning.png')");
        
        dbtn.setText("Decelration Forward Set");
        dbtn.setLayoutX(10005);
        drbtn.setText("Decelration Reverse Set");
        drbtn.setLayoutX(10005);
        dtbtn.setText("Decelration Turning Set");
        dtbtn.setLayoutX(10005);
        
        sbtn.setText("   Speed  Forward  Set   ");
        sbtn.setLayoutX(10005);
        srbtn.setText("   Speed  Reverse  Set   ");
        srbtn.setLayoutX(10005);
        stbtn.setText("   Speed  Turning  Set   ");
        stbtn.setLayoutX(10005);
        
  /*
        menubar is intialized and different item are added onto it 
        */      
                     
 Menu menu1 = new Menu("Settings"); // seting the menu 
 MenuItem open = new MenuItem("Open Settings");//adding the options into setting menu
 open.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));//setting shortcuts for the option to work from keyboard
 open.setOnAction(e ->{  // what happen when options get's clicked 
   FileChooser file = new FileChooser ();  // calling file chooser so they we may create a open setting functionality 
   file.setTitle("Open Your settings");
   FileChooser.ExtensionFilter extFilter =
                        new FileChooser.ExtensionFilter("CONFIG files (*.ini)", "*.init"); // telling file chooser which type of files we want to open in this case configration files (.ini).
                file.getExtensionFilters().add(extFilter);
         File openfile = file.showOpenDialog(primaryStage);
           try {
               FileReader read = new FileReader(openfile);
               BufferedReader bufferreader = new BufferedReader(read);
               StringBuffer stringbuffer = new StringBuffer(); // creating a buffer for the string 
               String line;
           while((line =bufferreader.readLine())!= null){
              String[] prams =  line.split("="); // parsing the string 
              if(prams[0].equals("accelration")) {
                  accelration= Integer.parseInt(prams[1]); 
                  initSpinners(ispinner,accelration);
              }
              if(prams[0].equals("accelrationReverse"))  {
                  accelrationR= Integer.parseInt(prams[1]);
                  initSpinners(ispinnerR,accelrationR);
              }
              
              if(prams[0].equals("accelrationTurning")) {
                  accelrationT= Integer.parseInt(prams[1]);
                  initSpinners(ispinnerT,accelrationT);
              }
              if(prams[0].equals("Decelration"))  {
                  decelration= Integer.parseInt(prams[1]);
                  initSpinners(dspinner,decelration);
              }
              if(prams[0].equals("DecelrationReverse"))  {
                  decelrationR= Integer.parseInt(prams[1]);
                  initSpinners(dspinnerR,decelrationR);
              }
              if(prams[0].equals("DecelrationTurning"))  {
                  decelrationT= Integer.parseInt(prams[1]);
                  initSpinners(dspinnerT,decelrationT);
              }
              if(prams[0].equals("Speed")) {
                  speed= Integer.parseInt(prams[1]);
                initSpinners(sspinner,speed);
              }
              if(prams[0].equals("SpeedReverse"))  {
                  speedR= Integer.parseInt(prams[1]);
                  initSpinners(sspinnerR,speedR);
              }
              if(prams[0].equals("SpeedTurning")) {
                  speedT= Integer.parseInt(prams[1]);
                  initSpinners(sspinnerT,speedT);
              }
              if(prams[0].equals("Joystickthrow")) System.out.println(prams[1]+"<--");
              if(prams[0].equals("Softreverse")) System.out.println(prams[1]+"<--");
              if(prams[0].equals("Wheeldrive")) System.out.println(prams[1]+"<--");
           }
           read.close();
           } catch (IOException ex) {
                Logger.getLogger(CSIO_MAIN.class.getName()).log(Level.SEVERE, null, ex);
            }
   file.showOpenDialog(primaryStage);
   
   
    });
 
  MenuItem saveas = new MenuItem("Save Setting"); // adding a new menu item to save the setting user created
  saveas.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN)); // creating a short cut for save setting to open
   saveas.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                FileChooser filesave = new FileChooser ();
                filesave.setTitle("Save your settings");
                FileChooser.ExtensionFilter extFilter =
                        new FileChooser.ExtensionFilter("CONFIG files (*.ini)", "*.ini");
                filesave.getExtensionFilters().add(extFilter);
                File name = filesave.showSaveDialog(primaryStage);
		try (FileWriter fileWriter = new FileWriter(name,false)){	                    
			fileWriter.write("accelration"+"="+accelration+"\r\n"+"accelrationReverse"+"="+accelrationR+"\r\n"+"accelrationTurning"+"="+accelrationT+"\r\n"+"Decelration"+"="+decelration+"\r\n"+
               "DecelrationReverse"+"="+decelrationR+"\r\n"+"DecelrationTurning"+"="+decelrationT+
               "\r\n"+"Speed"+"="+speed+"\r\n"+"SpeedReverse"+"="+speedR+"\r\n"+"SpeedTurning"+"="+speedT+"\r\n"+"Softreverse"+"="+value+"\r\n"+"Joystickthrow"+"="+value1+"\r\n"+"Wheeldrive"+"="+value2);						
		} catch (IOException i) {
	        System.err.println("Caught IOException: " + i.getMessage());
		}        }
        });

 
 MenuItem defaultSetting = new MenuItem("Default Setting"); // adding a new menu item to resrtore the default setting 
 defaultSetting.setAccelerator(new KeyCodeCombination(KeyCode.D, KeyCombination.CONTROL_DOWN)); // creating a keyboard shortcut for the deafult setting to open 
 defaultSetting.setOnAction(e -> {
     /*
     since we do not have a direct function in the spinner to set a default value we do it by so by manupulating the increament and decrement functions.
     First we are taking the value from the spinner and decrementing it if it is greater than 50 and increment ting it if it is smaller than 50.
     We are setting the value of spinner at 50 by deafult.
     */
 ispinner.decrement(ispinner.getValue() > 50? ispinner.getValue() - 50:0);
 ispinner.increment(ispinner.getValue() < 50?50 - ispinner.getValue():0);
 
 
 ispinnerR.decrement(ispinnerR.getValue() > 50? ispinnerR.getValue() - 50:0);
 ispinnerR.increment(ispinnerR.getValue() < 50?50 - ispinnerR.getValue():0);
 ispinnerT.decrement(ispinnerT.getValue() > 50? ispinnerT.getValue() - 50:0);
 ispinnerT.increment(ispinnerT.getValue() < 50?50 - ispinnerT.getValue():0);
 
 dspinner.decrement(dspinner.getValue() > 50? dspinner.getValue() - 50:0);
 dspinner.increment(dspinner.getValue() < 50?50 - dspinner.getValue():0);
 
 dspinnerR.decrement(dspinnerR.getValue() > 50? dspinnerR.getValue() - 50:0);
 dspinnerR.increment(dspinnerR.getValue() < 50?50 - dspinnerR.getValue():0);
 
 dspinnerT.decrement(dspinnerT.getValue() > 50? dspinnerT.getValue() - 50:0);
 dspinnerT.increment(dspinnerT.getValue() < 50?50 - dspinnerT.getValue():0);
 
 sspinner.decrement(sspinner.getValue() > 50?sspinner.getValue() - 50:0);
 sspinner.increment(sspinner.getValue() < 50?50 - sspinner.getValue():0);
 
 sspinnerR.decrement(sspinnerR.getValue() > 50?sspinnerR.getValue() - 50:0);
 sspinnerR.increment(sspinnerR.getValue() < 50?50 - sspinnerR.getValue():0);
 
 sspinnerT.decrement(sspinnerT.getValue() > 50?sspinnerT.getValue() - 50:0);
 sspinnerT.increment(sspinnerT.getValue() < 50?50 - sspinnerT.getValue():0);
 statusBar.setText("Done!");
 });
 
 Menu menu2 = new Menu("Options"); // 2nd menu item created with the name option and upload function added 
 MenuItem verify = new MenuItem("Verify connection");// we want to verify the connection .
verify.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN)); // creating a short cut for the verify connection to open.
 verify.setOnAction(e ->{
        try {
            Process r = Runtime.getRuntime().exec("cmd /c \"cd c:// && avrdude -c usbtiny -p m328p \""  );
            
          if(r.waitFor()== 0){
          statusBar.setText("Connected");
          }
          else {
               statusBar.setText("Disconnected");
          }
        
        } catch(Exception s)
        {
           s.printStackTrace();
           statusBar.setText("Error executing the command");           
        }
            });
         
 MenuItem upload = new MenuItem("Upload"); // to upload the code we created a another option upload 
 upload.setAccelerator(new KeyCodeCombination(KeyCode.U, KeyCombination.CONTROL_DOWN));// we created a key combination so thet it may from keyboard directly
 upload.setOnAction(e ->{
     /*
     here we are simply linking the Avrdude-Command class with the upload option so that when the user clicks on the options program get's upload onto the chip
     */
       
 Avrdude_Command avrdude_Command = new Avrdude_Command(); // creating a instance of the class 
            try {         
                Process vj = Runtime.getRuntime().exec("cmd /c \"cd c:// && avrdude -c usbtiny -p m328p \"" );// before upload firt check is there is a programme rocnnected to the system or not.
                if(vj.waitFor() == 0){
                    avrdude_Command.upload(accelration, accelrationR, accelrationT,decelration,decelrationR,decelrationT,speed,speedR,speedT);
                    statusBar.setText("Program Uploaded");
                }
                else{
                    statusBar.setText("Please check your connection and try again");
                }
                //System.out.print(accelration);                
                
            } catch (Throwable ex) {
                statusBar.setText("ERROR:Please check your connections");
              
            }
         });
 

 
 menu1.getItems().addAll(open,saveas,defaultSetting);
 menu2.getItems().addAll(upload,verify);

 MenuBar menuBar = new MenuBar();
 menuBar.getMenus().addAll(menu1, menu2);
        
        
       

  
        /*
 if there is action on the check box we are simply updatin the static variable's when it is checked 
 */
         checkboxA.setSelected(false);
        checkboxAr.setOnAction(e -> {
          this.accelration  = ispinnerR.getValue();
          System.out.println("accelrationR"+accelration);
          
        });
   
        checkboxAr.setSelected(false);
        checkboxAr.setOnAction(e -> {
          this.accelrationR  = ispinnerR.getValue();
          System.out.println("accelrationR"+accelrationR);
        });
        checkboxAt.setSelected(false);
        checkboxAt.setOnAction(e -> {
          this.accelrationT  = ispinnerT.getValue();
          System.out.println("accelrationT"+accelrationT);
        });
        checkboxD.setSelected(false);
        checkboxD.setOnAction(e -> {
          this.decelration  = dspinner.getValue();
          System.out.println("decelration" + decelration);
        });
        checkboxDr.setSelected(false);
        checkboxDr.setOnAction(e -> {
          this.decelrationR  = dspinnerR.getValue();
          System.out.println("decelrationR"+decelrationR);
        });
        checkboxDt.setSelected(false);
        checkboxDt.setOnAction(e -> {
          this.decelrationT  = dspinnerT.getValue();
          System.out.println("decelrationT"+decelrationT);
        });
        checkboxS.setSelected(false);
        checkboxS.setOnAction(e -> {
          this.speed  = sspinner.getValue();
          System.out.println("speed"+speed);
        });
        checkboxSr.setSelected(false);
        checkboxSr.setOnAction(e -> {
          this.speedR  = sspinnerR.getValue();
          System.out.println("speedR"+speedR);
        });
        checkboxSt.setSelected(false);
        checkboxSt.setOnAction(e -> {
          this.speedT  = sspinnerT.getValue();
          System.out.println("speedT"+speedT);
        });
        
        /*
        what happens when the buttong get clicked we simply take the value from the spinner and put it into the static varibales declared above
        */
        abtn.setOnAction(e -> {
            this.accelration  = ispinner.getValue();
            
          statusBar.setText("Status:Acelration Forward Set!");
            });
        arbtn.setOnAction(e -> {
           
            this.accelrationR  = ispinnerR.getValue();
            statusBar.setText("Status:Accelration Reverse Set!");
           
             
            });
        atbtn.setOnAction(e -> {
            
            this. accelrationT  = ispinnerT.getValue();
            
            statusBar.setText("Status:Accelration Turning Set!");
             
            });
        dbtn.setOnAction(e -> {
            this. decelration  = dspinner.getValue();
            
           statusBar.setText("Status:Decelration Forward Set!");
    
            });
        drbtn.setOnAction(e -> {
          
            this. decelrationR  = dspinnerR.getValue();
            
            
           statusBar.setText("Status:Decelration Reverse Set!");
            });
        dtbtn.setOnAction(e -> {
            
            this. decelrationT  = dspinnerT.getValue();
            
          statusBar.setText("Status:Decelration Turning Set!");
            });
        
        sbtn.setOnAction(e -> {
            this. speed  = sspinner.getValue();
            
           statusBar.setText("Status:Speed Forward Set!");
            });
        srbtn.setOnAction(e -> {
          
            this. speedR  = sspinnerR.getValue();
           
            statusBar.setText("Status:Speed Reverse Set!");
           
            });
        stbtn.setOnAction(e -> {
           
            this. speedT  = sspinnerT.getValue();
           
             statusBar.setText("Status:Speed Turning Set!");
            });
        /*
        fopr this gui we are using grid pane or say layout 
        */
        GridPane gridPane = new GridPane();
        
 
         GridPane.setVgrow(checkboxA, Priority.ALWAYS); // adding vertical space so as to adjust the component size acording to the window size and setting priority to always
         GridPane.setHgrow(checkboxA, Priority.ALWAYS);// adding horizontal space so as to adjust the component size acording to the window size and setting priority to always 
         gridPane.setColumnIndex(checkboxA,0); // setting the coloum index of the componenet on the grid  
        gridPane.setRowIndex(checkboxA,1); // setting the Row index of the componet of the grid 
        
         GridPane.setVgrow(abtn, Priority.ALWAYS);
         GridPane.setHgrow(abtn, Priority.ALWAYS);
        gridPane.setColumnIndex(abtn,1);
        gridPane.setRowIndex(abtn,1);
        
         GridPane.setVgrow(ispinner, Priority.ALWAYS);
         GridPane.setHgrow(ispinner, Priority.ALWAYS);
         gridPane.setColumnIndex(ispinner,3);
        gridPane.setRowIndex(ispinner,1);
        
         GridPane.setVgrow(checkboxAr, Priority.ALWAYS);
         GridPane.setHgrow(checkboxAr, Priority.ALWAYS);
        gridPane.setColumnIndex(checkboxAr,0);
        gridPane.setRowIndex(checkboxAr,2); 
        
           GridPane.setVgrow(arbtn, Priority.ALWAYS);
         GridPane.setHgrow(arbtn, Priority.ALWAYS);
        gridPane.setColumnIndex(arbtn,1);
        gridPane.setRowIndex(arbtn,2);
        
           GridPane.setVgrow(ispinnerR, Priority.ALWAYS);
         GridPane.setHgrow(ispinnerR, Priority.ALWAYS);
          gridPane.setColumnIndex(ispinnerR,3);
        gridPane.setRowIndex(ispinnerR,2);
        
        
           GridPane.setVgrow(checkboxAt, Priority.ALWAYS);
         GridPane.setHgrow(checkboxAt, Priority.ALWAYS);
        gridPane.setColumnIndex(checkboxAt,0);
        gridPane.setRowIndex(checkboxAt,3);
        
           GridPane.setVgrow(atbtn, Priority.ALWAYS);
         GridPane.setHgrow(atbtn, Priority.ALWAYS);
        gridPane.setColumnIndex(atbtn,1);
        gridPane.setRowIndex(atbtn,3);
        
           GridPane.setVgrow(ispinnerT, Priority.ALWAYS);
         GridPane.setHgrow(ispinnerT, Priority.ALWAYS);
          gridPane.setColumnIndex(ispinnerT,3);
        gridPane.setRowIndex(ispinnerT,3);
        
           
          
      
   
           GridPane.setVgrow(checkboxD, Priority.ALWAYS);
         GridPane.setHgrow(checkboxD, Priority.ALWAYS); 
        gridPane.setColumnIndex(checkboxD,0);
        gridPane.setRowIndex(checkboxD,6);  
        
        
           GridPane.setVgrow(dbtn, Priority.ALWAYS);
         GridPane.setHgrow(dbtn, Priority.ALWAYS);
        gridPane.setRowIndex(dbtn,6);
        gridPane.setColumnIndex(dbtn,1);
        
        
           GridPane.setVgrow(dspinner, Priority.ALWAYS);
         GridPane.setHgrow(dspinner, Priority.ALWAYS);
        gridPane.setColumnIndex(dspinner,3);
        gridPane.setRowIndex(dspinner,6);
        
        
           GridPane.setVgrow(checkboxDr, Priority.ALWAYS);
         GridPane.setHgrow(checkboxDr, Priority.ALWAYS);
        gridPane.setColumnIndex(checkboxDr,0);
        gridPane.setRowIndex(checkboxDr,7);
        
        
           GridPane.setVgrow(drbtn, Priority.ALWAYS);
         GridPane.setHgrow(drbtn, Priority.ALWAYS);
        gridPane.setColumnIndex(drbtn,1);
        gridPane.setRowIndex(drbtn,7);
        
           GridPane.setVgrow(dspinnerR, Priority.ALWAYS);
         GridPane.setHgrow(dspinnerR, Priority.ALWAYS);
        gridPane.setColumnIndex(dspinnerR,3);
        gridPane.setRowIndex(dspinnerR,7);
        
        
        
           GridPane.setVgrow(checkboxDt, Priority.ALWAYS);
         GridPane.setHgrow(checkboxDt, Priority.ALWAYS);
        gridPane.setColumnIndex(checkboxDt,0);
        gridPane.setRowIndex(checkboxDt,8);
        
        
           GridPane.setVgrow(dtbtn, Priority.ALWAYS);
         GridPane.setHgrow(dtbtn, Priority.ALWAYS);
        gridPane.setColumnIndex(dtbtn,1);
        gridPane.setRowIndex(dtbtn,8);
        
           GridPane.setVgrow(dspinnerT, Priority.ALWAYS);
         GridPane.setHgrow(dspinnerT, Priority.ALWAYS);
        gridPane.setColumnIndex(dspinnerT,3);
        gridPane.setRowIndex(dspinnerT,8);
        
        
          GridPane.setVgrow(checkboxS, Priority.ALWAYS);
         GridPane.setHgrow(checkboxS, Priority.ALWAYS);
        gridPane.setColumnIndex(checkboxS,0);
        gridPane.setRowIndex(checkboxS,11);//tabPane.getTabs().add(Speed);
       
           GridPane.setVgrow(sbtn, Priority.ALWAYS);
         GridPane.setHgrow(sbtn, Priority.ALWAYS);
        gridPane.setColumnIndex(sbtn,1);
        gridPane.setRowIndex(sbtn,11);
        
        
           GridPane.setVgrow(sspinner, Priority.ALWAYS);
         GridPane.setHgrow(sspinner, Priority.ALWAYS);
         gridPane.setColumnIndex(sspinner,3);
        gridPane.setRowIndex(sspinner,11);
        
         
        
           GridPane.setVgrow(checkboxSr, Priority.ALWAYS);
         GridPane.setHgrow(checkboxSr, Priority.ALWAYS);
        gridPane.setColumnIndex(checkboxSr,0);
        gridPane.setRowIndex(checkboxSr,12);
        
           GridPane.setVgrow(srbtn, Priority.ALWAYS);
         GridPane.setHgrow(srbtn, Priority.ALWAYS);
        gridPane.setColumnIndex(srbtn,1);
        gridPane.setRowIndex(srbtn,12);
        
           GridPane.setVgrow(sspinnerR, Priority.ALWAYS);
         GridPane.setHgrow(sspinnerR, Priority.ALWAYS);
          gridPane.setColumnIndex(sspinnerR,3);
        gridPane.setRowIndex(sspinnerR,12);

        
           GridPane.setVgrow(checkboxSt, Priority.ALWAYS);
         GridPane.setHgrow(checkboxSt, Priority.ALWAYS);
        gridPane.setColumnIndex(checkboxSt,0);
        gridPane.setRowIndex(checkboxSt,13); 
        
           GridPane.setVgrow(stbtn, Priority.ALWAYS);
         GridPane.setHgrow(stbtn, Priority.ALWAYS);
        gridPane.setColumnIndex(stbtn,1);
        gridPane.setRowIndex(stbtn,13);
        
           GridPane.setVgrow(sspinnerT, Priority.ALWAYS);
         GridPane.setHgrow(sspinnerT, Priority.ALWAYS);
        gridPane.setColumnIndex(sspinnerT,3);
        gridPane.setRowIndex(sspinnerT,13); 
     
    /*
        ============================================================================
        The radiobuttons group we daclared above now we are adding radiobuuttons into them.
        ============================================================================
        
        */
         Joystickthrow.getToggles().add(HIGH);
         Joystickthrow.getToggles().add(LOW);
         Joystickthrow.getToggles().add(MEDIUM);
         
         Softreverse.getToggles().add(ON);
         Softreverse.getToggles().add(OFF);
         
         Wheeldrive.getToggles().add(Rwd);
         Wheeldrive.getToggles().add(Fwd);
        /*
         =======================================================================================
         adding radiobuttons into grid pane 
        =====================================================================================
         */ 
         
           GridPane.setVgrow(HIGH, Priority.ALWAYS);
         GridPane.setHgrow(HIGH, Priority.ALWAYS); 
        gridPane.setColumnIndex(HIGH,20);
        gridPane.setRowIndex(HIGH,1);
        
           GridPane.setVgrow(MEDIUM, Priority.ALWAYS);
         GridPane.setHgrow(MEDIUM, Priority.ALWAYS);
        gridPane.setColumnIndex(MEDIUM,20);
        gridPane.setRowIndex(MEDIUM,2);
        
           GridPane.setVgrow(LOW, Priority.ALWAYS);
         GridPane.setHgrow(LOW, Priority.ALWAYS);
        gridPane.setColumnIndex(LOW,20);
        gridPane.setRowIndex(LOW,3);
        
      
      
           GridPane.setVgrow(ON, Priority.ALWAYS);
         GridPane.setHgrow(ON, Priority.ALWAYS);
        gridPane.setColumnIndex(ON,20);
        gridPane.setRowIndex(ON,7);
        
           GridPane.setVgrow(OFF, Priority.ALWAYS);
         GridPane.setHgrow(OFF, Priority.ALWAYS);
        gridPane.setColumnIndex(OFF,20);
        gridPane.setRowIndex(OFF,8);
        
        
           GridPane.setVgrow(Rwd, Priority.ALWAYS);
         GridPane.setHgrow(Rwd, Priority.ALWAYS);
        gridPane.setColumnIndex(Rwd,20);
        gridPane.setRowIndex(Rwd,12);
        
        
           GridPane.setVgrow(Fwd, Priority.ALWAYS);
         GridPane.setHgrow(Fwd, Priority.ALWAYS);
        gridPane.setColumnIndex(Fwd,20);
        gridPane.setRowIndex(Fwd,13);
    
    
  /*
        ===============================================================
        padding up the radiobuttons with intializing insets function for vbox 
        ===============================================================
        */       
         VBox.setMargin(HIGH,new Insets(0,0,0,20));
         VBox.setMargin(MEDIUM,new Insets(0,0,0,20));
         VBox.setMargin(LOW,new Insets(0,0,0,20));
         
  
         
         VBox.setMargin(ON,new Insets(0,0,0,20));
         VBox.setMargin(OFF,new Insets(0,0,30,20));
         

         VBox.setMargin(Rwd,new Insets(0,0,0,20));
         VBox.setMargin(Fwd,new Insets(0,0,0,20));
        // tabPane.getTabs().add(Control);
        gridPane.setVgap(8);
        gridPane.setHgap(20); 
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.getChildren().addAll(checkboxA,checkboxAr,checkboxAt,checkboxD,checkboxDr,checkboxDt,checkboxS,checkboxSr,checkboxSt,
        abtn,arbtn,atbtn,ispinner,ispinnerR,ispinnerT,dbtn,drbtn,dtbtn,dspinner,dspinnerR,dspinnerT,sbtn,srbtn,stbtn,sspinner,sspinnerR,sspinnerT,HIGH,LOW,MEDIUM,ON,OFF,Rwd,Fwd);
        
        
        
        BorderPane bp = new BorderPane();
        bp.setTop(menuBar);
        bp.setCenter(gridPane);
        bp.setBottom(statusBar);
        gridPane.setBackground(null);
        bp.setBackground(null);
        
       
        
        Scene scene = new Scene(bp);
        /*
        we are adding css style sheet into the gui so that we may alter the look of various things .
        */
        scene.getStylesheets().add(getClass().getResource("newCascadeStyleSheet.css").toExternalForm());
       
        primaryStage.setTitle("Wheel chair");
        primaryStage.setScene(scene);
        //primaryStage.getIcons().add("Desktop//csir-csio.jpg");
        primaryStage.show();
    }
    

    void initSpinners(Spinner spinner,int value) {
    ((SpinnerValueFactory)spinner.valueFactoryProperty().get()).valueProperty().set(value);
    }
    
}

    /**
     * @param args the command line arguments
     */
  
    