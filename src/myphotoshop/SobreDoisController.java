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
public class SobreDoisController implements Initializable
{

    @FXML
    private Label lbNomeArq;
    @FXML
    private Label lbDimImg;
    @FXML
    private Label lbTamArq;

    private double cx, cy;
    private String nomeArq;

    public void setNomeArq(String nomeArq)
    {
        this.nomeArq = nomeArq;
    }

    public void setLargura(int largura)
    {
        this.largura = largura;
    }

    public void setAltura(int altura)
    {
        this.altura = altura;
    }

    public void setTamanho(int tamanho)
    {
        this.tamanho = tamanho;
    }
    private int largura, altura, tamanho;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        if (TelaPrincipalController.arq != null)
        {
            lbNomeArq.setText(lbNomeArq.getText() + " " + nomeArq);
            //lbDimImg.setText(lbDimImg.getText() + " " + TelaPrincipalController.aux.getImage().getWidth()+ "x" + TelaPrincipalController.aux.getImage().getHeight());
            lbTamArq.setText(lbTamArq.getText() + " " + tamanho);
            lbDimImg.setText(lbDimImg.getText() + " " + String.format("%d x %d", largura, altura));
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
