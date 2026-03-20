package bantaybaha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public SensorReading getLatestStatus() {
        List<SensorReading> readings = repository.findAll();
        return readings.isEmpty() ? null : readings.get(readings.size() - 1);
    }
}
