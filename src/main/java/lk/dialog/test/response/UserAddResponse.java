package lk.dialog.test.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class UserAddResponse implements Serializable {
    private static final long serialVersionUID = 8805840964091900170L;

    @JsonProperty("user_id")
    private String id;



}
