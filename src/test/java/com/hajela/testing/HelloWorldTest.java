package com.hajela.testing;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

class HelloWorldTest {

    private HelloWorld helloWorld;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("BeforeAll called...");
    }

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach called..");
        helloWorld = new HelloWorld();
    }

    @Test
    void helloWorld() {
        System.out.println(helloWorld.helloWorld());
    }

    @Test
    void testHelloWorld() {
        System.out.println(helloWorld.helloWorld("Harsh"));
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach called..");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("AfterAll called...");
    }

    @DisplayName("Value source test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getData")
    void paramTest(String val) {
        System.out.println(val);
    }

    private static Stream<Arguments> getData(){
        return Stream.of(Arguments.of("Return data from method!"));
    }
}