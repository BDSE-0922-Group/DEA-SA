<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meals on Wheels</title>

    <link rel="stylesheet" href="/assets/css/styles.css">
    <link rel="stylesheet" href="/assets/css/member.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;700&family=Poppins:wght@400;500;700&display=swap"
        rel="stylesheet">

</head>

<body>
    
    <jsp:include page="../header.jsp"></jsp:include>

    <main class="bg3 align-center flex-col">
        <h2 class="dashboard-heading hFont text-align-center">Welcome to Meals on Wheels</h2>

        <p class="mealDisclaimer pFont text-align-center">Meals will be served frozen during week-ends or if your
            location is 10Km+ away</p>
        <a href="" class="btnAnimation orderLink text-deco-none pFont">Place an order</a>
        <div class="card-container justify-evenly flex-wrap">
            <div class="card pFont">
                <img src="https://placehold.co/300x300" class="card-image" />
                <h4 class="card-heading">Sample Meal</h4>
                <p class="card-desc">Meal Description</p>
                <a href="" class="card-link">View Details</a>
            </div>

            <div class="card pFont">
                <img src="https://placehold.co/300x300" class="card-image" />
                <h4 class="card-heading">Sample Meal</h4>
                <p class="card-desc">Meal Description</p>
                <a href="" class="card-link">View Details</a>
            </div>
        </div>
    </main>

    <div class="custom-shape-divider-bottom-1686717423">
        <svg data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1200 120" preserveAspectRatio="none">
            <path d="M600,112.77C268.63,112.77,0,65.52,0,7.23V120H1200V7.23C1200,65.52,931.37,112.77,600,112.77Z"
                class="shape-fill"></path>
        </svg>
    </div>

    <jsp:include page="../footer.jsp"></jsp:include>

</body>
<script src="js/nav-menu.js"></script>
</html>