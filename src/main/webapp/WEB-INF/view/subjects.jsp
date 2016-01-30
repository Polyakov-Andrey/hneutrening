<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="jspf/header.jspf"%>

<div
	class="row col-lg-8 col-md-8 col-lg-offset-2 col-md-offset-2 col-sm-12">
	<h2 class="text-center">
		<spring:message code="label.page.subjects" />
	</h2>
	<div class="table-responsive">
		<table class="table table-striped text-center">
			<thead>
				<tr>
					<th class="text-center"><spring:message code="label.page.newsubject.name" /></th>
					<th class="text-center"><spring:message code="label.page.newsubject.price" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="subject" items="${subjects}">
					<tr>
						<td>${subject.name}</td>
						<td>${subject.price}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="<c:url value="add"/>" class="btn btn-success input-block-level form-control"><spring:message code="button.add"/></a>
	</div>
	
</div>
<%@ include file="jspf/footer.jspf"%>