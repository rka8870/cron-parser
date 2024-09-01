package org.example.characterParser;

public enum SpecialCharacter {
    COMMA(","),SLASH("/"),DASH("-"),ASTERISK("*"),DIGIT("$");

    private final String value;

    public String getValue() {
        return value;
    }

    SpecialCharacter(String value) {
        this.value = value;
    }
}
