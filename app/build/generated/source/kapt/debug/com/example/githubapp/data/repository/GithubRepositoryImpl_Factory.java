package com.example.githubapp.data.repository;

import com.example.githubapp.data.api.GithubApiClient;
import com.example.githubapp.data.local.UserPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class GithubRepositoryImpl_Factory implements Factory<GithubRepositoryImpl> {
  private final Provider<GithubApiClient> apiClientProvider;

  private final Provider<UserPreferences> userPreferencesProvider;

  public GithubRepositoryImpl_Factory(Provider<GithubApiClient> apiClientProvider,
      Provider<UserPreferences> userPreferencesProvider) {
    this.apiClientProvider = apiClientProvider;
    this.userPreferencesProvider = userPreferencesProvider;
  }

  @Override
  public GithubRepositoryImpl get() {
    return newInstance(apiClientProvider.get(), userPreferencesProvider.get());
  }

  public static GithubRepositoryImpl_Factory create(Provider<GithubApiClient> apiClientProvider,
      Provider<UserPreferences> userPreferencesProvider) {
    return new GithubRepositoryImpl_Factory(apiClientProvider, userPreferencesProvider);
  }

  public static GithubRepositoryImpl newInstance(GithubApiClient apiClient,
      UserPreferences userPreferences) {
    return new GithubRepositoryImpl(apiClient, userPreferences);
  }
}
