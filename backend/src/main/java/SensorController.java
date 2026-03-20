package bantaybaha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sensor")
public class SensorController {

    @Autowired
    private SensorReadingRepository repository;

    @Autowired
    private HazardLevelService hazardService;

    @PostMapping("/data")
    public SensorReading receiveData(@RequestBody SensorReading reading) {
        reading.setTimestamp(new Date());
        reading.setHazard(hazardService.calculateHazard(reading.getLevelCm()));
        repository.save(reading);
        return reading;
    }

    @GetMapping("/status")
    public ResponseEntity<SensorReading> getLatestStatus() {
        List<SensorReading> readings = repository.findAll();
        if (readings.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content instead of 500
        }
        return ResponseEntity.ok(readings.get(readings.size() - 1));
    }

}
