package in.bouncenet.fragments.account;

import static android.view.View.VISIBLE;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import in.bouncenet.R;
import in.bouncenet.backendintegration.dtos.AuthRequestDto;
import in.bouncenet.backendintegration.dtos.AuthResponseDto;
import in.bouncenet.backendintegration.repocallbacks.RepositoryCallback;
import in.bouncenet.backendintegration.service.AuthenticationService;
import in.bouncenet.backendintegration.service.impl.AuthenticationServiceImpl;
import in.bouncenet.helpers.BnTextHelper;
import in.bouncenet.helpers.BnTextWatcher;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    private EditText emailAddressEditText, passwordEditText;
    private MaterialButton btnLogin;

    private AuthenticationService authenticationService;

    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        initViews(view);
        authenticationService = new AuthenticationServiceImpl();

        btnLogin.setOnClickListener(v -> login());
        return view;
    }

    private void initViews(View view) {
        emailAddressEditText = view.findViewById(R.id.etLoginEmailAddress);
        passwordEditText = view.findViewById(R.id.etLoginPassword);
        btnLogin = view.findViewById(R.id.btnLogin);
        progressBar = view.findViewById(R.id.loginProgressBar);

        emailAddressEditText.addTextChangedListener(BnTextHelper.bnTextWatcher());
        passwordEditText.addTextChangedListener(BnTextHelper.bnTextWatcher());
    }

    private void login() {
        // TODO email validation
        String email = emailAddressEditText.getText().toString().trim();

        // TODO password validation
        String password = passwordEditText.getText().toString().trim();

        // encrypt password

        // build authrequest
        AuthRequestDto authRequestDto = new AuthRequestDto(email, password);

        authenticationService.token(authRequestDto, new RepositoryCallback<AuthResponseDto>() {
            @Override
            public void onSuccess(AuthResponseDto authResponse) {
                progressBar.setVisibility(VISIBLE);
                SessionManager.getInstance(requireContext()).saveToken(authResponse);
                Navigation.findNavController(requireView())
                        .navigate(R.id.action_global_to_home);
                Toast.makeText(requireContext(), "Logged In Successfully 🙏🏻",
                        Toast.LENGTH_SHORT).show();
                Log.i("LOGIN_FRAGMENT_OP", "onSuccess: " + authResponse.toString());
            }

            @Override
            public void onFailure(String errorMessage) {
                Log.e("LOGIN_FRAGMENT_OP", "onFailure: ", new Exception(errorMessage));
                Toast.makeText(requireContext(),
                        "Network Error, please try after sometime",
                        Toast.LENGTH_SHORT).show();

            }
        });


    }


}