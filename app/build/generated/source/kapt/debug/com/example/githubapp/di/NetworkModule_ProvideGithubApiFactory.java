package com.example.githubapp.di;

import com.example.githubapp.data.api.GithubApi;
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
public final class NetworkModule_ProvideGithubApiFactory implements Factory<GithubApi> {
  private final Provider<GithubApiClient> apiClientProvider;

  public NetworkModule_ProvideGithubApiFactory(Provider<GithubApiClient> apiClientProvider) {
    this.apiClientProvider = apiClientProvider;
  }

  @Override
  public GithubApi get() {
    return provideGithubApi(apiClientProvider.get());
  }

  public static NetworkModule_ProvideGithubApiFactory create(
      Provider<GithubApiClient> apiClientProvider) {
    return new NetworkModule_ProvideGithubApiFactory(apiClientProvider);
  }

  public static GithubApi provideGithubApi(GithubApiClient apiClient) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideGithubApi(apiClient));
  }
}
