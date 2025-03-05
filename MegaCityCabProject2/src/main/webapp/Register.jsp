<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Customer Register</title>
  </head>
  
  <body>
    
    <div class="form-wrapper sign up">
      <form class="registration1" id="registration" method="post" action="addCustomer" onsubmit="return formValidation()">
        <h1 style="font-size: 30px;">CUSTOMER REGISTRATION</h1>
        <div class="input-box">
          <input class="text-input-field" type="text" id="CustomerFullName" name="User_Username" required>
          <label class="main-labels" for="">Enter Your Full Name Here</label>
          <i class='i-icons bx bxs-user'></i>
        </div>
        <div class="input-box">
          <input class="text-input-field" type="Email" id="CustomerEmail" name="User_Email" required>
          <label class="main-labels" for="Email">Enter Your Email Here</label>
          <i class='i-icons bx bxs-envelope'></i>
        </div>
        <div class="input-box">
          <input class="text-input-field" type="text" id="CustomerNIC" name="User_NIC" required>
          <label class="main-labels" for="Email">Enter Your NIC Number Here</label>
          <i class='i-icons fas fa-address-card'></i>
        </div>
        <div class="input-box">
          <input class="text-input-field" type="text" id="CustomerAddress" name="User_Address" required>
          <label class="main-labels" for="Email">Enter Your Address Here</label>
          <i class='i-icons fas fa-home'></i>
        </div>
        <div class="input-box">
          <input class="text-input-field" type="number" id="CustomerTelephoneNumber" name="User_Telephone_Number" required>
          <label class="main-labels" for="Email">Enter Your Telephone Number Here</label>
          <i class='i-icons fas fa-phone-alt'></i>
        </div>
        <div class="input-box">
          <div class="icons-container">
            <i class="password-hide-icon fas fa-eye-slash" style="left:357px" onclick="togglePasswordVisibility('customerpassword', this)"></i>
            <i class='i-icons fas fa-lock'></i>
          </div>
          <input class="password-field" type="password" name="User_Password" id="customerpassword" required>
          <label class="main-labels">Enter Your Password Here</label>
        </div>
        <div class="input-box">
          <div class="icons-container">
            <i class="password-hide-icon fas fa-eye-slash" style="left:357px" onclick="togglePasswordVisibility('confirmCustomerPassword', this)"></i>
            <i class='i-icons fas fa-lock'></i>
          </div>
          <input class="password-field" type="password" name="User_Confirm_Password" id="confirmCustomerPassword" required>
          <label class="main-labels">Confirm Your Password Here</label>
        </div>
        
        <button class="register-button" style="font-size:24px" type="submit" name="submit">Register</button>
        <div class="signIn-link">
          <p>Already have an account?<a href="Login.jsp"class="signInBtn"> Sign In</a>
        </p>
        </div>
      </form>
    </div>

    <script>
      function togglePasswordVisibility(fieldId, toggleIcon) {
        var input = document.getElementById(fieldId);
        var isPasswordVisible = input.type === 'password';
        input.type = isPasswordVisible ? 'text' : 'password';
        toggleIcon.className = isPasswordVisible ? 'password-hide-icon fas fa-eye' : 'password-hide-icon fas fa-eye-slash';
      }
    </script>

    <script type="text/javascript">
      function formValidation() {
        var CustomerFullName = document.getElementById('CustomerFullName').value;
        var CustomerEmail = document.getElementById('CustomerEmail').value;
        var CustomerPassword = document.getElementById('customerpassword').value; 
        var ConfirmCustomerPassword = document.getElementById('confirmCustomerPassword').value;

        if (allLetter(CustomerFullName)) {
          if (ValidateEmail(CustomerEmail)) {
        	if (PasswordLengthLong(CustomerPassword)) {
              if (PasswordandConfirmPasswordMatching(CustomerPassword, ConfirmCustomerPassword)) {
                return true;
              }
            }
          }
        }
        return false;
      }

      function allLetter(CustomerFullName) {
        var letters = /^[A-Za-z ]+$/; 
        if (CustomerFullName.match(letters)) {
          return true;
        } else {
          alert("Dear Customer, Full Name must have alphabet characters and spaces only!");
          return false;
        }
      }

      function ValidateEmail(CustomerEmail) {
        var mailformat = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        if (CustomerEmail.match(mailformat)) {
          return true;
        } else {
          alert("Dear Customer, please enter a valid Email address!");
          return false;
        }
      }

      function PasswordandConfirmPasswordMatching(CustomerPassword, ConfirmCustomerPassword) {
        if (CustomerPassword !== ConfirmCustomerPassword) {
          alert("Dear Customer, Password and Confirm Password must be equal!");
          return false;
        }
        return true;
      }
      
      function PasswordLengthLong(CustomerPassword) {
        if (CustomerPassword.length<5) {
            alert("Dear Customer, Password must have more than 4 characters!");
            return false;
        }
        return true;
      }
    </script>

  </body>
</html>