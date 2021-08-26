package lk.dialog.test.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class EmployeeUpdateRequest implements Serializable {
    private static final long serialVersionUID = 8805840964091900170L;

        @JsonProperty("name")
        private String name;

    }
