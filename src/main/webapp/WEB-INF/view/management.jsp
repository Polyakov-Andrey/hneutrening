<%@ include file="jspf/header.jspf"%>
<div class="container">
	<div class="row">
		<ul class="thumbnails">
			<li class="col-lg-4 col-md-4 col-sm-6"><a
				href="<c:url value="/info"/>" class="thumbnail"> <img
					alt="" src="<c:url value="/resources/img/dashboard.jpg"/>">
			</a></li>
			<li class="col-lg-3 col-md-4 col-sm-6"><a
				href="<c:url value="/management/teachers"/>" class="thumbnail">
					<img alt="" src="<c:url value="/resources/img/teachers.jpg"/>">
			</a></li>
			<li class="col-lg-3 col-md-4 col-sm-6"><a
				href="<c:url value="/management/subjects"/>" class="thumbnail">
					<img alt="" src="<c:url value="/resources/img/subjects.jpg"/>">
			</a></li>
			<li class="col-lg-3 col-md-4 col-sm-6"><a
				href="<c:url value="/management/groups"/>" class="thumbnail"> <img
					alt="" src="<c:url value="/resources/img/groups.jpg"/>">
			</a></li>
			<li class="col-lg-3 col-md-4 col-sm-6"><a
				href="<c:url value="/management/lessons"/>" class="thumbnail"> <img
					alt="" src="<c:url value="/resources/img/lessons.jpg"/>">
			</a></li>
		</ul>
	</div>
</div>
<%@ include file="jspf/footer.jspf"%>
