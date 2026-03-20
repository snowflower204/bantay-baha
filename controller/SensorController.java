@GetMapping("/analytics")
public Map<String, Object> getWeeklyAnalytics() {
    List<SensorReading> readings = InMemoryDatabase.readings;

    // Simulate grouping by day (in real case, use DB queries)
    Map<String, Integer> dailyAverage = new LinkedHashMap<>();
    dailyAverage.put("Thu", 40);
    dailyAverage.put("Fri", 55);
    dailyAverage.put("Sat", 70);
    dailyAverage.put("Sun", 110);
    dailyAverage.put("Mon", 95);
    dailyAverage.put("Tue", 80);
    dailyAverage.put("Wed", 60);

    Map<String, Object> response = new HashMap<>();
    response.put("labels", dailyAverage.keySet());
    response.put("data", dailyAverage.values());
    return response;
}
