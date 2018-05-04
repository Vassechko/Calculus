package com.company;

/**
 * программа реализующая вычисление выражений из входного файла в выходной
 * входные параметры два файла с входными данными и выходными данными.
 * @param inputFileName
 * @param outputFileName
 * в результате выполениния операции выходной файл содержит значение выражения или сообщение об ошибке
 *
 */

import com.sun.xml.internal.bind.v2.TODO;

import java.io.*;
import java.util.*;
import java.util.ArrayList;


public class Main {

    static ArrayList<String> expressionList = new ArrayList();
//    static Map values = new HashMap<String, Double>();

    static String inFileNm;
    public static void main(String[] args) throws IOException {
        Params params = Params.parseArgs(args);
        // чтение наименований файлов, вывод ошибок в случае возникновения
        if (!params.valid()) {
            System.out.println(String.join("\n", params.getErrors()));
            return;
        }
        // после проверки корретности вводных данных преступаем к считыванию выражений
        try {
            calc(params);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Complete!");


    }

        // inFileNm = params.getInputFileName();
    private static void calc (Params params) throws IOException {
            String key;
            Integer value;
            String res;
            // чтение выражений
            ArrayList<String> expressionList = readFile(params.getInputFileName());
            // для записи в файл
            PrintWriter out = new PrintWriter(params.getOutFileName());
            // выполнение команд
            // просто присваивание мы записываем в карту
            Parser parser = new Parser();
            for (String expres: expressionList){
                // получаем строку в которой находится либо расчитанное значение, либо сообщение об ошибке
                //если res равно "", то в выражении было присваивание.
                res = parser.assign(expres);
                if (res != "") {
                    out.println(res);
                }
            }
            out.close();


        }
    private static ArrayList<String> readFile(String inputFileName)  throws IOException{
            ArrayList<String> expressions = new  ArrayList();



            try(BufferedReader reader = new BufferedReader(
               //     System.out.println(Paths.get(inputFileName).toAbsolutePath());
                    new InputStreamReader(
                            new FileInputStream(inputFileName))))
            {
              //  System.out.println(Paths.get(inputFileName).toAbsolutePath());
                String val;
                while ((val = reader.readLine()) != null) {
                    expressions.add(val);
                }
            }
            catch(IOException ex) {
                System.out.println(ex.getMessage());
            }
            // вывод введенных данных
            System.out.println("expressions: ");
            for(String line: expressions){
                System.out.println(line);
            }

        return expressions;
        }


    }

