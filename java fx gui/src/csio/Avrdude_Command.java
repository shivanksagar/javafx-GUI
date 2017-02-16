    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class  Avrdude_Command {
    
    static String text;    
    
    
//     static String text = "#include <avr/io.h>" + "\r\n" +"#include <util/delay.h>" + "\r\n"  
//+ "#define BLINK_DELAY_MS " + blink+ "\r\n" + "int main (void){" + "\r\n" + " DDRB |= _BV(DDB5);"+ "\r\n" + 
// "while(1) {" + "\r\n" + " PORTB |= _BV(PORTB5);" + "\r\n" + "_delay_ms(BLINK_DELAY_MS);" + "\r\n" +"PORTB &= ~_BV(PORTB5);" + 
//"\r\n" +" _delay_ms(BLINK_DELAY_MS);" + "\r\n"  + " }" + "\r\n" + "}";
    /**
     *
     * @param args
     * @throws Throwable
     */
  void upload(int accelration,int accelrationR,int acccelrationT,int decelration,int decelrationR,int decelrationT,int speed,int speedR,int speedT) throws Throwable {
		int blink = accelration*1000;
                 this.text = "#include <avr/io.h>" + "\r\n" +"#include <util/delay.h>" + "\r\n"  
+ "#define BLINK_DELAY_MS " + blink+ "\r\n" + "int main (void){" + "\r\n" + " DDRB |= _BV(DDB5);"+ "\r\n" + 
 "while(1) {" + "\r\n" + " PORTB |= _BV(PORTB5);" + "\r\n" + "_delay_ms(BLINK_DELAY_MS);" + "\r\n" +"PORTB &= ~_BV(PORTB5);" + 
"\r\n" +" _delay_ms(BLINK_DELAY_MS);" + "\r\n"  + " }" + "\r\n" + "}";
                 
      File Foo = new File("c:/led.c");
         try (FileWriter fw = new FileWriter(Foo,false);)
        {
             
             fw.write(text);
         }
		 try 
          { 
              //statusbar.setText("uploading");
              Process p=Runtime.getRuntime().exec("cmd.exe /c \"cd c:// &&  avr-gcc -Os -DF_CPU=16000000UL -mmcu=atmega328p -c -o led.o led.c && avr-gcc -mmcu=atmega328p led.o -o led && avr-objcopy -O ihex -R .eeprom led led.hex &&avrdude -c usbtiny -p m328p -U flash:w:led.hex\""  ); 
          
             InputStream is = p.getInputStream();
//            
              BufferedReader reader=new BufferedReader(
                  new InputStreamReader(is)
              ); 
              String line=null; 
              while((line = reader.readLine()) != null) 
              { 
                  System.out.println(line);                 
              } 
               p.waitFor(); 

          }
          catch(IOException | InterruptedException e1) {System.out.println("Done"); } 
                  File hex = new File ("c:/led.hex");
                  hex.delete();
                  File obj = new File("c:/led.o");
                  obj.delete();
                  File nor = new File ("c:/led");
                  nor.delete();
                  Foo.delete();

          
 
    }
}

