<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="jspf/header.jspf"%>

<div
	class="row col-lg-8 col-md-8 col-lg-offset-2 col-md-offset-2 col-sm-12">
	<h2 class="text-center">
		<spring:message code="label.page.lessons" />
	</h2>
	<div class="table-responsive">
		<table class="table table-striped text-center">
			<thead>
				<tr>
					<th class="text-center"><spring:message
							code="label.page.newlesson.subject" /></th>
					<th class="text-center"><spring:message
							code="label.page.newlesson.group" /></th>
					<th class="text-center"><spring:message
							code="label.page.newlesson.teacher" /></th>
					<th class="text-center"><spring:message
							code="label.page.newlesson.type" /></th>
					<th class="text-center"><spring:message
							code="label.page.newlesson.price" /></th>
					<th class="text-center"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="lesson" items="${lessons}">
					<tr>
						<td>${lesson.subject.name}</td>
						<td>${lesson.group.speciality}</td>
						<td>${lesson.teacher.name}${lesson.teacher.patronymic}
							${lesson.teacher.surname}</td>
						<td>${lesson.type.name}</td>
						<td>${lesson.price}</td>
						<td><a href="<c:url value="lessons/remove/${lesson.id}"/>"
							class="btn btn-danger"><spring:message code="button.remove" /></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="<c:url value="lessons/add"/>"
			class="btn btn-success input-block-level form-control"><spring:message
				code="button.add" /></a>
	</div>

</div>
<%@ include file="jspf/footer.jspf"%>