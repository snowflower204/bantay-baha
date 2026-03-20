package bantaybaha;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SensorReadingRepository extends MongoRepository<SensorReading, String> {
}
