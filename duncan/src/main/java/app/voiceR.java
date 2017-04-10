package app;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;

public class voiceR {
   private static final int RECORD_TIME = 3000;//3 sec
  public static void main (String [] args) {
    final SoundRecordingUtil recorder = new SoundRecordingUtil ();
    File wavFile = new File ("/home/phiber/Desktop/Work/duncan/duncan/target/voice/audio.wav");

    // create a separate thread for recording
      Thread recordThread = new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   System.out.println("Start recording...");
                   recorder.start();
               } catch (LineUnavailableException ex) {
                   ex.printStackTrace();
                   System.exit(-1);
               }
           }
       });
       recordThread.start();
       try {
           Thread.sleep(RECORD_TIME);
       } catch (InterruptedException ex) {
           ex.printStackTrace();
       }
       try {
           recorder.stop();
           recorder.save(wavFile);
           System.out.println("STOPPED");
       } catch (IOException ex) {
           ex.printStackTrace();
       }
       System.out.println("DONE");
  }
}