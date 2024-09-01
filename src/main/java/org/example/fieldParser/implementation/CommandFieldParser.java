package org.example.fieldParser.implementation;

import org.example.InvalidCronException;
import org.example.fieldParser.FieldParser;

public class CommandFieldParser implements FieldParser {

    @Override
    public String parseField(String field) throws InvalidCronException {
        return String.format("%-14s", "command") + field;
    }
}
