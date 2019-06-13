package com.mycompany.aes;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import org.joda.time.DateTime;

public class SideB {
   private static String Name;
   private static String LastName;
   private static int Seconds;
   private static SecretKey Key;
   private static String nameDecrypt = "";
   private static String lastNameDecrypt = "";
   private static int timeSideB;
   private static int timeRange;
   
   private static byte[] byteName;
   private static byte[] byteLastName;
   
   public static int getTimeSideB() {
        return timeSideB;
    }
   public static void setTimeSideB(int timeSideB) {
        SideB.timeSideB = timeSideB;
    }
   public static String getNameDecrypt() {
        return nameDecrypt;
    }
   public static String getLastNameDecrypt() {
        return lastNameDecrypt;
    }
   
    public SideB(String Name, String LastName, int Seconds, SecretKey Key, byte[] byteName, byte[] byteLastName) {
        this.Name = Name;
        this.LastName = LastName;
        this.Seconds = Seconds;
        this.Key = Key;
        this.byteName = byteName;
        this.byteLastName = byteLastName;
    }
    
    protected static void DecipherLogin() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.DECRYPT_MODE, Key);
    cipher.update(byteName);
    byte[] byteDecrypt = cipher.doFinal();
      nameDecrypt = "";
        for(byte b : byteDecrypt){
        
            nameDecrypt += (char) b;
        
        }
      
    }
    
    protected static void DecipherPassword() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.DECRYPT_MODE, Key);
    cipher.update(byteLastName);
    byte[] byteDecrypt = cipher.doFinal();
      lastNameDecrypt = "";
        for(byte b : byteDecrypt){
            lastNameDecrypt += (char) b;
        
        }
               
    }
    
    protected static void Auth(){
    if(timeSideB <= timeRange){
        if(Name.equals(nameDecrypt) && LastName.equals(lastNameDecrypt)){MessageDialog.messageAuth();}else{MessageDialog.messageNoAuth();}  
        }else{MessageDialog.messageDelay();}
      
    }
    
    protected static void processingTime(){
        timeSideB = new DateTime().now().getSecondOfDay();
        timeRange = Seconds + 20;
    
    }
    
}
