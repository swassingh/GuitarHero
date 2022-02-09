// Swastik Singh
// 01/19/2022
// CSE 143 EC
// TA: Omar Ibrahim

import java.util.*;

// 

public class GuitarString {

   private Queue<Double> ringQ; // Stores sound data
   public static final double DECAY_FACTOR = 0.996; // Energy decay factor

   public GuitarString(double frequency){
      if (frequency <= 2 || (int) (Math.round(StdAudio.SAMPLE_RATE / frequency)) < 2){
         throw new IllegalArgumentException();
      }
      
      ringQ = new LinkedList<>();
      
      for (int i = 0; i < (int) (Math.round(StdAudio.SAMPLE_RATE / frequency)); i++){
         ringQ.add(0.0);
      }
   }
   
   public GuitarString(double[] init){
      if (init.length < 2){
         throw new IllegalArgumentException();
      }
      
      ringQ = new LinkedList<>();
      
      for (int i = 0; i < init.length; i++){
         ringQ.add(init[i]);
      }
   }
   
   public void pluck(){
      Random rand = new Random();
      int size = ringQ.size();
      for(int i = 0; i < size; i++){
         double randomVal = (rand.nextDouble() - 0.5);
         ringQ.add(randomVal);
         ringQ.remove();
      }
   }
   
   public void tic(){
      double firstValue = ringQ.remove();
      double secondValue = ringQ.peek();
      double toTheEndOfQ = ((firstValue +secondValue) / 2) * DECAY_FACTOR;
      ringQ.add(toTheEndOfQ);
   }
   
   public double sample(){
      return ringQ.peek();
   }
}