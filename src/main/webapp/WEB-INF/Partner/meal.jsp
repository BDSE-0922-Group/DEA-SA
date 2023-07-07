<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../header.jsp">
	<jsp:param value="Donation" name="HTMLtitle" />
</jsp:include>

<main class="bg3 align-center justify-center">

	<div class="align-center error-popup">
		<span class="material-icons">error</span>
		<p id="error-text" class="pFont error-text"></p>
		<button class="btnAnimation icon material-icons"
			onclick="closeFormError()">close</button>
	</div>

	<section class="align-center flex-col form-card">
		<h3 class="form-heading">Post Meal</h3>
		<sf:form class="align-center flex-col form" action="post-meal"
			method="post" modelAttribute="meal" enctype="multipart/form-data">
			<div class="input-group">
				<sf:input required="true" type="text" name="name" autocomplete="off"
					path="name" class="input" />
				<label class="user-label">Meal Name</label>
			</div>
			<div class="input-group">
				<sf:textarea rows="5" required="true" name="description"
					autocomplete="off" path="description" class="input input-textarea" />
				<label class="user-label">Meal Description</label>
			</div>
			<div class="input-group">
				<label class="select-label">Meal Availability</label> <select
					class="input-select" name="availability" path="availability"> 
					<option value="" selected disabled hidden>Choose here</option>
					<option value="Available"  >Available</option>
					<option value="Not Available" >Not Available</option>
				</select>
			</div>
			<div class="input-group flex-col align-center">
				<label class="file-input">Upload a Picture</label> <input
					required="true" type="file" name="fileImage" id="photo"
					accept="image/png, image/jpeg" />
			</div>
			<div class="imagePreview">
				<img id="imgPreview" class="pFont" src="#" alt=""
					style="width: inherit;" />
			</div>

			<button type="submit" class="submit-btn">Add Meal</button>
		</sf:form>
		<script>
            $(document).ready(() => {
            	
                $("#photo").change(function () {
                    const file = this.files[0];
                    if (file) {
                        let reader = new FileReader();
                        reader.onload = function (event) {
                            $("#imgPreview")
                              .attr("src", event.target.result);
                        };
                        reader.readAsDataURL(file);
                    }
                });
            });
       </script>
	</section>

</main>

<jsp:include page="../footer.jsp"></jsp:include>