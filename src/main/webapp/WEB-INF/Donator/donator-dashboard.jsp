<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Meals on Wheels</title>

<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/admin.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;700&family=Poppins:wght@400;500;700&display=swap"
	rel="stylesheet">
<script src="https://cdn.anychart.com/releases/8.0.0/js/anychart-base.min.js"></script>
<script src="https://cdn.anychart.com/releases/8.0.0/themes/dark_earth.min.js" type="text/javascript"></script>
<script>
        const toggleNavMenu = () => {
            var navMenu = document.getElementById("navMenu");
            var navMenuBtn = document.getElementById("headerMenuBtn");
            navMenuBtn.classList.toggle("opened");
            navMenu.classList.toggle("opened");
        };
    </script>
</head>

<body>
	<header class="align-center justify-between hFont">
		<div id="headerL" class="align-center">
			<a href="" class="align-center text-deco-none"> <img
				src="images/Logo.png" alt="Logo" width="75" />
				<h1>Meals on Wheels</h1>
			</a>
		</div>

		<div id="headerR" class="align-center">
			<ul id="navLinks" class="align-center list-style-none">
				<li><a href="home">Home</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="logout" class="alt">Logout</a></li>
			</ul>

			<button id="headerMenuBtn" class="icon material-icons"
				onclick="toggleNavMenu()">menu</button>
		</div>

		<aside id="navMenu" class="justify-center">
			<ul id="navMenuLinks" class="flex-col align-center list-style-none">
				<li><a href="home">Home</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="logout" class="alt">Logout</a></li>
			</ul>
		</aside>
	</header>

	<main class="bg1 flex-col align-center">
		<div class="flex-row mt-3">
			<div class="card">
				<h2>Total Donation Received by Meals on Wheels</h2>
			</div>

			<div class="card">
				<h2>Average Donation Amount</h2>
			</div>

			<div class="card">
				<h2>Total Donors Who Donated</h2>
			</div>
		</div>
		
		<div class="mt-3">
			<div class="chart" id="chart">
			
			</div>
			<div class=>
			</div>
		</div>

	</main>

	<div class="custom-shape-divider-bottom-1686717423">
		<svg data-name="Layer 1" xmlns="http://www.w3.org/2000/svg"
			viewBox="0 0 1200 120" preserveAspectRatio="none">
            <path
				d="M600,112.77C268.63,112.77,0,65.52,0,7.23V120H1200V7.23C1200,65.52,931.37,112.77,600,112.77Z"
				class="shape-fill"></path>
        </svg>
	</div>

	<footer class="justify-center flex-col">

		<div id="footerTop" class="hFont">
			<a href="home" class="align-center text-deco-none"> <img
				src="images/Logo.png" alt="Logo" width="75" />
				<h1>Meals on Wheels</h1>
			</a>
		</div>

		<div id="footerMid" class="align-start justify-between">
			<div id="footerMidL">

				<ul id="footLinks" class="align-start flex-col list-style-none">
					<h5 class="footerSubHeader">Company</h5>
					<li><a href="/About-Us">About Us</a></li>
					<li><a href="/Contact-Us">Contact Us</a></li>
				</ul>

				<ul id="footLinks" class="align-start flex-col list-style-none">
					<h5 class="footerSubHeader">Meals</h5>
					<li><a href="Login.html">Order a Meal</a></li>
					<li><a href="/Registration.html">Order History</a></li>
				</ul>
			</div>

			<div id="footerMidR">
				<div id="contactBlock" class="align-end flex-col pFont">
					<h5 class="hFont">Contact Us</h5>
					<p>+63 1075693</p>
					<p>meals.on.wheels@gmail.com</p>
					<p>404 Address st. Country</p>
				</div>
			</div>
		</div>

		<div id="footerBot" class="align-center justify-between pFont">
			<div id="footerBotL">
				<p>Lithan Academy &#169;2023</p>
			</div>

			<div id="footerBotR" class="align-center">
				<ul id="botLinks" class="align-center list-style-none">
					<li><a href="/Privacy-Policy">Privacy Policy</a></li>
					<li><a href="/Terms-and-Conditions">Terms & Conditions</a></li>
				</ul>
			</div>
		</div>

	</footer>

<script>
anychart.onDocumentReady(function() {

    anychart.theme(anychart.themes.darkEarth);
    
    // set the data
    var data = {
      header: ["Name", "Death toll"],
      rows: [
        ["San-Francisco (1906)", 1500],
        ["Messina (1908)", 87000],
        ["Ashgabat (1948)", 175000],
        ["Chile (1960)", 10000],
        ["Tian Shan (1976)", 242000],
        ["Armenia (1988)", 25000],
        ["Iran (1990)", 50000]
    ]};

    // create the chart
   var chart = anychart.bar();

    // add data
    chart.data(data);

    // set the chart title
    chart.title("The deadliest earthquakes in the XXth century");

  // draw
  chart.container("chart");
  chart.draw();
});
</script>

</body>

</html>