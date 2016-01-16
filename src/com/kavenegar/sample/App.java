/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kavenegar.sample;

import com.kavenegar.ArrayOfLong;
import com.kavenegar.ArrayOfString;
import javax.xml.ws.Holder;

/**
 *
 * @author Mohsen
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SendSMS();
    }

    public static void SendSMS() {
        try {
            String apikey = "YourApiKey";
            String sender = "10006707323323";
            String message = "hello soap";
            ArrayOfString receptor = new ArrayOfString();
            receptor.getString().add("YourCellNumber");
            long unixdate = 0;
            int msgmode = 1;
            com.kavenegar.V1 service = new com.kavenegar.V1();
            com.kavenegar.V1Soap port = service.getV1Soap();
            // TODO initialize WS operation arguments here
            Holder<Integer> status = new Holder<>();
            Holder<String> statusmessage = new Holder<>();
            Holder<ArrayOfLong> sendSimpleByApikeyResult = new Holder<>();
            port.sendSimpleByApikey(apikey, sender, message, receptor, unixdate, msgmode, status, statusmessage, sendSimpleByApikeyResult);
            System.err.println(statusmessage.value);
            System.err.println(status.value);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
