<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="jspf/header.jspf"%>

<div
	class="row col-lg-8 col-md-8 col-lg-offset-2 col-md-offset-2 col-sm-12">
	<h2 class="text-center">
		<spring:message code="label.page.newgroup" />
	</h2>
	<c:url var="url" value="/management/groups/add" />
	<form:form method="POST" action="${url}" commandName="group">
		<div class="form-group">
			<label for="speciality"><spring:message
					code="label.page.newgroup.speciality" /></label>
			<form:input path="speciality" cssClass="form-control" />
		</div>
		<c:set var="error"><form:errors path="speciality" /></c:set>
		<c:if test="${not empty error }">
			<div class="form-group alert alert-danger">
				<form:errors path="speciality" />
			</div>
		</c:if>
		
		<div class="form-group">
			<label for="department"><spring:message
					code="label.page.newgroup.department" /></label>
			<form:input path="department" cssClass="form-control" />
		</div>
		<c:set var="error"><form:errors path="department" /></c:set>
		<c:if test="${not empty error }">
			<div class="form-group alert alert-danger">
				<form:errors path="department" />
			</div>
		</c:if>
		
		<div class="form-group">
			<label for="department"><spring:message
					code="label.page.newgroup.studentscount" /></label>
			<form:input path="studentsCount" type="number" cssClass="form-control" />
		</div>
		<c:set var="error"><form:errors path="studentsCount" /></c:set>
		<c:if test="${not empty error }">
			<div class="form-group alert alert-danger">
				<form:errors path="studentsCount" />
			</div>
		</c:if>
		
		<div class="form-group">
			<button type="submit"
				class="btn btn-success input-block-level form-control">
				<spring:message code="button.add" />
			</button>
		</div>
	</form:form>
</div>
<%@ include file="jspf/footer.jspf"%>