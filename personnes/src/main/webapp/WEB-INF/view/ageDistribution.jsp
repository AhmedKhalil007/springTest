<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
    <title>Repartition des Ages</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
  
    <canvas id="ageDistributionChart"></canvas>

    <script>
        fetch('http://localhost:7090/personnes/ageDistribution')
          .then(response => response.json())
          .then(data => {
            const ages = data.map(entry => entry.age);
            const counts = data.map(entry => entry.count);

            const ctx = document.getElementById('ageDistributionChart').getContext('2d');
            new Chart(ctx, {
              type: 'bar',
              data: {
                labels: ages,
                datasets: [{
                  label: 'Nombre de personnes',
                  data: counts,
                  backgroundColor: 'rgba(75, 192, 192, 0.8)',
                  borderColor: 'rgba(75, 192, 192, 1)',
                  borderWidth: 1
                }]
              },
              options: {
                scales: {
                  x: {
                    title: {
                      display: true,
                      text: 'Âge'
                    }
                  },
                  y: {
                    title: {
                      display: true,
                      text: 'Nombre de personnes'
                    },
                    beginAtZero: true,
                    stepSize: 1
                  }
                }
              }
            });
          })
          .catch(error => {
            console.error('Erreur lors de la récupération de la répartition par âge:', error);
          });
    </script>
</body>
</html>