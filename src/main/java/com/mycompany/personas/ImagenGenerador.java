/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personas;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import sun.misc.BASE64Encoder;

/**
 * Clase que maneja las fotos, asegurando que tengan el mismo tamaño, y maneja 
 * la codificación a base64.
 * @author Franco Morbidoni
 */
public class ImagenGenerador {
    
    /**
     * Método que convierte la imagen obtenida, a un tamaño comun entre todos los
     * registros de personas.
     * 
     * @param originalImage Imagen original.
     * @param scaledWidth Ancho a ajustar la imagen.  
     * @param scaledHeight Alto a ajustar la imagen.
     * @param preserveAlpha Determina la consevacion de la composición alfa
     * @return BufferedImage correspondiente a la nueva imagen.
     */
    public BufferedImage createResizedCopy(Image originalImage, int scaledWidth, int scaledHeight, boolean preserveAlpha) {
        int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
        Graphics2D g = scaledBI.createGraphics();
        if (preserveAlpha) {
            g.setComposite(AlphaComposite.Src);
        }
        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
        g.dispose();
        return scaledBI;
    }
    
    /**
     * Método que convierte la imagen obtenida a un string en base 64 para su
     * almacenamiento en la base de datos.
     * 
     * @param image Imagen obtenida por el sistema.
     * @param type Tipo de archivo original.
     * @return String correspondiente al codigo base64 de la imagen.
     */
    public static String encodeToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();

            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);

            bos.close();
        } catch (IOException e) {
            imageString="Foto no encontrada.";
        }
        return imageString;
    }
}
