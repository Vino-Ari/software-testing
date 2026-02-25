package ru.ac.uniyar.testingcourse;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.within;


public class LinearEquationSolverTest {
    /**
     * Проверка, правильно ли решается линейное уравнение из натуральных чисел
     * Дано: numberOne = 3.0, numberTwo = 9.0
     * Ожидаемый результат: solve(numberOne, numberTwo) вернёт 3.0
     */
    @Test
    void naturalNumbersCase() {
        assertThat(LinearEquationSolver.solve(3.0, 9.0)).isEqualTo(3.0);
    }

    /**
     * Проверка, правильно ли решается линейное уравнение из рациональных чисел
     * Дано: numberOne = 0.5, numberTwo = 0.25
     * Ожидаемый результат: solve(numberOne, numberTwo) вернёт 0.5
     */
    @Test
    void realNumbersCase() {
        assertThat(LinearEquationSolver.solve(0.5, 0.25)).isEqualTo(0.5);
    }

    /**
     * Проверка, правильно ли решается линейное уравнение c отрицательным числом
     * Дано: numberOne = -0.5, numberTwo = 0.25
     * Ожидаемый результат: solve(numberOne, numberTwo) вернёт -0.5
     */
    @Test
    void negativeNumbersCase() {
        assertThat(LinearEquationSolver.solve(-0.5, 0.25)).isEqualTo(-0.5);
    }

    /**
     * Проверяется, что если при решении линейного уравнения корнем является любое число, возникает исключение
     * Дано: numberOne = 0.0, numberTwo = 0.0
     * Ожидаемый результат: solve(numberOne, numberTwo) вернёт AnyNumberIsRootException
     */
    @Test
    void AnyNumberIsRoot() {
        assertThatThrownBy(() -> LinearEquationSolver.solve(0.0, 0.0)).isInstanceOf(LinearEquationSolver
                .AnyNumberIsRootException.class);
    }

    /**
     * Проверка, что при отсутствии корней выведется null
     * Дано: numberOne = 0.0, numberTwo = 10.0
     * Ожидаемый результат: solve(numberOne, numberTwo) вернёт null
     */
    @Test
    void nullCase() {
        assertThat(LinearEquationSolver.solve(0.0, 10.0)).isNull();
    }

    /**
     * Проверка, что корень может быть бесконечной дробью
     * Дано: numberOne = 3, numberTwo = 2
     * Ожидаемый результат: solve(numberOne, numberTwo) вернёт 0,666666....
     */
    @Test
    void infiniteFraction() {
        assertThat(LinearEquationSolver.solve(3.0, 2.0)).isCloseTo(2.0 / 3.0, within(1e-9));

    }
}
