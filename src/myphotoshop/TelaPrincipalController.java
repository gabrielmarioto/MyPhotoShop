/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myphotoshop;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Gabriel Marioto
 */
public class TelaPrincipalController implements Initializable
{    
    @FXML
    private ImageView imgview;
    private Image img; 
    private File arq = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void evt_Abrir(ActionEvent event)
    {
        FileChooser fc = new FileChooser();
        //COLOCAR FILTROS PARA IMAGEM JPG, GIF, PNG e JPEG
        FileChooser.ExtensionFilter extensao = new FileChooser.ExtensionFilter("Todas as Imagens ","*.jpg","*.jpeg","*.gif","*.png");      
        fc.getExtensionFilters().add(extensao);
        arq = fc.showOpenDialog(null); // ABRIR UM ARQUIVO/IMAGEM 
        
        if(arq != null)
        {
          img = new Image(arq.toURI().toString()); 
          imgview.setImage(img);
          imgview.setFitWidth(img.getWidth());
          imgview.setFitHeight(img.getHeight());
          ((Stage)(imgview.getScene().getWindow())).setTitle(arq.getName()+" - Photoshop FX");
        }
    }

    @FXML
    private void evt_Salvar(ActionEvent event)
    {
    }

    @FXML
    private void evt_SalvarComo(ActionEvent event)
    {
    }

    @FXML
    private void evt_Fechar(ActionEvent event)
    {
    }

    @FXML
    private void evt_Cinza(ActionEvent event)
    {
    }

    @FXML
    private void evt_Media(ActionEvent event)
    {
    }

    @FXML
    private void evt_Prewitt(ActionEvent event)
    {
    }

    @FXML
    private void evt_Sobre(ActionEvent event)
    {
    }
    
}
