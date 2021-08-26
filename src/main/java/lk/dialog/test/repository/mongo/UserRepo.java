package lk.dialog.test.repository.mongo;

import lk.dialog.test.entity.mongo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,Long> {

}
