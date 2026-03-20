// Fetch real-time status
async function fetchStatus() {
  const response = await fetch("http://localhost:8080/api/sensor/status");
  const data = await response.json();

  document.getElementById("level").textContent = data.levelCm;
  document.getElementById("status").textContent = "Status: " + data.hazard;

  const statusBox = document.getElementById("status");
  if (data.hazard === "Safe") statusBox.style.background = "lightgreen";
  else if (data.hazard === "Warning") statusBox.style.background = "orange";
  else if (data.hazard === "Danger") statusBox.style.background = "red";
  else statusBox.style.background = "yellow";
}

// Fetch weekly analytics
async function fetchAnalytics() {
  const response = await fetch("http://localhost:8080/api/sensor/analytics");
  const data = await response.json();

  chart.data.labels = Array.from(data.labels);
  chart.data.datasets[0].data = Array.from(data.data);
  chart.update();
}

// Chart.js setup
const ctx = document.getElementById('chart').getContext('2d');
const chart = new Chart(ctx, {
  type: 'line',
  data: {
    labels: [],
    datasets: [{
      label: 'Water Level (cm)',
      data: [],
      borderColor: 'blue',
      backgroundColor: 'lightblue',
      fill: true,
      tension: 0.3
    }]
  },
  options: {
    responsive: true,
    scales: {
      y: {
        min: 0,
        max: 120,
        title: { display: true, text: 'Water Level (cm)' }
      },
      x: {
        title: { display: true, text: 'Day of the Week' }
      }
    }
  }
});

// Refresh every 5 seconds
setInterval(fetchStatus, 5000);
setInterval(fetchAnalytics, 10000);

fetchStatus();
fetchAnalytics();
