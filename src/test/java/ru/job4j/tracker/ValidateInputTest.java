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
        selected[0] = input.askInt("Enter menu:");
        selected[1] = input.askInt("Enter menu:");
        selected[2] = input.askInt("Enter menu:");
        selected[3] = input.askInt("Enter menu:");
        selected[4] = input.askInt("Enter menu:");
        selected[5] = input.askInt("Enter menu:");
        selected[6] = input.askInt("Enter menu:");
        selected[7] = input.askInt("Enter menu:");
        selected[8] = input.askInt("Enter menu:");
        selected[9] = input.askInt("Enter menu:");
        selected[10] = input.askInt("Enter menu:");
        selected[11] = input.askInt("Enter menu:");
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