package com.mycompany.aes;

import javafx.scene.control.Alert;

public class MessageDialog {
   public static void messageAuth(){
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.setTitle("Information Message");
       alert.setContentText("Your was Authentificate");
       alert.showAndWait();
   
   } 
   
    public static void messageNoAuth(){
       Alert alert = new Alert(Alert.AlertType.ERROR);
       alert.setTitle("Information Message");
       alert.setContentText("Your dont was Authentificate");
       alert.showAndWait();
   
   } 
    
    public static void messageDelay(){
    Alert alert = new Alert(Alert.AlertType.WARNING);
       alert.setTitle("Information Message");
       alert.setContentText("Message delay exceeded");
       alert.showAndWait();
    
    }
    
    public static void messageAbout(){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("About program");
    alert.setHeaderText("Developer: ");
    alert.setContentText(" Dyaduk Yaroslav");
    alert.showAndWait();
        
    }
    
    public static void messageHelp(){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Help");
    alert.setContentText("                       �������� ������"
            + "\n" +  "1.�������� ������ \"Genarate Secret Key\""
            + "\n" + "2.�������� ���� ����"
            + "\n" + "3.�������� ������ \"Send Data\""
            + "\n" + "4.�������� ������ \"Authentificate\""
            + "\n" + "\n" + "                             ����������"
            + "\n" + "1.�������� ������ \"Genarate Secret Key\""
            + "\n" + "2.�������� ���� ����"
            + "\n" + "3.�������� ������ \"Send Data\""
            + "\n" + "4.�������� ������ \"Set Delay\""
            + "\n" + "5.�������� ������ \"Authentificate\"");
    alert.showAndWait();
    
    }
}
