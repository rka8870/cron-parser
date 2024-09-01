package org.example.characterParser;

import org.example.InvalidCronException;
import org.example.fieldParser.FieldContext;

import java.util.List;

public interface ValueExtractor {

    List<Integer> extractValues(String fieldExpression, FieldContext context) throws InvalidCronException;

}
