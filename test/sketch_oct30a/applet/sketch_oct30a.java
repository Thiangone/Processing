import processing.core.*; 
import processing.xml.*; 

import processing.serial.*; 

import java.applet.*; 
import java.awt.*; 
import java.awt.image.*; 
import java.awt.event.*; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class sketch_oct30a extends PApplet {



Serial myPort; 

int[] data = new int[8];

int i=0;

int distance;

int inByte;



PFont fontA;



public void setup() {

  println(Serial.list());

  myPort = new Serial(this, Serial.list()[1], 9600);

  

  size(450, 200);

  background(0);

  smooth();

  fontA  = createFont("FFScala",100);

  textFont(fontA);

}



public void draw() {

  while (myPort.available() > 0) {

  inByte = myPort.read();

  data[i]=inByte;

  i++;

  if(inByte == 10 ){

  if(i == 3) {distance= data[0]-48;}

  if(i == 4) {distance=(((data[0]-48)*10) +(data[1]-48));}

  if(i == 5) {distance=(((data[0]-48)*100)+((data[1]-48)*10) + (data[0]-48));}

  i=0;

}

}

  background(0);

  fill(255);

  text(distance, 100, 100);

  text("cm", 240, 100);

  fill(255,0,0); 

  rect(20, 120, distance*15, 20); 



}


  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#ECE9D8", "sketch_oct30a" });
  }
}
