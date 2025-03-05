<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    
    <title>Customer Login</title>
    
  </head>
  
  <body>
    
    
    <div class="form-wrapper sign up">
      <form class="registration1" id="registration" method="post" action="customerLogin" onsubmit="return formValidation()">
        <h1 style="font-size: 30px;">CUSTOMER LOGIN</h1>
        <div class="input-box">
          <input class="text-input-field" type="Email" id="CustomerEmail" name="User_Email" required>
          <label class="main-labels" for="Email">Enter Your Email Here</label>
          <i class='i-icons bx bxs-envelope'></i>
        </div>
        <div class="input-box">
          <div class="icons-container">
            <i class="password-hide-icon fas fa-eye-slash" style="left:357px" onclick="togglePasswordVisibility('customerpassword', this)"></i>
            <i class='i-icons fas fa-lock'></i>
          </div>
          <input class="password-field" type="password" name="User_Password" id="customerpassword" required>
          <label class="main-labels">Enter Your Password Here</label>
        </div>
        
        <button class="register-button" style="font-size:24px" type="submit" name="submit">Login</button>
        <div class="signIn-link">
          <p>Do not have an account?<a href="Register.jsp"class="signInBtn"> Sign Up</a>
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

    
    
  </body>
</html>