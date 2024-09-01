package org.example.fieldParser.implementation;

import org.example.InvalidCronException;
import org.example.characterParser.SpecialCharacter;
import org.example.characterParser.ValueExtractor;
import org.example.characterParser.implementation.*;
import org.example.fieldParser.FieldContext;
import org.example.fieldParser.FieldParser;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractFieldParser implements FieldParser {

    private final Map<String, ValueExtractor> extractorMap = new HashMap<>();

    private final Set<Integer> uniqueValues = new HashSet<>();

    public AbstractFieldParser() {
        extractorMap.put(SpecialCharacter.COMMA.getValue(), new ListValueExtractor());
        extractorMap.put(SpecialCharacter.DASH.getValue(), new RangeValueExtractor());
        extractorMap.put(SpecialCharacter.SLASH.getValue(), new StepIncrementValueExtractor());
        extractorMap.put(SpecialCharacter.ASTERISK.getValue(), new AnyValueExtractor());
        extractorMap.put(SpecialCharacter.DIGIT.getValue(), new SingleValueExtractor());
    }

    public ValueExtractor getValueExtractor(SpecialCharacter character) {
        return extractorMap.getOrDefault(character.getValue(), new SingleValueExtractor());
    }


    public String getSpaceSeparatedValues(String field, FieldContext context) throws InvalidCronException {
        if (context.getApplicableCharacters().contains(SpecialCharacter.COMMA)) {
            String[] values = field.split(SpecialCharacter.COMMA.getValue());
            for (String val : values) {
                if (val.contains(SpecialCharacter.DASH.getValue())) {
                    uniqueValues.addAll(getValueExtractor((SpecialCharacter.DASH)).extractValues(val, context));
                }
                else if (val.contains(SpecialCharacter.SLASH.getValue())) {
                    uniqueValues.addAll(getValueExtractor((SpecialCharacter.SLASH)).extractValues(val, context));
                }
                else if (val.contains(SpecialCharacter.ASTERISK.getValue())) {
                    uniqueValues.addAll(getValueExtractor((SpecialCharacter.ASTERISK)).extractValues(val, context));
                }else{
                    uniqueValues.addAll(getValueExtractor((SpecialCharacter.DIGIT)).extractValues(val, context));
                }
            }
        }
        return  uniqueValues.stream().sorted().map(String::valueOf).collect(Collectors.joining(" "));
    }

}
