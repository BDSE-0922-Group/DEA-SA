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
</head>

<body>
    <header class="align-center justify-between hFont">
        <div id="headerL" class="align-center">
            <a href="home" class="align-center text-deco-none">
                <img src="images/Logo.png" alt="Logo" width="75" />
                <h1>Meals on Wheels</h1>
            </a>
        </div>

        <div id="headerR" class="align-center">
            <ul id="navLinks" class="align-center list-style-none">
                <li>
                    <a href="/register">Sign Up</a>
                </li>
                <li>
                    <a href="login">Log In</a>
                </li>
                <li>
                    <a href="home">Home</a>
                </li>
            </ul>

            <button id="headerMenuBtn" class="icon material-icons">
                menu
            </button>
        </div>
    </header>

    <div class="custom-shape-divider-top-1686716923">
        <svg data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1200 120" preserveAspectRatio="none">
            <path
                d="M321.39,56.44c58-10.79,114.16-30.13,172-41.86,82.39-16.72,168.19-17.73,250.45-.39C823.78,31,906.67,72,985.66,92.83c70.05,18.48,146.53,26.09,214.34,3V0H0V27.35A600.21,600.21,0,0,0,321.39,56.44Z"
                class="shape-fill"></path>
        </svg>
    </div> 

    <main class="bg1 align-center justify-center">

        <div class="align-center confirmation-card flex-col">
            <img src="images/Confirmation.svg" alt="Confirmation" width="400" height="300" />
            <p class="hFont text-align-center">Registration Successful
            </p>
            <a href="login" class="pFont text-deco-none">Click here to Login</a>
        </div>

    </main>

    <div class="custom-shape-divider-bottom-1686717423">
        <svg data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1200 120" preserveAspectRatio="none">
            <path d="M600,112.77C268.63,112.77,0,65.52,0,7.23V120H1200V7.23C1200,65.52,931.37,112.77,600,112.77Z"
                class="shape-fill"></path>
        </svg>
    </div>

    <footer class="justify-center flex-col">

        <div id="footerTop" class="hFont">
            <a href="home" class="align-center text-deco-none">
                <img src="images/Logo.png" alt="Logo" width="75" />
                <h1>Meals on Wheels</h1>
            </a>
        </div>

        <div id="footerMid" class="align-start justify-between">
            <div id="footerMidL">
                <ul id="footLinks" class="align-start flex-col list-style-none">
                    <h5 class="footerSubHeader">Account</h5>
                    <li>
                        <a href="login">Log In</a>
                    </li>
                    <li>
                        <a href="register">Sign Up</a>
                    </li>
                </ul>

                <ul id="footLinks" class="align-start flex-col list-style-none">
                    <h5 class="footerSubHeader">Company</h5>
                    <li>
                        <a href="/About-Us">About Us</a>
                    </li>
                    <li>
                        <a href="/Contact-Us">Contact Us</a>
                    </li>
                </ul>
            </div>

            <div id="footerMidR">
                <div id="contactBlock" class="align-end flex-col pFont">
                    <h5 class="hFont">Contact Us</h5>
                    <p>+63 1075693</p>
                    <p>meals.on.wheels@gmail.com</p>
                    <p> 404 Address st. Country</p>
                </div>
            </div>
        </div>

        <div id="footerBot" class="align-center justify-between pFont">
            <div id="footerBotL">
                <p>Lithan Academy &#169;2023</p>
            </div>

            <div id="footerBotR" class="align-center">
                <ul id="botLinks" class="align-center list-style-none">
                    <li>
                        <a href="/Privacy-Policy">Privacy Policy</a>
                    </li>
                    <li>
                        <a href="/Terms-and-Conditions">Terms & Conditions</a>
                    </li>
                </ul>
            </div>
        </div>

    </footer>

</body>

</html>