package com.javarush.task.task20.task2024;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/*
Знакомство с графами
Прочитать в дополнительных материалах о сериализации графов.
Дан ориентированный плоский граф Solution, содержащий циклы и петли.

Пример, http://edu.nstu.ru/courses/saod/images/graph1.gif

Сериализовать Solution.
Все данные должны сохранить порядок следования.


Требования:
1. В классе Solution должно существовать поле edges.
2. В классе Solution должно существовать поле node.
3. Тип поля node должен быть int.
4. Класс Solution должен поддерживать интерфейс Serializable.
*/

/**
 * Графы: основные понятия и алгоритмы
 * http://neerc.secna.ru/Algor/algo_base_graph_intr.html
 *
 * Информатика. Теория графов. Хранение графа: матрица смежности. Центр онлайн-обучения «Фоксфорд»
 * https://www.youtube.com/watch?v=TLV2akXrAXE
 *
 * Информатика. Теория графов: Алгоритм поиска в глубину. Центр онлайн-обучения «Фоксфорд»
 * https://www.youtube.com/watch?v=Tzc7Z-mOwxY
 *
 * Информатика. Теория графов: Алгоритм поиска в ширину. Центр онлайн-обучения «Фоксфорд»
 * https://www.youtube.com/watch?v=4A5vN9p0YTY
 *
 * Граф объектов в сериализации Java
 * http://espressocode.top/object-graph-java-serialization/
 */

public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) {

    }
}

/*
package com.javarush.task.task20.task2024;

import java.util.LinkedList;
import java.util.List;

/*
Знакомство с графами
Прочитать в дополнительных материалах о сериализации графов.
Дан ориентированный плоский граф Solution, содержащий циклы и петли.

Пример, http://edu.nstu.ru/courses/saod/images/graph1.gif

Сериализовать Solution.
Все данные должны сохранить порядок следования.


Требования:
1. В классе Solution должно существовать поле edges.
2. В классе Solution должно существовать поле node.
3. Тип поля node должен быть int.
4. Класс Solution должен поддерживать интерфейс Serializable.
*/
/*
public class Solution {
    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) {

    }
}

 */