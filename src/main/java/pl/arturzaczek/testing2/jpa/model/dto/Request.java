package pl.arturzaczek.testing2.jpa.model.dto;

import lombok.ToString;
import lombok.Value;

@Value
@ToString
public class Request {
    String name;
    String lastName;
    String age;
    String university;
}
