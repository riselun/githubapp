package com.example.githubapp.ui.profile;

import com.example.githubapp.data.repository.GithubRepository;
import com.example.githubapp.util.NetworkUtils;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class ProfileViewModel_Factory implements Factory<ProfileViewModel> {
  private final Provider<GithubRepository> githubRepositoryProvider;

  private final Provider<NetworkUtils> networkUtilsProvider;

  public ProfileViewModel_Factory(Provider<GithubRepository> githubRepositoryProvider,
      Provider<NetworkUtils> networkUtilsProvider) {
    this.githubRepositoryProvider = githubRepositoryProvider;
    this.networkUtilsProvider = networkUtilsProvider;
  }

  @Override
  public ProfileViewModel get() {
    return newInstance(githubRepositoryProvider.get(), networkUtilsProvider.get());
  }

  public static ProfileViewModel_Factory create(Provider<GithubRepository> githubRepositoryProvider,
      Provider<NetworkUtils> networkUtilsProvider) {
    return new ProfileViewModel_Factory(githubRepositoryProvider, networkUtilsProvider);
  }

  public static ProfileViewModel newInstance(GithubRepository githubRepository,
      NetworkUtils networkUtils) {
    return new ProfileViewModel(githubRepository, networkUtils);
  }
}
