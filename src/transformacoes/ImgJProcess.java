/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformacoes;

import ij.ImagePlus;
import ij.process.ImageProcessor;
import java.awt.image.BufferedImage;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

/**
 *
 * @author Gabriel Marioto
 */
public class ImgJProcess
{
    public static Image erosao(Image img)
    {
        BufferedImage bimg;
        bimg = SwingFXUtils.fromFXImage(img, null);       
        ImagePlus imgPlus = new ImagePlus();
        
        imgPlus.setImage(bimg);
        ImageProcessor imP = imgPlus.getProcessor(); // Pegar IMG e jogar no processador de imagem
        
        imP.erode();        
        return SwingFXUtils.toFXImage(imP.getBufferedImage(), null);
    }
    
    public static Image dilatacao(Image img)
    {
        BufferedImage bimg;
        bimg = SwingFXUtils.fromFXImage(img, null);       
        ImagePlus imgPlus = new ImagePlus();
        
        imgPlus.setImage(bimg);
        ImageProcessor imP = imgPlus.getProcessor(); // Pegar IMG e jogar no processador de imagem
        
        imP.dilate();
        return SwingFXUtils.toFXImage(imP.getBufferedImage(), null);
    }
    
    public static Image detBorda(Image img)
    {
        BufferedImage bimg;
        bimg = SwingFXUtils.fromFXImage(img, null);       
        ImagePlus imgPlus = new ImagePlus();
        
        imgPlus.setImage(bimg);
        ImageProcessor imP = imgPlus.getProcessor(); // Pegar IMG e jogar no processador de imagem
        
        imP.findEdges();
        return SwingFXUtils.toFXImage(imP.getBufferedImage(), null);
    }
}
