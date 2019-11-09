/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo_flyer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JMarySystems
 */
public class Turbo_Flyer_Auto_Leitura_Offline {
    
    String s = System.getProperty("file.separator");
    String internalStorageDir = System.getProperty("user.dir");
    
    int contadorX = 0;
    boolean primeira_vez = false;
    
    Email_Mensagens_Por_Contato Email_Mensagens_Por_ContatoX;
    String email_remetenteX;
    String email_destinatarioX;
    
    public Turbo_Flyer_Auto_Leitura_Offline(
            Email_Mensagens_Por_Contato Email_Mensagens_Por_ContatoR,
            String email_remetente,
            String email_destinatario,
            int contadorR,
            boolean primeira_vez2) {
        
        Email_Mensagens_Por_ContatoX = Email_Mensagens_Por_ContatoR;
        email_remetenteX = email_remetente;
        email_destinatarioX = email_destinatario;
        contadorX = contadorR;
        primeira_vez = primeira_vez2;
        
        new Thread() {   @Override public void run() { try {
            
            //System.out.println( "\n\nInício - Turbo_Flyer_Auto_Leitura_Offline***************************************************"); 
            
            pegar_Endereco_Da_pasta_Da_Mensagem( Email_Mensagens_Por_ContatoX, email_remetenteX, email_destinatarioX, contadorX );
        } catch( Exception e ){  } } }.start(); 
    }
    
    private void pegar_Endereco_Da_pasta_Da_Mensagem(
            Email_Mensagens_Por_Contato Email_Mensagens_Por_Contato,
            String email_remetente,
            String email_destinatario,
            int contador) { 
        
           contadorX = contador;
        
            //System.out.println( "\n\n pegar_Endereco_Da_pasta_Da_Mensagem - Início Turbo_Flyer_Auto_Leitura_Offline ***************************************************");
            //System.out.println( "email_remetente - " + email_remetente + " - email_destinatario - " + email_destinatario + " - contador - " + contador);
            //System.out.println( "pegar_Endereco_Da_pasta_Da_Mensagem - Fim Turbo_Flyer_Auto_Leitura_Offline ***************************************************\n\n");

            String email_DESTINATARIO = "";
            String email_REMETENTE = "";

            List<String[]> lista_de_mensagens_nao_lidas = new ArrayList<String[]>();
            try {
                String nome_email_destinatario = email_destinatario.trim().toUpperCase().replace("@", "_");
                email_DESTINATARIO = nome_email_destinatario.trim().toUpperCase().replace(".", "_");
                String arquivo_properties2 = email_remetente.trim().toUpperCase().replace("@", "_");
                email_REMETENTE = arquivo_properties2.trim().toUpperCase().replace(".", "_");

                String destino = internalStorageDir +s+"00_Externo"+s+"MENSAGENS_RECEBIDAS"+ s + email_REMETENTE + s + email_DESTINATARIO;
                //System.out.println( "\n\n pegar_Endereco_Da_pasta_Da_Mensagem - Início Turbo_Flyer_Auto_Leitura_Offline ***************************************************");
                //System.out.println( "email_remetente - " + email_remetente );
                //System.out.println( "email_destinatario - " + email_destinatario );
                //System.out.println( "contador - " + contador );
                //System.out.println( "internalStorageDir - " + internalStorageDir );
                //System.out.println( "destino - " + destino );
                //System.out.println( "pegar_Endereco_Da_pasta_Da_Mensagem - Fim Turbo_Flyer_Auto_Leitura_Offline ***************************************************\n\n");

                File diretorio = new File( destino );
                File[] pasta_do_remetente_destinatario = diretorio.listFiles();
                if ( pasta_do_remetente_destinatario != null ) {
                    /*
                    System.out.println( "\n\n pegar_Endereco_Da_pasta_Da_Mensagem - Início Turbo_Flyer_Auto_Leitura_Offline ***************************************************");
                    System.out.println( "email_remetente - " + email_remetente );
                    System.out.println( "email_destinatario - " + email_destinatario );
                    System.out.println( "contador - " + contador );
                    System.out.println( "internalStorageDir - " + internalStorageDir );
                    System.out.println( "destino - " + destino );
                    System.out.println( "if ( lista_data_pasta_da_msg_recebida != null ) {" );
                    System.out.println( "quantidade de arquivos - " + lista_data_pasta_da_msg_recebida.length );
                    System.out.println( "pegar_Endereco_Da_pasta_Da_Mensagem - Fim Turbo_Flyer_Auto_Leitura_Offline ***************************************************\n\n");
                    */
                    //for (int j=0; j < lista_data_pasta_da_msg_recebida.length; j++) {
                    int count_recebido = contador;
                    for (int j=count_recebido; j < pasta_do_remetente_destinatario.length; j++) {
                                                                        
                        if( primeira_vez == true ){                                                        
                            System.out.println( "\nFor ( J >= contador ) { - " + "J - " + j + " - contador - " + contador );
                        
                            System.out.println( "\nprimeira_vez == true");
                            
                            for (int r=0; r < pasta_do_remetente_destinatario.length; r++) {
                                //
                                contador += 1;
                                
                                String nome_Da_pasta_Da_Mensagem_Data = pasta_do_remetente_destinatario[r].getName().trim().toUpperCase();
                                String endereco_Da_pasta_Da_Mensagem_Data = internalStorageDir + s+"00_Externo"+s+"MENSAGENS_RECEBIDAS"+s + email_REMETENTE + s + email_DESTINATARIO + s + pasta_do_remetente_destinatario[r].getName().trim();
                                //System.out.println( "\nnome_Da_pasta_Da_Mensagem_Data - " + nome_Da_pasta_Da_Mensagem_Data);
                                //System.out.println( "\nendereco_Da_pasta_Da_Mensagem_Data - " + endereco_Da_pasta_Da_Mensagem_Data);
                                File data_diretorio2 = new File( endereco_Da_pasta_Da_Mensagem_Data );
                                File[] data_lista_pasta_Da_Mensagem = data_diretorio2.listFiles();
                                for (int i=0; i < data_lista_pasta_Da_Mensagem.length; i++) {
                                                                      
                                    String subnome_Da_pasta_Da_Mensagem = data_lista_pasta_Da_Mensagem[i].getName().trim().toUpperCase();
                                    String endereco_recebido_e_nao_lido = endereco_Da_pasta_Da_Mensagem_Data + s + subnome_Da_pasta_Da_Mensagem;
                                    if ( !subnome_Da_pasta_Da_Mensagem.equals("ENVIADO") ) {
                                        //System.out.println( "\nsubnome_Da_pasta_Da_Mensagem - " + subnome_Da_pasta_Da_Mensagem);
                                        //System.out.println( "\nendereco_recebido_e_nao_lido - " + endereco_recebido_e_nao_lido);
                                        File[] data_lista_arquivos_Da_Mensagem = data_lista_pasta_Da_Mensagem[i].listFiles();
                                        for (int x = 0; x < data_lista_arquivos_Da_Mensagem.length; x++) {
                                        
                                            String nome_do_arquivo = data_lista_arquivos_Da_Mensagem[i].getName().trim().toUpperCase();
                                            String endereco_do_arquivo = data_lista_arquivos_Da_Mensagem[i].getPath().trim().toUpperCase();
                                            //System.out.println( "\nnome_do_arquivo - " + nome_do_arquivo);
                                            //System.out.println( "\nendereco_do_arquivo - " + endereco_do_arquivo);
                                            
                                            String str_para_extencao = new File( endereco_recebido_e_nao_lido ).getPath() + s + new File( data_lista_arquivos_Da_Mensagem[x].getName() ).getPath();
                                            String extencao_do_arquivo = str_para_extencao.substring( str_para_extencao.lastIndexOf('.') + 1 );
                                            //System.out.println( "\nstr_para_extencao - " + str_para_extencao);
                                            //System.out.println( "\nextencao_do_arquivo - " + extencao_do_arquivo);
                                            
                                            if( extencao_do_arquivo.equalsIgnoreCase( "html" ) ){
                                                
                                                //System.out.println( "\nstr_para_extencao - " + str_para_extencao);
                                                //System.out.println( "\nextencao_do_arquivo - " + extencao_do_arquivo);
                                                filtrarTipoArquivos__iniciais_2( 
                                                        Email_Mensagens_Por_Contato, 
                                                        data_lista_arquivos_Da_Mensagem[x], 
                                                        nome_Da_pasta_Da_Mensagem_Data, 
                                                        email_remetente, 
                                                        email_destinatario );
                                                
                                                try {
                                                    
                                                    boolean nl = true;
                                                    String endereco_txt_mensagens = internalStorageDir + s+"00_Externo"+s+"MENSAGENS_RECEBIDAS"+s + email_REMETENTE + s + email_DESTINATARIO + s + "MENSAGENS_TXT" + s + "txt" + ".txt";
                                                    
                                                    BufferedWriter out = new BufferedWriter(new FileWriter(endereco_txt_mensagens ,true));
                                                    out.write(nome_Da_pasta_Da_Mensagem_Data);
                                                    if(nl) { out.newLine(); }
                
                                                    out.close();
                                                } catch (IOException e) {}
                                            }
                                        }
                                    }
                                }
                            }
                            
                            
                            /*
                            File data_diretorio2 = new File( endereco_Da_pasta_Da_Mensagem_Data );
                            File[] data_lista_pasta_Da_Mensagem = data_diretorio2.listFiles();
                            for (int i=0; i < data_lista_pasta_Da_Mensagem.length; i++) {
                                String subnome_Da_pasta_Da_Mensagem = data_lista_pasta_Da_Mensagem[i].getName().trim().toUpperCase();
                                String endereco_recebido_e_nao_lido = endereco_Da_pasta_Da_Mensagem_Data + s + subnome_Da_pasta_Da_Mensagem;
                                if ( !subnome_Da_pasta_Da_Mensagem.equalsIgnoreCase("ENVIADO") ) {
                                    File[] data_lista_arquivos_Da_Mensagem = data_lista_pasta_Da_Mensagem[i].listFiles();
                                    for (int x = 0; x < data_lista_arquivos_Da_Mensagem.length; x++) {
                                        String str_para_extencao = new File( endereco_recebido_e_nao_lido ).getPath() + s + new File( data_lista_arquivos_Da_Mensagem[x].getName() ).getPath();
                                        String extencao_do_arquivo = str_para_extencao.substring( str_para_extencao.lastIndexOf('.') + 1 );
                                        if( extencao_do_arquivo.equalsIgnoreCase( "html" ) ){ 
                                            filtrarTipoArquivos__iniciais_2( Email_Mensagens_Por_Contato, data_lista_arquivos_Da_Mensagem[x], lista_de_mensagens_nao_lidas.get(j)[1], email_remetente, email_destinatario );
                                        }          
                                    }
                                }
                            }
                            */
                            break;
                        }
                        else {
                            
                            System.out.println( "\nFor ( J >= contador ) { - " + "J - " + j + " - contador - " + contador );
                        
                            System.out.println( "\nprimeira_vez == false");
                            
                            boolean umaVez = false;
                            
                            for (int r=0; r < pasta_do_remetente_destinatario.length; r++) {
                                                                
                                String nome_Da_pasta_Da_Mensagem_Data = pasta_do_remetente_destinatario[r].getName().trim().toUpperCase();
                                if( !nome_Da_pasta_Da_Mensagem_Data.equals("MENSAGENS_TXT") ){
                                if( verificar_se_arquivo_tem_string( nome_Da_pasta_Da_Mensagem_Data, email_remetente, email_destinatario) == false ){    
                                    //
                                    if( umaVez == false ){
                                        umaVez = true;
                                        contador += 1;
                                    }
                                String endereco_Da_pasta_Da_Mensagem_Data = internalStorageDir + s+"00_Externo"+s+"MENSAGENS_RECEBIDAS"+s + email_REMETENTE + s + email_DESTINATARIO + s + pasta_do_remetente_destinatario[r].getName().trim();
                                //System.out.println( "\nnome_Da_pasta_Da_Mensagem_Data - " + nome_Da_pasta_Da_Mensagem_Data);
                                //System.out.println( "\nendereco_Da_pasta_Da_Mensagem_Data - " + endereco_Da_pasta_Da_Mensagem_Data);
                                File data_diretorio2 = new File( endereco_Da_pasta_Da_Mensagem_Data );
                                File[] data_lista_pasta_Da_Mensagem = data_diretorio2.listFiles();
                                for (int i=0; i < data_lista_pasta_Da_Mensagem.length; i++) {
                                                                      
                                    String subnome_Da_pasta_Da_Mensagem = data_lista_pasta_Da_Mensagem[i].getName().trim().toUpperCase();
                                    String endereco_recebido_e_nao_lido = endereco_Da_pasta_Da_Mensagem_Data + s + subnome_Da_pasta_Da_Mensagem;
                                    if ( !subnome_Da_pasta_Da_Mensagem.equals("ENVIADO") ) {
                                    if ( !subnome_Da_pasta_Da_Mensagem.equals("ENVIADO_ONLINE") ) {
                                        //System.out.println( "\nsubnome_Da_pasta_Da_Mensagem - " + subnome_Da_pasta_Da_Mensagem);
                                        //System.out.println( "\nendereco_recebido_e_nao_lido - " + endereco_recebido_e_nao_lido);
                                        File[] data_lista_arquivos_Da_Mensagem = data_lista_pasta_Da_Mensagem[i].listFiles();
                                        for (int x = 0; x < data_lista_arquivos_Da_Mensagem.length; x++) {
                                        
                                            String nome_do_arquivo = data_lista_arquivos_Da_Mensagem[i].getName().trim().toUpperCase();
                                            String endereco_do_arquivo = data_lista_arquivos_Da_Mensagem[i].getPath().trim().toUpperCase();
                                            //System.out.println( "\nnome_do_arquivo - " + nome_do_arquivo);
                                            //System.out.println( "\nendereco_do_arquivo - " + endereco_do_arquivo);
                                            
                                            String str_para_extencao = new File( endereco_recebido_e_nao_lido ).getPath() + s + new File( data_lista_arquivos_Da_Mensagem[x].getName() ).getPath();
                                            String extencao_do_arquivo = str_para_extencao.substring( str_para_extencao.lastIndexOf('.') + 1 );
                                            //System.out.println( "\nstr_para_extencao - " + str_para_extencao);
                                            //System.out.println( "\nextencao_do_arquivo - " + extencao_do_arquivo);
                                            
                                            if( extencao_do_arquivo.equalsIgnoreCase( "html" ) ){
                                                
                                                //System.out.println( "\nstr_para_extencao - " + str_para_extencao);
                                                //System.out.println( "\nextencao_do_arquivo - " + extencao_do_arquivo);
                                                filtrarTipoArquivos__iniciais_2( 
                                                        Email_Mensagens_Por_Contato, 
                                                        data_lista_arquivos_Da_Mensagem[x], 
                                                        nome_Da_pasta_Da_Mensagem_Data, 
                                                        email_remetente, 
                                                        email_destinatario );
                                                
                                                try {
                                                    
                                                    boolean nl = true;
                                                    String endereco_txt_mensagens = internalStorageDir + s+"00_Externo"+s+"MENSAGENS_RECEBIDAS"+s + email_REMETENTE + s + email_DESTINATARIO + s + "MENSAGENS_TXT" + s + "txt" + ".txt";
                                                    
                                                    BufferedWriter out = new BufferedWriter(new FileWriter(endereco_txt_mensagens ,true));
                                                    out.write(nome_Da_pasta_Da_Mensagem_Data);
                                                    if(nl) { out.newLine(); }
                
                                                    out.close();
                                                } catch (IOException e) {}
                                            }
                                        }
                                    }
                                    }
                                }
                                }
                                }
                            }
                            
                            break;
                        }
/*
                        if ( lista_data_pasta_da_msg_recebida[j].isDirectory()  ) {

                            // PARA NÃO REPETIR A INCLUSÃO DAS MESMAS MENSAGENS AO ABRIR
                            if ( j >= contador ) {
                                contador += 1;

                                System.out.println( "\nif ( J >= contador ) { - " + "J - " + j + " - contador - " + contador );

                                String nome_Da_pasta_Da_Mensagem_Data = lista_data_pasta_da_msg_recebida[j].getName().trim().toUpperCase();
                                //System.out.println( "pasta_Data_Mensagem - " + nome_Da_pasta_Da_Mensagem_Data );
                                /*
                                System.out.println( "\n\n pegar_Endereco_Da_pasta_Da_Mensagem - Início Turbo_Flyer_Auto_Leitura_Offline ***************************************************");
                                System.out.println( "email_remetente - " + email_remetente );
                                System.out.println( "email_destinatario - " + email_destinatario );
                                System.out.println( "contador - " + contador );
                                System.out.println( "internalStorageDir - " + internalStorageDir );
                                System.out.println( "destino - " + destino );
                                System.out.println( "if ( lista_data_pasta_da_msg_recebida != null ) {" );
                                System.out.println( "quantidade de arquivos - " + lista_data_pasta_da_msg_recebida.length );
                                System.out.println( "Arquivo - " + j + " - " + lista_data_pasta_da_msg_recebida[j].getPath() );
                                System.out.println( "pegar_Endereco_Da_pasta_Da_Mensagem - Fim Turbo_Flyer_Auto_Leitura_Offline ***************************************************\n\n");
                                */
/*                                String endereco_Da_pasta_Da_Mensagem_Data = internalStorageDir + s+"00_Externo"+s+"MENSAGENS_RECEBIDAS"+s + email_REMETENTE + s + email_DESTINATARIO + s + lista_data_pasta_da_msg_recebida[j].getName().trim();

                                File data_diretorio2 = new File( endereco_Da_pasta_Da_Mensagem_Data );
                                File[] data_lista_pasta_Da_Mensagem = data_diretorio2.listFiles();
                                if ( data_lista_pasta_Da_Mensagem != null ) {

                                    for (int i=0; i < data_lista_pasta_Da_Mensagem.length; i++) {
                                        /*
                                        System.out.println( "\n\n pegar_Endereco_Da_pasta_Da_Mensagem - Início Turbo_Flyer_Auto_Leitura_Offline ***************************************************");
                                        System.out.println( "email_remetente - " + email_remetente );
                                        System.out.println( "email_destinatario - " + email_destinatario );
                                        System.out.println( "contador - " + contador );
                                        System.out.println( "internalStorageDir - " + internalStorageDir );
                                        System.out.println( "destino - " + destino );
                                        System.out.println( "if ( lista_data_pasta_da_msg_recebida != null ) {" );
                                        System.out.println( "quantidade de arquivos - " + lista_data_pasta_da_msg_recebida.length );
                                        System.out.println( "Pasta - " + j + " - " + lista_data_pasta_da_msg_recebida[j].getPath() );
                                        System.out.println( "Arquivo - " + i + " - " + data_lista_pasta_Da_Mensagem[i].getPath() );
                                        System.out.println( "pegar_Endereco_Da_pasta_Da_Mensagem - Fim Turbo_Flyer_Auto_Leitura_Offline ***************************************************\n\n");
                                        */
/*                                        String subnome_Da_pasta_Da_Mensagem = data_lista_pasta_Da_Mensagem[i].getName().trim().toUpperCase();
                                        String endereco_recebido_e_nao_lido = endereco_Da_pasta_Da_Mensagem_Data + s + subnome_Da_pasta_Da_Mensagem;

                                        boolean continuar = false;

                                        if ( subnome_Da_pasta_Da_Mensagem.equalsIgnoreCase("RECEBIDO_E_NAO_LIDO") ) {
                                            System.out.println( "\nif ( subnome_Da_pasta_Da_Mensagem.equalsIgnoreCase(\"RECEBIDO_E_NAO_LIDO\") ) {" + contador  );
                                           
                                            continuar = true;
                                        } else if ( subnome_Da_pasta_Da_Mensagem.equalsIgnoreCase("ENVIADO_ONLINE") ) {
                                            System.out.println( "\n} else if ( subnome_Da_pasta_Da_Mensagem.equalsIgnoreCase(\"ENVIADO_ONLINE\") ) { - " + contador  );
                                            
                                            if( primeira_vez == true ){

                                                continuar = true;
                                            }
                                        } else if ( subnome_Da_pasta_Da_Mensagem.equalsIgnoreCase("ENVIADO") ) {
                                            
                                            System.out.println( "\nif ( subnome_Da_pasta_Da_Mensagem.equalsIgnoreCase(\"ENVIADO\") ) { - " + contador  );
                                            System.out.println( "continuar = false;" + contador  );
                                        }

                                        if ( continuar == true ) {
                                            String[] strArray = new String[3];
                                            strArray[0] = endereco_recebido_e_nao_lido;
                                            strArray[1] = nome_Da_pasta_Da_Mensagem_Data;
                                            strArray[2] = endereco_Da_pasta_Da_Mensagem_Data;

                                            lista_de_mensagens_nao_lidas.add( strArray );

/////////////////////////////////////////////arquivos /////////////////////////////////////////////
                                            File[] data_lista_arquivos_Da_Mensagem = data_lista_pasta_Da_Mensagem[i].listFiles();
                                            for (int x = 0; x < data_lista_arquivos_Da_Mensagem.length; x++) {

                                            
                                             System.out.println( "\n\n pegar_Endereco_Da_pasta_Da_Mensagem - Início Turbo_Flyer_Auto_Leitura_Offline ***************************************************");
                                             System.out.println( "email_remetente - " + email_remetente );
                                             System.out.println( "email_destinatario - " + email_destinatario );
                                             System.out.println( "contador - " + contador );
                                             System.out.println( "internalStorageDir - " + internalStorageDir );
                                             System.out.println( "destino - " + destino );
                                             System.out.println( "if ( lista_data_pasta_da_msg_recebida != null ) {" );
                                             System.out.println( "quantidade de arquivos - " + lista_data_pasta_da_msg_recebida.length );
                                             System.out.println( "Pasta - " + j + " - " + lista_data_pasta_da_msg_recebida[j].getPath() );
                                             System.out.println( "Subpasta - " + i + " - " + data_lista_pasta_Da_Mensagem[i].getPath() );
                                             System.out.println( "Arquivo - " + x + " - " + data_lista_arquivos_Da_Mensagem[x].getPath() );
                                             System.out.println( "pegar_Endereco_Da_pasta_Da_Mensagem - Fim Turbo_Flyer_Auto_Leitura_Offline ***************************************************\n\n");
                                           
                                                try{
                                                    String str_para_extencao = new File( endereco_recebido_e_nao_lido ).getPath() + s + new File( data_lista_arquivos_Da_Mensagem[x].getName() ).getPath();
                                                    String extencao_do_arquivo = str_para_extencao.substring( str_para_extencao.lastIndexOf('.') + 1 );
                                                    if( extencao_do_arquivo.equalsIgnoreCase( "html" ) ){
                                                        /*
                                                        System.out.println( "HTML - extencao_do_arquivo - " + extencao_do_arquivo );
                                                        System.out.println( "Arquivo - " + x + " - " + data_lista_arquivos_Da_Mensagem[x].getPath() );
                                                        System.out.println( "HTML - extencao_do_arquivo - " + extencao_do_arquivo );
                                                        */
 /*                                                   }
                                                } catch( Exception e ){}
                                            }

                                        }
                                    }
                                }
                                //}
                            }
                            else{
                                
                                //System.out.println( "\nelse ( J >= contador ) { - " + "J - " + j + " - contador - " + contador );
                            }
                        }
*/                        
                    }
                }
        } catch( Exception e ){}
        
        //try{
            
        //    mostrar_arquivo_html__iniciais_1( Email_Mensagens_Por_Contato, lista_de_mensagens_nao_lidas, email_REMETENTE, email_DESTINATARIO, contador );
        //} catch( Exception e ){}
        
        //Reiniciar
        try { 
            
            //System.out.println( "Fim - Turbo_Flyer_Auto_Leitura_Offline***************************************************\n\n");
            
            Thread.sleep( 2000 );             
            Turbo_Flyer_Auto_Leitura_Offline Turbo_Flyer_Auto_Leitura_Offline = new Turbo_Flyer_Auto_Leitura_Offline( Email_Mensagens_Por_Contato, email_remetente, email_destinatario, contador++, false );
          
        } catch( Exception e ){}
    }
    
    private void mostrar_arquivo_html__iniciais_1( 
            Email_Mensagens_Por_Contato Email_Mensagens_Por_Contato,
            List<String[]> lista_de_mensagens_nao_lidas,
            String email_remetente,
            String email_destinatario,
            int contador){
        
        try{
                                                
            for (int j = 0; j < lista_de_mensagens_nao_lidas.size(); j++) {
                
                String endereco_recebido_e_nao_lido = lista_de_mensagens_nao_lidas.get(j)[0];
                String nome_Da_pasta_Da_Mensagem_Data = lista_de_mensagens_nao_lidas.get(j)[1];
                String endereco_Da_pasta_Da_Mensagem_Data = lista_de_mensagens_nao_lidas.get(j)[2]; 
                
                File[] listaDosArquivos = new File( endereco_recebido_e_nao_lido ).listFiles();    
                
                try{                                                
                    for (int i=0; i < listaDosArquivos.length; i++) {
                        
                        String str_para_extencao = new File( endereco_recebido_e_nao_lido ).getPath() + s + new File( listaDosArquivos[i].getName() ).getPath();
                        String extencao_do_arquivo = str_para_extencao.substring( str_para_extencao.lastIndexOf('.') + 1 );   
                        if( extencao_do_arquivo.equalsIgnoreCase( "html" ) ){
                            
                            filtrarTipoArquivos__iniciais_2( Email_Mensagens_Por_Contato, listaDosArquivos[i], lista_de_mensagens_nao_lidas.get(j)[1], email_remetente, email_destinatario );
                        }                                                        
                    }   
                    
                    /*
                    Arquivo_Ou_Pasta.criarPasta( endereco_Da_pasta_Da_Mensagem_Data, "RECEBIDO" );
                    for (int i=0; i < listaDosArquivos.length; i++) {
                        
                        Arquivo_Ou_Pasta.copiarArquivo( 
                                new File( endereco_recebido_e_nao_lido + "\\" + listaDosArquivos[i].getName() ), 
                                endereco_Da_pasta_Da_Mensagem_Data + "\\" + "RECEBIDO"
                        );       
                        
                        listaDosArquivos[i].delete();
                        
                        System.out.println( "Arquivo_Ou_Pasta.copiarArquivo - \n" + 
                                "Arquivo - " + endereco_recebido_e_nao_lido + "\\" + listaDosArquivos[i].getName() + "\n" +
                                "Destino - " + endereco_Da_pasta_Da_Mensagem_Data + "\\" + "RECEBIDO"
                        );
                        
                        Arquivo_Ou_Pasta.deletar( 
                                new File( endereco_Da_pasta_Da_Mensagem_Data + "\\" + "RECEBIDO_E_NAO_LIDO" )
                        );
                    }
                    */
                    
                } catch( Exception e ){}
            }
            
        } catch( Exception e ){}
        
        //Reiniciar
        try { 
            
            //System.out.println( "Fim - Turbo_Flyer_Auto_Leitura_Offline***************************************************\n\n");
            
            Thread.sleep( 2000 );             
            Turbo_Flyer_Auto_Leitura_Offline Turbo_Flyer_Auto_Leitura_Offline = new Turbo_Flyer_Auto_Leitura_Offline( Email_Mensagens_Por_Contato, email_remetente, email_destinatario, contador++, false );
          
        } catch( Exception e ){}
    }
    
    private void filtrarTipoArquivos__iniciais_2( 
            Email_Mensagens_Por_Contato Email_Mensagens_Por_Contato,
            File file_recebido, 
            String nome_Da_pasta_Da_Mensagem,
            String email_remetente,
            String email_destinatario){
        
        try{  
            
///////////////////////////////////////////////////////////////////////////////
                //Lendo arquivo
                if ( file_recebido.isFile() == true ) {

                    // abertura do arquivo
                    BufferedReader bR = new BufferedReader(new InputStreamReader(
                            new FileInputStream(file_recebido), "UTF-8"));
                    StringBuilder sb = new StringBuilder();

                    String linha;
                    while ((linha = bR.readLine()) != null) {

                        //System.out.println( linha );
                        sb.append(linha);
                        //String decodedUrl = java.net.URLDecoder.decode(linha, "UTF-8");
                        //sb.append(decodedUrl);
                    }
///////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
                    // codePointAt para String
                    StringBuilder sb_final = new StringBuilder();
                    String parte_01[] = sb.toString().trim().split("_");
                    for (int i = 0; i < parte_01.length; i++) {

                        int codePointAt = Integer.parseInt( parte_01[i] );
                        // converting to char[] pair
                        char[] charPair = Character.toChars(codePointAt);
                        // and to String, containing the character we want
                        String symbol = new String(charPair);

                        sb_final.append(symbol);

                        //Transformar unicode para utf
                        if (Character.charCount(codePointAt) == 1) {
                            /*
                            System.out.println( "\n\n filtrarTipoArquivos__iniciais_2 - Início - Turbo_Flyer_Auto_Leitura_Offline ***************************************************");
                            System.out.println( " String Completa - " + sb.toString() );
                            System.out.println( " String parte_01[i] - " + parte_01[i] );
                            System.out.println( " codePointAt - " + codePointAt );
                            System.out.println( " char[] charPair - " + charPair );
                            System.out.println( " Symbol - " + symbol );
                            System.out.println( " filtrarTipoArquivos__iniciais_2 - Fim - Turbo_Flyer_Auto_Leitura_Offline ***************************************************\n\n");
                            */
                        } else {
                            //return new String(Character.toChars(codePoint));
                        }
                    }
////////////////////////////////////////////////////////////////////////////////

                //String mensagemSX = sb.toString().trim();
                String lineSeparator = System.getProperty("line.separator");
                String mensagemSX = sb_final.toString().trim().replaceAll("__@jm@quebra_linha@jm@__", "<br>" );
                     
                String datas[] = nome_Da_pasta_Da_Mensagem.trim().split("_");
                String nome_data_hora_mensagem = datas[2]+"/"+datas[1]+"/"+datas[0]+" "+datas[3]+":"+datas[4]+":"+datas[5];
                   
                String nome_email_destinatario = email_destinatario.trim().toUpperCase().replace("@", "_");
                String email_DESTINATARIO = nome_email_destinatario.trim().toUpperCase().replace(".", "_");
                String arquivo_properties2 = email_remetente.trim().toUpperCase().replace("@", "_");
                String email_REMETENTE = arquivo_properties2.trim().toUpperCase().replace(".", "_");
                    
                String remetente_e_destinatario = email_REMETENTE    + "-" + email_DESTINATARIO + "-";
                String destinatario_e_remetente = email_DESTINATARIO + "-" + email_REMETENTE + "-";
                                                         
                /*
                System.out.println( "\n\n filtrarTipoArquivos__iniciais_2 - Início Turbo_Flyer_Auto_Leitura_Offline ***************************************************");
                System.out.println( "mensagemSX - " + mensagemSX );
                System.out.println( " filtrarTipoArquivos__iniciais_2 - Fim Turbo_Flyer_Auto_Leitura_Offline ***************************************************\n\n");
                */
                    
                if ( file_recebido.getName().equalsIgnoreCase( remetente_e_destinatario + ".HTML" ) ) {
                                               
                    Email_Mensagens_Por_Contato.mensagem2("      Você - " + nome_data_hora_mensagem, mensagemSX, true, false);
                }
                else if ( file_recebido.getName().equalsIgnoreCase( destinatario_e_remetente + ".HTML" ) ) {

                    Email_Mensagens_Por_Contato.mensagem2( nome_data_hora_mensagem, mensagemSX, false, false );
                }
            }
                        
        } catch( Exception e ){ System.out.println( "Zero - Diretórios - Home - filtrarTipoArquivos( File diretório, File arquivo )" ); }
    }
    
    private boolean verificar_se_arquivo_tem_string( 
            String nome_Da_pasta_Da_Mensagem,
            String email_remetente,
            String email_destinatario){
        
        boolean retorno = false;
        
        try{
                        
            String nome_email_destinatario = email_destinatario.trim().toUpperCase().replace("@", "_");
            String email_DESTINATARIO = nome_email_destinatario.trim().toUpperCase().replace(".", "_");
            String arquivo_properties2 = email_remetente.trim().toUpperCase().replace("@", "_");
            String email_REMETENTE = arquivo_properties2.trim().toUpperCase().replace(".", "_");
            
            String endereco_txt_mensagens = internalStorageDir + s+"00_Externo"+s+"MENSAGENS_RECEBIDAS"+s + email_REMETENTE + s + email_DESTINATARIO + s + "MENSAGENS_TXT";
            
///////////////////////////////////////////////////////////////////////////////
            //Lendo arquivo
            if ( new File( endereco_txt_mensagens + s + "txt" + ".txt" ).exists() == true ) {

                    // abertura do arquivo
                    BufferedReader bR = new BufferedReader(new InputStreamReader(
                            new FileInputStream(new File( endereco_txt_mensagens + s + "txt" + ".txt" )), "UTF-8"));

                    String linha;
                    while ((linha = bR.readLine()) != null) {

                        if( linha.trim().equalsIgnoreCase(nome_Da_pasta_Da_Mensagem) ){
                            
                            retorno = true;
                            System.out.println( "\nVerificando arquivo: " + nome_Da_pasta_Da_Mensagem);
                            break;
                        }
                    }
            }
            else{
                
                retorno = false;
            }
                        
        } catch( Exception e ){}
    
        return retorno;
    }
}