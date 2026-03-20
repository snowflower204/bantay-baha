const express = require('express');
const app = express();
const path = require('path');

// Serve static files (HTML, CSS, JS)
app.use(express.static(path.join(__dirname)));

app.listen(3000, () => {
  console.log('Frontend running at http://localhost:3000');
});
