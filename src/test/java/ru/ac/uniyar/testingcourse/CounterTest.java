package ru.ac.uniyar.testingcourse;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CounterTest {
    Counter counter = new Counter();

    /**
     * Проверка, что при создании объекта класса Counter значение его поля value равняется 0
     * Ожидаемый результат: counter.getValue() вернёт 0
     */
    @Test
    void firstValue() {
        assertThat(counter.getValue()).isEqualTo(0);
    }

    /**
     * Поверка, что метод increase увеличивает значение на 1
     * Дано:
     * counter.increase();
     * increase.increase();
     * Ожидаемый результат: counter.getValue() вернёт 2
     */
    @Test
    void increaseTest() {
        counter.increase();
        counter.increase();
        assertThat(counter.getValue()).isEqualTo(2);
    }

    /**
     * Проверка, что метод reset сбрасывает счётчик до значения 0
     * Дано:
     * counter.increase();
     * counter.reset();
     * Ожидаемый результат: counter.getValue() вернёт 0
     */
    @Test
    void resetTest() {
        counter.increase();
        counter.reset();
        assertThat(counter.getValue()).isEqualTo(0);
    }
}
