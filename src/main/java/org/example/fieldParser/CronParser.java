package org.example.fieldParser;

import org.example.InvalidCronException;
import org.example.fieldParser.implementation.*;

import java.util.ArrayList;
import java.util.List;

public class CronParser {


    private final List<FieldParser> fieldParsers;

    private final List<String> expandedExpression = new ArrayList<>();


    public CronParser() {
        this.fieldParsers = new ArrayList<>();
        initializeParseOrder(fieldParsers);
    }

    private void initializeParseOrder(List<FieldParser> fieldParsers) {
        fieldParsers.add(new MinuteFieldParser(0,59));
        fieldParsers.add(new HourCronFieldParser(0,23));
        fieldParsers.add(new DaysOfMonthFieldParser(0,31));
        fieldParsers.add(new MonthFieldParser(1,12));
        fieldParsers.add(new DaysOfWeekFieldParser(0,6));
        fieldParsers.add(new CommandFieldParser());
    }


    public List<String> parseExpression(String expression) throws InvalidCronException {
        String[] fieldValues = expression.split(" ");
        if(fieldValues.length>fieldParsers.size()){
                throw new InvalidCronException("Expression is in-correct. Individual Fields should be seperated with single space. Supporting Minute,Hours,DaysOfMonth,Month,DaysOfWeek and Command in respective order");
        }
        for(int index=0;index<fieldValues.length;index++){
            expandedExpression.add(fieldParsers.get(index).parseField(fieldValues[index]));
        }
        return expandedExpression;
    }


    public void viewExpandedExpression(){
        for(String expandedExpression : expandedExpression){
            System.out.println(expandedExpression);
        }
    }


}
