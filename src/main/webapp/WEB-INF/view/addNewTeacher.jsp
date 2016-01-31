<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="jspf/header.jspf"%>

<div
	class="row col-lg-8 col-md-8 col-lg-offset-2 col-md-offset-2 col-sm-12">
	<h2 class="text-center">
		<spring:message code="label.page.newteacher" />
	</h2>
	<c:url var="url" value="add" />
	<form:form method="POST" action="${url}">
		<div class="form-group">
			<label for="name"><spring:message
					code="label.page.newteacher.name" /></label>
			<form:input path="name" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label for="surname"><spring:message
					code="label.page.newteacher.surname" /></label>
			<form:input path="surname" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label for="patronymic"><spring:message
					code="label.page.newteacher.patronymic" /></label>
			<form:input path="patronymic" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label for="phone"><spring:message
					code="label.page.newteacher.phone" /></label>
			<form:input path="phone" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label for="experience"><spring:message
					code="label.page.newteacher.experience" /></label>
			<form:input path="experience" type="number" cssClass="form-control" />
		</div>
		<div class="form-group">
			<label for="phone"><spring:message
					code="label.page.newteacher.specialization" /></label>
			<form:select multiple="true" path="subjects" cssClass="input-block-level form-control"
				items="${subjectsForChose}" itemLabel="name" itemValue="id" />
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-success input-block-level form-control">
				<spring:message code="button.add" />
			</button>
		</div>
	</form:form>
</div>
<%@ include file="jspf/footer.jspf"%>