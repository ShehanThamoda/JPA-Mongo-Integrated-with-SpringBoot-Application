package lk.dialog.test.entity.mongo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Getter
@Setter
@ToString
@Document(collection = "user")
public class User {

    @Id
    String id;
    String name;
    int age;
}
