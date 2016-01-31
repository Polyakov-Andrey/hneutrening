<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="jspf/header.jspf"%>

<div
	class="row col-lg-8 col-md-8 col-lg-offset-2 col-md-offset-2 col-sm-12">
	<h2 class="text-center">
		<spring:message code="label.page.groups" />
	</h2>
	<div class="table-responsive">
		<table class="table table-striped text-center">
			<thead>
				<tr>
					<th class="text-center"><spring:message
							code="label.page.newgroup.speciality" /></th>
					<th class="text-center"><spring:message
							code="label.page.newgroup.department" /></th>
					<th class="text-center"><spring:message
							code="label.page.newgroup.studentscount" /></th>
					<th class="text-center"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="group" items="${groups}">
					<tr>
						<td>${group.speciality}</td>
						<td>${group.department}</td>
						<td>${group.studentsCount}</td>
						<td><a href="<c:url value="groups/remove/${group.id}"/>"
							class="btn btn-danger"><spring:message code="button.remove" /></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="<c:url value="groups/add"/>"
			class="btn btn-success input-block-level form-control"><spring:message
				code="button.add" /></a>
	</div>

</div>
<%@ include file="jspf/footer.jspf"%>