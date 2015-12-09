<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="validUser" value="${session.validUser}" scope="page" />
<c:set var="sensorData" value="${requestScope.virtualSensorData}"
	scope="page" />


	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">UV Radiation in your
					area</h4>
			</div>
			<div class="modal-body">
				<h5><strong>UV Index: <fmt:formatNumber type="number" maxFractionDigits="1" value="${sensorData.uvIndex}" /></strong></h5>
				<c:choose>
					<c:when test="${sensorData.riskColor == 'green'}">
						<div class="alert alert-success">
	                    	 Risk: <h5><strong>${sensorData.risk}</strong></h5>
	                	</div>
					</c:when>
					<c:when test="${sensorData.riskColor == 'yellow'}">
						<div class="alert alert-success">
	                    	 Risk: <h5><strong>${sensorData.risk}</strong></h5>
	                	</div>
					</c:when>
					<c:when test="${sensorData.riskColor == 'orange'}">
						<div class="alert alert-warning">
	                    	 Risk: <h5><strong>${sensorData.risk}</strong></h5>
	                	</div>
					</c:when>
					<c:when test="${sensorData.riskColor == 'red'}">
						<div class="alert alert-danger">
	                    	 Risk: <h5><strong>${sensorData.risk}</strong></h5>
	                	</div>
					</c:when>
					<c:otherwise>
						<div class="alert alert-danger">
	                    	 Risk: <h5><strong>${sensorData.risk}</strong></h5>
	                	</div>
					</c:otherwise>
				</c:choose>
				
                <div class="alert alert-info">
                     Suggestion: ${sensorData.suggestionMessage}
                </div>
				
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" id="modalCloseButton" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>