package in.bouncenet.fragments.account;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import in.bouncenet.R;
import in.bouncenet.backendintegration.dtos.MemberResponseDto;
import in.bouncenet.backendintegration.dtos.RegisterMemberRequestDto;
import in.bouncenet.backendintegration.repocallbacks.RepositoryCallback;
import in.bouncenet.backendintegration.service.MemberService;
import in.bouncenet.backendintegration.service.impl.MembersServiceImpl;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class SignUpFragment extends Fragment {

    private EditText fullNameEditText, emailAddressEditText, phoneNumberEditText, passwordEditText;
    private MaterialButton createMyAccountButton;
    private CheckBox termsAndConditionCheckBox;
    private TextView passwordStrengthTextView;
    private ProgressBar progressBar;

    private MemberService memberService;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        initViews(view);
        memberService = new MembersServiceImpl();
        createMyAccountButton.setOnClickListener(v -> registerMember());
        return view;
    }

    private void initViews(View view) {
        fullNameEditText = view.findViewById(R.id.etFullName);
        emailAddressEditText = view.findViewById(R.id.etEmailAddress);
        phoneNumberEditText = view.findViewById(R.id.etMobile);
        passwordEditText = view.findViewById(R.id.etPassword);
        createMyAccountButton = view.findViewById(R.id.btnCreateAccount);
        termsAndConditionCheckBox = view.findViewById(R.id.signUpTermsAndConditionCheckBox);
        passwordStrengthTextView = view.findViewById(R.id.tvPasswordStrength);
        progressBar = view.findViewById(R.id.signUpProgressBar);

        createMyAccountButton.setEnabled(false);

        // text change watcher
        TextWatcher watcher = new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                updateButtonState();
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
        };

        // Attach watcher to all edit texts
        fullNameEditText.addTextChangedListener(watcher);
        emailAddressEditText.addTextChangedListener(watcher);
        phoneNumberEditText.addTextChangedListener(watcher);
        passwordEditText.addTextChangedListener(watcher);
        termsAndConditionCheckBox.setOnCheckedChangeListener(
                (buttonView, isChecked) -> updateButtonState());
    }


    private void updateButtonState() {
        boolean isFullNameValid = !fullNameEditText.getText().toString().trim().isEmpty();
        boolean isEmailValid = !emailAddressEditText.getText().toString().trim().isEmpty();
        boolean isPhoneValid = !phoneNumberEditText.getText().toString().trim().isEmpty();
        boolean isPasswordValid = !passwordEditText.getText().toString().trim().isEmpty();
        boolean isTermsChecked = termsAndConditionCheckBox.isChecked();

        createMyAccountButton.setEnabled(
                isFullNameValid && isEmailValid && isPhoneValid && isPasswordValid
                        && isTermsChecked
        );
    }

    private void registerMember() {
        String fullName = fullNameEditText.getText().toString().trim();
        // extract first name and last name
        String[] nameParts = fullName.split("\\s+");
        String firstName = nameParts[0].trim();
        String lastName = nameParts.length > 1 ? nameParts[nameParts.length - 1].trim() : "".trim();

        String emailAddr = emailAddressEditText.getText().toString().trim();
        String phoneNumber = phoneNumberEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        boolean isChecked = termsAndConditionCheckBox.isChecked();

        if (TextUtils.isEmpty(fullName)
                || TextUtils.isEmpty(emailAddr)
                || TextUtils.isEmpty(phoneNumber)
                || TextUtils.isEmpty(password)
        ) {
            Toast.makeText(requireContext(), "All fields are required",
                    Toast.LENGTH_LONG).show();
        }

        if (!isChecked) {
            Toast.makeText(requireContext(), "Please accept terms and conditions",
                    Toast.LENGTH_LONG).show();
            createMyAccountButton.setEnabled(false);
        }
        // showing progress bar
        progressBar.setVisibility(VISIBLE);
        // disabling create account button
        createMyAccountButton.setEnabled(false);

        RegisterMemberRequestDto requestDto = buildRegisterMemberRequest(firstName, lastName, emailAddr, phoneNumber, password);

        memberService.register(requestDto, new RepositoryCallback<MemberResponseDto>() {
            @Override
            public void onSuccess(MemberResponseDto member) {
                progressBar.setVisibility(GONE);
                createMyAccountButton.setEnabled(true);
                SessionManager.getInstance(requireContext()).saveMember(member);
                Toast.makeText(requireContext(),
                        "Welcome !!" + member.getFirstName(),
                        Toast.LENGTH_LONG).show();

                Navigation.findNavController(requireView())
                        .navigate(R.id.action_global_to_home);
            }

            @Override
            public void onFailure(String errorMessage) {
                progressBar.setVisibility(GONE);
                createMyAccountButton.setEnabled(true);
                Toast.makeText(requireContext(), "Registration Failed " + errorMessage,
                        Toast.LENGTH_LONG).show();
            }
        });


    }

    @NonNull
    private static RegisterMemberRequestDto buildRegisterMemberRequest(
            String firstName, String lastName,
            String emailAddr, String phoneNumber,
            String password) {
        RegisterMemberRequestDto requestDto = new RegisterMemberRequestDto();
        requestDto.setFirstName(firstName);
        requestDto.setLastName(lastName);
        requestDto.setEmail(emailAddr);
        requestDto.setPhone(phoneNumber);
        requestDto.setPassword(password);
        return requestDto;
    }

}