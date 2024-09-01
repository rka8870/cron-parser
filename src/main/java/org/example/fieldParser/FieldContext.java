package org.example.fieldParser;

import org.example.characterParser.SpecialCharacter;

import java.util.List;
import java.util.Set;

public class FieldContext {

    private Integer min;
    private Integer max;
    private String fieldExpression;
    private Set<SpecialCharacter> applicableCharacters;

    public FieldContext(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    public Set<SpecialCharacter> getApplicableCharacters() {
        return applicableCharacters;
    }

    public void setApplicableCharacters(Set<SpecialCharacter> applicableCharacters) {
        this.applicableCharacters = applicableCharacters;
    }

    public void setFieldExpression(String fieldExpression) {
        this.fieldExpression = fieldExpression;
    }

    public String getFieldExpression() {
        return fieldExpression;
    }

    public Integer getMin() {
        return min;
    }

    public Integer getMax() {
        return max;
    }

}
