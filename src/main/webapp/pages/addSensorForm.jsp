<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="col-md-12">
	<div class="">
		<div class="row text-center">
			<div class="col-md-12">
				<h2>Add your UV Sensor</h2>

				<h5>( Register UV Sensors on Mobile Sensor Cloud Engine )</h5>
				<br />
			</div>
		</div>
	</div>

	<form:form class="form-horizontal" commandName="virtualSensor"
		method="post" action="addSensorSubmit.ac">
		<table class="table table-responsive nopadding" style="width: 60%;"
			align="center">

			<tbody>
				<tr>
					<div class="row">
						<td>
							<div class="form-group">
								<label class="control-label" for="Dimensions">
									Dimensions</label>
							</div>
						</td>
						<td>
							<div class="form-group">
								<form:input path="dimensions" type="text" class="form-control"
									placeholder="L , B , H" />
							</div>
						</td>
					</div>
				</tr>
				<tr>
					<div class="row">
						<td>
							<div class="form-group">
								<label class="control-label" for="Signal">Signal Type</label>
							</div>
						</td>
						<td>
							<div class="form-group">
								<form:select path="signalType" class="form-control">
									<form:option value="Broadband">Broadband</form:option>
									<form:option value="Wifi">Wifi</form:option>
									<form:option value="4G">4G</form:option>
									<form:option value="3G">3G</form:option>
								</form:select>
							</div>
						</td>
					</div>
				</tr>
				<tr>
					<div class="row">
						<td>
							<div class="form-group">
								<label class="control-label" for="Signal Speed"> Signal
									Speed (In KBPS)</label>
							</div>
						</td>
						<td>
							<div class="form-group">
								<form:input path="signalSpeed" type="text" class="form-control"
									placeholder="Eg.- 125.5" />
							</div>
						</td>
					</div>
				</tr>

				<tr>
					<div class="row">
						<td>
							<div class="form-group">
								<label class="control-label" for="NumberOfPins">Number
									of Pins</label>
							</div>
						</td>
						<td>
							<div class="form-group">
								<form:select path="NumOfPins" class="form-control">
									<form:option value="1">1</form:option>
									<form:option value="2">2</form:option>
									<form:option value="3">3</form:option>
									<form:option value="4">4</form:option>
									<form:option value="5">5</form:option>
									<form:option value="6">6</form:option>
									<form:option value="7">7</form:option>
									<form:option value="8">8</form:option>
									<form:option value="9">9</form:option>
									<form:option value="10">10</form:option>
								</form:select>
							</div>
						</td>
					</div>
				</tr>
				<tr>
					<div class="row">
						<td>
							<div class="form-group">
								<label class="control-label" for="OutputSignal">Output
									Signal</label>
							</div>
						</td>
						<td>
							<div class="form-group">
								<form:select path="outputSignal" class="form-control">
									<form:option value="Digital">Digital</form:option>
									<form:option value="Analog">Analog</form:option>
								</form:select>
							</div>
						</td>
					</div>
				</tr>
				<tr>
					<div class="row">
						<td>
							<div class="form-group">
								<label class="control-label" for="MinimumWorkingTemperature">
									Minimum Working Temperature (in Kelvin)</label>
							</div>
						</td>
						<td>
							<div class="form-group">
								<form:input path="operatingRangeFrom" type="text"
									class="form-control" placeholder="Temperature in kelvin" />
							</div>
						</td>
					</div>
				</tr>
				<tr>
					<div class="row">
						<td>
							<div class="form-group">
								<label class="control-label" for="MaximumWorkingTemperature">
									Maximum Working Temperature (in Kelvin)</label>
							</div>
						</td>
						<td>
							<div class="form-group">
								<form:input path="operatingRangeTo" type="text"
									class="form-control" placeholder="Temperature in kelvin" />
							</div>
						</td>
					</div>
				</tr>
				<tr>
					<div class="row">
						<td>
							<div class="form-group">
								<label class="control-label" for="installationDateTime">
									Installation Date</label>
							</div>
						</td>
						<td>
							<div class="form-group">
								<form:input path="installationDateTime" type="text"
									class="form-control" placeholder="Eg.- 01/25/2015" />
							</div>
						</td>
					</div>
				</tr>
				<tr>
					<div class="row">
						<td>
							<div class="form-group">
								<label class="control-label" for="latitude"> Sensor
									Location - Latitude</label>
							</div>
						</td>
						<td>
							<div class="form-group">
								<form:input path="latitude" type="text" class="form-control"
									placeholder="Latitude" />
							</div>
						</td>
					</div>
				</tr>
				<tr>
					<div class="row">
						<td>
							<div class="form-group">
								<label class="control-label" for="longitude"> Sensor
									Location - Longitude</label>
							</div>
						</td>
						<td>
							<div class="form-group">
								<form:input path="longitude" type="text" class="form-control"
									placeholder="Longitude" />
							</div>
						</td>
					</div>
				</tr>
				<tr>
					<div class="row">
						<td>
							<div class="form-group">
								<label class="control-label" for="city"> Sensor Location
									- City</label>
							</div>
						</td>
						<td>
							<div class="form-group">
								<form:input path="sensorCity" type="text" class="form-control"
									placeholder="City" />
							</div>
						</td>
					</div>
				</tr>
			</tbody>
		</table>
		<center>
			<input type="submit" value="Add Sensor" class="btn btn-danger">
		</center>
	</form:form>
</div>
