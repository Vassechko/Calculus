package com.company;

import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    private String key = null;
    private Integer value = null;
    private String sValue;
    private Integer position;
    private String result;
    static Map values = new HashMap<String, Double>();

    /**
     * алгоритм разбора строк согласно ОПН возвращает либо строку с результатом выражение
     * @param inExpression принимает выражение которое необходимо вычислить
     * @return либо строка с результатом вычисления выражения, либо строка, содержащая сообщение об ошике
     */
    private String exprCalc (String inExpression) {
        // тут текст операции, которая счтает выражение
        String res = "";


        return  res;
    }

    public String getKey (){
        return key;
    }

    public Integer getValue(){
        return value;
    }

    public String assign( String  expression){
        // самый простой случай - инициализация переменной

        if (expression.contains(":=")){
            // тут необходимо выделить имя переменной и значение
            position = expression.indexOf("=");
            key = expression.substring(0, position-1).trim();
            sValue = expression.substring(position + 1).trim();

            System.out.println("(key, value) = (" + key + ", " + sValue + ")" );
            try {
                value = Integer.valueOf(sValue);
                values.put(key, value);
                return "";
            }catch (NumberFormatException e) {
                System.err.println("Неверный формат строки! значение [" + sValue + "], невозможно перевести в число" );
            }
        } else {
            if (expression.contains("print")) {
                // выделяем имя переменной после слова "print", убираем пробелы
                key = expression.substring(5).trim();
                System.out.println("print key [" + key + "]");
                   // если в карте есть ключь, выводим в файл значение
                if(values.containsKey(key)){
                    result = values.get(key).toString();
                } else { // выводим сообщение об ошибке
                    result = "Constant " + key + " is not defined";
                }

                // неплохо бы было использовать регулярные выражения для разделения строки

            }
            else{ // считаем что попалось выражение тут надо его распарсить
                result = exprCalc(expression);
            }
        }
        return result;

    }
}
