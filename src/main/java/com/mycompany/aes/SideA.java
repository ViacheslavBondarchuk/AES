package com.mycompany.aes;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class SideA {
    private static String Name;
    private static String LastName;
    private static SecretKey Key;
    private static int Seconds;
    
    private static byte[] byteName;
    private static byte[] byteLastName;
    
    public static byte[] getByteName() {
        return byteName;
    }
    public static byte[] getByteLastName() {
        return byteLastName;
    }

    public SideA(String Name, String LastName, SecretKey Key, int Seconds) {
        this.Name = Name;
        this.LastName = LastName;
        this.Key = Key;
        this.Seconds = Seconds;
    }
    
    protected static void CipherName() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.ENCRYPT_MODE, Key);
    cipher.update(Name.getBytes());
    byteName = cipher.doFinal();
    
    }
    
    protected static void CipherLastName() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.ENCRYPT_MODE, Key);
    cipher.update(LastName.getBytes());
    byteLastName = cipher.doFinal();
    
    }
    
    protected static void SendDataSideB(){
    
        new SideB(Name,LastName,Seconds,Key,byteName,byteLastName);
    
    }
    
}
