package com.example.githubapp.data.api;

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
public final class GithubApiClient_Factory implements Factory<GithubApiClient> {
  private final Provider<AuthTokenProvider> authTokenProvider;

  public GithubApiClient_Factory(Provider<AuthTokenProvider> authTokenProvider) {
    this.authTokenProvider = authTokenProvider;
  }

  @Override
  public GithubApiClient get() {
    return newInstance(authTokenProvider.get());
  }

  public static GithubApiClient_Factory create(Provider<AuthTokenProvider> authTokenProvider) {
    return new GithubApiClient_Factory(authTokenProvider);
  }

  public static GithubApiClient newInstance(AuthTokenProvider authTokenProvider) {
    return new GithubApiClient(authTokenProvider);
  }
}
