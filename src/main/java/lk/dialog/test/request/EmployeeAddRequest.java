package lk.dialog.test.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EmployeeAddRequest implements Serializable {
    private static final long serialVersionUID = 8805840964091900170L;

        @Valid
        @JsonProperty("name")
        @NotNull(message = "Employee name cannot be null")
        private String name;


    public EmployeeAddRequest(String name) {
        this.name = name;
    }
}
