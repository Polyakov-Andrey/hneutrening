<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="jspf/header.jspf"%>

<div
	class="row col-lg-8 col-md-8 col-lg-offset-2 col-md-offset-2 col-sm-12">
	<h2 class="text-center">
		<spring:message code="label.page.subjects" />
	</h2>
	<div class="table-responsive">
		<table class="table table-striped table-hover text-center">
			<thead>
				<tr>
					<th class="text-center"><spring:message
							code="label.page.newsubject.name" /></th>
					<th class="text-center"><spring:message
							code="label.page.newsubject.price" /></th>
					<th class="text-center"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="subject" items="${subjects}">
					<tr class="clickable-row"
						data-href="<c:url value="subjects/update/${subject.id}"/>">
						<td>${subject.name}</td>
						<td>${subject.price}</td>
						<td><a href="<c:url value="subjects/remove/${subject.id}"/>"
							class="btn btn-danger"><spring:message code="button.remove" /></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="<c:url value="subjects/add"/>"
			class="btn btn-success input-block-level form-control"><spring:message
				code="button.add" /></a>
	</div>

</div>

<%@ include file="jspf/footer.jspf"%>