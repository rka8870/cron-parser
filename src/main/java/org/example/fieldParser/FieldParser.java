package org.example.fieldParser;

import org.example.InvalidCronException;

public interface FieldParser {

    String parseField(String field) throws InvalidCronException;

}
