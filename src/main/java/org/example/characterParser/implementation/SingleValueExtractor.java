package org.example.characterParser.implementation;

import org.example.InvalidCronException;
import org.example.characterParser.ValueExtractor;
import org.example.fieldParser.FieldContext;

import java.util.List;

public class SingleValueExtractor implements ValueExtractor {
    @Override
    public List<Integer> extractValues(String fieldExpression, FieldContext context) throws InvalidCronException {
        try{
        return List.of(Integer.parseInt(fieldExpression));
        } catch (Exception exception){
            throw new InvalidCronException("Please re-check the cron expression : " + fieldExpression);
        }
    }
}
