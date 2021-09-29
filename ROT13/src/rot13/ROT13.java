
package rot13;


public class ROT13 {

      public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";   //from a to z we have indexes (0 to 25) like a=0,b=1....z=25
       
      public static String encrypt(String plainText){
          
        
          
          plainText=plainText.toLowerCase();        
          String encrypt="";
          int charPosition=0;
          
          for(int i=0;i<plainText.length();i++){
              
              if (plainText.charAt(i) == ' ') {

                  encrypt = encrypt + " ";
              }
              
               if(!Character.isAlphabetic(plainText.charAt(i))){ //ignore everything except a to z letters
                 
                  continue;
               }
              
              charPosition=(ALPHABET.indexOf(plainText.charAt(i))+13 ) % 26;           //E=(Pi+K)% 26
              encrypt=encrypt+ALPHABET.charAt(charPosition);
              
          }
          
          return encrypt;
      }
      
        public static String decrypt(String cipherText){
          
          cipherText=cipherText.toLowerCase();        
          String decrypt="";
          int charPosition=0;
          
          for(int i=0;i<cipherText.length();i++){
              
               if(cipherText.charAt(i)==' '){
                  
                  decrypt=decrypt+" ";
              }
              
              if(!Character.isAlphabetic(cipherText.charAt(i))){
                  continue;
              }
              
              charPosition=(ALPHABET.indexOf(cipherText.charAt(i)) - 13 ) % 26;           //D=(Ci-K)% 26
              
                 
              if(charPosition<0){   //for negative remainder value
               
                  charPosition=26+charPosition;                            //actually we have to minus the value with m like (m-r) but if we put -
                                                                           // then m-(-r) becomes m+r thats why we took m+r
              }
           
              decrypt=decrypt+ALPHABET.charAt(charPosition);
              
          }
          
          return decrypt;
      }
      
    
    public static void main(String[] args) {
        
     
        String enc=encrypt("Wellcome back to university, it's being long ago to teach in the classroom.");
        System.out.println("Encrypted Text: "+enc);
        
      
        String dec=decrypt("unirsha");
        System.out.println("Decrypted Text: "+dec);
        
        
    }
    
}
