/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifsc.sistemainternacional;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class Principal {
    public static void main(String[] args) {
        
        String idioma;
        String pais;
//        java -jar pacote.jar pr[0] BR pt[1]

        //verifica se não foi passado nenhum argumento por parametro
        if(args.length != 2){
            idioma = "en";
            pais = "US";
        } else { 
            idioma = args[0]; //pt ou en
            pais = args[1]; //BR ou US
        }
        
        Locale localCorrente;
        ResourceBundle traducoes = null;
        
        //localCorrente = new Locale(idioma, pais);
        //um recurso que vai ter ler arquivos de idiomas com objetos locale
        //MessagesBundle_pt_BR.properties
        //MessagesBundle_en_US.properties
        //src/main/resource/Messages...
        //traducoes = ResourceBundle.getBundle("MessagesBundle", localCorrente);
        
        //System.out.println(traducoes.getString("cad_cliente_nome"));
        
        //PRODUÇÃO - idioma para o executável .jar
        InputStream newInputStream;
        String nomeArquivo = "./idiomas/MessagesBundle_"+idioma+"_"+pais+".properties";
        try {
            newInputStream = Files.newInputStream(Paths.get(nomeArquivo));
            traducoes = new PropertyResourceBundle(newInputStream);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(traducoes.getString("cad_cliente_nome"));
                
        
    }
}
