package com.codebind;

import com.company.libUtp;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private JTextField tokenField;
    private JTextField portField;
    private JLabel amountLabel;
    private JLabel balanceLabel;
    private JButton updateButton;
    private JPanel panelMain;
    private JLabel pkLabel;
    private JTextField pkField;
    private JTextField muchField;
    private JButton sendButton;
    private JTextField TOKENMASSAGETextField;
    private JButton SENDButton;
    private JTextField ENTERQUANTITYTextField;
    private JTextField TOKENTRANSFERTextField;
    private JTextField CARDIDTextField;
    private JPanel picL;


    public App() {
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                libUtp kek = new libUtp();

                String PORTIO = portField.getText();
                String TOKENIO = tokenField.getText();

                // kek.port = "20000";
                // kek.token = "2928E4C1435847EAC35E186D640A04A4";

                kek.port = PORTIO;
                kek.token = TOKENIO;

                String RESOLT = null;

                //last contact PK
                JSONObject PKeyJO = null; //full json string
                try {
                    PKeyJO = new JSONObject(kek.getOwnContact());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }


                System.out.println(PKeyJO); //CHECK FULL

                JSONObject PKeyOut; // result string

                PKeyOut = PKeyJO.getJSONObject("result");

                System.out.println(PKeyOut); // chek result

                // :)))

                //SONObject PKFinal = new JSONObject(PKeyOut);

                String PKey = PKeyOut.getString("pk");

                System.out.println(PKey);

                pkLabel.setText(PKey);

                //balance

                JSONObject BJO = null;
                try {
                    BJO = new JSONObject(kek.getBalance());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.out.println(BJO);

                String balancio = BJO.get("result").toString();

                System.out.println(balancio);

                amountLabel.setText(balancio);








            }
        });


        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                libUtp kek = new libUtp();



                String PORTIO = portField.getText();
                String TOKENIO = tokenField.getText();

                String toPK = TOKENMASSAGETextField.getText();
                String toAm= pkField.getText();



                //  kek.port = "20000";
                //  kek.token = "0E71EEDD23090DD7399878D048F201F5";

                kek.port = PORTIO;
                kek.token = TOKENIO;

                String RESOLT = null;

                try {
                    kek.sendInstantMessage(toPK,toAm);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }


                JSONObject BJO = null;
                try {
                    BJO = new JSONObject(kek.getBalance());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.out.println(BJO);

                String balancio = BJO.get("result").toString();

                System.out.println(balancio);

                amountLabel.setText(balancio);



            }
        });
        SENDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                libUtp kek = new libUtp();



                String PORTIO = portField.getText();
                String TOKENIO = tokenField.getText();

                String toPK = TOKENTRANSFERTextField.getText();
                String toAm= ENTERQUANTITYTextField.getText();
                String  imCARDIDTextField = CARDIDTextField.getText();


                //  kek.port = "20000";
                //  kek.token = "0E71EEDD23090DD7399878D048F201F5";

                kek.port = PORTIO;
                kek.token = TOKENIO;

                String RESOLT = null;

                try {
                    kek.sendPayment(imCARDIDTextField,toPK, toAm,  "1");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }


                JSONObject BJO = null;
                try {
                    BJO = new JSONObject(kek.getBalance());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.out.println(BJO);

                String balancio = BJO.get("result").toString();

                System.out.println(balancio);

                amountLabel.setText(balancio);

            }
        });
    }

    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();


        frame.setSize(1080,240);
        frame.setVisible(true);




    }


    private void createUIComponents() {
        // TODO: place custom component creation code here

    }







}
