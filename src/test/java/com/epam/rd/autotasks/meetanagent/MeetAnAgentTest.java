package com.epam.rd.autotasks.meetanagent;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

public class MeetAnAgentTest {

    @ParameterizedTest
    @MethodSource("getParameters")
    public void correctPasswordTest(String userInput, String expected)
    {

        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        PrintStream defaultOut = System.out;
        InputStream defaultIn = System.in;

        try {
            MeetAnAgent.main(new String[]{});
            printStream.flush();
            String actual = baos.toString().trim();
            assertEquals(expected,actual);
        }
        finally {
            System.setIn(defaultIn);
            System.setOut(defaultOut);
        }
    }

    private static Stream<Arguments> getParameters() {
        return Stream.of(
                Arguments.of(MeetAnAgent.password, "Hello, Agent"),
                Arguments.of(MeetAnAgent.password + "a","Access is denied")
        );
    }
}
