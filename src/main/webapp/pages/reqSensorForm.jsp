<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-12">
	<div class="">
		<div class="row text-center">
			<div class="col-md-12">
				<h2>Request UV Sensor</h2>

				<h5>( Request UV Sensors on Mobile Sensor Cloud Engine )</h5>
				<br />
			</div>
		</div>
	</div>

	<form class="form-horizontal" 
		method="post" action="reqSensorSubmit.ac">
		<table class="table table-responsive nopadding" style="width: 60%;"
			align="center">

			<tbody>
				
				<tr>
					<div class="row">
						<td>
							<div class="form-group">
								<label class="control-label" for="location">Select Location </label>
							</div>
						</td>
						<td>
							<div class="form-group">
								<select class="form-control" name="reqCity" id="reqCity">
									<option value="-1">--SELECT--</option>
									<c:forEach items="${cityList }" var="city">
										<option value="${city}">${city}</option>
									</c:forEach>
								</select>
							</div>
						</td>
					</div>
				</tr>
				
			</tbody>
		</table>
		<center>
			<input type="submit" value="Request Sensor" class="btn btn-danger">
		</center>
	</form>
</div>
