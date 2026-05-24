package in.bouncenet.backendintegration.repocallbacks;

/**
 * Generic callback for repository operations
 */
public interface RepositoryCallback<T> {
    /**
     * Called when API call is successful
     */
    void onSuccess(T data);

    /**
     * Called when API call fails
     */
    void onFailure(String errorMessage);
}
