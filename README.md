

## Login Lifecycle Summary

### Summary of the Flow in your specific project:
```
1.LoginFragment takes input.
2.AuthenticationService calls the API.
3.SessionManager saves the MemberResponseDto.
4.NavController moves to HomeFragment.
5.HeroBannerView (as we discussed) reads from SessionManager to show the name.
```

## 1. User Input & Validation
   ```
   The View: The user enters credentials in a Fragment or Activity.
   Validation: Before hitting the network, you check for basic errors (e.g., empty fields, invalid email format) to avoid unnecessary API calls.
   State Change: Disable the "Login" button and show a ProgressBar to prevent multiple clicks and give visual feedback.
   ```

---
## 2. API Request (Authentication)
   •
   The Service: The app calls a backend endpoint (usually POST /auth/login or /token) via Retrofit.
   •
   The Request: You send a DTO containing the credentials.
   •
   The Response: The server returns a 200 OK with a payload containing:
   ◦
   Access Token: Short-lived (e.g., 15 mins) for authenticating every API request.
   ◦
   Refresh Token: Long-lived (e.g., 30 days) used to get a new Access Token when it expires.
   ◦
   User Info: Basic details (Name, ID, Email) for the UI.

---
## 3. Session Management (Persistence)
   •
   Storage: Once the response arrives, you save the tokens and user info.
   ◦
   SharedPreferences: Common for non-sensitive user data.
   ◦
   EncryptedSharedPreferences: Best practice for storing actual tokens securely.
   •
   Singleton Manager: You use a class like your SessionManager to provide a global way to check isLoggedIn().

---
## 4. Navigation & State Update
   •
   Success: The app clears the login fragment from the "Back Stack" and navigates the user to the HomeFragment. (Clearing the back stack is vital so the user doesn't go back to the login screen when they press the system Back button).
   •
   Failure: Show a Toast or an error message and re-enable the UI for another attempt.

---
## 5. Auto-Login (The Splash Check)
   •
   When the app starts (usually in a SplashActivity or a "Launcher" logic):
   ◦
   The app checks SessionManager.getMember().
   ◦
   If a valid token exists, navigate directly to Home.
   ◦
   If no token exists, navigate to the Landing/Login screen.

---

## 6. Token Handling & Interceptors
   •
   Authorization Header: For all subsequent API calls (e.g., GET /profile), you use an OkHttp Interceptor to automatically attach the Authorization: Bearer <token> header to every request.
   •
   Expiry (401 Handling): If a request returns a 401 Unauthorized, an Authenticator or Interceptor catches it:
   ◦
   It uses the Refresh Token to silently get a new Access Token.
   ◦
   If the Refresh Token is also expired, it triggers a Logout, clears the session, and sends the user back to the Login screen.