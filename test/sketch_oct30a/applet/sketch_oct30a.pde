import processing.serial.*;

Serial myPort; 

int[] data = new int[8];

int i=0;

int distance;

int inByte;



PFont fontA;



void setup() {

  println(Serial.list());

  myPort = new Serial(this, Serial.list()[1], 9600);

  

  size(450, 200);

  background(0);

  smooth();

  fontA  = createFont("FFScala",100);

  textFont(fontA);

}



void draw() {

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

