package org.example.characterParser.implementation;

import org.example.InvalidCronException;
import org.example.characterParser.SpecialCharacter;
import org.example.characterParser.ValueExtractor;
import org.example.fieldParser.FieldContext;

import java.util.ArrayList;
import java.util.List;

public class StepIncrementValueExtractor implements ValueExtractor {
    @Override
    public List<Integer> extractValues(String fieldExpression, FieldContext context) throws InvalidCronException {
        try {
            List<Integer> values = new ArrayList<>();
            String[] splits = fieldExpression.split(SpecialCharacter.SLASH.getValue());
            int step = Integer.parseInt(splits[1]);
            int min = context.getMin();
            if (splits[0].equals(SpecialCharacter.ASTERISK.getValue())) {
                min = context.getMin();
            } else {
                min = Integer.parseInt(splits[0]);
            }
            for (int val = min; val < context.getMax(); val = val + step) {
                values.add(val);
            }
            return values;
        } catch (Exception exception){
        throw new InvalidCronException("Please re-check the cron expression : " + fieldExpression);
    }
    }
}
