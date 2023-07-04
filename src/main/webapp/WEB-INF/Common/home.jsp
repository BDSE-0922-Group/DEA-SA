<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meals on Wheels</title>

    <link rel="stylesheet" href="css/styles.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
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
    
    <jsp:include page="../header.jsp"></jsp:include>

    <div class="custom-shape-divider-top-1686716923">
        <svg data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1200 120" preserveAspectRatio="none">
            <path
                d="M321.39,56.44c58-10.79,114.16-30.13,172-41.86,82.39-16.72,168.19-17.73,250.45-.39C823.78,31,906.67,72,985.66,92.83c70.05,18.48,146.53,26.09,214.34,3V0H0V27.35A600.21,600.21,0,0,0,321.39,56.44Z"
                class="shape-fill"></path>
        </svg>
    </div>

    <main class="bg1 home">
        <section id="landingSection" class="align-start justify-evenly">

            <div id="homeCard" class="flex-col justify-center">
                <h2 class="hFont">Welcome to Meals on Wheels</h2>
                <p class="pFont">Bringing food directly to your doorstep</p>
                <button class="get-started hFont" onclick="window.location.href='register';">
                    <span class="circle" aria-hidden="true">
                        <span class="icon arrow"></span>
                    </span>
                    <span class="button-text">Get Started</span>
                </button>
            </div>

            <div id="blobContainer">
                <img id="blob" src="images/blob.svg" alt="Svg graphic" width="500" />
                <img id="motorcycle" src="images/Motorcycle.svg" alt="Motorcycle graphic" width="500" />
            </div>
        </section>
    </main>

    <div class="custom-shape-divider-bottom-1686717423">
        <svg data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1200 120" preserveAspectRatio="none">
            <path d="M600,112.77C268.63,112.77,0,65.52,0,7.23V120H1200V7.23C1200,65.52,931.37,112.77,600,112.77Z"
                class="shape-fill"></path>
        </svg>
    </div>
    
    <jsp:include page="../footer.jsp"></jsp:include>

</body>

</html>