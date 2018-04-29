<%@ include file ="../tags/header.jsp" %>

<h1>Create a new user</h1>
<form method="post" action="/">
	<p>
		<label for="email">Email*</label>
		<input type="text" name="email" />
	</p>
	<p>
		<label for="password">Password*</label>
		<input type="password" name="password" />
	</p>
	<p>
		<label for="passwordConfirm">Confirm password*</label>
		<input type="password" name="passwordConfirm" />
	</p>
	<p>
		<label for="city">City</label>
		<input type="text" name="city" />
	</p>
	<p>
		<label for="profile">Profile</label>
		<input type="text" name="profile" />
	</p>
	<p>
		<input type="submit" value="valider" />
	</p>
</form>

<%@ include file ="../tags/footer.jsp" %>