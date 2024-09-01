package org.example.characterParser.implementation;

import org.example.InvalidCronException;
import org.example.characterParser.SpecialCharacter;
import org.example.characterParser.ValueExtractor;
import org.example.fieldParser.FieldContext;

import java.util.ArrayList;
import java.util.List;

public class RangeValueExtractor implements ValueExtractor {
    @Override
    public List<Integer> extractValues(String fieldExpression, FieldContext context) throws InvalidCronException {
        try {
            String[] range = fieldExpression.split(SpecialCharacter.DASH.getValue());
            List<Integer> values = new ArrayList<>();
            int min = Integer.parseInt(range[0]);
            String end = range[1];
            int step = 1;
            int max = context.getMax();
            if (end.contains(SpecialCharacter.SLASH.getValue())) {
                String[] split = end.split(SpecialCharacter.SLASH.getValue());
                max = Integer.parseInt(split[0]);
                step = Integer.parseInt(split[1]);
            } else {
                max = Integer.parseInt(range[1]);
            }
            for (int val = min; val <= max; val = val + step) {
                values.add(val);
            }
            return values;
        } catch (Exception exception) {
            throw new InvalidCronException("Please re-check the cron expression : " + fieldExpression);
        }
    }
}
