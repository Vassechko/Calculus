# Calculus
Пишем вычислитель выражений:

•Два параметра командной строки: входной и выходной файлы.
•Во входном файле – список выражений, по одному в каждой строке.
•Каждое выражение представляет собой: ◦либо присвоение значения константе в виде: a := 1
◦либо задание выражения в виде: x = -(a * 3) + b – 3
◦либо команду печати выражения или константы: print a

•Не должно быть переменных и констант с одинаковым именем. Если переопределяем, то новое определение заменяет старое. ◦Выражения должны разбираться в момент определения, а вычисляться – в момент вызова print, подставляя текущие значения констант.

•Если часть констант выражения не определены, результатом команды print будет являться вывод этих констант: Constants a, b, с are not defined
•Одни выражения могут использовать другие. Вычисление значений также происходит в момент вызова print.
•Рекурсию не проверяем (в этом случае допустимо зацикливание программы)
•Результаты команды print пишутся в выходной файл. 

