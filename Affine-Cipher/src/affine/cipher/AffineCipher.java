
package affine.cipher;

public class AffineCipher {
    
    
    
   public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";   //from a to z we have indexes (0 to 25) like a=0,b=1....z=25
 
 
    static String encryptMessage(String plainText,int a,int b)
    {
       
          plainText=plainText.toLowerCase();        
          String encrypt="";
          int P=0;
          int C=0;
          
         for(int i=0;i<plainText.length();i++){
             
             if(plainText.charAt(i)==' '){
                encrypt=encrypt+" ";
             }
              
             if(!Character.isAlphabetic(plainText.charAt(i))){ //ignore everything except a to z letters
                   continue;
              }
              
             P=(ALPHABET.indexOf(plainText.charAt(i)));           
             C= (P*a+b)% 26;                                                //C=Pa+b % 26
             encrypt=encrypt+ALPHABET.charAt(C);
              
          }
          
          return encrypt;
    }
 
    static String decryptCipher(String cipher,int a,int b)
    {
        cipher=cipher.toLowerCase();
        String msg = "";
        int a_inv = 0;
        int flag = 0;
        int P=0;
 
        //Find a^-1 (the multiplicative inverse of a
        //in the group of integers modulo m.)
        for (int i = 0; i < 26; i++)
        {
            flag = (a * i) % 26;
 
            // Check if (a*i)%26 == 1,
            // then i will be the multiplicative inverse of a
            if (flag == 1)
            {
                a_inv = i;
            }
        }
        for (int i = 0; i < cipher.length(); i++)
        {
          
            if (cipher.charAt(i) == ' ')
            {
                msg=msg+" ";
            }
            if(!Character.isAlphabetic(cipher.charAt(i))){ //ignore everything except a to z letters
                   continue;
              }
            
            P=a_inv*(ALPHABET.indexOf(cipher.charAt(i)) - b )%26;           //P=a_inv(c-b)%26
            
            if(P<0){                                                 //for negative remainder value
               
                  P=26+P;                                          
              }
            
            msg=msg+ALPHABET.charAt(P);
            
           
        }
 
        return msg;
    }

    static void showAllkeys(String cipher){
        String msgKeys="";
        for(int i=1;i<27;i++){            //keys not known  (apply outer and inner loop in which all possible combination of system occurs) 
                                          //keys will be identify where we see some meaningful sentence 
            
         for(int j=1;j<27;j++){
             
              msgKeys=decryptCipher(cipher,i,j);
              System.out.println("Keys=>"+"("+i+","+j+")"+"\nMesssage="+msgKeys);
         }
         
        }
        
    }
   
    public static void main(String[] args) {
        
        String enc=encryptMessage("congratulationsonsecuringfivemarks",23,14);
        System.out.println("Encrypted Text: "+enc);
        String dec=decryptCipher("Iybwpojghojqybmybmcigpqbwzqdceopkm",23,14);
        System.out.println("Decrypted Text: "+dec);
        
        showAllkeys("zbx gcb dbzx rob eleb res xbybegbbe");
        
    }
    
}
