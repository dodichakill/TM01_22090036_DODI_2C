package View;

import Controller.ConnectURI;
import Model.ResponseModel;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class myGUI {
    private JPanel myPanel;
    private JPanel customHeader;
    private JPanel form;
    private JPanel exiting;
    private JButton submitButton;
    private JTextField messageValue;
    private JButton exitButton;
    private JButton minimaze;
    private JTextField statusValue;
    private JTextField commentValue;

    public JPanel getMyPanel() {
        return myPanel;
    }

    public myGUI() {
        customHeader.setBackground(Color.decode("#609966"));
    exitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ConnectURI koneksiku = new ConnectURI();
                    URL myAddress = koneksiku.buildURL("https://harber.mimoapps.xyz/api/getaccess.php");
                    String responese = koneksiku.getResponseFromHttpUrl(myAddress);
                    JSONArray responseJSON = new JSONArray(responese);
                    ArrayList<ResponseModel> listRespons = new ArrayList<>();
                    for(int i =0; i < responseJSON.length(); i++){
                        ResponseModel resModel = new ResponseModel();
                        JSONObject myJSONObject = responseJSON.getJSONObject(i);
                        resModel.setMsg(myJSONObject.getString("message"));
                        resModel.setStatus(myJSONObject.getString("status"));
                        resModel.setComments(myJSONObject.getString("comment"));
                        listRespons.add(resModel);
                    }

                    for(ResponseModel result :listRespons) {
                        messageValue.setText(result.getMsg());
                        statusValue.setText(result.getStatus());
                        commentValue.setText(result.getComments());
                    }

                } catch (Exception err) {
                    System.out.println(err);
                }
            }
        });
    }
    public JButton getMinimaze(){
        return minimaze;
    }
}
