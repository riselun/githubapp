package com.example.githubapp.di;

import com.example.githubapp.data.api.AuthTokenProvider;
import com.example.githubapp.data.api.GithubApiClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class NetworkModule_ProvideGithubApiClientFactory implements Factory<GithubApiClient> {
  private final Provider<AuthTokenProvider> authTokenProvider;

  public NetworkModule_ProvideGithubApiClientFactory(
      Provider<AuthTokenProvider> authTokenProvider) {
    this.authTokenProvider = authTokenProvider;
  }

  @Override
  public GithubApiClient get() {
    return provideGithubApiClient(authTokenProvider.get());
  }

  public static NetworkModule_ProvideGithubApiClientFactory create(
      Provider<AuthTokenProvider> authTokenProvider) {
    return new NetworkModule_ProvideGithubApiClientFactory(authTokenProvider);
  }

  public static GithubApiClient provideGithubApiClient(AuthTokenProvider authTokenProvider) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideGithubApiClient(authTokenProvider));
  }
}
