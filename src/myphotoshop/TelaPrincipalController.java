/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myphotoshop;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import transformacoes.Basicas;

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
    private void evt_SalvarComo(ActionEvent event) throws IOException
    {
        FileChooser fc = new FileChooser();
        //FileChooser.ExtensionFilter extensao = new FileChooser.ExtensionFilter("Todas as Imagens ","*.jpg","*.jpeg","*.gif","*.png");      
        //fc.getExtensionFilters().add(extensao);
        
        arq = fc.showSaveDialog(null);
        
        if(arq != null)
        {
            if(arq.getAbsolutePath().endsWith("png"))
            {
                ImageIO.write(SwingFXUtils.fromFXImage(imgview.getImage(), null), "png", arq);
            }
            else
            {
              //  ImageIO.write(SwingFXUtils.fromFXImage(imgview.getImage(), null), "jpg", arq);
                 Iterator<ImageWriter> writers = ImageIO.getImageWritersBySuffix("jpg");
                ImageWriter writer = (ImageWriter) writers.next();
                // Cria um conjunto de parâmetros para configuração
                ImageWriteParam param = writer.getDefaultWriteParam();
                // Altera para não usar compressão automática
                param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                // Muda a taxa de compressão para 100% (valor entre 0 e 1)
                param.setCompressionQuality(1);
                // Salva a imagem
                FileImageOutputStream output = new FileImageOutputStream(arq);
                writer.setOutput(output);
                writer.write(null, new IIOImage(SwingFXUtils.fromFXImage(imgview.getImage(),null), null, null), param);
            }
        }
    }

    @FXML
    private void evt_Fechar(ActionEvent event)
    {
    }

    @FXML
    private void evt_Cinza(ActionEvent event)
    {
        imgview.setImage(Basicas.tonsCinza(img));
    }

    @FXML
    private void evt_Media(ActionEvent event)
    {
        imgview.setImage(Basicas.suavizacao(img,11));
    }

    @FXML
    private void evt_Prewitt(ActionEvent event)
    {
        imgview.setImage(Basicas.prewitt(img));
    }

    @FXML
    private void evt_Sobre(ActionEvent event)
    {
        
    }
    
}
