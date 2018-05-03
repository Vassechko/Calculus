package com.company;

import java.lang.String;

public class Parser {
    private String key = null;
    private Integer value = null;
    private String sValue;
    private Integer position;

    public String GetKey (){
        return key;
    }

    public Integer GetValue(){
        return value;
    }

    public void assign( String  expression){
        // самый простой случай - инициализация переменной
        if (expression.contains(":=")){
            // тут необходимо выделить имя переменной и значение
            position = expression.indexOf("=");
            key = expression.substring(0, position-1).trim();
            sValue = expression.substring(position + 1).trim();

            System.out.println("(key, value) = (" + key + ", " + sValue + ")" );
            try {
                value = Integer.valueOf(sValue);
            }catch (NumberFormatException e) {
                System.err.println("Неверный формат строки! значение [" + sValue + "], невозможно перевести в число" );
            }
        } else {
            if (expression.contains("print")) {
                // выделяем имя переменной после слова "print", убираем пробелы
                key = expression.substring(5).trim();
                System.out.println("print key [" + key + "]");
                // неплохо бы было использовать регулярные выражения для разделения строки

            }
            else{ // считаем что попалось выражение тут надо его распарсить

            }
        }

    }
}
