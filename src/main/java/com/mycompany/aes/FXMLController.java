package com.mycompany.aes;

import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import org.joda.time.DateTime;



public class FXMLController implements Initializable {
    
    private String Name;
    private String LastName;
    private SecretKey Key;
    private int Seconds;
    
    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldSecretKey;

    @FXML
    private TextField fieldLastName;

    @FXML
    private Label lableTime;

    @FXML
    private Button btnGenerateSecretKey;

    @FXML
    private Button btnSendData;

    @FXML
    private Button btnAuth;
    
    @FXML
    private TextField fieldEncName;

    @FXML
    private TextField fieldEncLastName;

    @FXML
    private TextField fieldServerSecretKey;

    @FXML
    private Label lableServerTime;
    
    @FXML
    private RadioButton btnSetDelay;
    
    @FXML
    private TextField fieldDecName;

    @FXML
    private TextField fieldDecLastName;
    
    @FXML
    private MenuItem itemAbout;

    @FXML
    private MenuItem itemHelp;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btnGenerateSecretKey.setOnAction(event->{try {
            GenerateSecretKey();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }});
        
        btnSendData.setOnAction(event->{try {
            ProccesingData();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }});
        
        btnAuth.setOnAction(event->{try {
            Auth();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }});
        
        itemAbout.setOnAction(event->{MessageDialog.messageAbout();});
        itemHelp.setOnAction(event->{MessageDialog.messageHelp();});
     
    } 
    
    private void GenerateSecretKey() throws NoSuchAlgorithmException{
    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
    keyGenerator.init(128);
    Key = keyGenerator.generateKey();
    
    fieldSecretKey.setText(Key.toString());
    
    }
    
    private void ProccesingData() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
    Name = fieldName.getText();
    LastName = fieldLastName.getText();
    Seconds = new DateTime().now().getSecondOfDay();
    
    lableTime.setText(Seconds + "");
        
    new SideA(Name,LastName,Key,Seconds);
    
    SideA.CipherName();
    SideA.CipherLastName();
    SideA.SendDataSideB();
    
    fieldEncName.setText(SideA.getByteName().toString());
    fieldEncLastName.setText(SideA.getByteLastName().toString());
    fieldServerSecretKey.setText(Key.toString());
    
    }
    
    private void Auth() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
    SideB.DecipherLogin();
    SideB.DecipherPassword();
    SideB.processingTime();
    if(btnSetDelay.isSelected()){SideB.setTimeSideB(Seconds + 25);}
    SideB.Auth();
    
    lableServerTime.setText(SideB.getTimeSideB() + "");
    fieldDecName.setText(SideB.getNameDecrypt());
    fieldDecLastName.setText(SideB.getLastNameDecrypt());
    
    
    
    }
}
