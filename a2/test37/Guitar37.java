// Guitar37 class, this class implements Guitar


public class Guitar37 implements Guitar {
   public static final String KEYBOARD =
      "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";  // keyboard layout
   private GuitarString[] keys;
   private int countOfTics;
   
   public Guitar37(){
      countOfTics = 0;
      keys = new GuitarString[KEYBOARD.length()];
      for (int i = 0; i < KEYBOARD.length(); i++){
         keys[i] = new GuitarString(440.0 * Math.pow(2.0,((i-24.0)/12.0)));
      }
   }
   public void playNote(int pitch){
      if (pitch + 24 >= 0 && pitch + 24 < 37){
         keys[pitch + 24].pluck();
      }
   }
   
   public boolean hasString(char key){
      return KEYBOARD.indexOf(key) != -1;
   }
   
   public void pluck(char key){
      if(!hasString(key)){
         throw new IllegalArgumentException();
      }
      
      keys[KEYBOARD.indexOf(key)].pluck();
   }
   
   public double sample(){
      double sum = 0.0;
      for (int i = 0; i < KEYBOARD.length(); i++){
         sum += keys[i].sample();
      }
      return sum;
   }
   
   public void tic(){
      for (int i = 0; i < KEYBOARD.length(); i++){
         keys[i].tic();
      }
      countOfTics++;
   }
   
   public int time(){
      return countOfTics;
   }

}