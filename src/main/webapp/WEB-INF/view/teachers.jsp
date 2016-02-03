<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="jspf/header.jspf"%>

<div
	class="row col-lg-8 col-md-8 col-lg-offset-2 col-md-offset-2 col-sm-12">
	<h2 class="text-center">
		<spring:message code="label.page.teachers" />
	</h2>
	<div class="table-responsive">
		<table class="table table-striped table-hover text-center">
			<thead>
				<tr>
					<th class="text-center"><spring:message code="label.page.newsubject.name" /></th>
					<th class="text-center"><spring:message code="label.page.newteacher.phone" /></th>
					<th class="text-center"><spring:message code="label.page.newteacher.experience" /></th>
					<th class="text-center"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="teacher" items="${teachers}">
					<tr class="clickable-row"
						data-href="<c:url value="/management/teachers/update/${teacher.id}"/>">
						<td>${teacher.surname} ${teacher.name} ${teacher.patronymic}</td>
						<td>${teacher.phone}</td>
						<td>${teacher.experience}</td>
						<td><a href="<c:url value="/management/teachers/remove/${teacher.id}"/>" class="btn btn-danger"><spring:message code="button.remove" /></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="<c:url value="teachers/add"/>" class="btn btn-success input-block-level form-control"><spring:message code="button.add"/></a>
	</div>
	
</div>
<%@ include file="jspf/footer.jspf"%>