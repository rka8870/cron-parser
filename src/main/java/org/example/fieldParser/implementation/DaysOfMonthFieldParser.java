package org.example.fieldParser.implementation;


import org.example.InvalidCronException;
import org.example.characterParser.SpecialCharacter;
import org.example.fieldParser.FieldContext;

import java.util.HashSet;
import java.util.Set;

public class DaysOfMonthFieldParser extends AbstractFieldParser {

    private final FieldContext context;

    public DaysOfMonthFieldParser(int min, int max) {
        this.context = new FieldContext(min,max);
        addApplicableCharacters(context);
    }

    private void addApplicableCharacters(FieldContext context) {
        Set<SpecialCharacter> specialCharacterSet = new HashSet<>();
        specialCharacterSet.add(SpecialCharacter.COMMA);
        specialCharacterSet.add(SpecialCharacter.DASH);
        specialCharacterSet.add(SpecialCharacter.SLASH);
        specialCharacterSet.add(SpecialCharacter.ASTERISK);
        context.setApplicableCharacters(specialCharacterSet);
    }

    @Override
    public String parseField(String field) throws InvalidCronException {
        return String.format("%-14s", "day of month")+getSpaceSeparatedValues(field,context);
    }
}
