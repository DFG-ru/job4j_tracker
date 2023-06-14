package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{
                        "one",
                        "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenMultiplyValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{
                        "1234567890",
                        "987654321",
                        "1",
                        "2",
                        "3",
                        "4",
                        "5",
                        "6",
                        "7",
                        "8",
                        "9",
                        "0"
                }
        );
        ValidateInput input = new ValidateInput(out, in);
        int[] selected = new int[12];
        int[] expected = {
                1234567890,
                987654321,
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9,
                0,
        };
        for (int i = 0; i < selected.length; i++) {
            selected[i] = input.askInt("Enter menu:");
        }
        assertThat(selected).isEqualTo(expected);
    }

    @Test
    public void whenNegativeNumberValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}