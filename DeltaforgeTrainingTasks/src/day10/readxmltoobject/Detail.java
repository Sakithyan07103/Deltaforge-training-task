package day10.readxmltoobject;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Detail {
    @JacksonXmlProperty(localName = "details")
    private String details;
    @JacksonXmlProperty(localName = "id")
    private int id;
}
