<jsp:include page="../header.jsp">
	<jsp:param value="Home" name="HTMLtitle" />
</jsp:include>

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
    
    <jsp:include page="../footer.jsp"></jsp:include>