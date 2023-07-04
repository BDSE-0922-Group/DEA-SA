<jsp:include page="../header.jsp">
	<jsp:param value="Donation" name="HTMLtitle" />
</jsp:include>

    <main class="bg1 align-center justify-center">

        <div class="align-center error-popup">
            <span class="material-icons">error</span>
            <p id="error-text" class="pFont error-text"></p>
            <button class="btnAnimation icon material-icons" onclick="closeFormError()">close
            </button>
        </div>

        <section class="align-center flex-col form-card">
            <h3 class="form-heading">Donation Form</h3>
            <form id="registration" class="align-center flex-col form">
                <div class="input-group">
                    <input required="true" type="text" name="text" autocomplete="off" class="input">
                    <label class="user-label">Donation Amount</label>
                </div>
                <div class="input-group">
                    <input type="text" name="text" autocomplete="off" class="input" value="USD" disabled>
                </div>
                <div class="input-group">
                    <input required="true" type="text" name="text" autocomplete="off" class="input">
                    <label class="user-label">Contact No.</label>
                </div>
                <div class="input-group">
                    <input required="true" type="text" name="text" autocomplete="off" class="input">
                    <label class="user-label">Email Address</label>
                </div>
              
                <button type="submit" class="submit-btn">Donate</button>
            </form>
        </section>

    </main>

<jsp:include page="../footer.jsp"></jsp:include>