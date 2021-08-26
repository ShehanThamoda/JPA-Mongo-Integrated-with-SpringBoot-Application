package lk.dialog.test.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class EmployeeAddResponse implements Serializable {
    private static final long serialVersionUID = 8805840964091900170L;

    private Integer id;

    public EmployeeAddResponse(){

    }

}





