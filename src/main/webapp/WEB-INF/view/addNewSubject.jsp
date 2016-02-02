<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="jspf/header.jspf"%>

<div class="row col-lg-8 col-md-8 col-lg-offset-2 col-md-offset-2 col-sm-12">
	<h2 class="text-center"><spring:message code="label.page.newsubject" /></h2>
	<c:url var="url" value="add"/>
	<form:form method="POST" action="${url}" commandName="subject">
		
		<div class="form-group">
			<label for="name"><spring:message code="label.page.newsubject.name"/></label>
			<form:input path="name" cssClass="form-control" />
		</div>
		<c:set var="error"><form:errors path="name" /></c:set>
		<c:if test="${not empty error }">
			<div class="form-group alert alert-danger">
				<form:errors path="name" />
			</div>
		</c:if>
		
		<div class="form-group">
			<label for="price"><spring:message code="label.page.newsubject.price"/></label>
			<form:input path="price" type="number" cssClass="form-control" />
		</div>
		<c:set var="error"><form:errors path="price" /></c:set>
		<c:if test="${not empty error }">
			<div class="form-group alert alert-danger">
				<form:errors path="price" />
			</div>
		</c:if>
		
		<div class="form-group">
			<button type="submit" class="btn btn-success input-block-level form-control">
				<spring:message code="button.add" />
			</button>
		</div>
	</form:form>
</div>
<%@ include file="jspf/footer.jspf"%>