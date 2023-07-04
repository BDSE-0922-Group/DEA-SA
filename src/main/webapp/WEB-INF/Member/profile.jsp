<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Meals on Wheels</title>

<link rel="stylesheet" href="/assets/css/styles.css">
<link rel="stylesheet" href="/assets/css/admin.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;700&family=Poppins:wght@400;500;700&display=swap"
	rel="stylesheet">

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
				src="/assets/images/Logo.png" alt="Logo" width="75" />
				<h1>Meals on Wheels</h1>
			</a>
		</div>

		<div id="headerR" class="align-center">
			<ul id="navLinks" class="align-center list-style-none">
				<li><a href="">Home</a></li>
				<li><a href="">Profile</a></li>
				<li><a href="" class="alt">Logout</a></li>
			</ul>

			<button id="headerMenuBtn" class="icon material-icons"
				onclick="toggleNavMenu()">menu</button>
		</div>

		<aside id="navMenu" class="justify-center">
			<ul id="navMenuLinks" class="flex-col align-center list-style-none">
				<li><a>Home</a></li>
				<li><a>Profile</a></li>
				<li><a class="alt">Logout</a></li>
			</ul>
		</aside>
	</header>

	<main class="bg3 align-center flex-col">
		<div id="profile-card" class="align-center flex-col pFont">
			<img src="https://placehold.co/300x300" alt="profile picture"
				width="300" height="300" />
			<h4>Anzel Ken Sakamoto</h4>
			<ul id="user-details" class="flex-col list-style-none">
				<li><label>Gender:</label>Male</li>
				<li><label>Username:</label>anzel_sakamoto</li>
				<li><label>Address:</label>404 Address st. Sample City</li>
				<li><label>Mobile No.:</label>09062820823</li>
			</ul>

			<button id="edit-profile" class="btnAnimation material-icons">edit</button>
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
			<a href="Home.html" class="align-center text-deco-none"> <img
				src="/assets/images/Logo.png" alt="Logo" width="75" />
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

</body>

</html>