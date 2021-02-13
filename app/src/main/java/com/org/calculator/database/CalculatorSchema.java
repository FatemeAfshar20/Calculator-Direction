package com.org.calculator.database;

public class CalculatorSchema {
    public static final String NAME="calculatorDatabase";
    public static final int VERSION=1;

    public static class DirectionTable{
        public static final String NAME="directionTable";

        public static class Columns{
            public static final String ID="id";
            public static final String X="x";
            public static final String Y="y";
        }
    }

    public static class CalculateTable{
        public static final String NAME="calculateTable";

        public static class Columns{
            public static final String ID="id";
            public static final String DIRECTIONS="x";
            public static final String RESULT="result";
        }
    }
}
