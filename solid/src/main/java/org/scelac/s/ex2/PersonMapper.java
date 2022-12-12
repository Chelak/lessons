package org.scelac.s.ex2;

import org.scelac.s.Record;

public class PersonMapper {
    public Person mapPersonFrom(Record record){
        return new Person(record.getStringField(),record.getStringField(),record.getIntegerField());
    }
}
