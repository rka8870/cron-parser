package org.example.characterParser.implementation;

import org.example.InvalidCronException;
import org.example.characterParser.ValueExtractor;
import org.example.fieldParser.FieldContext;

import java.util.ArrayList;
import java.util.List;

public class AnyValueExtractor implements ValueExtractor {
    @Override
    public List<Integer> extractValues(String fieldExpression, FieldContext context) throws InvalidCronException {
        try{
            List<Integer> values = new ArrayList<>();
            for(int val = context.getMin();val<= context.getMax();val++){
                values.add(val);
            }
            return values;
        } catch (Exception exception){
            throw new InvalidCronException("Please re-check the cron expression : " + fieldExpression);
        }

    }
}
