/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo_flyer;

import br.com.jmary.utilidades.Arquivo_Ou_Pasta;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.StringTokenizer;

/**
 *
 * @author JMarySystems
 */
public class Turbo_Flyer_Auto_Enviar_Offline {
    
    String s = System.getProperty("file.separator");
    String internalStorageDir = System.getProperty("user.dir");
    
    public Turbo_Flyer_Auto_Enviar_Offline(
            String msg_a_enviar3, 
            String nome_criar_pasta_mensagem,
            String de_email_remetente2, 
            String para_email_destinatario2) {
        
        String msg_a_enviar2 = "";
        try{
            byte array[] = msg_a_enviar3.getBytes( "UTF-8" );
            //byte array[] = msg_a_enviar3.getBytes( "ISO-8859-1" );
            //String novaString = new String( array, "ISO-8859-1" );
            String novaString = new String( array, "UTF-8" );
            
            msg_a_enviar2 = novaString;
        } catch( Exception e ){
            
            msg_a_enviar2 = msg_a_enviar3;
        }
        
        //Quebra de linha para - __@jm@quebra_linha@jm@__
        StringBuilder sb_turbo_android = new StringBuilder();
        String separador0 = System.getProperty("line.separator");
        StringTokenizer st1 = new StringTokenizer(msg_a_enviar2, separador0 );
        //System.out.println( "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx " + separador0);
        for (int i = 0; st1.hasMoreTokens(); i++) {

            String rowstring = ""; try{ rowstring = st1.nextToken(); }catch( Exception e ){}
            //System.out.println( "rowstring - " + rowstring );
            if( !rowstring.trim().equals("") ){

                sb_turbo_android.append( rowstring.trim() + "__@jm@quebra_linha@jm@__");
            }
        }
        String mensagemComQuebraJM = sb_turbo_android.toString().trim();
        
////////////////////////////////////////////////////////////////////////////////
        StringBuilder sb_turbo_codePointAt = new StringBuilder();
        //String para codePointAt
        String str = mensagemComQuebraJM;
        CharSequence charPair_Array = str;
        for (int i = 0; i < charPair_Array.length(); i++) {

            int codePointAt = Character.codePointAt(charPair_Array, i);
            sb_turbo_codePointAt.append( codePointAt + "_" );

            /////////////////////////////////////////////////////////////////////////
            // converting to char[] pair
            char[] charPair = Character.toChars(codePointAt);
            // and to String, containing the character we want
            String symbol = new String(charPair);
            /////////////////////////////////////////////////////////////////////////

            System.out.println( "\n\n public Turbo_Flyer_Auto_Enviar_Offline - Início - Turbo_Flyer_Auto_Enviar_Offline ***************************************************");
            System.out.println( " msg_a_enviar2 - " + msg_a_enviar2 );
            System.out.println( " String Completa - " + str );
            System.out.println( " int ( i ) - " + i );
            System.out.println( " codePointAt - " + codePointAt );
            System.out.println( " Symbol - " + symbol );
            System.out.println( " public Turbo_Flyer_Auto_Enviar_Offline - Fim - Turbo_Flyer_Auto_Enviar_Offline ***************************************************\n\n");
        }
        String mensagem_codePointAt = sb_turbo_codePointAt.toString().trim();
////////////////////////////////////////////////////////////////////////////////     
                
        OO13_Enviar_Mensagens_Auto2(
             "__@jm@inicio@jm@__" + mensagem_codePointAt + "__@jm@inicio@jm@__",
             nome_criar_pasta_mensagem,
             de_email_remetente2,
             para_email_destinatario2);
    }
    
    private void OO13_Enviar_Mensagens_Auto2(
            String msg_a_enviar2, 
            String nome_criar_pasta_mensagem,
            String de_email_remetente2, 
            String para_email_destinatario2) {
        
        System.out.println("\n** OO13_Enviar_Mensagens_Auto2 *****************************************************************");
        System.out.println("Email Usuário Logado - " + de_email_remetente2);
        System.out.println("** OO13_Enviar_Mensagens_Auto2 *****************************************************************\n");   
        
        String jsonDeResposta = null;
        try{
            
            String id_0_formulario = "1FAIpQLSe26aTcu7OC_OnfIiBk9bkoSsI_cps6EDoI71kX64fZNrW6Hw";
                String id_1_formulario_email_de = "1897386233";
                String id_2_formulario_email_para = "1845166634";
                String id_3_sub_item_formulario_mensagem = "283884279";

                String email_remetente3 = de_email_remetente2;
                String email_destinatario3 = para_email_destinatario2;
                //String sub_item_formulario_mensagem = URLEncoder.encode(msg_a_enviar2, "utf-8");
                String sub_item_formulario_mensagem = msg_a_enviar2;
                //String sub_item_formulario_mensagem = java.net.URLEncoder.encode(msg_a_enviar2, "UTF-8");

                String GET_URL = "https://docs.google.com/forms/d/e/" + id_0_formulario + "/formResponse?"
                        + "entry." + id_1_formulario_email_de + "=" + email_remetente3
                        + "&entry." + id_2_formulario_email_para + "=" + email_destinatario3
                        + "&entry." + id_3_sub_item_formulario_mensagem + "=" + sub_item_formulario_mensagem;

                URL url = new URL(GET_URL);
                URLConnection conn = url.openConnection();

                InputStream is = url.openStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                
                StringBuilder sb = new StringBuilder();

                String linha = br.readLine();

                while (linha != null) {
                    //System.out.println(linha);
                    sb.append(linha);
                    linha = br.readLine();
                }

                jsonDeResposta = sb.toString();
                try{

                    System.out.println("\n*******************************************************************");
                    System.out.println("jsonDeResposta - " + jsonDeResposta);
                    System.out.println("*******************************************************************\n");
                } catch( Exception e ){}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {}
        
        try{

            salvar_arquivo_baixado(
                    nome_criar_pasta_mensagem, 
                    jsonDeResposta, 
                    msg_a_enviar2,
                    de_email_remetente2,
                    para_email_destinatario2); 
            
        } catch( Exception e ){}
    }
    
    public void salvar_arquivo_baixado(
            String nome_criar_pasta_mensagem, 
            String jsonDeResposta, 
            String msg_a_enviar2,
            String email_remetente,
            String email_destinatario) { /*new Thread() {   @Override public void run() {*/ try { 
        
        try{

            String data = nome_criar_pasta_mensagem.trim().toUpperCase().replace("-", "_");
            String minuto = data.trim().toUpperCase().replace(":", "_");
            String nada = minuto.trim().toUpperCase().replace(" ", "_");
            String segundo = nada.trim().toUpperCase().replace(".", "_");

            String nome_email_destinatario = email_destinatario.trim().toUpperCase().replace("@", "_");
            String email_DESTINATARIO = nome_email_destinatario.trim().toUpperCase().replace(".", "_");
            String arquivo_properties2 = email_remetente.trim().toUpperCase().replace("@", "_");
            String email_REMETENTE = arquivo_properties2.trim().toUpperCase().replace(".", "_");
            String remetente_e_destinatario = email_REMETENTE + "-" + email_DESTINATARIO + "-";
            String destinatario_e_remetente = email_DESTINATARIO + "-" + email_REMETENTE + "-";

            Arquivo_Ou_Pasta.criarPasta( internalStorageDir, "00_Externo");
            Arquivo_Ou_Pasta.criarPasta( internalStorageDir + s + "00_Externo", "MENSAGENS_RECEBIDAS");
            Arquivo_Ou_Pasta.criarPasta( internalStorageDir + s + "00_Externo" + s + "MENSAGENS_RECEBIDAS", email_REMETENTE);
            Arquivo_Ou_Pasta.criarPasta( internalStorageDir + s + "00_Externo" + s + "MENSAGENS_RECEBIDAS" + s + email_REMETENTE, email_DESTINATARIO);
            Arquivo_Ou_Pasta.criarPasta( internalStorageDir + s + "00_Externo" + s + "MENSAGENS_RECEBIDAS" + s + email_REMETENTE + s + email_DESTINATARIO, segundo);
                                        
            if( jsonDeResposta != null ){                
                try{
                    
                    Arquivo_Ou_Pasta.criarPasta( internalStorageDir + s + "00_Externo" + s + "MENSAGENS_RECEBIDAS" + s + email_REMETENTE + s + email_DESTINATARIO + s + segundo, "ENVIADO");
                    
                    //Mensagem Enviada
                    String destino = internalStorageDir + s + "00_Externo" + s + "MENSAGENS_RECEBIDAS" + s + email_REMETENTE + s + email_DESTINATARIO + s + segundo + s + "ENVIADO"; 
                    String arquivoASerCriadoXX = destino + s + remetente_e_destinatario + ".html";
                    File file_x = Arquivo_Ou_Pasta.criar_Arquivo_Iso_Boo_Tipo_UTFISO_Ret_F(arquivoASerCriadoXX, msg_a_enviar2, "UTF-8");
                    
                } catch( Exception e ){}                
            }
            else{                
                try{
                    
                    Arquivo_Ou_Pasta.criarPasta( internalStorageDir + s + "00_Externo" + s + "MENSAGENS_RECEBIDAS" + s + email_REMETENTE + s + email_DESTINATARIO + s + segundo, "NAO_ENVIADO");
                    
                    //Mensagem Não Enviada
                    String destino = internalStorageDir + s + "00_Externo" + s + "MENSAGENS_RECEBIDAS" + s + email_REMETENTE + s + email_DESTINATARIO + s + segundo + s + "NAO_ENVIADO"; 
                    String arquivoASerCriadoXX = destino + s + remetente_e_destinatario + ".html";
                    File file_x = Arquivo_Ou_Pasta.criar_Arquivo_Iso_Boo_Tipo_UTFISO_Ret_F(arquivoASerCriadoXX, msg_a_enviar2, "UTF-8");
                    
                } catch( Exception e ){} 
                
                System.out.println("\n**NULL*****************************************************************");
                System.out.println("jsonDeResposta = " + "NULL");
                System.out.println("**NULL*****************************************************************\n");
            } 
        } catch( Exception e ){}
         
    } catch( Exception e ){ } /*} }.start();*/ }

}