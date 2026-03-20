package bantaybaha;

import org.springframework.stereotype.Service;

@Service
public class HazardLevelService {
    public String calculateHazard(int levelCm) {
        if (levelCm < 50) return "Safe";
        else if (levelCm < 80) return "Watch";
        else if (levelCm < 100) return "Warning";
        else return "Danger";
    }
}
