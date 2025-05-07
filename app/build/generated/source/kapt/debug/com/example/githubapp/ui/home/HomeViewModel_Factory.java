package com.example.githubapp.ui.home;

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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<GithubRepository> githubRepositoryProvider;

  private final Provider<NetworkUtils> networkUtilsProvider;

  public HomeViewModel_Factory(Provider<GithubRepository> githubRepositoryProvider,
      Provider<NetworkUtils> networkUtilsProvider) {
    this.githubRepositoryProvider = githubRepositoryProvider;
    this.networkUtilsProvider = networkUtilsProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(githubRepositoryProvider.get(), networkUtilsProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<GithubRepository> githubRepositoryProvider,
      Provider<NetworkUtils> networkUtilsProvider) {
    return new HomeViewModel_Factory(githubRepositoryProvider, networkUtilsProvider);
  }

  public static HomeViewModel newInstance(GithubRepository githubRepository,
      NetworkUtils networkUtils) {
    return new HomeViewModel(githubRepository, networkUtils);
  }
}
