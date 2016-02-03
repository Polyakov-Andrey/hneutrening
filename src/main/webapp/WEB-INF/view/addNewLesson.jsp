<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="jspf/header.jspf"%>

<div
	class="row col-lg-8 col-md-8 col-lg-offset-2 col-md-offset-2 col-sm-12">
	<h2 class="text-center">
		<spring:message code="label.page.newlesson" />
	</h2>
	<c:url var="url" value="/management/lessons/add" />
	<form:form method="POST" action="${url}" commandName="lesson">
		<c:set var="error"><form:errors path="*" /></c:set>
		<c:if test="${not empty error }">
			<div class="form-group alert alert-danger">
				<form:errors path="*" />
			</div>
		</c:if>
		<div class="form-group">
			<label for="phone"> <spring:message
					code="label.page.newlesson.subject" /></label>
			<form:select multiple="false" path="subject"
				cssClass="input-block-level form-control" items="${subjects}"
				itemLabel="name" itemValue="id" />
		</div>
		
		<div class="form-group">
			<label for="phone"> <spring:message
					code="label.page.newlesson.teacher" /></label>
			<form:select multiple="false" path="teacher"
				cssClass="input-block-level form-control" items="${teachers}"
				itemLabel="fullName" itemValue="id" />
		</div>
		
		<div class="form-group">
			<label for="phone"> <spring:message
					code="label.page.newlesson.group" /></label>
			<form:select multiple="false" path="group"
				cssClass="input-block-level form-control" items="${groups}"
				itemLabel="speciality" itemValue="id" />
		</div>
		
		<div class="form-group">
			<label for="phone"> <spring:message
					code="label.page.newlesson.type" /></label>
			<form:select multiple="false" path="type"
				cssClass="input-block-level form-control" items="${types}"
				itemLabel="name" itemValue="name" />
		</div>
		
		<div class="form-group">
			<button type="submit"
				class="btn btn-success input-block-level form-control">
				<spring:message code="button.add" />
			</button>
		</div>
	</form:form>
</div>
<%@ include file="jspf/footer.jspf"%>