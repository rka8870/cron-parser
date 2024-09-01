package org.example.characterParser.implementation;

import org.example.InvalidCronException;
import org.example.characterParser.SpecialCharacter;
import org.example.characterParser.ValueExtractor;
import org.example.fieldParser.FieldContext;

import java.util.ArrayList;
import java.util.List;

public class ListValueExtractor implements ValueExtractor {
    @Override
    public List<Integer> extractValues(String fieldExpression, FieldContext context) throws InvalidCronException {
        try {
            String[] vals = fieldExpression.split(SpecialCharacter.COMMA.getValue());
            List<Integer> values = new ArrayList<>();
            for (String val : vals) {
                values.add(Integer.parseInt(val));
            }
            return values;
        } catch (Exception exception){
        throw new InvalidCronException("Please re-check the cron expression : " + fieldExpression);
    }
    }
}
