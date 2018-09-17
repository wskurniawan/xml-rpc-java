package com.company;



import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.URL;
import java.io.DataInputStream.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	// write your code here
        startProgram();
    }

    private static void startProgram(){
        System.out.println("=========================================================");
        System.out.println("Program XML-RPC");
        System.out.println("=========================================================");

        boolean isContinue = true;
        Scanner s = new Scanner(System.in);

        while (isContinue){
            System.out.print("Masukkan angka pertama: ");
            int angkaPertama = s.nextInt();

            System.out.println();

            System.out.println("------------------");
            System.out.print("Pilih operasi:");
            System.out.print("1. Tambah ");
            System.out.print("2. Kurang ");
            System.out.print("3. Kali ");
            System.out.println("4. Bagi ");
            System.out.println("------------------");
            System.out.print("Input: ");
            int operasi = s.nextInt();
            System.out.println();

            System.out.print("Masukkan angka kedua: ");
            int angkaKedua = s.nextInt();
            System.out.println();

            try {
                XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();

                config.setServerURL(new URL("http://localhost:9090"));

                XmlRpcClient client = new XmlRpcClient();

                client.setConfig(config);

                Object[] params = new Object[]{angkaPertama, angkaKedua};

                if(operasi == 1){
                    Integer result = (Integer) client.execute("tambah", params);
                    System.out.println("Hasil: " + result);
                }else if(operasi == 2){
                    Integer result = (Integer) client.execute("kurang", params);
                    System.out.println("Hasil: " + result);
                }else if(operasi == 3){
                    Integer result = (Integer) client.execute("kali", params);
                    System.out.println("Hasil: " + result);
                }else if(operasi == 4){
                    Double result = (Double) client.execute("bagi", params);
                    System.out.println("Hasil: " + result);
                }

            } catch (Exception exception) {
                System.err.println("JavaClient: " + exception);
            }

            System.out.print("Keluar? (1. Ya, 2. Tidak)");
            int keluar = s.nextInt();

            if(keluar == 1)
            {
                isContinue = false;
            }
        }

        System.out.println("Sampai jumpa");
    }
}
