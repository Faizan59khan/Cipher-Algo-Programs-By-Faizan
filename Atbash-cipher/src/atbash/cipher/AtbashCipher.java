
package atbash.cipher;


public class AtbashCipher {
    
      public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";   //from a to z we have indexes (0 to 25) like a=0,b=1....z=25
      public static final String REVERSE = "zyxwvutsrqponmlkjihgfedcba";  

       public static String decrypt(String cipherText){
           
          
          cipherText=cipherText.toLowerCase();        
          String decrypt="";
          int charPosition=0;
          
          for(int i=0;i<cipherText.length();i++){
              
            
              if (cipherText.charAt(i) == ' ') {
                  decrypt = decrypt + " ";
              }
            
             if(!Character.isAlphabetic(cipherText.charAt(i))){
                  continue;
              }
              
            charPosition=ALPHABET.indexOf(cipherText.charAt(i));   
            decrypt=decrypt+REVERSE.charAt(charPosition);
            
          }
         
          
          return decrypt;
      }
  
    public static void main(String[] args) {
        
        String dec=decrypt("ivevihv xrksvi gvxsmrjf");
        System.out.println("Decrypted Text: "+dec);
       
    }
    
}
