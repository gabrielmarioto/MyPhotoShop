/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myphotoshop;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author GABRIEL
 */
public class SobreController implements Initializable
{

    @FXML
    private Label lbNomeArq;
    @FXML
    private Label lbDimImg;
    @FXML
    private Label lbTamArq;

    private double cx,cy;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        if (TelaPrincipalController.arq != null)
        {
            lbNomeArq.setText(lbNomeArq.getText() + " " + TelaPrincipalController.arq.getName());
            //lbDimImg.setText(lbDimImg.getText() + " " + TelaPrincipalController.aux.getImage().getWidth()+ "x" + TelaPrincipalController.aux.getImage().getHeight());
            lbTamArq.setText(lbTamArq.getText() + " " + TelaPrincipalController.arq.length());
            lbDimImg.setText(lbDimImg.getText() + " "
                    + String.format("%.0f x %.0f", TelaPrincipalController.aux.getImage().getWidth(),
                            TelaPrincipalController.aux.getImage().getHeight()));
        }

    }

    @FXML
    private void evt_Fechar(ActionEvent event)
    {
        ((Button) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void evt_Dragged(MouseEvent event)
    {
        Stage stage = ((Stage) ((Node) event.getSource()).getScene().getWindow());
        stage.setX(event.getScreenX() + cx);
        stage.setY(event.getScreenY() + cy);

    }

    @FXML
    private void evt_Pressed(MouseEvent event)
    {
        Stage stage = ((Stage) ((Node) event.getSource()).getScene().getWindow());
        cx = stage.getX() - event.getScreenX();
        cy = stage.getY() - event.getScreenY();
    }

}
