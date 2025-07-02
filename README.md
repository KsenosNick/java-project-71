### Hexlet tests and linter status:
[![Actions Status](https://github.com/KsenosNick/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/KsenosNick/java-project-71/actions)

[![SonarQube Cloud](https://sonarcloud.io/images/project_badges/sonarcloud-light.svg)](https://sonarcloud.io/summary/new_code?id=KsenosNick_java-project-71)
# Вычислитель отличий
## О приложении
Приложение разработано в рамках учебного проекта, выполненного при прохождении модуля **"Структуры данных"** в 
онлайн-школе программирования **"Хекслет"** (**Hexlet**). Приложение представляет собой консольную утилиту, выполняющую 
сравнение данных и выводящую результат сравнения в консоль. На данный момент поддерживаются следующие форматы:
* **ввода**
    * *JSON*
    * *YAML*
* **вывода**
    * *Stylish* (по-умолчанию)
    * *Plain*
    * *JSON*

Примеры форматов вывода можно увидеть в разделе [Пример работы приложения](#пример-работы-приложения).
## Установка приложения
Установка приложения выполняется с помощью утилиты **Make** командой `make install`. Предварительно убедитесь, что 
утилита **Make** у вас установлена командой `make -v`.

В результате выполнения команды появится директория *build/install/app*, внутри которой находятся две директории: *bin* 
(с исполняемым файлом приложения) и *lib* (содержит упакованные в jar скомпилированные файлы).
## Запуск приложения
Формат командной строки:
```
app [-hV] [-f=format] filepath1 filepath2
```
Опции:
* **-f**, **--format=format** - формат вывода;
* **-h**, **--help** - вывод справки по утилите;
*  **-V**, **--version** - вывод версии утилиты.

Параметры:
* **filepath1** - путь до первого файла;
* **filepath2** - путь до второго файла.
## Пример работы приложения
Скринкаст работы приложения в [asciinema](https://asciinema.org/). Продемонстрирована работа со всеми вариантами 
доступных форматов ввода и вывода.
[![asciicast](https://asciinema.org/a/upYcFsfwpWmNElydQCjDm90om.svg)](https://asciinema.org/a/upYcFsfwpWmNElydQCjDm90om)