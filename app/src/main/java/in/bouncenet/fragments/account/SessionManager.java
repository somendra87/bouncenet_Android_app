package in.bouncenet.fragments.account;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import in.bouncenet.backendintegration.dtos.AuthResponseDto;
import in.bouncenet.backendintegration.dtos.MemberResponseDto;

public class SessionManager {
    private static final String PREF_NAME = "BounceNetSession";
    private static final String MEMBER = "member_data";

    private static final String AUTHORIZATION = "Authorization";


    private static SessionManager instance;
    private final SharedPreferences sharedPreferences;
    private final Gson gson;

    private SessionManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public static synchronized SessionManager getInstance(Context context) {
        if (instance == null) {
            instance = new SessionManager(context.getApplicationContext());
        }
        return instance;
    }

    public void saveMember(MemberResponseDto member) {
        String memJson = gson.toJson(member);
        sharedPreferences.edit().putString(MEMBER, memJson).apply();
    }

    // Retrieve the entire object
    public MemberResponseDto getMember() {
        String json = sharedPreferences.getString(MEMBER, null);
        if (json == null){
            return null;
        }
        return gson.fromJson(json, MemberResponseDto.class);
    }

    public void saveToken(AuthResponseDto authResponseDto) {
        String authResponse = gson.toJson(authResponseDto);
        sharedPreferences.edit().putString(AUTHORIZATION, authResponse).apply();
    }

    public AuthResponseDto getTokenFromSession() {
        String json = sharedPreferences.getString(AUTHORIZATION, null);
        if (json == null ) {
            return null;
        }
        return gson.fromJson(json, AuthResponseDto.class);
    }


    public void logout(){
        sharedPreferences.edit().clear().apply();
    }
}
