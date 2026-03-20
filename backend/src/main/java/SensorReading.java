package bantaybaha;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "sensor_readings")
public class SensorReading {

    @Id
    private String id;

    private String sensorId;
    private int levelCm;
    private String hazard;
    private Date timestamp;

    // Getters and setters
    public String getSensorId() {
        return sensorId;
    }
    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public int getLevelCm() {
        return levelCm;
    }
    public void setLevelCm(int levelCm) {
        this.levelCm = levelCm;
    }

    public String getHazard() {
        return hazard;
    }
    public void setHazard(String hazard) {
        this.hazard = hazard;
    }

    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
