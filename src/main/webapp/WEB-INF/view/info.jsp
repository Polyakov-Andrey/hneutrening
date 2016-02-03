<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="jspf/header.jspf"%>

<div
	class="row col-lg-8 col-md-8 col-lg-offset-2 col-md-offset-2 col-sm-12">
	<h2 class="text-center">
		<spring:message code="label.page.teachercapacities" />
	</h2>
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<th colspan="2" class="text-center"><spring:message
							code="label.page.newteacher.name" /></th>
					<th class="text-center"><spring:message
							code="label.page.newteacher.totalHours" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="teacher" items="${teachers}">
					<tr class="table-row-selected">
						<td colspan="2">${teacher.surname}${teacher.name}
							${teacher.patronymic}</td>
						<td class="text-center">${teacher.totalHours}</td>
					</tr>
					<c:forEach var="group" items="${teacher.relatedGroups}">
						<tr>
							<td/>
							<td>${group.speciality}</td>
							<td class="text-center">${group.totalHoursForTeacher}</td>
						</tr>
					</c:forEach>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="jspf/footer.jspf"%>
