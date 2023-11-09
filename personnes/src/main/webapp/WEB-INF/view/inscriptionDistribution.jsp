<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
    <title>Répartition par mois d'inscription</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
    <canvas id="inscriptionDistributionChart"></canvas>

    <script>
        fetch('http://localhost:7090/personnes/inscriptionDistributions')
            .then(response => response.json())
            .then(data => {
                const months = data.map(entry => entry.month);
                const counts = data.map(entry => entry.count);

                const ctx = document.getElementById('inscriptionDistributionChart').getContext('2d');
                new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: months,
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
                                    text: 'Mois'
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
                console.error('Erreur lors de la récupération de la répartition par mois d\'inscription:', error);
            });
    </script>
</body>
</html>