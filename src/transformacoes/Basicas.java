/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformacoes;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

/**
 *
 * @author Gabriel Marioto
 */
public class Basicas
{
    public static Image tonsCinza(Image img)
    {
        BufferedImage bimg;
        bimg = SwingFXUtils.fromFXImage(img, null);
        WritableRaster raster = bimg.getRaster();
        int[] pixel ={0,0,0,0};
        int cinza;
        for (int i = 0; i < img.getHeight(); i++) // MATRIZ DE LINHAS
        {
            for (int j = 0; j < img.getWidth(); j++) // MATRIZ DE COLUNAS
            {
                raster.getPixel(j, i, pixel);
                cinza = (int)(pixel[0]*0.3+pixel[1]*0.59+pixel[2]*0.11); // FORMA ERRADA
                
                pixel[0]=pixel[1]=pixel[2]=cinza;
                raster.setPixel(j, i, pixel);
            }
        }
        return SwingFXUtils.toFXImage(bimg, null);
    }
    public static Image suavizacao(Image img, int dim)
    {
        //f(x,y) é a imagem origem
        //g(x,y) é a imagem destino
        img = tonsCinza(img); // CONVERSÃO PARA CINZA
        BufferedImage imagemO,imagemD;
        imagemO = SwingFXUtils.fromFXImage(img, null);
        imagemD = new BufferedImage(imagemO.getWidth(),imagemO.getHeight(),imagemO.getType());
        WritableRaster raster = imagemO.getRaster();
        WritableRaster rasterDest = imagemD.getRaster();
        int[] pixel = {0,0,0,0}; // R,G,B,(ALFA);
        int cinza;
        int m = dim/2;
        for (int i = m; i < img.getHeight()-m; i++)
        {
            for (int j = m; j < img.getWidth()-m; j++)
            {
                cinza = 0;
                for (int y = 0; y < dim; y++) // 5X5 
                {
                    for (int x = 0; x < dim; x++) // 5X5
                    {
                        raster.getPixel(j+x-m, i+y-m, pixel);
                        cinza += pixel[0]; 
                    }
                }
                pixel[0]=pixel[1]=pixel[2] = cinza/(dim*dim); // FAZER A MÉDIA                                              
                rasterDest.setPixel(j, i, pixel);
            }
        }
        return SwingFXUtils.toFXImage(imagemD, null);
    }
    public static Image prewitt(Image img)
    {
        img = suavizacao(img,3); // CONVERSÃO PARA CINZA
        BufferedImage imagemO,imagemD;
        imagemO = SwingFXUtils.fromFXImage(img, null);
        imagemD = new BufferedImage(imagemO.getWidth(),imagemO.getHeight(),imagemO.getType());
        WritableRaster raster = imagemO.getRaster();
        WritableRaster rasterDest = imagemD.getRaster();
        int[] pixel = {0,0,0,0}; // R,G,B,(ALFA);
        int z1,z2,z3,z4,z6,z7,z8,z9;
        
        //z7 + z8 + z9
        
        for (int i = 1; i < img.getHeight()-1; i++) // LINHA
        {
            for (int j = 1; j < img.getWidth()-1; j++) // COLUNA
            {
                raster.getPixel(j-1, i-1, pixel);z1 = pixel[0];
                raster.getPixel(j, i-1, pixel);z2 = pixel[0];
                raster.getPixel(j+1, i-1, pixel);z3 = pixel[0];
                raster.getPixel(j-1, i, pixel);z4 = pixel[0];
                raster.getPixel(j+1, i, pixel);z6 = pixel[0];
                raster.getPixel(j-1, i+1, pixel);z7 = pixel[0];
                raster.getPixel(j, i+1, pixel);z8 = pixel[0];
                raster.getPixel(j+1, i+1, pixel);z9 = pixel[0];
                
                pixel[0] = pixel[1] = pixel[2] = (int)
                Math.sqrt( Math.pow( (z7+z8+z9) - (z1+z2+z3),2) +
                           Math.pow( (z3+z6+z9) - (z1+z4+z7),2));
                
                rasterDest.setPixel(j, i, pixel);
            }
        }
        return SwingFXUtils.toFXImage(imagemD, null);
        
        
    }
    public static Image kVizinhos(Image img,int k) // FAZER OS KVIZINHOS
    {
        
        return img;
    }
    
    public static Image sobel(Image img)
    {
        img = suavizacao(img,3); // CONVERSÃO PARA CINZA
        BufferedImage imagemO,imagemD;
        imagemO = SwingFXUtils.fromFXImage(img, null);
        imagemD = new BufferedImage(imagemO.getWidth(),imagemO.getHeight(),imagemO.getType());
        WritableRaster raster = imagemO.getRaster();
        WritableRaster rasterDest = imagemD.getRaster();
        int[] pixel = {0,0,0,0}; // R,G,B,(ALFA);
        int z1,z2,z3,z4,z6,z7,z8,z9;
        
        //z7 + 2.z8 + z9 - z1 +2.z2 +z3 ^2 +z3 +2.z6 + z9 - (z1+2.z4 + z7) ^2
        
        for (int i = 1; i < img.getHeight()-1; i++) // LINHA
        {
            for (int j = 1; j < img.getWidth()-1; j++) // COLUNA
            {
                raster.getPixel(j-1, i-1, pixel);z1 = pixel[0];
                raster.getPixel(j, i-1, pixel);z2 = pixel[0];
                raster.getPixel(j+1, i-1, pixel);z3 = pixel[0];
                raster.getPixel(j-1, i, pixel);z4 = pixel[0];
                raster.getPixel(j+1, i, pixel);z6 = pixel[0];
                raster.getPixel(j-1, i+1, pixel);z7 = pixel[0];
                raster.getPixel(j, i+1, pixel);z8 = pixel[0];
                raster.getPixel(j+1, i+1, pixel);z9 = pixel[0];
                
                pixel[0] = pixel[1] = pixel[2] = (int)
                Math.sqrt( Math.pow( (z7+2*z8+z9) - (z1+2*z2+z3),2) +
                           Math.pow( (z3+2*z6+z9) - (z1+2*z4+z7),2));
                
                rasterDest.setPixel(j, i, pixel);
            }
        }
        return SwingFXUtils.toFXImage(imagemD, null);
        
    }
}
