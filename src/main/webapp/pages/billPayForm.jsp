<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="billPay" value="${requestScope.billPay}" scope="page" />
<div class="col-md-12">
	<div class="">
		<div class="row text-center">
			<div class="col-md-12">
				<h2>Pay Your Bill</h2>

				<h5>( Pay for Sensor Data on Mobile Sensor Cloud Engine )</h5>
				<br />
			</div>
		</div>
	</div>

	<div class="col-md-12">
	<div class="col-md-3"></div>
    <div class="col-sm-6">
        <fieldset>
        <form:form action="payBill.ac" commandName="billPay" method="post">
            <div class="control-group">
                <label label-default="" class="control-label">Card Holder's Name</label>
                <div class="controls">
                    <form:input path="userName" type="text" class="form-control" pattern="\w+ \w+.*" placeholder="First and last name" required="" />
                </div>
            </div>
            </br>
            <div class="control-group">
                <label label-default="" class="control-label">Card Number</label>
                <div class="controls">
                    <div class="row">
                        <div class="col-md-12">
                            <form:input path="creditCardNumber" type="text" class="form-control" autocomplete="off" maxlength="16" pattern="\d{16}" placeholder="16 digit card number" required="" />
                        </div>
                    </div>
                </div>
            </div>
            </br>
            <div class="control-group">
                <label label-default="" class="control-label">Card Expiry Date</label>
                <div class="controls">
                    <div class="row">
                        <div class="col-md-9">
                            <form:select path="expiryMonth" class="form-control" name="cc_exp_mo">
                                <form:option value="01">January</form:option>
                                <form:option value="02">February</form:option>
                                <form:option value="03">March</form:option>
                                <form:option value="04">April</form:option>
                                <form:option value="05">May</form:option>
                                <form:option value="06">June</form:option>
                                <form:option value="07">July</form:option>
                                <form:option value="08">August</form:option>
                                <form:option value="09">September</form:option>
                                <form:option value="10">October</form:option>
                                <form:option value="11">November</form:option>
                                <form:option value="12">December</form:option>
                            </form:select>
                        </div>
                        <div class="col-md-3">
                            <form:select path="expiryYear" class="form-control" name="cc_exp_yr">
                                <form:option value="2016">2016</form:option>
                                <form:option value="2017">2017</form:option>
                                <form:option value="2018">2018</form:option>
                                <form:option value="2019">2019</form:option>
                                <form:option value="2020">2020</form:option>
                                <form:option value="2021">2021</form:option>
                                <form:option value="2022">2022</form:option>
                                <form:option value="2023">2023</form:option>
                                <form:option value="2024">2024</form:option>
                            </form:select>
                        </div>
                    </div>
                </div>
            </div>
            </br>
            <div class="control-group">
                <label label-default="" class="control-label">Card CVV</label>
                <div class="controls">
                    <div class="row">
                        <div class="col-md-4">
                            <form:input path="cvv" type="password" class="form-control" autocomplete="off" maxlength="3" pattern="\d{3}" placeholder="3 digit CVV" required=""/>
                        </div>
                        <div class="col-md-8"></div>
                    </div>
                </div>
            </div>
            </br>
            <div class="control-group">
                
                <div class="controls">
                    <div class="row">
                        <div class="col-md-3">
                        <label label-default="" class="control-label">Amount </label>
                        	<h4 style="color: #3c763d;"><strong>$${billPay.amount}</strong></h4>
                        	<form:hidden path="amount" />
                        </div>
                        <div class="col-md-8"></div>
                    </div>
                </div>
            </div>
            </br>
            <div class="control-group">
              <label label-default="" class="control-label"></label>
              <div class="controls">
                <input type="submit" class="btn btn-primary" value="Pay Now">
                <button type="button" class="btn btn-danger">Cancel</button>
              </div>
            </div>
            </form:form>
        </fieldset>
    </div>
    <div class="col-md-3"></div>
</div>
<hr>
</div>
